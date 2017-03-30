package com.digitalhealthcare;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;


/**
 * Saves OTP in the database
 * 
 * @author Castus info solutions
 *
 */

public class DigihealthCareRequestOTPDAO extends JdbcDaoSupport{
	
	/**
	 * creates a new record in the database for the newly generated OTP
	 * @param phoneNumber
	 * @param emailId
	 * @param otpId
	 * @param otpdateTime
	 * @param deleteInd
	 * @return
	 */
	public CISResults requestOTP(String phoneNumber,String emailId,int otpId,String otpdateTime,String deleteInd) {
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		try{
			getJdbcTemplate().update(DigihealthCareRequestOTPQuery.SQL_REQUEST_OPT,phoneNumber,emailId,otpId,otpdateTime,deleteInd);		
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to access db");
		}
   		return cisResults;  
   	}
}
