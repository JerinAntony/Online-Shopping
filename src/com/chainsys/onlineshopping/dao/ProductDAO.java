package com.chainsys.onlineshopping.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.chainsys.onlineshopping.model.Product;
import com.chainsys.onlineshopping.util.ConnectionUtil;

public class ProductDAO {

	public void addProduct(Product poduct) throws Exception {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "Insert into product(id,category_id,product,description,quantity,price,expired_date,created_date,status) values(product_id_seq.NEXTVAL,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setInt(1, poduct.getCategoryId().getId());
			preparedStatement.setString(2, poduct.getProduct());
			preparedStatement.setString(3, poduct.getDescription());
			preparedStatement.setInt(4, poduct.getQuantity());
			preparedStatement.setInt(5, poduct.getPrice());
			preparedStatement.setDate(6, Date.valueOf(poduct.getExpiredDate()));
			preparedStatement.setTimestamp(7, poduct.getCreatedDate());
			preparedStatement.setString(8, poduct.getStatus());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
