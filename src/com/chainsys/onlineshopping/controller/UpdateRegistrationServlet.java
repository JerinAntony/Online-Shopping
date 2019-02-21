package com.chainsys.onlineshopping.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.onlineshopping.dao.RegistrationDAO;
import com.chainsys.onlineshopping.model.Registration;


@WebServlet("/UpdateRegistrationServlet")
public class UpdateRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String phone=request.getParameter("phone");
	String oldPassword=request.getParameter("oldpassword");
	String newPassword=request.getParameter("newpassword");
	Registration register=new Registration();
	register.setPhoneNumber(Long.parseLong(phone));
	register.setPassword(oldPassword);
	RegistrationDAO registrationDAO=new RegistrationDAO();
	
	try {
		registrationDAO.changePassword(register,newPassword);
		RequestDispatcher req = request.getRequestDispatcher("login.html");
		req.forward(request, response);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	}

}
