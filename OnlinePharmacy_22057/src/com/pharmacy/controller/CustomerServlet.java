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

import com.pharmacy.dao.CustomerDaoImpl;
import com.pharmacy.pojo.Customer;

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    Customer customer;
    CustomerDaoImpl impl = new CustomerDaoImpl();
    List<Customer> customerList = new ArrayList<>();
    boolean flag;
    
    public CustomerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		HttpSession session = request.getSession();	
		String key = request.getParameter("action");
		
		if(key !=null && key.equals("delete")) 
		{
			int customerId=Integer.parseInt(request.getParameter("custId"));
			flag = impl.deleteCustomer(customerId);
			
			if(flag) 
			{
				customerList = impl.showAllCustomer();
				session.setAttribute("custList", customerList);
				request.setAttribute("status", "been deleted");
				
				//response.sendRedirect("CustomerList.jsp");	
			}
			else 
			{
				request.setAttribute("status", "not been deleted");
			}

			RequestDispatcher rd= request.getRequestDispatcher("CustomerList.jsp");
			rd.forward(request, response);
			
		}
		else if(key !=null && key.equals("update")) 
		{
			int customerId=Integer.parseInt(request.getParameter("custId"));
			customer = impl.searchCustomerById(customerId);
			session.setAttribute("cust", customer);
			response.sendRedirect("UpdateCustomer.jsp");
		}
		else if(key !=null && key.equals("edit")) 
		{
			String customerEmailId=request.getParameter("custemailid");
			customer = impl.searchCustomerByEmailId(customerEmailId);
			session.setAttribute("cust", customer);
			response.sendRedirect("UpdateCustomer.jsp");
		}
		else 
		{
			customerList = impl.showAllCustomer();
			session.setAttribute("custList", customerList);
			response.sendRedirect("CustomerList.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String customerName,customerEmailId,customerPassword,customerAddress;
		long customerContactNo;
		int customerId;
		
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String key = request.getParameter("action");
		
		if(key!=null && key.equals("add")) 
		{
			customerName = request.getParameter("custName");
			customerEmailId = request.getParameter("custEmailId");
			customerPassword = request.getParameter("custPassword");
			customerContactNo = Long.parseLong(request.getParameter("custContactNo"));
			customerAddress = request.getParameter("custAddress");
			
	       		
			customer = new Customer(customerName,customerEmailId,customerPassword,
					 customerContactNo,customerAddress);
			
			flag = impl.addCustomer(customer);
			
			if(flag) 
			{
				customerList = impl.showAllCustomer();
				session.setAttribute("custList", customerList);
				session.setAttribute("status", "been added");
				//response.sendRedirect("CustomerList.jsp");
			}
			else 
			{
				session.setAttribute("status", "not been added");
			}
			RequestDispatcher rd= request.getRequestDispatcher("CustomerList.jsp");
			rd.forward(request, response);
		}
		
		else if(key!=null && key.equals("update"))
		{

			customerId = Integer.parseInt(request.getParameter("custid"));
			customerName = request.getParameter("custname");
			customerEmailId = request.getParameter("custemailid");
			customerPassword = request.getParameter("custpassword");
			customerContactNo = Long.parseLong(request.getParameter("custcontactno"));
			customerAddress = request.getParameter("custaddress");
			
	       		
			customer = new Customer(customerName,customerEmailId,customerPassword,
					 customerContactNo,customerAddress);
			
			customer.setCustomerId(customerId);
			
			flag = impl.updateCustomer(customer);
			
			if(flag) 
			{
				customerList = impl.showAllCustomer();
				session.setAttribute("custList", customerList);
				session.setAttribute("status", "been updated");
				//response.sendRedirect("CustomerList.jsp");
			}
			else 
			{
				session.setAttribute("status", "not been updated");
			}
			
			RequestDispatcher rd= request.getRequestDispatcher("CustomerList.jsp");
			rd.forward(request, response);
		}
	}
}
