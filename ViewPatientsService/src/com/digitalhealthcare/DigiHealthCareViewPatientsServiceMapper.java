package com.digitalhealthcare;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


@SuppressWarnings("rawtypes")
public class DigiHealthCareViewPatientsServiceMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		DigiHealthCareViewPatientsService viewPatients = new DigiHealthCareViewPatientsService();
		
		viewPatients.setAppId(rs.getString("App_id"));
		viewPatients.setUserId(rs.getString("User_id"));
		
		viewPatients.setAccountType(rs.getString("Account_type"));
		viewPatients.setFirstName(rs.getString("First_name"));
		viewPatients.setLastName(rs.getString("Last_name"));
		viewPatients.setPhoneNumber(rs.getString("Phone_no"));
		//homeCareRegistration.setPassword(rs.getString("Password"));
		viewPatients.setEmailId(rs.getString("Email_id"));
		viewPatients.setGender(rs.getString("Gender"));
		viewPatients.setPhoto(rs.getString("Photo"));
		viewPatients.setDob(rs.getString("DOB"));
		viewPatients.setDate(rs.getDate("Date"));
		
		
		return viewPatients;
	}

}
