package com.digitalhealthcare;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISResults;

public class DigiHealthCareAdminAddCareTakerBL {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml");
	DigiHealthCareAdminAddCareTakerDAO adminCareTakerDAO=(DigiHealthCareAdminAddCareTakerDAO)ctx.getBean("addCaretaker");

	
	

	public CISResults addCareTakers(String userId, String phoneNumber) {
		// TODO Auto-generated method stub
		 CISResults cisResult = adminCareTakerDAO.addCareTakers(userId,phoneNumber);	
		return cisResult;
	}

}
