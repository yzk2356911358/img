package com.yzk.shopsystem.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yzk.shopsystem.daoimp.ShopDaoImp;
import com.yzk.shopsystem.model.Shop;

@WebServlet("/GetShop")
public class GetShop extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ShopDaoImp daoImp = new ShopDaoImp();
		int id = Integer.parseInt(request.getParameter("id"));

		for (Shop temp : daoImp.selectAll()) {
			if (temp.getId() == id) {
				request.setAttribute("shop", temp);
				RequestDispatcher rd = getServletConfig().getServletContext().getRequestDispatcher("/getshop.jsp");
				rd.forward(request, response);
			}
		}

	}

}
