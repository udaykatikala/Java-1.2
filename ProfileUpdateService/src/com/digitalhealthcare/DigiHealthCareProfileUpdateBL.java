package com.digitalhealthcare;
/**
 * Profile Update Service
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */

import java.sql.Date;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;






import com.cis.CISConstants;
import com.cis.CISResults;

public class DigiHealthCareProfileUpdateBL {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigiHealthCareProfileUpdateDAO profileUpdateDAO=(DigiHealthCareProfileUpdateDAO)ctx.getBean("profileUpdateDAO");

	/**
	 * @param updateProfile
	 * @return
	 */
	public CISResults updateProfile(DigihealthCareSaveProfile updateProfile) {
		final Logger logger = Logger.getLogger(DigiHealthCareProfileUpdateBL.class);
		String phoneNumber=updateProfile.getPhoneNumber(); 
		CISResults cisResult = profileUpdateDAO.updateProfile(updateProfile.getAppId(),updateProfile.getUserId(),updateProfile.getAccountType(),updateProfile.getFirstName(),updateProfile.getLastName(),updateProfile.getEmailId(),phoneNumber,updateProfile.getGender(),updateProfile.getPhoto(),updateProfile.getDob());
		logger.debug("DigitalHealthCare:saveFeedback dao service" +cisResult );
		return cisResult;
	}

}