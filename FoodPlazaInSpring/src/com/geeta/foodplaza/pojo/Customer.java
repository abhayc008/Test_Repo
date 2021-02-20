package com.geeta.foodplaza.pojo;

public class Customer 
{
	private int customerId;
	private String customerName,customerEmailId,customerPassword, customerAddress;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String customerName, String customerEmailId, String customerAddress, String customerPassword) {
		super();
		this.customerName = customerName;
		this.customerEmailId = customerEmailId;
		this.customerAddress = customerAddress;
		this.customerPassword =customerPassword;
	}

	public Customer(int customerId, String customerName, String customerEmailId, String customerAddress, String customerPassword) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmailId = customerEmailId;
		this.customerAddress = customerAddress;
		this.customerPassword =customerPassword;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerEmailId="
				+ customerEmailId + ", customerAddress=" + customerAddress +",customerPassword ="+customerPassword+ "]";
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmailId() {
		return customerEmailId;
	}

	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	
	
	
}
