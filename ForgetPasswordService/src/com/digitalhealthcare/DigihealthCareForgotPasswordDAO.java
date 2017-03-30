package com.digitalhealthcare;




import java.util.Calendar;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;








import com.cis.CISConstants;
import com.cis.CISResults;
import com.digitalhealthcare.DigihealthCareSaveProfile;


public class DigihealthCareForgotPasswordDAO extends JdbcDaoSupport {

	public CISResults forgotPassword(String emailId,String phoneNumber,int otpNumber, String otpdateTime, String deleteInd) {
		DigihealthCareSaveProfile forgotPassword;
		CISResults cisResult=new CISResults();
		cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		
		try{
			
			getJdbcTemplate().update(DigihealthCareForgotPasswordQuery.SQL_FORGOT_OTP,phoneNumber,emailId,otpNumber,otpdateTime,deleteInd);		
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResult.setErrorMessage("Failed to login to the system");
		}

   		return cisResult;  
	}

	


}