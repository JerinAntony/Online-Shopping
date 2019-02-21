package com.chainsys.onlineshopping.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.onlineshopping.dao.RegistrationDAO;
import com.chainsys.onlineshopping.model.Registration;

/**
 * Servlet implementation class AddRegisterationServlet
 */
@WebServlet("/AddRegisterationServlet")
public class AddRegisterationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		long phone = Long.parseLong(request.getParameter("phone"));
		System.out.println(phone);
		LocalDate dateOfBirth = LocalDate.parse(request
				.getParameter("dateOfBirth"));
		LocalDateTime datetime = LocalDateTime.now();
		Timestamp createddate = Timestamp.valueOf(datetime);
		Registration register = new Registration();
		register.setUsername(username);
		register.setEmail(email);
		register.setPassword(password);
		register.setPhoneNumber(phone);
		register.setDateOfBirth(dateOfBirth);
		register.setCreatedDate(createddate);
		RegistrationDAO registerdao = new RegistrationDAO();
		try {
			registerdao.addCustomer(register);
			RequestDispatcher rd = request
					.getRequestDispatcher("booklists.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("failure.html");
			rd.forward(request, response);
		}
	}
}
