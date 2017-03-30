package com.digitalhealthcare;

import org.apache.log4j.Logger;

import com.cis.CISResults;

public class DigihealthCareUserLogoutWebservice {
	static Logger logger = Logger.getLogger(DigihealthCareUserLogoutWebservice.class);
	DigihealthCareUserLogoutBL userLogoutBL=new DigihealthCareUserLogoutBL();

	public CISResults userLogout(String userId,String sessionId) {
		
		 CISResults cisResult = userLogoutBL.userLogout(userId,sessionId);
		 logger.debug(" DigitalHealthCare:save content :"+cisResult);
		return cisResult;
	}
}