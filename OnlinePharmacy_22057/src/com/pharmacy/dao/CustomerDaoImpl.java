package com.pharmacy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pharmacy.dbutility.DBUtility;
import com.pharmacy.pojo.Customer;

public class CustomerDaoImpl implements CustomerDao
{

	Customer customer;
	Connection con = DBUtility.getConnection();
	int row;
     

    String addCust = "insert into customer_22057 (customer_name,customer_email_id, customer_password,"
    		+ "customer_contact_no,customer_address) values(?,?,?,?,?)";
    
    String updateCust = "update customer_22057 set customer_name = ?,customer_email_id= ? , customer_password= ?,customer_contact_no= ?,customer_address = ?"
    		           +"where customer_id=?";
    
	String deleteCust = "delete from customer_22057 where customer_id = ?";
	
	String searchById = "select * from customer_22057 where customer_id = ?";
	
	String searchByName = "select * from customer_22057 where customer_name like ? ";
	
	String searchByEmailId = "select * from customer_22057 where customer_email_id= ?";
	
	String searchByContactNo = "select * from customer_22057 where customer_contact_no = ?";
	
	String searchByPassword = "select * from customer_22057 where customer_password = ?";
	
	String showAll = "select * from customer_22057";
	
    @Override
	public boolean addCustomer(Customer customer) 
	{
		try 
		{
			PreparedStatement ps =con.prepareStatement(addCust);
			ps.setString(1, customer.getCustomerName());
			ps.setString(2, customer.getCustomerEmailId());
			ps.setString(3, customer.getCustomerPassword());
			ps.setLong(4, customer.getCustomerContactNo());
			ps.setString(5, customer.getCustomerAddress());
			
			row = ps.executeUpdate();
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		if(row>0) 
		{
			return true;
		}
		else 
		{
	 	  return false;
		}
	}

	@Override
	public boolean updateCustomer(Customer customer)
	{
		try 
		{
			PreparedStatement ps =con.prepareStatement(updateCust);
			ps.setString(1, customer.getCustomerName());
			ps.setString(2, customer.getCustomerEmailId());
			ps.setString(3, customer.getCustomerPassword());
			ps.setLong(4, customer.getCustomerContactNo());
			ps.setString(5, customer.getCustomerAddress());
			ps.setInt(6, customer.getCustomerId());
			
			row = ps.executeUpdate();
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		if(row>0) 
		{
			return true;
		}
		else 
		{
	 	  return false;
		}
	}

	@Override
	public boolean deleteCustomer(int customerId)
	{
		try 
		{
		   PreparedStatement ps = con.prepareStatement(deleteCust);
		   ps.setInt(1, customerId);
		   
		   row = ps.executeUpdate();
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	    if(row>0) 
	    {
	    	return true;
	    }
	    else 
	    {
	    	return false;	
	    }
	}

	@Override
	public Customer searchCustomerById(int customerId) 
	{
		try 
	    {   
	          	    
      	  PreparedStatement ps = con.prepareStatement(searchById);
      	  ps.setInt(1, customerId);
      	  
      	  ResultSet rs = ps.executeQuery();

      	  while (rs.next()) 
			  {
                 int customer_id = rs.getInt("customer_id");
                 String customer_name = rs.getString("customer_name");
                 String customer_email_id = rs.getString("customer_email_id");
                 String customer_password = rs.getString("customer_password");
                 String customer_address = rs.getString("customer_address");
                 long customer_contact_no = rs.getLong("customer_contact_no");
                 
				
				 customer = new Customer(customer_name,customer_email_id,customer_password,customer_contact_no,customer_address);
				 customer.setCustomerId(customer_id);
			  }	 
	    }   
		
	    catch(Exception ex) 
	    {
	    	ex.printStackTrace();
	    }
		return customer;
	}

	@Override
	public List<Customer> searchCustomerByCustomerName(String customerName)
	{
		List<Customer> lstCustomer = new ArrayList<>();
		try 
	    { 
			
      	  PreparedStatement ps = con.prepareStatement(searchByName);
      	  ps.setString(1, "%" +customerName+ "%");
      	  ResultSet rs = ps.executeQuery();

      	  while (rs.next()) 
			  {
      		     String name = rs.getString("customer_name");
      		     if(name.contains(customerName)) 
      		     {
      		    	 int customer_id = rs.getInt("customer_id");
                     String customer_name = rs.getString("customer_name");
                     String customer_email_id = rs.getString("customer_email_id");
                     String customer_password = rs.getString("customer_password");
                     String customer_address = rs.getString("customer_address");
                     long customer_contact_no = rs.getLong("customer_contact_no");
                     
    				
    				 customer = new Customer(customer_name,customer_email_id,customer_password,customer_contact_no,customer_address);
    				 customer.setCustomerId(customer_id);
    			     lstCustomer.add(customer) ; 
      		     }
                
			  }	 
	    }   
		
	    catch(Exception ex) 
	    {
	    	ex.printStackTrace();
	    }
		return lstCustomer;
	}


	@Override
	public List<Customer> showAllCustomer() 
	{
		List<Customer> allCust = new ArrayList<>();
		try 
		{
			PreparedStatement ps = con.prepareStatement(showAll);
	      	  
	      	ResultSet rs = ps.executeQuery();
			while (rs.next()) 
			  {
               int customer_id = rs.getInt("customer_id");
               String customer_name = rs.getString("customer_name");
               String customer_email_id = rs.getString("customer_email_id");
               String customer_password = rs.getString("customer_password");
               String customer_address = rs.getString("customer_address");
               long customer_contact_no = rs.getLong("customer_contact_no");
               
				
				 customer = new Customer(customer_name,customer_email_id,customer_password,customer_contact_no,customer_address);
				 customer.setCustomerId(customer_id);
				 
			     allCust.add(customer) ;
			  }	 
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		return allCust;
	}

	@Override
	public Customer searchCustomerByEmailId(String customerEmailId)
	{
		try 
	    { 
			
      	  PreparedStatement ps = con.prepareStatement(searchByEmailId);
      	  ps.setString(1, customerEmailId);
      	  ResultSet rs = ps.executeQuery();

      	  while (rs.next()) 
			  {
      		  
      		     int customer_id = rs.getInt("customer_id");
                 String customer_name = rs.getString("customer_name");
                 String customer_email_id = rs.getString("customer_email_id");
                 String customer_password = rs.getString("customer_password");
                 String customer_address = rs.getString("customer_address");
                 long customer_contact_no = rs.getLong("customer_contact_no");
                     
    			 customer = new Customer(customer_name,customer_email_id,customer_password,customer_contact_no,customer_address);
    			 customer.setCustomerId(customer_id);
    		 
      		   }	 
	    }   
	    catch(Exception ex) 
	    {
	    	ex.printStackTrace();
	    }
		return customer;
	}

	@Override
	public Customer searchCustomerByContactNo(long customerContactNo) 
	{
		try 
	    { 
			
      	  PreparedStatement ps = con.prepareStatement(searchByContactNo);
      	  ps.setLong(1, customerContactNo);
      	  ResultSet rs = ps.executeQuery();

      	  while (rs.next()) 
			  {
      		  
      		     int customer_id = rs.getInt("customer_id");
                 String customer_name = rs.getString("customer_name");
                 String customer_email_id = rs.getString("customer_email_id");
                 String customer_password = rs.getString("customer_password");
                 String customer_address = rs.getString("customer_address");
                 long customer_contact_no = rs.getLong("customer_contact_no");
                     
    			 customer = new Customer(customer_name,customer_email_id,customer_password,customer_contact_no,customer_address);
    			 customer.setCustomerId(customer_id);
    		 
      		   }	 
	    }   
	    catch(Exception ex) 
	    {
	    	ex.printStackTrace();
	    }
		return customer;
	}

	@Override
	public Customer searchCustomerByPassword(String customerPassword) 
	{
		try 
	    { 
			
      	  PreparedStatement ps = con.prepareStatement(searchByPassword);
      	  ps.setString(1, customerPassword);
      	  ResultSet rs = ps.executeQuery();

      	  while (rs.next()) 
			  {
      		  
      		     int customer_id = rs.getInt("customer_id");
                 String customer_name = rs.getString("customer_name");
                 String customer_email_id = rs.getString("customer_email_id");
                 String customer_password = rs.getString("customer_password");
                 String customer_address = rs.getString("customer_address");
                 long customer_contact_no = rs.getLong("customer_contact_no");
                     
    			 customer = new Customer(customer_name,customer_email_id,customer_password,customer_contact_no,customer_address);
    			 customer.setCustomerId(customer_id);
    		 
      		   }	 
	    }   
	    catch(Exception ex) 
	    {
	    	ex.printStackTrace();
	    }
		return customer;
	}

}
