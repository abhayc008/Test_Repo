package com.geeta.foodplaza.pojo;

public class Customer 
{
	private int customerId;
	private Long customerMobileNo;
	private String customerName,customerEmailId,customerPassword, customerAddress;
	
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Customer(Long customerMobileNo,String customerName, String customerEmailId, String customerAddress, String customerPassword) {
		super();
		
		this.customerMobileNo =customerMobileNo;
		this.customerName = customerName;
		this.customerEmailId = customerEmailId;
		this.customerAddress = customerAddress;
		this.customerPassword =customerPassword;
	}

	public Customer(int customerId, Long customerMobileNo,String customerName, String customerEmailId, String customerAddress, String customerPassword) {
		super();
		this.customerId = customerId;
		this.customerMobileNo =customerMobileNo;
		this.customerName = customerName;
		this.customerEmailId = customerEmailId;
		this.customerAddress = customerAddress;
		this.customerPassword =customerPassword;
	}



	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerMobileNo=" + customerMobileNo + ", customerName="
				+ customerName + ", customerEmailId=" + customerEmailId + ", customerPassword=" + customerPassword
				+ ", customerAddress=" + customerAddress + "]";
	}

	public Long getCustomerMobileNo() {
		return customerMobileNo;
	}

	public void setCustomerMobileNo(Long customerMobileNo) {
		this.customerMobileNo = customerMobileNo;
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
