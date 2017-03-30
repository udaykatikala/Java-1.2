package com.digitalhealthcare;


import org.apache.log4j.Logger;

import com.cis.CISResults;


public class DigiHealthCareGetProfileDataWebservice {
	
	static Logger logger = Logger.getLogger(DigiHealthCareGetProfileDataWebservice.class);
	
	DigiHealthCareGetProfileDataBL profileBL=new DigiHealthCareGetProfileDataBL();

	public CISResults getProfileData(String phoneNumber) {
		
		 CISResults cisResult = profileBL.getProfileData(phoneNumber);
		 logger.info(" DigitalHealthCare:ProfileDataWebService :"+cisResult);
		return cisResult;
	}
}