package assignment_12;

import java.util.Date;

public class Transaction
{
	   @Override
	public String toString() {
		return "Transaction [transactionDate=" + transactionDate + ", amount=" + amount + ", fromAccount=" + fromAccount
				+ ", toAccount=" + toAccount + "]";
	}
	Date transactionDate;
	   int amount;	   
	   int fromAccount;
	   int toAccount;	  
	   
	 
}
