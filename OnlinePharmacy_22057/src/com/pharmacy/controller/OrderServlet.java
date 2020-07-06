package com.pharmacy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pharmacy.dao.OrderDaoImpl;
import com.pharmacy.pojo.Order;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	OrderDaoImpl odao = new OrderDaoImpl();
	Order order;
       
    public OrderServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String key=request.getParameter("aaction");
		String customerEmailId= (String)session.getAttribute("user");
		double totalBill=0;
		
		if(key != null && key.equals("placeorder")) 
		{
			String medicineQuantity[] = request.getParameterValues("medqty");
			String medicinePrice[] = request.getParameterValues("medprice");
			
			for(int i=0;i<=medicineQuantity.length;i++) 
			{
				totalBill = totalBill + (Integer.parseInt(medicineQuantity[i]) * Double.parseDouble(medicinePrice[i]));
				
			}
		}
		Order order = odao.placeOrder(customerEmailId,totalBill);
		
		if(order != null)
			out.println("Order Placed");
		else
			out.println("Failed");
		}
	}
