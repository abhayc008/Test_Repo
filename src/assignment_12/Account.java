package assignment_12;

import java.util.Date;

class Account 
{

	int accountId;
    int accountNumber;
    String accounType;  
    boolean isActive;
    
	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccounType() {
		return accounType;
	}

	public void setAccounType(String accounType) {
		this.accounType = accounType;
	}

    
    protected Account(int accountId, int accountNumber, String accounType, boolean isActive) {
		super();
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.accounType = accounType;
		this.isActive = isActive;
	}
 
    public Account(int accountNumber)
    {
		this.accountNumber = accountNumber;	
    }

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + "\n, accountNumber=" + accountNumber + "\n, accounType=" + accounType
				+ "\n, isActive=" + isActive + "]";
	}
    	
}