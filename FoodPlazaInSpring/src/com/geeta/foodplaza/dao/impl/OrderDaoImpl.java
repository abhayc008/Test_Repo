package com.geeta.foodplaza.dao.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.geeta.foodplaza.dao.OrderDao;
import com.geeta.foodplaza.pojo.Cart;
import com.geeta.foodplaza.pojo.Order;
import com.geeta.foodplaza.pojo.OrderDetails;

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
	public Order placeOrder(String custEmailId, double totalPrice,List<Cart> cartList)
	{
		/*
		Order order= new Order();
		order.setCustEmailId(custEmailId);
		order.setTotalAmount(totalPrice);
	 	*/
		
		LocalDateTime orderDateTime =  LocalDateTime.now();
		
		Order order = new Order(custEmailId,totalPrice,orderDateTime);
		int id = (int) hibernateTemplate.save(order);
		
		for(Cart cart:cartList)
		{
			OrderDetails orderDetails = new OrderDetails(id, cart.getFoodId(),cart.getCartFoodQuantity(), cart.getFoodPrice(),cart.getFoodName());
			hibernateTemplate.save(orderDetails);
		}
		
		order = hibernateTemplate.get(Order.class, id);
		System.out.println("After place order is:-" +order);
		
		return order;
	}

	@Override
	public List<Order> showAllOrder() {
		List<Order> lstOrder = hibernateTemplate.loadAll(Order.class);
		return lstOrder;
	}

	@Override
	public List<OrderDetails> getOrderById(int orderId) 
	{
		List<OrderDetails> lstOrder = (List<OrderDetails>)hibernateTemplate.find("from  OrderDetails where order_fId=?0 ",new Object[]{orderId});
		
		return  lstOrder;
	}
	
}
