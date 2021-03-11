package com.pharmacy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.pharmacy.dbutility.DBUtility;


@WebServlet("/CheckUser")
public class CheckUserName extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
    public CheckUserName() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String customerEmailId = request.getParameter("custemailid");
		
		PrintWriter out = response.getWriter();
		
		Connection con = DBUtility.getConnection();
		
		try {
			PreparedStatement ps =con.prepareStatement("Select * from customer_22057 where customer_email_id=?");
			ps.setString(1,customerEmailId);
			
			ResultSet rs   = ps.executeQuery();
			
			if(rs.next()) 
			{
			    String msg = "Already Exist";
			    
			    Gson gson = new Gson();
			    
			    String message = gson.toJson(msg);// converting java object to json
			    
			    response.setContentType("application/json"); //type by default text/java
			    
			    out.print(message);
			}
			else 
			{
               out.print("");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
