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

import com.pharmacy.dao.CartDaoImpl;
import com.pharmacy.pojo.Cart;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    Cart cart = new Cart();
    CartDaoImpl cdao = new CartDaoImpl();
    List<Cart> cList = new ArrayList<>();
    boolean flag;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String key= request.getParameter("action");
		String customerEmailId = (String)session.getAttribute("user");
		
		if(key != null && key.equals("addtocart")) 
		{
			int medicineId =Integer.parseInt(request.getParameter("medId"));
		
			cart.setMedicineId(medicineId);
			cart.setMedicineQty(1);
			cart.setCustomerEmailId(customerEmailId);
			
			flag = cdao.addToCart(cart);
			
			if(flag) 
			{
				cList = cdao.showCart(customerEmailId);
				session.setAttribute("list_Cart",cList);
				response.sendRedirect("CartList.jsp");
			}
			else 
			{
				out.print("failed");
			}
			
		}
		else if(key != null && key.equals("delete"))
		{
			int cartId = Integer.parseInt(request.getParameter("cartid"));
			flag = cdao.deleteToCart(cartId);
			
			if(flag) 
			{
				cList = cdao.showCart(customerEmailId);
				session.setAttribute("list_Cart",cList);
				request.setAttribute("status", "been deleted!!!");
			}
			else 
			{
				request.setAttribute("status", "not been deleted !!!");
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("CartList.jsp");
			rd.forward(request, response);
		}
		else 
		{
			cList = cdao.showCart(customerEmailId);
			session.setAttribute("list_Cart",cList);
			response.sendRedirect("CartList.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
