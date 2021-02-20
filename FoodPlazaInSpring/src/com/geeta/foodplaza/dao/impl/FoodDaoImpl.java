package com.geeta.foodplaza.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.geeta.foodplaza.dao.FoodDao;
import com.geeta.foodplaza.pojo.Food;

public class FoodDaoImpl implements FoodDao
{
	
	HibernateTemplate hibernateTemplate;
	//we use autowire attribute with constructor value in XML file.
	public FoodDaoImpl(HibernateTemplate hibernateTemplate) 
	{	
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	@Transactional
	public int save(Food food) 
	{
		int id = (int)hibernateTemplate.save(food);
		return id;
	}

	@Override
	@Transactional
	public boolean delete(int foodId) {
		try
		{
			Food food = getById(foodId);
			hibernateTemplate.delete(food);
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	@Transactional
	public boolean update(Food food) {
		try
		{
			hibernateTemplate.update(food);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Food> gets() 
	{
		List<Food> foodlist = hibernateTemplate.loadAll(Food.class); 
		return foodlist;
	}

	@Override
	public Food getById(int foodId) {
		Food food = hibernateTemplate.get(Food.class, foodId);
		return food;
	}

}
