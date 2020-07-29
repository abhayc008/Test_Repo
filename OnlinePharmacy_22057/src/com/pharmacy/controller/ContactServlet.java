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

import com.pharmacy.dao.ContactDaoImpl;
import com.pharmacy.pojo.Contact;

@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	ContactDaoImpl cdao = new ContactDaoImpl();
	List<Contact> contactList = new ArrayList<>();
	Contact contact ;
    
    public ContactServlet() {
        super();
     }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		 String key=request.getParameter("action");
		 HttpSession session = request.getSession();
		 
		 if(key!=null && key.equals("add"))		    
		 {	
		    response.sendRedirect("Contact.jsp");
		 }
		 else 
		  {
			 
			    contactList = cdao.showAllContact();
			    
				session.setAttribute("contactlist", contactList);
				response.sendRedirect("ContactList.jsp");	
		    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 
			String firstName, messsage, lastName,subject,emailId;
			boolean flag;	
			
			PrintWriter out = response.getWriter();
			
			System.out.print("hello");
			
			String key=request.getParameter("action");
			
			System.out.print(key);
			if(key!=null && key.equals("add")) 
			{ 
				
				firstName = request.getParameter("firstname");
				lastName = request.getParameter("lastname");
				emailId = request.getParameter("emailid");
				subject= request.getParameter("subject");
				messsage=request.getParameter("message");
			    
				
				
				contact = new Contact(firstName,lastName,subject,messsage,emailId);
				
				System.out.println(contact);
				
				flag = cdao.addContact(contact);
				
				System.out.println(flag);
				   
				   if(flag) 
				   {
					    
					   request.setAttribute("status_contact", "successfully ");
					   
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
