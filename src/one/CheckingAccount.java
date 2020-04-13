package mini_project;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

class CheckingAccount
{
	private double balance;
	private int number;
	private double minBalance=1000;
	Scanner scanner=new Scanner(System.in);
	CheckingAccount()
	{
		setBalance(0);
	}
	public int getNumber()
	{
		return number;
	}

	public void setNumber(int number)
	{
		this.number = number;
	}

	public void setBalance(double balance)
	{
		this.balance = balance;
	}	
	public void getBalance()
	{
		System.out.println("Current Account balance is Rs." +balance);
	}

	public Transaction depositInAccount() throws AmountInvalidException 
	{   
		Transaction  trans=new Transaction();
		double depositAmount;
		System.out.println("Enter the amount to deposit");
		depositAmount=scanner.nextDouble();
		
		if(depositAmount>=25000 && depositAmount%100==0 )
		{
		balance+=depositAmount;
		System.out.println("Updated balance is Rs."+balance);
		}
		else
		{
			throw new AmountInvalidException();
			//System.out.println("Amount should be greater than 0");
		}
		trans.transactionDate=new Date();
		trans.closingBalance= balance;
		trans.deposit=depositAmount;
		
		return trans;
		
	}
	public Transaction withDrawFromAccount() throws InsufficientAmountException
	{
		double withDrawAmount;
		Transaction  trans=new Transaction();
		System.out.println("Enter the amount to withdraw");
		withDrawAmount=scanner.nextDouble();
		
		if((balance- (minBalance +withDrawAmount))>=0)
		{
		balance-=withDrawAmount;
		
		System.out.println("Updated balance is Rs. "+balance);
		}
		else
		{
			throw new InsufficientAmountException(balance);
			//System.out.println("Insufficient balance to process withdraw request.");
			//System.out.println("Your account balance is Rs."+balance);
		}
		trans.transactionDate=new Date();
		trans.closingBalance= balance;
		trans.withdraw=withDrawAmount;
		
		return trans; 
	 }
	public void miniStatement(List<Transaction> transactions) 
	{
		System.out.println("transactionDate deposit  withdraw  closingBalance");
		for(Transaction i:transactions)
		{
		    System.out.println(i.transactionDate+"  "+i.deposit+"  "+i.withdraw+" "+i.closingBalance);
		}
	}
}
