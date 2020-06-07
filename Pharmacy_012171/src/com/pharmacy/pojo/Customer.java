package com.pharmacy.pojo;

public class Customer 
{
	private int customerId;
	private String customerName,customerEmailId, customerPassword ;
    private long customerContactNo;
    private String customerAddress;

	public Customer(String customerName, String customerEmailId, String customerPassword, long customerContactNo,
			String customerAddress) {
		super();
		this.customerName = customerName;
		this.customerEmailId = customerEmailId;
		this.customerPassword = customerPassword;
		this.customerContactNo = customerContactNo;
		this.customerAddress = customerAddress;
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
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	public long getCustomerContactNo() {
		return customerContactNo;
	}
	public void setCustomerContactNo(long customerContactNo) {
		this.customerContactNo = customerContactNo;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerEmailId="
				+ customerEmailId + ", customerPassword=" + customerPassword + ", customerContactNo="
				+ customerContactNo + ", customerAddress=" + customerAddress + "]";
	}

}
