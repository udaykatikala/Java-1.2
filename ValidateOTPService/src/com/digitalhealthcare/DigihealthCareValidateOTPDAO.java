package com.digitalhealthcare;




import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;

/**
 * Queries database to validate OTP 
 * @author Castus Info Solutions
 *
 */
public class DigihealthCareValidateOTPDAO extends JdbcDaoSupport {
	
	/**
	 * Queries database to validate OTP for the input phone number.
	 * @param phoneNumber
	 * @param emailId - not implemented
	 * @param otp
	 * @param deleteInd
	 * @return 0-Success,1-Error
	 */
	public CISResults validateOTP(String phoneNumber,String emailId,String otp,String deleteInd) {
		DigihealthCareValidateOTP verifyModel;
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{phoneNumber,otp,deleteInd};
		try{	
			verifyModel=(DigihealthCareValidateOTP)getJdbcTemplate().queryForObject(DigihealthCareValidateOTPQuery.SQL_VALIDATE_OPT,inputs,new DigihealthCareValidateOTPMapper());
			if(verifyModel!=null){		
				cisResults.setResultObject(verifyModel);
			}
		
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage(CISConstants.ACCOUNT_STATUS4);
		}
   		return cisResults;  
	}
}