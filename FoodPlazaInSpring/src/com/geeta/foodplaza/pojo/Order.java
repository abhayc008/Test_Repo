package com.geeta.foodplaza.pojo;

import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="order_101")
public class Order 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	//if you want to change the name of column then use column annotation
	//dont use a
	@Column(name="custEmailId")
	private String custEmailId;
	
	private double totalAmount;
	private LocalDateTime orderDateTime;
	private String orderStatus = "Processing";
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="order_fId",referencedColumnName = "orderId")
	private List<OrderDetails> orderDetails = new ArrayList<>();
	

	public Order()
	{
		
	}
    
    



	public Order(String custEmailId, double totalAmount, LocalDateTime orderDateTime) {
		super();
		this.custEmailId = custEmailId;
		this.totalAmount = totalAmount;
		this.orderDateTime = orderDateTime;
	}

	

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}





	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}





	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustEmailId() {
		return custEmailId;
	}

	public void setCustEmailId(String custEmailId) {
		this.custEmailId = custEmailId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDateTime getOrderDateTime() {
		return orderDateTime;
	}

	public void setOrderDateTime(LocalDateTime orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", custEmailId=" + custEmailId + ", totalAmount=" + totalAmount
				+ ", orderDateTime=" + orderDateTime + ", orderStatus=" + orderStatus + "]";
	}
	

}
