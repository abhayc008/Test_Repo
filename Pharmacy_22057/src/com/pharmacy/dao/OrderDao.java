package com.pharmacy.dao;

import java.util.List;

import com.pharmacy.pojo.Order;

public interface OrderDao 
{
    Order placeOrder(String customerEmailId);//core java
    Order placeOrder(String customerEmailId, double totalBill);//for advanced java
    List<Order> showAllOrder(String customerEmailId);// for particular order
    boolean cancelOrder(int orderId);
    //for Admin
    List<Order> showAllOrder();// for 
}
