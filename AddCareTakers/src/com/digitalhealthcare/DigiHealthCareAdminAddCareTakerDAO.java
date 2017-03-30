/**
 * 
 */
package com.digitalhealthcare;

import com.cis.CISConstants;
import com.cis.CISResults;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
/**
 * @author Darshan
 *
 */
public class DigiHealthCareAdminAddCareTakerDAO extends JdbcDaoSupport {

	public CISResults addCareTakers(String userId, String phoneNumber) {
		// TODO Auto-generated method stub
		DigiHealthCareAdminAddCareTakerModel addCareTakers=new DigiHealthCareAdminAddCareTakerModel();
		String careTakerNumber=CISConstants.USA_COUNTRY_CODE+phoneNumber;
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		try{
			getJdbcTemplate().update(DigiHealthCareAdminAddCareTakerQuery.SQL_ADD_CARETAKER,userId,careTakerNumber);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}

 		return cisResults; 
	}

	

}
