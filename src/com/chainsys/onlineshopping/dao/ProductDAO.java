package com.chainsys.onlineshopping.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.chainsys.onlineshopping.model.Category;
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
			ConnectionUtil.close(connection, preparedStatement, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Product> findAll() throws SQLException {
		ArrayList<Product> productLists = new ArrayList<>();

		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT id,category_id,product,description,quantity,price,expired_date,created_date,status FROM product ORDER BY id";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultset = preparedStatement.executeQuery();
		productLists = new ArrayList<>();
		CategoryDAO categoryDAO = new CategoryDAO();
		while (resultset.next()) {
			Product product = new Product();
			product.setId(resultset.getInt("id"));
			Category cat = new Category();
			cat = categoryDAO.findById(resultset.getInt("category_id"));
			product.setCategoryId(cat);
			product.setProduct(resultset.getString("product"));
			product.setDescription(resultset.getString("description"));
			product.setQuantity(resultset.getInt("quantity"));
			product.setPrice(resultset.getInt("price"));
			product.setExpiredDate(resultset.getDate("expired_date")
					.toLocalDate());
			product.setStatus(resultset.getString("status"));
			productLists.add(product);
		}
		ConnectionUtil.close(connection, preparedStatement, null);
		return productLists;
	}

	public void deleteProduct(int id) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sqldelete = "Delete from product where id=?";
		PreparedStatement preparedstatement = connection
				.prepareStatement(sqldelete);
		preparedstatement.setInt(1, id);
		int row = preparedstatement.executeUpdate();
		System.out.println("Delete record sucessfully :" + row);
		ConnectionUtil.close(connection, preparedstatement, null);
	}

	public void updateProduct(Product product) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "UPDATE product set price=?,quantity=? where id=?";
		PreparedStatement preparedstatement = connection.prepareStatement(sql);
		preparedstatement.setInt(1, product.getPrice());
		preparedstatement.setInt(2, product.getQuantity());
		preparedstatement.setInt(3, product.getId());
		int row = preparedstatement.executeUpdate();
		System.out.println("Update :" + row);
		ConnectionUtil.close(connection, preparedstatement, null);

	}

	public Product findById(int productid) throws SQLException {
		Product product = null;
		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT id,category_id,product,quantity,price FROM product where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, productid);
		ResultSet resultset = preparedStatement.executeQuery();
		if (resultset.next()) {
			product = new Product();
			product.setId(resultset.getInt("id"));
			product.setProduct(resultset.getString("product"));
			product.setQuantity(resultset.getInt("quantity"));
			product.setPrice(resultset.getInt("price"));
			Category category = new Category();
			category.setId(resultset.getInt("category_id"));
			product.setCategoryId(category);
		}
		ConnectionUtil.close(connection, preparedStatement, null);
		return product;
	}
}
