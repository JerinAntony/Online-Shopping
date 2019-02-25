package com.chainsys.onlineshopping.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.onlineshopping.dao.ProductDAO;
import com.chainsys.onlineshopping.model.Category;
import com.chainsys.onlineshopping.model.Product;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
public class AddProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int categoryid = Integer.parseInt(request.getParameter("category"));
		System.out.println(categoryid);
		String productname = request.getParameter("product");
		String description = request.getParameter("description");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int price = Integer.parseInt(request.getParameter("price"));
		LocalDate expireddate = LocalDate.parse(request
				.getParameter("expiration_date"));
		LocalDateTime datetime = LocalDateTime.now();
		Timestamp createddate = Timestamp.valueOf(datetime);
		String status = request.getParameter("status");
		Product product = new Product();
		Category category = new Category();
		category.setId(categoryid);
		product.setCategoryId(category);
		product.setProduct(productname);
		product.setDescription(description);
		product.setQuantity(quantity);
		product.setPrice(price);
		product.setExpiredDate(expireddate);
		product.setCreatedDate(createddate);
		product.setStatus(status);
		ProductDAO productDAO = new ProductDAO();
		try {
			productDAO.addProduct(product);
			ArrayList<Product> productlist = new ArrayList<>();
			productlist.addAll(productDAO.findAll());
			request.setAttribute("PRODUCT", productlist);
			RequestDispatcher rd = request.getRequestDispatcher("product.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
