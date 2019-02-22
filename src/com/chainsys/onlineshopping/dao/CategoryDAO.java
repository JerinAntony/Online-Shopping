package com.chainsys.onlineshopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.chainsys.onlineshopping.model.Category;
import com.chainsys.onlineshopping.util.ConnectionUtil;

public class CategoryDAO {
	public void addCategory(Category category) throws Exception {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "Insert into category(id,name) values(category_id_seq.NEXTVAL,?)";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setString(1, category.getName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
