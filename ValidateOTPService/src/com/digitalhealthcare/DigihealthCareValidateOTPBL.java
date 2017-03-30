package com.digitalhealthcare;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.SessionTimeCheck;
/**
 * Validates OTP
 * @author Castus Info Solutions
 *
 */

public class DigihealthCareValidateOTPBL {
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigihealthCareValidateOTPDAO verifyOTPDAO=(DigihealthCareValidateOTPDAO)ctx.getBean("validateotpDAO");

	/**
	 * Validates OTP
	 * @param phoneNumber
	 * @param emailId
	 * @param otp
	 * @return 0-Success,1-Error
	 */
	public CISResults validateOTP(String phoneNumber,String emailId,String otp) {
		final Logger logger = Logger.getLogger(DigihealthCareValidateOTPBL.class);
		SessionTimeCheck sessionTimeCheck=new SessionTimeCheck();
		String contact=CISConstants.USA_COUNTRY_CODE+phoneNumber;
		String deleteInd=CISConstants.DELETE_IND;
		 Calendar currentdate = Calendar.getInstance();
	      DateFormat formatter = new SimpleDateFormat(CISConstants.DATE_FORMAT);
	      TimeZone obj = TimeZone.getTimeZone("CST");
	      formatter.setTimeZone(obj);
	      System.out.println("Local:: " +currentdate.getTime());
	      System.out.println("CST:: "+ formatter.format(currentdate.getTime()));
		
	    String OtpTimeGenerateTime;
		CISResults cisResult = verifyOTPDAO.validateOTP(contact,emailId,otp,deleteInd);
		logger.info("DigitalHealthCare:Validate OTP  BL service" +cisResult );
		if(cisResult.getResponseCode().contentEquals(CISConstants.RESPONSE_SUCCESS)){
		 DigihealthCareValidateOTP validate=(DigihealthCareValidateOTP)cisResult.getResultObject();
		 OtpTimeGenerateTime=validate.getTimeStamp();
		  String currentDateTime = formatter.format(currentdate.getTime());
		  cisResult=sessionTimeCheck.checkSessionTime(currentDateTime,OtpTimeGenerateTime);
		}
		
		return cisResult;
	}


}