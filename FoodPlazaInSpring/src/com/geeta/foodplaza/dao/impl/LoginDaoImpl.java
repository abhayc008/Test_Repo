package com.geeta.foodplaza.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.geeta.foodplaza.dao.LoginDao;
import com.geeta.foodplaza.pojo.Admin;
import com.geeta.foodplaza.pojo.Customer;

public class LoginDaoImpl implements LoginDao
{
	
	HibernateTemplate hibernateTemplate;
	

	protected LoginDaoImpl(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}


	@Override
	public boolean isAdmin(String emailId, String password) 
	{
		List<Admin> adminlist = (List<Admin>) hibernateTemplate.find("from  Admin where adminEmailId=?0 and adminPassword=?1",new Object[]{emailId,password});
	 
		
		/*
		if((adminlist.isEmpty())==true)
		{
			return false;
		}
		else 
			return true;
		*/
		return !adminlist.isEmpty();
	}


	@Override
	public boolean isCustomer(String emailId, String password)
	{
		List<Customer> custlist = (List<Customer>) hibernateTemplate.find("from Customer where customerEmailId =?0 and customerPassword =?1 ",new Object[]{emailId,password});
		return !custlist.isEmpty();
	}


}
