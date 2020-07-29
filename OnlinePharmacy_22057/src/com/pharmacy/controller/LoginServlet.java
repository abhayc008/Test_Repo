package com.pharmacy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pharmacy.dao.CustomerDaoImpl;
import com.pharmacy.dao.LoginDaoImpl;
import com.pharmacy.pojo.Customer;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	LoginDaoImpl ldao = new LoginDaoImpl();
	CustomerDaoImpl impl = new CustomerDaoImpl();
    boolean flag;
    
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("index.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type,userName,password,key;
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();
		
		key=request.getParameter("action");
		type=request.getParameter("selecttype");
		userName=request.getParameter("loginid");
		password=request.getParameter("password");
		
		
		
		if(key!=null && key.equals("login")) 
		{
			//flag=ldao.userLogin(userName,password);
			if(type!=null && type.equals("User")) 
			{
				flag=ldao.userLogin(userName,password);
				System.out.println(userName);
				System.out.println(password);
				System.out.print(flag);
				if(flag == true) 
				{
				    session.setAttribute("user", userName);	
				    out.write("success");
				    
				    response.sendRedirect("index.jsp");
				}
				else 
				{
					request.setAttribute("status", "Invalid Creditials !!!");
					RequestDispatcher rd =request.getRequestDispatcher("Login.jsp");
					rd.forward(request, response);
				}
				
			}
			else if(type!=null && type.equals("Admin"))
			{
				//List <Customer> custList = new ArrayList<>();
				
				flag=ldao.adminLogin(userName,password);
				//custList = impl.searchCustomerByEmailId(userName);
				if(flag == true) 
				{
					session.setAttribute("admin",userName);
					response.sendRedirect("index.jsp");
					//RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
					//rd.forward(request, response);
				}
				else 
				{
					
					request.setAttribute("status", "Invalid Creditionals !!!");
					RequestDispatcher rd =request.getRequestDispatcher("Login.jsp");
					rd.forward(request, response);
				}
			}	
		}
		
		if(key != null && key.equals("change")) 
		{
			if(type!=null && type.equals("User")) 
			{
				flag=ldao.userChangePassword(userName, password);
				
				if(flag == true) 
				{
					request.setAttribute("status", "Successfully Changed!!!");
					RequestDispatcher rd =request.getRequestDispatcher("Login.jsp");
					rd.forward(request, response);
				}
				else 
				{
					request.setAttribute("status", "Failed");					
				}
			}
			else if(type!=null && type.equals("Admin"))
			{
				flag=ldao.adminChangePassword(userName, password);
				if(flag == true) 
				{
					request.setAttribute("status", "Successfully Changed!!!");
				}
				else 
				{
					request.setAttribute("status", "Failed!!!");

				}

			}

			RequestDispatcher rd =request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
	}
}

