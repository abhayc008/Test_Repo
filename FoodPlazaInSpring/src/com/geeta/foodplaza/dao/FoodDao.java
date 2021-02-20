package com.geeta.foodplaza.dao;

import java.util.List;

import com.geeta.foodplaza.pojo.Food;

public interface FoodDao
{
	int save(Food food);
	boolean delete(int foodId);
	boolean update(Food food);
	List<Food> gets();
	Food getById(int foodId);
	
}
