package com.pharmacy.pojo;

public class Feedback 
{

	@Override
	public String toString() {
		return "Feedback [Id=" + feedbackId + ","
				+ ", Service Rating=" + rateUs
				+ ", Email=" + customerEmailId + ", Name="
				+ customerName + ", Feedback=" + suggestion + ", Date=" +feedbackDate+"]";
	}

	private int feedbackId,rateUs;
	private String customerEmailId, customerName,suggestion,feedbackDate;	
	   
    public Feedback(int rateUs,String customerEmailId,
			String customerName, String suggestion) {
		super();
		//this.feedbackId = feedbackId;
		this.rateUs = rateUs;
		this.customerEmailId = customerEmailId;
		this.customerName = customerName;
		this.suggestion = suggestion;
	}
     
    public int getFeedbackId() {
		return feedbackId;
	}
    
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}	
  
	public int getRateUs() {
		return rateUs;
	}
	
	public void setRateUs(int rateUs) {
		this.rateUs = rateUs;
	}
	
	public String getCustomerEmailId() {
		return customerEmailId;
	}
	
	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getSuggestion() {
		return suggestion;
	}
	
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	
	public String getFeedbackDate() {
		return feedbackDate;
	}
	
	public void setFeedbackDate(String feedbackDate) {
		this.feedbackDate = feedbackDate;
	}
}
