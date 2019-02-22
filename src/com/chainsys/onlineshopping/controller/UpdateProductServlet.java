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
import com.chainsys.onlineshopping.dao.RegistrationDAO;
import com.chainsys.onlineshopping.model.Product;
import com.chainsys.onlineshopping.model.Registration;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int productid = 2;
		int price = Integer.parseInt(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		System.out.println(productid);
		System.out.println(price);
		System.out.println(quantity);
		Product prod = new Product();
		prod.setId(productid);
		prod.setPrice(price);
		prod.setQuantity(quantity);
		ProductDAO productDAO = new ProductDAO();
		try {
			productDAO.updateProduct(prod);
			/*ArrayList<Product> productlist = new ArrayList<>();
			productlist.addAll(productDAO.findAll());
			request.setAttribute("PRODUCT", productlist);
			RequestDispatcher req = request
					.getRequestDispatcher("viewupdatedelete.jsp");
			req.forward(request, response);*/
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
