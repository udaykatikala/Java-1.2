package com.digitalhealthcare;


import java.util.Calendar;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;




import com.cis.CISConstants;
import com.cis.CISResults;
import com.digitalhealthcare.DigihealthCareSaveProfile;


public class DigiHealthCareGetProfileDataDAO extends JdbcDaoSupport {

	public CISResults getProfileData(String phoneNumber) {
		DigihealthCareSaveProfile profileData;
		CISResults cisResult=new CISResults();
		Calendar cal = Calendar.getInstance();
		
		cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		
		Object[] inputs = new Object[]{phoneNumber};
		try{
			
			profileData=(DigihealthCareSaveProfile)getJdbcTemplate().queryForObject(DigiHealthCareGetProfileDataQuery.SQL_PROFILEDATA,inputs,new DigiHealthCareSaveContentMapper());
			profileData.setUserId(profileData.getUserId());
			profileData.setFirstName(profileData.getFirstName());
			profileData.setLastName(profileData.getLastName());
			profileData.setEmailId(profileData.getEmailId());	
			profileData.setPhoneNumber(profileData.getPhoneNumber());
			
			
			cisResult.setResultObject(profileData);
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResult.setErrorMessage("Failed to login to the system");
		}

   		return cisResult;  
	}


}