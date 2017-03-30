/**
 * 
 */
package com.digitalhealthcare;

/**
 * Query to check if account already exists 
 * @author Castus Info Solutions
 *
 */
public class DigiHealthCareAccountExistQuery {
	public static String SQL_VALIDATE_ACCOUNT = "select Phone_no,User_id,Email_id,First_name,Last_name,Account_type,Password from Profile_table where Phone_no=?";
	public static String SQL_CHECK_CARETAKERS = "select Patient_id,Phone_number from Patient_phonenumber where Phone_number=? ";
	
}
