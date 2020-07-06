package com.pharmacy.pojo;

public class Order
{

	private int orderId;
	private String customerEmailId, orderStatus;
	private double totalBill;
	private String orderDate;
	
	
	public Order(int orderId, String customerEmailId, String orderStatus, double totalBill, String orderDate) {
		super();
		this.orderId = orderId;
		this.customerEmailId = customerEmailId;
		this.orderStatus = orderStatus;
		this.totalBill = totalBill;
		this.orderDate = orderDate;
	}
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustomerEmailId() {
		return customerEmailId;
	}
	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public double getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerEmailId=" + customerEmailId + ", orderStatus=" + orderStatus
				+ ", totalBill=" + totalBill + ", orderDate=" + orderDate + "]";
	}
	
}
