package com.geeta.foodplaza.dao;

import java.util.List;

import com.geeta.foodplaza.pojo.Customer;


public interface CustomerDao 
{
	
	int save(Customer customer);
	boolean delete(int customerId);
	boolean update(Customer customer);
	List<Customer> gets();
	Customer getById(int customerId);
	Customer getByEmailId(String customerEmailId);
}
