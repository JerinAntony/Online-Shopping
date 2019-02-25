package com.chainsys.onlineshopping.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.onlineshopping.dao.ProductDAO;
import com.chainsys.onlineshopping.model.Product;

/**
 * Servlet implementation class UpdatePlaceOrderServlet
 */
@WebServlet("/UpdatePlaceOrderServlet")
public class UpdatePlaceOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Product> productlist = new ArrayList<>();
		ProductDAO productDAO = new ProductDAO();
		try {
			productlist.addAll(productDAO.findAll());
			request.setAttribute("PRODUCT", productlist);
			RequestDispatcher req = request
					.getRequestDispatcher("placeorder.jsp");
			req.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
