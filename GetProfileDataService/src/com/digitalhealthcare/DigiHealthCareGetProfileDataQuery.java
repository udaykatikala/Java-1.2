package com.digitalhealthcare;

public class DigiHealthCareGetProfileDataQuery {
	public static String SQL_PROFILEDATA = " select App_id,User_id,Account_type,First_name,Last_name,Phone_no,Email_id,Gender,DOB,Date from Profile_table where User_id=? "; 
	 

}
