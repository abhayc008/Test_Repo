package com.geeta.foodplaza.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.geeta.foodplaza.dao.CartDao;
import com.geeta.foodplaza.dao.OrderDao;
import com.geeta.foodplaza.pojo.Order;

@Controller
public class OrderController 
{
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	CartDao cartDao;
	
	@RequestMapping(value="/placeorder")
	public ModelAndView placeOrder(@RequestParam("totalPrice") double totalPrice, HttpSession session)
	{
		
		ModelAndView mv = new ModelAndView();
        
		String custEmailId = (String)session.getAttribute("customer");
		
		Order order = orderDao.placeOrder(custEmailId, totalPrice);
		
		cartDao.clearCart(custEmailId);
		
		mv.addObject("msg","Order has been placed successfully...!!!");
		mv.addObject("order", order);
		mv.setViewName("orderDetails");
		
		return mv;
	}

}
