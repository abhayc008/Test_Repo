package com.geeta.foodplaza.dao;

import com.geeta.foodplaza.pojo.Order;

public interface OrderDao 
{
	Order placeOrder(String custEmailId, double totalPrice);

}
