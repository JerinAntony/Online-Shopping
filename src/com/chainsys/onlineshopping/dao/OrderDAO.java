package com.chainsys.onlineshopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import com.chainsys.onlineshopping.model.Orders;
import com.chainsys.onlineshopping.util.ConnectionUtil;

public class OrderDAO {
	public void insertOrder(Orders order) {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "INSERT INTO orders (id,product_id,quantity,order_no,ordered_date,registered_id) values(orders_id_seq.NEXTVAL,?,?,orders_order_no_seq.NEXTVAL,?,?)";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			order.setProductId(order.getProductId());
			order.setQuantity(order.getQuantity());
			LocalDate date = LocalDate.now();
			order.setOrderedDate(date);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
