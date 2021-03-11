package com.pharmacy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pharmacy.dao.FeedbackDaoImpl;
import com.pharmacy.pojo.Feedback;

@WebServlet("/FeedbackServlet")
public class FeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	FeedbackDaoImpl fdao = new FeedbackDaoImpl();
	List<Feedback> feedbackList = new ArrayList<>();
	Feedback feed ;
    
    public FeedbackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		    String key=request.getParameter("action");
		    HttpSession session = request.getSession();
		    
          
		    if(key!=null && key.equals("add"))		    
		    {	
				response.sendRedirect("Feedback.jsp");
		    }
		    else 
		    {
			    feedbackList = fdao.showAllFeedback();
				session.setAttribute("fedlist", feedbackList);
				response.sendRedirect("FeedbackList.jsp");	
		    }
		    

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int rateUs;
		String customerEmailId, customerName,suggestion;
		boolean flag;	
		
		PrintWriter out = response.getWriter();
		
		System.out.print("hello");
		
		String key=request.getParameter("action");
		
		System.out.print(key);
		if(key!=null && key.equals("add")) 
		{ 
			
			customerName = request.getParameter("custname");
			customerEmailId = request.getParameter("custemailid");
			rateUs =Integer.parseInt(request.getParameter("selected_rating"));
			suggestion=request.getParameter("suggestion");
			
			feed = new Feedback(rateUs,customerEmailId,customerName,suggestion);
			
			System.out.println(feed);
			
			flag = fdao.addFeedback(feed);
			
			System.out.println(flag);
			   
			   if(flag) 
			   {
				    
				   request.setAttribute("status_feedback", "added successfully");
				   
			   }
			   else 
			   {
				   out.print("not been added");
			   }

				RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);

		}
	}

}
