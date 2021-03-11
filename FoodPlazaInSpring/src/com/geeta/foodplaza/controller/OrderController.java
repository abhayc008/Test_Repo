package com.geeta.foodplaza.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.geeta.foodplaza.dao.CartDao;
import com.geeta.foodplaza.dao.OrderDao;
import com.geeta.foodplaza.pojo.Cart;
import com.geeta.foodplaza.pojo.Food;
import com.geeta.foodplaza.pojo.Order;
import com.geeta.foodplaza.pojo.OrderDetails;

@Controller
public class OrderController 
{
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	CartDao cartDao;
	
	
	
	@RequestMapping(value="/placeorder")
	public ModelAndView placeOrder(@RequestParam("totalPrice") double totalPrice, 
			@RequestParam("cartId") int cartId,HttpSession session)
	{
		
		ModelAndView mv = new ModelAndView();
        
		String custEmailId = (String)session.getAttribute("customer");
		
		//Add Order Main data
		List<Cart> cartlist = (List<Cart>) session.getAttribute("cartlist");
		Order order = orderDao.placeOrder(custEmailId, totalPrice,cartlist);
		
		
		//After successfully place order clear Cart
		cartDao.clearCart(custEmailId);
	
		//
		mv.addObject("msg","Order has been placed successfully...!!!");
		mv.addObject("order", order);
		mv.setViewName("orderDetails");
		
		return mv;
	}
	
	@RequestMapping(value="/allorder")
	public ModelAndView showAllOrder()
	{

		ModelAndView mv = new ModelAndView();
		List<Order> orderlist = orderDao.showAllOrder();
		mv.addObject("orderlist", orderlist);//request scope
		//session.setAttribute("foodlist", foodlist);//session scope
		mv.setViewName("allorders");
		return mv;
		
		
	}
	@RequestMapping(value="/orderDetails")
	public ModelAndView orderDetailsById(@RequestParam("orderId") int orderId)
	{
		ModelAndView mv = new ModelAndView();
		List<OrderDetails>  orderDetails = orderDao.getOrderById(orderId);
		
		mv.addObject("orderDetails", orderDetails);//request scope
		//session.setAttribute("foodlist", foodlist);//session scope
		mv.setViewName("orderDetails");
		return mv;
	}


}
