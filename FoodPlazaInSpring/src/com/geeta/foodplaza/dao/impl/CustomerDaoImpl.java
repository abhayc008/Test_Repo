package com.geeta.foodplaza.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.geeta.foodplaza.dao.CustomerDao;
import com.geeta.foodplaza.pojo.Customer;



public class CustomerDaoImpl implements CustomerDao 
{
	
	HibernateTemplate hibernateTemplate;
	
	public CustomerDaoImpl(HibernateTemplate hibernateTemplate) 
	{	
		this.hibernateTemplate = hibernateTemplate;
	}


	@Override
	@Transactional
	public int save(Customer customer) 
	{
		int id = (int)hibernateTemplate.save(customer);
		return id;
	}

	@Override
	@Transactional
	public boolean delete(int customerId)
	{
		try
		{
			Customer customer = getById(customerId);
			hibernateTemplate.delete(customer);
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	@Transactional
	public boolean update(Customer customer)
	{
		try
		{
			hibernateTemplate.update(customer);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Customer> gets()
	{
		List<Customer> custlist = hibernateTemplate.loadAll(Customer.class); 
		return custlist;
	}

	@Override
	public Customer getById(int customerId) {
		Customer customer = hibernateTemplate.get(Customer.class, customerId);
		return customer;
	}

}
