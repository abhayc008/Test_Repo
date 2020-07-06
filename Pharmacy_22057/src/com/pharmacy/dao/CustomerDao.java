package com.pharmacy.dao;

import java.util.List;

import com.pharmacy.pojo.Customer;

public interface CustomerDao
{
    boolean addCustomer(Customer customer);
    boolean updateCustomer(Customer customer);
    boolean   deleteCustomer(int customerId);
    Customer searchCustomerById(int customerId);
    List<Customer> searchCustomerByCustomerName(String customerName);
    List<Customer> searchCustomerByEmailId(String customerEmailId);
    List<Customer> showAllCustomer();
    
}