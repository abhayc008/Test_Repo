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
    Customer searchCustomerByEmailId(String customerEmailId);
    Customer searchCustomerByContactNo(long customerContactNo);
    Customer searchCustomerByPassword(String customerPassword);
    List<Customer> showAllCustomer();
    
}