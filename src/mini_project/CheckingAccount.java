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
		setBalance(10000);
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
		System.out.println("--------------------------------");
		System.out.println("Current Account balance is Rs." +balance);
		System.out.println("--------------------------------");
	}

	public Transaction depositInAccount() throws AmountInvalidException 
	{   
		Transaction  trans=new Transaction();
		double depositAmount;
		System.out.println("--------------------------------");
		System.out.println("Enter the amount to deposit: ");
		System.out.println("--------------------------------");
		depositAmount=scanner.nextDouble();
		
		if(depositAmount<=25000 && depositAmount >0)
		{
			if(depositAmount%100==0)
			{
				balance+=depositAmount;
				System.out.println("--------------------------------");
				System.out.println("Updated balance is Rs."+balance);
				System.out.println("--------------------------------");
				}
				else
				{
					throw new AmountInvalidException("change");
					//System.out.println("Amount should be greater than 0");
				}
			}
		else 
		{
			throw new AmountInvalidException("deposite");
		}
		trans.transactionDate=new Date();
		trans.closingBalance= balance;
		trans.deposit=depositAmount;
		
		return trans;
		
	}
	public Transaction withDrawFromAccount() 
	{
		double  withDrawAmount;
		double drawAmount;
		double notes;
		Transaction  trans=new Transaction();
		System.out.println("--------------------------------");
		System.out.println("Enter the amount to withdraw :");
		System.out.println("--------------------------------");
		withDrawAmount=scanner.nextDouble();
		
		drawAmount = withDrawAmount;
		
		if((balance- (minBalance +withDrawAmount))>=0 && withDrawAmount > 0 )
		{
			if(drawAmount % 100 == 0){
				
				if(drawAmount >=2000)
				{
					notes = Math.abs(drawAmount/2000);
					System.out.println("2000 notes: "+notes);
					drawAmount=drawAmount%2000;
				}
				if(drawAmount >= 500)
				{
					notes = Math.abs(drawAmount/500);
					System.out.println("500 notes: "+notes);
					drawAmount=drawAmount%500;
				}
				if(drawAmount >= 200)
				{
					notes = Math.abs(drawAmount/200);
					System.out.println("200 notes: "+notes);
					drawAmount=drawAmount%200;
				}
				if(drawAmount >= 100)
				{
					notes = Math.abs(drawAmount/100);
					System.out.println("100 notes: "+notes);
					drawAmount=drawAmount%100;
				}
		     	balance-=withDrawAmount;
		     	System.out.println("-------------------------------");
			    System.out.println("Updated balance is Rs. "+balance);
			    System.out.println("--------------------------------");
			}
			else
			{
				try 
				{
					throw new AmountInvalidException("withdraw");
				} 
				catch (AmountInvalidException e) 
				{
					
					System.out.println(e);
				}
			}
		    
		}
		else
		{
			try 
			{
				throw new InsufficientAmountException(balance);
			}
			catch (InsufficientAmountException e) 
			{
				System.out.println(e);
			}
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
		System.out.println("-------------------------------------------------------------------");
		System.out.println("transactionDate************deposit*****withdraw******closingBalance");
		System.out.println("-------------------------------------------------------------------");
		for(Transaction i:transactions)
		{
		    System.out.println(i.transactionDate+"   "+i.deposit+"   "+i.withdraw+"   "+i.closingBalance);
		}
		System.out.println("--------------------------------------------------------------------");
	}
}
