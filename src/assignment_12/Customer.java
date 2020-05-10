package assignment_12;

public class Customer
{
	
	protected Customer() {
		super();
	}
	private String firstName;
    private String lastName;
    private int contactNo;
    private int customerId;
    private Account account;
   

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + "\n, lastName=" + lastName + "\n, contactNo=" + contactNo
				+ "\n, customerId=" + customerId + "\n, account=" + account + "]";
	}
	
     protected Customer(String firstName, String lastName, int contactNo, int customerId, Account account) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNo = contactNo;
		this.customerId = customerId;
		this.account = account;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getContactNo() {
		return contactNo;
	}
	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
}