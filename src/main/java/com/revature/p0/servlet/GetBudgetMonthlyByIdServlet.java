package com.revature.p0.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.p0.daoimpl.BudgetMonthlyDAOImpl;
import com.revature.p0.model.BudgetMonthly;

@WebServlet("getBudgetMonthlyByIdServlet")
public class GetBudgetMonthlyByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetBudgetMonthlyByIdServlet() {
        super();
    }
    
    BudgetMonthlyDAOImpl bmdi = new BudgetMonthlyDAOImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
			try {
				int bmid = (Integer) session.getAttribute("expenseId");
				ArrayList<BudgetMonthly> bmList = 
			}
	}

}
