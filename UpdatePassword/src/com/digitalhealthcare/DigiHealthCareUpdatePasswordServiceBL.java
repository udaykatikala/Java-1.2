package com.digitalhealthcare;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.MailCommunication;


public class DigiHealthCareUpdatePasswordServiceBL {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	
	DigiHealthCareUpdatePasswordServiceDAO updatePasswordServiceDAO=(DigiHealthCareUpdatePasswordServiceDAO)ctx.getBean("UpdatePasswordDAO");

	public CISResults updatePassword(String userId,String password) {
		final Logger logger = Logger.getLogger(DigiHealthCareUpdatePasswordServiceBL.class);
		  
		CISResults cisResult = updatePasswordServiceDAO.updatePassword(userId,password);
		logger.info("DigitalHealthCare:ProfileDataBL  service" +cisResult );
		
		return cisResult;
	}


}