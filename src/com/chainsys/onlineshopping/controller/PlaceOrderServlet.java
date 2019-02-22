package com.chainsys.onlineshopping.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.onlineshopping.dao.OrderDAO;
import com.chainsys.onlineshopping.model.Orders;
import com.chainsys.onlineshopping.model.Product;

/**
 * Servlet implementation class PlaceOrderServlet
 */
@WebServlet("/PlaceOrderServlet")
public class PlaceOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		Product prod = new Product();
		prod.setId(product_id);
		Orders order = new Orders();
		order.setProductId(prod);
		order.setQuantity(quantity);
		OrderDAO oderdao = new OrderDAO();
		oderdao.insertOrder(order);

	}

}
