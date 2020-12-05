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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("username") == null) {
			request.setAttribute("error", "用戶名或密码错误");
			RequestDispatcher rd = getServletConfig().getServletContext().getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}
		UserDaoImp userDaoImp = new UserDaoImp();
		for (User temp : userDaoImp.selectAll()) {
			System.out.println(temp);
			System.out.println(request.getParameter("username") + request.getParameter("password"));
			if (request.getParameter("username").equals(temp.getUsername())
					&& temp.getPassword().equals(request.getParameter("password"))) {
				request.getSession().setAttribute("uname", request.getParameter("username"));
				response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
				RequestDispatcher rd = getServletConfig().getServletContext().getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
			}
		}
		request.setAttribute("error", "用戶名或密码错误");
		RequestDispatcher rd = getServletConfig().getServletContext().getRequestDispatcher("/login.jsp");
		rd.forward(request, response);
	}

}
