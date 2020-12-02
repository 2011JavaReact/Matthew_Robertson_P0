package com.revature.p0.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.p0.daoimpl.UserDAOImpl;
import com.revature.p0.model.User;

@WebServlet("/getUserByIdServlet")
public class GetUserByIdServlet extends HttpServlet {

	UserDAOImpl udi = new UserDAOImpl();

	public GetUserByIdServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session != null) {
			try {
				int uid = (Integer) session.getAttribute("userId");
				ArrayList<User> userList = udi.getUserById(uid);
				response.getWriter().write((new ObjectMapper()).writeValueAsString(userList));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			response.setStatus(400);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session != null) {
			try {
				System.out.println("ServeId Check");
				int uid = (Integer) session.getAttribute("userId");
				ArrayList<User> userList = udi.getUserById(uid);
				response.getWriter().write((new ObjectMapper()).writeValueAsString(userList));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			response.setStatus(400);
		}
	}

}
