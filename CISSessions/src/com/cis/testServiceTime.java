/**
 * 
 */
package com.cis;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Darshan
 *
 */
public class testServiceTime {
	public void getServiceTime(String currentDateTime,
			String otpTimeGenerateTime) {
	SimpleDateFormat format = new SimpleDateFormat(CISConstants.DATE_FORMAT);
	CISResults cisResult=new CISResults();
	Date d1 = null;
	Date d2 = null;
	try {
		d1 = format.parse(currentDateTime);
		d2 = format.parse(otpTimeGenerateTime);
      System.out.println(d1);
      System.out.println(d2);
		//in milliseconds
		long diff = d1.getTime()- d2.getTime();
		
		
		long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		long diffDays = diff / (24 * 60 * 60 * 1000);
	
		System.out.print(diff+ " milliSeconds");
		System.out.print(diffDays + " days, ");
		System.out.print(diffHours + " hours, ");
		System.out.print(diffMinutes + " minutes, ");
		System.out.print(diffSeconds + " seconds.");
		
		
		

	} catch (Exception e) {
		e.printStackTrace();
	}
	
	}
}
