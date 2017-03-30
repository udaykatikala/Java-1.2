/**
 * 
 */
package com.digitalhealthcare;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * This class maps database table names to Model
 * @author Castus Info Solutions
 *
 */
@SuppressWarnings("rawtypes")
public class DigitalHealthCareIsCareTakerExistMapper implements RowMapper{
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		DigitalHalthCareTakersModel digiHealthCareTakersExist = new DigitalHalthCareTakersModel();	
		digiHealthCareTakersExist.setPhoneNumber(rs.getString("Phone_number"));
		digiHealthCareTakersExist.setPatientId(rs.getString("Patient_id"));
		return digiHealthCareTakersExist;
	}
}
