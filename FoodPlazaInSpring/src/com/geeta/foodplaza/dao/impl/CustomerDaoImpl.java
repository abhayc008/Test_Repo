package com.geeta.foodplaza.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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


	@Override
	@Transactional
	public Customer getByEmailId(String customerEmailId) 
	{
		SessionFactory session= hibernateTemplate.getSessionFactory(); 
		Query query = session.getCurrentSession().createQuery("from Customer where customerEmailId = :customerEmailId");
		query.setParameter("customerEmailId", customerEmailId);
		return (Customer) query.list().get(0);
		

	    
	}


}
