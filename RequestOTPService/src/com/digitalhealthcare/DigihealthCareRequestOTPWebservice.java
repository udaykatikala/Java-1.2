package com.digitalhealthcare;

/**
 * Provides service to return OTP (One Time Password)
 * 
 * @author Castus info solutions
 *
 */
import org.apache.log4j.Logger;


import com.cis.CISResults;

public class DigihealthCareRequestOTPWebservice {
	
	static Logger logger = Logger.getLogger(DigihealthCareRequestOTPWebservice.class);
	DigihealthCareRequestOTPBL otpBL=new DigihealthCareRequestOTPBL();

	/**
	 * generates and sends OTP to input phone number
	 * @param phoneNumber
	 * @param emailId
	 * @return 0-Success,1-Error
	 */
	public CISResults requestOTP(String phoneNumber,String emailId) {
		CISResults cisResult = null;
		try {
			 cisResult = otpBL.requestOTP(phoneNumber,emailId);
			// logger.info(" DigitalHealthCare:Webservice Request OTP :"+cisResult);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cisResult;
	}


}
