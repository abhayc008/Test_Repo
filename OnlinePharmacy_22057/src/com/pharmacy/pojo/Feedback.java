package com.pharmacy.pojo;

public class Feedback 
{

	@Override
	public String toString() {
		return "Feedback [Id=" + feedbackId + ", Medicine Name=" + medicineName +""
				+ ", Service Rating=" + rateUs
				+ ", Medicine Rating=" + rateMedicine + ", Email=" + customerEmailId + ", Name="
				+ customerName + ", Feedback=" + suggestion + ", Date=" +feedbackDate+"]";
	}

	private int feedbackId,rateUs,rateMedicine;
	private String customerEmailId, customerName,suggestion, medicineName,feedbackDate;	
	   
    public Feedback(int rateUs,String medicineName, int rateMedicine, String customerEmailId,
			String customerName, String suggestion) {
		super();
		//this.feedbackId = feedbackId;
		this.rateUs = rateUs;
		this.medicineName = medicineName;
		this.rateMedicine = rateMedicine;
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
  
	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	
	public int getRateUs() {
		return rateUs;
	}
	
	public void setRateUs(int rateUs) {
		this.rateUs = rateUs;
	}
	
	public int getRateMedicine() {
		return rateMedicine;
	}
	
	public void setRateMedicine(int rateMedicine) {
		this.rateMedicine = rateMedicine;
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
