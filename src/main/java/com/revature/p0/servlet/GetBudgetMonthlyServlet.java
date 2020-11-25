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
import com.revature.p0.daoimpl.BudgetMonthlyDAOImpl;
import com.revature.p0.model.BudgetMonthly;

@WebServlet("/getBudgetMonthlyServletList")
public class GetBudgetMonthlyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ObjectMapper om = new ObjectMapper();
      
	BudgetMonthlyDAOImpl bmdi = new BudgetMonthlyDAOImpl();
  
    public GetBudgetMonthlyServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//HttpSession session = request.getSession(false);
		
		//if(session != null) {
			try {
				ArrayList<BudgetMonthly> reqList = bmdi.getBudgetMonthly();
				response.getWriter().write((new ObjectMapper()).writeValueAsString(reqList));
			}catch(Exception e) {
				e.printStackTrace();
			}
	//}else {
		//response.setStatus(400);
	//}
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
