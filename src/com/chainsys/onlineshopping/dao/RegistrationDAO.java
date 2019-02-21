package com.chainsys.onlineshopping.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.chainsys.onlineshopping.model.Registration;
import com.chainsys.onlineshopping.util.ConnectionUtil;

public class RegistrationDAO {

	public void addCustomer(Registration register) throws Exception {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "Insert into registeration(id,username,email,password,phone_number,dateofbirth,created_date) values(registeration_id_seq.NEXTVAL,?,?,?,?,?,?)";
			PreparedStatement preparedstatement = connection
					.prepareStatement(sql);
			preparedstatement.setString(1, register.getUsername());
			preparedstatement.setString(2, register.getEmail());
			preparedstatement.setString(3, register.getPassword());
			preparedstatement.setLong(4, register.getPhoneNumber());
			preparedstatement.setDate(5,
					Date.valueOf(register.getDateOfBirth()));
			preparedstatement.setTimestamp(6, register.getCreatedDate());
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
