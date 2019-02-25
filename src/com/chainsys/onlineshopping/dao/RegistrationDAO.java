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
			ConnectionUtil.close(connection, preparedstatement, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void changePassword(Registration register, String newpassword)
			throws Exception {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "UPDATE registeration SET password=? WHERE phone_number=? and password=?";
			PreparedStatement preparedstatement = connection
					.prepareStatement(sql);
			preparedstatement.setString(1, newpassword);
			preparedstatement.setLong(2, register.getPhoneNumber());
			preparedstatement.setString(3, register.getPassword());
			preparedstatement.executeUpdate();
			ConnectionUtil.close(connection, preparedstatement, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Registration checkLogin(Registration register) {
		Registration registration = null;
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "select phone_number,password from registeration where phone_number=? and password=?";
			PreparedStatement preparedstatement = connection
					.prepareStatement(sql);
			long phone = register.getPhoneNumber();
			preparedstatement.setLong(1, phone);
			preparedstatement.setString(2, register.getPassword());
			preparedstatement.executeUpdate();
			ConnectionUtil.close(connection, preparedstatement, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return registration;
	}
}
