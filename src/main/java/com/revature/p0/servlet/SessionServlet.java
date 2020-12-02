package com.revature.p0.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.p0.model.User;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SessionServlet() {
        super(); 
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("employeeId") != null) {
			try {
				int userId = Integer.getInteger(session.getAttribute("userId").toString());
				String username = session.getAttribute("username").toString();
				String password = session.getAttribute("password").toString();
				String firstname = session.getAttribute("firstname").toString();
				String lastname = session.getAttribute("lastname").toString();
				String email = session.getAttribute("email").toString();
				User u = new User(userId, username, password, firstname, lastname, email);
				response.getWriter().write((new ObjectMapper()).writeValueAsString(u));
			}catch(Exception e) {
				e.printStackTrace();
				response.getWriter().write("{\"session\":null}");
			}
		}else {
			response.getWriter().write("{\"session\":null}");
		}
	}

}
