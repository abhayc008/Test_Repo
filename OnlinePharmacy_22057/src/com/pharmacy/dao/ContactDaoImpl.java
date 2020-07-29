package com.pharmacy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pharmacy.dbutility.DBUtility;
import com.pharmacy.pojo.Contact;


public class ContactDaoImpl implements ContactDao
{
	Connection con = DBUtility.getConnection();
    PreparedStatement ps;
    ResultSet rs;
    boolean flag;
    int row;
    Contact contact;

    
    String addContact = "insert into contact_22057(first_name,last_name,"
			+ "subject,message,email_id)  values(?,?,?,?,?) ";
    
    String showContact = "Select * from contact_22057";


	@Override
	public boolean addContact(Contact contact)
	{
		try 
		{
			ps = con.prepareStatement(addContact);
			ps.setString(1, contact.getFirstName());
			ps.setString(2, contact.getLastName());
			ps.setString(3, contact.getSubject());
			ps.setString(4, contact.getMessage());
			ps.setString(5, contact.getEmailId());
			
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
	public List<Contact> showAllContact() 
	{
		
		List<Contact> lstContact = new ArrayList<Contact>();
		try 
		{
			ps = con.prepareStatement(showContact);
			
			rs = ps.executeQuery();
		
			while(rs.next())
			{
		        contact = new Contact(		        	
		                rs.getString("first_name"),
		        		rs.getString("last_name"),
		        		rs.getString("subject"),
		        		rs.getString("message"),
		        		rs.getString("email_id")
		        		);
		        contact.setContactId(rs.getInt("contact_id"));
		       
		        lstContact.add(contact);
			}
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		return lstContact;
	}
			
	}

