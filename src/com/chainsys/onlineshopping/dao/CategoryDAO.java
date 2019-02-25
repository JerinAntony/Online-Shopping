package com.chainsys.onlineshopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			ConnectionUtil.close(connection, preparedStatement, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Category> findAll() {
		ArrayList<Category> categoryLists = new ArrayList<>();
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "SELECT id,name FROM category ORDER BY id";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			ResultSet resultset = preparedStatement.executeQuery();
			categoryLists = new ArrayList<>();
			while (resultset.next()) {
				Category cat = new Category();
				cat.setId(resultset.getInt("id"));
				cat.setName(resultset.getString("name"));
				categoryLists.add(cat);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return categoryLists;
	}

	public Category findById(int categoryid) {
		Category category = new Category();
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "SELECT id,name FROM category where id=?";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setInt(1, categoryid);
			ResultSet resultset = preparedStatement.executeQuery();
			category = new Category();
			if (resultset.next()) {
				category.setId(resultset.getInt("id"));
				category.setName(resultset.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return category;
	}
}
