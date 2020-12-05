package com.yzk.shopsystem.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yzk.shopsystem.daoimp.UserDaoImp;
import com.yzk.shopsystem.model.User;

@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDaoImp userDaoImp = new UserDaoImp();
		User user = new User(1, request.getParameter("username"), request.getParameter("password"),
				request.getParameter("gender"), request.getParameter("tel"), request.getParameter("email"),
				request.getParameter("addres"));
		userDaoImp.insert(user);
		RequestDispatcher rd = getServletConfig().getServletContext().getRequestDispatcher("/login.jsp");
		rd.forward(request, response);
	}

}
