package com.geeta.foodplaza.pojo;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="cart_101")
public class Cart 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cartId;
	
	@Column
	private int foodId;
	
	private String foodName;
	private double foodPrice;
	
	@Column
	private int cartFoodQuantity;
	
	@Column
	private String cartCustEmailId;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
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
	public double getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}
	public int getCartFoodQuantity() {
		return cartFoodQuantity;
	}
	public void setCartFoodQuantity(int cartFoodQuantity) {
		this.cartFoodQuantity = cartFoodQuantity;
	}
	public String getCartCustEmailId() {
		return cartCustEmailId;
	}
	public void setCartCustEmailId(String cartCustEmailId) {
		this.cartCustEmailId = cartCustEmailId;
	}
}
