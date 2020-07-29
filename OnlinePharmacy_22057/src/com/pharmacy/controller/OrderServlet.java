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

import com.pharmacy.dao.OrderDaoImpl;
import com.pharmacy.pojo.Order;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	OrderDaoImpl odao = new OrderDaoImpl();
	Order order;
	boolean flag;
	List<Order> orderList = new ArrayList<>();
	
    public OrderServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
	    String key=request.getParameter("action");
	    String user = request.getParameter("user");
	    
		if(key!=null && key.equals("cancel")) 
		{
			int orderId=Integer.parseInt(request.getParameter("odid"));
			flag = odao.cancelOrder(orderId);
			
			if(flag) 
			{
				orderList = odao.showAllOrder();
				session.setAttribute("odlist", orderList);				
				request.setAttribute("status", "been cancelled");
			}
			else 
			{
			   request.setAttribute("status", "not been cancelled");	
			}

			RequestDispatcher rd= request.getRequestDispatcher("OrderList.jsp");
			rd.forward(request, response);
		}
		else if(key!=null && key.equals("myorders")) 
		{
			List<Order> myOrders = new ArrayList<>();
			String customerEmailId = request.getParameter("custemailid");
			myOrders = odao.showAllOrder(customerEmailId);
			session.setAttribute("myorders", myOrders);
			response.sendRedirect("MyOrderList.jsp");
			
		}
		else 
		{
			orderList = odao.showAllOrder();
			session.setAttribute("odlist", orderList);
			response.sendRedirect("OrderList.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String key=request.getParameter("action");
		String customerEmailId= (String)session.getAttribute("user");
		double totalBill=0;
		
		if(key != null && key.equals("placeorder")) 
		{
			String medicineQuantity[] = request.getParameterValues("medqty");
			String medicinePrice[] = request.getParameterValues("medprice");
			
			for(int i=0;i<medicineQuantity.length;i++) 
			{
			    totalBill = totalBill + (Integer.parseInt(medicineQuantity[i]) * Double.parseDouble(medicinePrice[i]));
			
			}
			
			Order order = odao.placeOrder(customerEmailId,totalBill);
			
			if(order != null)
			{
				request.setAttribute("placeorder", order);
			    RequestDispatcher rd = request.getRequestDispatcher("Order.jsp");
			    rd.forward(request, response);
			}
			else
			{
				out.println("Failed");
			}
		}
	}
}
