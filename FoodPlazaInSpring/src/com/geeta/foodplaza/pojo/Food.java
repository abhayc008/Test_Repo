package com.geeta.foodplaza.pojo;

import java.util.Set;

import javax.persistence.OneToMany;

public class Food 
{
	private int foodId;
	private String foodName,foodCategory,foodDescription;
	private double foodPrice;
	private byte [] foodImage;
	
	@OneToMany(mappedBy="food")
	private Set<Order> Order;
	
	public Food() {
		super();
	}

	public Food(String foodName, String foodCategory, double foodPrice) {
		super();
		this.foodName = foodName;
		this.foodCategory = foodCategory;
		this.foodPrice = foodPrice;
	}

	public Food(int foodId, String foodName, String foodCategory, double foodPrice) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodCategory = foodCategory;
		this.foodPrice = foodPrice;
	}
	
	public Food(int foodId, String foodName, String foodCategory, String foodDescription, double foodPrice,
			byte[] foodImage) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodCategory = foodCategory;
		this.foodDescription = foodDescription;
		this.foodPrice = foodPrice;
		this.foodImage = foodImage;
	}

	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", foodName=" + foodName + ", foodCategory=" + foodCategory
				+ ", foodDescription=" + foodDescription + ", foodPrice=" + foodPrice + "]";
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getFoodCategory() {
		return foodCategory;
	}

	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}

	public double getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}

	public String getFoodDescription() {
		return foodDescription;
	}

	public void setFoodDescription(String foodDescription) {
		this.foodDescription = foodDescription;
	}

	public byte[] getFoodImage() {
		return foodImage;
	}

	public void setFoodImage(byte[] foodImage) {
		this.foodImage = foodImage;
	}
	
	
	
	
}
