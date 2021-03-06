package com.chainsys.onlineshopping.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.onlineshopping.dao.CategoryDAO;
import com.chainsys.onlineshopping.dao.RegistrationDAO;
import com.chainsys.onlineshopping.model.Category;
import com.chainsys.onlineshopping.model.Registration;
import com.chainsys.onlineshopping.validator.LoginValidator;

/**
 * Servlet implementation class LoginServelt
 */
@WebServlet("/LoginServelt")
public class LoginServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		long phone = Long.parseLong(request.getParameter("phone"));
		String password = request.getParameter("password");
		Registration register = new Registration();
		register.setPhoneNumber((phone));
		register.setPassword(password);
		System.out.println(register.getPhoneNumber());
		System.out.println(register.getPassword());
		RegistrationDAO registrationDAO = new RegistrationDAO();
		CategoryDAO categoryDAO = new CategoryDAO();
		ArrayList<Category> categorylist = new ArrayList<>();
		try {
			LoginValidator validator = new LoginValidator();
			validator.loginValidator(register);
			registrationDAO.checkLogin(register);
			categorylist.addAll(categoryDAO.findAll());
			request.setAttribute("CATEGORY", categorylist);
			RequestDispatcher req = request.getRequestDispatcher("home.jsp");
			req.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher req = request.getRequestDispatcher("login.html");
			req.forward(request, response);

		}

	}

}
