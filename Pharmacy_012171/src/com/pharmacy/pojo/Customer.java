package com.pharmacy.pojo;

public class Customer 
{
	String customerName,customerAddress, customerEmailId, customerPassword ;
    int customerId;
    long customerContactNo;
    
    
	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", customerAddress=" + customerAddress + ", customerEmailId="
				+ customerEmailId + ", customerPassword=" + customerPassword + ", customerContactNo="
				+ customerContactNo + ", customerId=" + customerId + "]";
	}
	
	public Customer( int customerId,String customerName, String customerEmailId, String customerAddress, String customerPassword,
			long customer_contact_no) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerEmailId = customerEmailId;
		this.customerPassword = customerPassword;
		this.customerContactNo = customer_contact_no;
		
	}
	
	public Customer(String customerName, String customerAddress, String customerEmailId, String customerPassword,
		 long customerContactNo) {
		super();
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerEmailId = customerEmailId;
		this.customerPassword = customerPassword;
		this.customerContactNo = customerContactNo;
	}
	
	public Customer() {
		// TODO Auto-generated constructor stub
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
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
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
	
}
