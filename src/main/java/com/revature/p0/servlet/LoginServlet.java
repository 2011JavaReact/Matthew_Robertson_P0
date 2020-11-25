package com.revature.p0.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.p0.model.User;
import com.revature.p0.service.AuthenticationService;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AuthenticationService authService = new AuthenticationService();
	
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		User u =  authService.authenticateUser(request.getParameter("username"), request.getParameter("password"));
		if(u != null) {
			session.setAttribute("userId", u.getUserId());
			session.setAttribute("username", u.getUsername());
			session.setAttribute("password", u.getPassword());
			session.setAttribute("firstname", u.getFirstname());
			session.setAttribute("lastname", u.getLastname());
			session.setAttribute("email", u.getEmail());
			response.setStatus(200);
		}else {
			session.setAttribute("problem", "invalid credentials");
			response.setStatus(400);
		}
	}

}
