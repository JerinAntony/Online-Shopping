package com.chainsys.onlineshopping.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.onlineshopping.dao.OrderDAO;
import com.chainsys.onlineshopping.model.Orders;
import com.chainsys.onlineshopping.model.Product;
import com.chainsys.onlineshopping.model.Registration;

/**
 * Servlet implementation class PlaceOrderServlet
 */
@WebServlet("/PlaceOrderServlet")
public class PlaceOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int product_id = Integer.parseInt(request.getParameter("product"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		Product prod = new Product();
		prod.setId(product_id);
		Orders order = new Orders();
		order.setProductId(prod);
		System.out.println("product"+order.getProductId().getId());
		order.setQuantity(quantity);
		LocalDate orderdate = LocalDate.now();
		order.setOrderedDate(orderdate);
		Registration reg = new Registration();
		reg.setId(2);
		order.setRegisterId(reg);
		OrderDAO oderdao = new OrderDAO();
		try {
			oderdao.insertOrder(order);
			ArrayList<Orders> orderlist = new ArrayList<>();
			orderlist.addAll(oderdao.findAll());
			request.setAttribute("ORDERS", orderlist);
			RequestDispatcher rd = request
					.getRequestDispatcher("ordersummary.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
