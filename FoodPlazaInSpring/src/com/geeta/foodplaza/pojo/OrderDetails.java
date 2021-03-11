package com.geeta.foodplaza.pojo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="order_details_101")
public class OrderDetails 
{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int order_fId;
	
	private int foodId;
	
	private int qty;
	
	private double price;
	
	private String foodName; 
	
	
    public OrderDetails(int order_fId,int foodId, int qty, double price, String foodName) {
		super();
		this.order_fId = order_fId;
		this.foodId = foodId;
		this.qty = qty;
		this.price = price;
		this.foodName = foodName;
	}

	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", order_fId=" + order_fId + ", foodId=" + foodId + ", qty=" + qty
				+ ", price=" + price + ", foodName=" + foodName + "]";
	}
	
}
