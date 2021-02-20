package com.geeta.foodplaza.dao;

public interface LoginDao
{
    public boolean isAdmin(String emailId, String password);
    public boolean isCustomer(String emailId, String password);
    //getCustomerbyEmailId(String emailId)
}
