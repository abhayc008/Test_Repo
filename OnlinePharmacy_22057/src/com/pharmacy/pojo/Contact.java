package com.pharmacy.pojo;

public class Contact 
{
	private int contactId;
	private String firstName, LastName,subject, message, emailId;
	
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Contact(String firstName, String lastName, String subject, String message, String emailId) {
		super();
		this.firstName = firstName;
		LastName = lastName;
		this.subject = subject;
		this.message = message;
		this.emailId = emailId;
	}
	
	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", firstName=" + firstName + ", LastName=" + LastName + ", subject="
				+ subject + ", message=" + message + ",emailid=" + emailId + "]";
	}
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	   

}
