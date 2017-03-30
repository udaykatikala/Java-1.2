package com.digitalhealthcare;

/**
 * Validates OTP
 * @author Castus Info Solutions
 *
 */
import org.apache.log4j.Logger;

import com.cis.CISResults;


public class DigihealthCareValidateOTPWebservice {

	static Logger logger = Logger.getLogger(DigihealthCareValidateOTPWebservice.class);
	DigihealthCareValidateOTPBL verifyOTPBL=new DigihealthCareValidateOTPBL();

	/** 
	 * Compares input otp with otp value stored in the database
	 * @param phoneNumber
	 * @param emailId
	 * @param otp
	 * @return 0-Success,1-Error
	 */
	public CISResults validateOTP(String phoneNumber,String emailId,String otp) {
		
		 CISResults otResult = verifyOTPBL.validateOTP(phoneNumber,emailId,otp);
		 logger.info(" DigitalHealthCare:Validate OTP :"+otResult);
		return otResult;
	}
}