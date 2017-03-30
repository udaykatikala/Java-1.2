/**
 * 
 */
package com.digitalhealthcare;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.CISSessionModel;

/**
 * Queries database to check if accounts exists for the input phone number. 
 * @author Castus Info Solutions
 *
 */
public class DigitalHealthCareIsAccountExistDAO  extends JdbcDaoSupport{
	/**
	 * @param contactNumber
	 * @return Returns 0 if account exists , 1 if account doesn't exists
	 */
	public CISResults isAccountExists(String contactNumber) {
		// TODO Auto-generated method stub
		DigitalHealthCareIsAccountExistModel verifyPhoneNumber;
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{contactNumber};
		try{
			 verifyPhoneNumber=(DigitalHealthCareIsAccountExistModel)getJdbcTemplate().queryForObject(DigiHealthCareAccountExistQuery.SQL_VALIDATE_ACCOUNT,inputs,new DigitalHealthCareIsAccountExistMapper());
			if(verifyPhoneNumber!=null){
				String password=verifyPhoneNumber.getPassword();
				if(password.contentEquals(""))
				{
					verifyPhoneNumber.setPassword(CISConstants.NO);
				}else
				{
				     verifyPhoneNumber.setPassword(CISConstants.YES);
				}
				cisResults.setResultObject(verifyPhoneNumber);
			}
		
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage(CISConstants.ACCOUNT_STATUS2);
		}
   		return cisResults; 
	}

	

	/**
	 * @param contactNumber
	 * @return
	 */
	public CISResults checkCareTakerDetails(String contactNumber) {
		// TODO Auto-generated method stub
		DigitalHalthCareTakersModel digitalHalthCareTakersModel = new DigitalHalthCareTakersModel() ;
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{contactNumber};
		try{
			List result= getJdbcTemplate().query(DigiHealthCareAccountExistQuery.SQL_CHECK_CARETAKERS,inputs,new DigitalHealthCareIsCareTakerExistMapper());
				if(result.size()!=0){
					digitalHalthCareTakersModel.setAccountType(CISConstants.FAMILY_FLAG);
					digitalHalthCareTakersModel.setPassword(CISConstants.NO);
					cisResults.setResultObject(digitalHalthCareTakersModel);
					 
					 
				}else{
					cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
					cisResults.setErrorMessage(CISConstants.ACCOUNT_STATUS2);
				}
		
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage(CISConstants.ACCOUNT_STATUS2);
		}
   		return cisResults; 
	}

}
