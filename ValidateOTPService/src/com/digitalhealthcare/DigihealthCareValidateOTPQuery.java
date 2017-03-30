package com.digitalhealthcare;
/**
 * Query - Validate OTP
 * @author Castus Info Solutions
 *
 */
public class DigihealthCareValidateOTPQuery {
	
	public static String SQL_VALIDATE_OPT =" select Registered_Phone_Number,time_stamp,delete_ind from OTP_table where Registered_Phone_Number=? and OTP=? and delete_ind=?"; 
	 


}
