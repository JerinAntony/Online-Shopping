package com.chainsys.onlineshopping.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.chainsys.onlineshopping.model.Category;
import com.chainsys.onlineshopping.model.Orders;
import com.chainsys.onlineshopping.model.Product;
import com.chainsys.onlineshopping.model.Registration;
import com.chainsys.onlineshopping.util.ConnectionUtil;

public class OrderDAO {
	public void insertOrder(Orders order) {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "INSERT INTO orders (id,product_id,quantity,order_no,ordered_date,registered_id) values(orders_id_seq.NEXTVAL,?,?,orders_order_no_seq.NEXTVAL,?,?)";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setInt(1, order.getProductId().getId());
			preparedStatement.setInt(2, order.getQuantity());
			preparedStatement.setDate(3, Date.valueOf(order.getOrderedDate()));
			preparedStatement.setInt(4, order.getRegisterId().getId());
			preparedStatement.executeUpdate();
			ConnectionUtil.close(connection, preparedStatement, null);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Orders> findAll() {
		ArrayList<Orders> odersLists = new ArrayList<>();
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "SELECT id,product_id,quantity,order_no,ordered_date,registered_id FROM orders ORDER BY id";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			ResultSet resultset = preparedStatement.executeQuery();
			System.out.println(resultset);
			ProductDAO productDAO = new ProductDAO();
			while (resultset.next()) {
				Orders orders = new Orders();
				Product product = new Product();
				Registration register = new Registration();
				orders.setId(resultset.getInt("id"));
				product = productDAO.findById(resultset.getInt("product_id"));
				orders.setProductId(product);
				orders.setQuantity(resultset.getInt("quantity"));
				orders.setOrderNo(resultset.getInt("order_no"));
				orders.setOrderedDate(resultset.getDate("ordered_date")
						.toLocalDate());
				register.setId(resultset.getInt("registered_id"));
				orders.setRegisterId(register);
				System.out.println(orders);
				odersLists.add(orders);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return odersLists;
	}
}
