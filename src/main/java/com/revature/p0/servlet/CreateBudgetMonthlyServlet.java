package com.revature.p0.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.p0.dao.BudgetMonthlyDAO;
import com.revature.p0.daoimpl.BudgetMonthlyDAOImpl;

@WebServlet("/createBudgetMonthlyServlet")
public class CreateBudgetMonthlyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateBudgetMonthlyServlet() {
        super();
    }

    BudgetMonthlyDAOImpl bmdi = new BudgetMonthlyDAOImpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		
		if(session != null) {
			int user_id = Integer.parseInt(session.getAttribute("userId").toString());
			double housing = Double.parseDouble(request.getParameter("housing"));
			double utilities = Double.parseDouble(request.getParameter("utilities"));
			double internet = Double.parseDouble(request.getParameter("internet"));
			double grocery = Double.parseDouble(request.getParameter("grocery"));
			double entertainment = Double.parseDouble(request.getParameter("entertainment"));
			double transportation = Double.parseDouble(request.getParameter("transportation"));
			double savings = Double.parseDouble(request.getParameter("savings"));
			
			boolean test = false;
			try {
				test = bmdi.createBudgetMonthly(user_id, housing, utilities, internet, grocery, entertainment, transportation, savings);
				response.setStatus(200);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}else {
			response.setStatus(400);
		}
	}

}
