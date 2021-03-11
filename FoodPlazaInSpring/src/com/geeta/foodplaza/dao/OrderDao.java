package com.geeta.foodplaza.dao;

import java.util.List;

import com.geeta.foodplaza.pojo.Cart;
import com.geeta.foodplaza.pojo.Order;
import com.geeta.foodplaza.pojo.OrderDetails;

public interface OrderDao 
{
	Order placeOrder(String custEmailId, double totalPrice,List<Cart> cartList);
	List<Order> showAllOrder();
	List<OrderDetails> getOrderById(int orderId);

}
