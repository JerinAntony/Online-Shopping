package com.chainsys.onlineshopping.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.onlineshopping.dao.ProductDAO;
import com.chainsys.onlineshopping.model.Product;

/**
 * Servlet implementation class DeleteProductServlet
 */
@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			ProductDAO productdao = new ProductDAO();
			/*
			 * String[] deleteproduct = request.getParameterValues("delete");
			 * System.out.println(deleteproduct.length); int[] productid = new
			 * int[deleteproduct.length]; for (String ss : deleteproduct) {
			 * System.out.println(ss); } for (int i = 0; i < productid.length;
			 * i++) { productid[i] = Integer.parseInt(deleteproduct[i]);
			 * System.out.println(productid[i]);
			 * productdao.deleteProduct(productid[i]); }
			 */
			int productidt = Integer
					.parseInt(request.getParameter("product"));
			productdao.deleteProduct(productidt);
			List<Product> productlist = productdao.findAll();
			request.setAttribute("PRODUCT", productlist);
			RequestDispatcher rd = request
					.getRequestDispatcher("viewupdatedelete.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("failure.html");
			rd.forward(request, response);
			e.printStackTrace();
		}
	}

}
