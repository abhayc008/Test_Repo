package com.geeta.foodplaza.dao.impl;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.geeta.foodplaza.dao.OrderDao;
import com.geeta.foodplaza.pojo.Order;

public class OrderDaoImpl implements OrderDao
{
	
	HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	@Transactional
	public Order placeOrder(String custEmailId, double totalPrice)
	{
		/*
		Order order= new Order();
		order.setCustEmailId(custEmailId);
		order.setTotalAmount(totalPrice);
	 	*/
		
		LocalDateTime orderDateTime =  LocalDateTime.now();
		
		Order order = new Order(custEmailId,totalPrice,orderDateTime);
		int id = (int) hibernateTemplate.save(order);
		
		
		order = hibernateTemplate.get(Order.class, id);
		System.out.println("After place order is:-" +order);
		
		return order;
	}
	
	//profile--by getbyEmailId, forget password, change password
	//emailId verification--through ajax
	//Add Admin
	//clear cart
}
