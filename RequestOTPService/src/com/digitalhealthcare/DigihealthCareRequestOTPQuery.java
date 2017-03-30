package com.digitalhealthcare;

/**
 * Provides service to return OTP (One Time Password)
 * 
 * @author Castus info solutions
 *
 */
public class DigihealthCareRequestOTPQuery {
	
	public static String SQL_REQUEST_OPT ="insert into OTP_table(Registered_Phone_Number,EmailId,OTP,time_stamp,delete_ind)"+"values(?,?,?,?,?)"; 
	
	public static String SQL_CHECKPHONENUMBER=" SELECT Registered_Phone_Number FROM Profile_table WHERE Registered_Phone_Number=?"; 

	//public static String SQL_DELETEOTP="DELETE FROM Request_OTP WHERE User_Id=?";
}