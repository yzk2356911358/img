package com.yzk.shopsystem.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yzk.shopsystem.daoimp.ShopDaoImp;
import com.yzk.shopsystem.model.Shop;

@WebServlet("/ShopList")
public class ShopListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Shop> shops = new ArrayList<Shop>();
		ShopDaoImp daoImp = new ShopDaoImp();
		String fl = request.getParameter("fl");
		if (fl == null) {
			for (Shop temp : daoImp.selectAll()) {
				if (temp.getFl().equals("海鲜")) {
					shops.add(temp);
				}
			}
			request.setAttribute("list", shops);
			RequestDispatcher rd = getServletConfig().getServletContext().getRequestDispatcher("/shoplist.jsp");
			rd.forward(request, response);
		}
		if (fl.equals("sc")) {
			for (Shop temp : daoImp.selectAll()) {
				if (temp.getFl().equals("牲畜")) {
					shops.add(temp);
				}
			}
			request.setAttribute("list", shops);
			RequestDispatcher rd = getServletConfig().getServletContext().getRequestDispatcher("/shoplist.jsp");
			rd.forward(request, response);
		}
		if (fl.equals("hx")) {
			for (Shop temp : daoImp.selectAll()) {
				if (temp.getFl().equals("海鲜")) {
					shops.add(temp);
				}
			}
			request.setAttribute("list", shops);
			RequestDispatcher rd = getServletConfig().getServletContext().getRequestDispatcher("/shoplist.jsp");
			rd.forward(request, response);
		}
		if (fl.equals("jq")) {
			for (Shop temp : daoImp.selectAll()) {
				if (temp.getFl().equals("家禽")) {
					shops.add(temp);
				}
			}
			request.setAttribute("list", shops);
			RequestDispatcher rd = getServletConfig().getServletContext().getRequestDispatcher("/shoplist.jsp");
			rd.forward(request, response);
		}
		if (fl.equals("sg")) {
			for (Shop temp : daoImp.selectAll()) {
				if (temp.getFl().equals("水果")) {
					shops.add(temp);
				}
			}
			request.setAttribute("list", shops);
			RequestDispatcher rd = getServletConfig().getServletContext().getRequestDispatcher("/shoplist.jsp");
			rd.forward(request, response);
		}
		else
			for (Shop temp : daoImp.selectAll()) {
				if (temp.getFl().equals("蔬菜")) {
					shops.add(temp);
				}
			}
		request.setAttribute("list", shops);
		RequestDispatcher rd = getServletConfig().getServletContext().getRequestDispatcher("/shoplist.jsp");
		rd.forward(request, response);

	}

}
