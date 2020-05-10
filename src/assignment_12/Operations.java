package assignment_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Operations
{
	private int minBalance = 1000;

	 Scanner scanner = new Scanner(System.in);
      
     InputStreamReader isr = new InputStreamReader(System.in);
		
     BufferedReader br = new BufferedReader(isr);

	public void addAccount(List<Customer> customers, List<Transaction> transactions) throws IOException
	{		
		String firstName;
		String lastName,accounType;
		int contactNo, accountId,accountNumber;
		int customerId;
		Account account;
		
		customerId = customers.size() +1;
		boolean isActive = true;
		
	    System.out.println("Enter firstName ");
	    firstName =  br.readLine();
	
		System.out.println("Enter lastName: ");
		lastName =  br.readLine();
		
		System.out.println("Enter contactNo: ");
		contactNo=  scanner.nextInt();;
	
		System.out.println("Enter accountId: ");
		accountId= scanner.nextInt();
		
		System.out.println("Enter accountNo: ");
		accountNumber= scanner.nextInt();
		
		System.out.println("Enter accountType: ");
		accounType =  br.readLine();
		
		account = new Account(accountId ,accountNumber, accounType, isActive);	
		
		Customer cust = new Customer(firstName, lastName, contactNo, customerId, account);
		
		Transaction trans = new Transaction();
		
		trans.transactionDate = new Date();
		trans.amount= 1000;
		trans.fromAccount = 0;
		trans.toAccount = accountNumber;
  	     
		transactions.add(trans);
		customers.add(cust);
		
		System.out.println(cust);
		
	}

	public void updateAccount(List<Customer> customers) throws IOException
    {
		  System.out.println("Update:");
		  System.out.println("Enter the customerId :");
		  int id = scanner.nextInt();
		
		  for (int i=0; i<customers.size() ; i++)
		  {
			  
			  if(customers.get(i).getCustomerId() == id)
			  {
				    
				    System.out.println("Enter firstName ");
				    String firstName =  br.readLine();
				    customers.get(i).setFirstName(firstName);
				
					System.out.println("Enter lastName: ");
					String lastName =  br.readLine();
				    customers.get(i).setLastName(lastName);
					
					System.out.println("Enter contactNo: ");
					int contactNo=  scanner.nextInt();
				    customers.get(i).setContactNo(contactNo);		
						
			  }
	}
  }

	public void deleteAccount(List<Customer> customers) throws IOException
	{
		  System.out.println("Delete:");
		  System.out.println("Enter the customerId :");
		  int id = scanner.nextInt();
		
		  for (int i=0; i<customers.size() ; i++)
		  {
			  
			  if(customers.get(i).getCustomerId() == id)
			  {
				    
				    customers.get(i).getAccount().isActive =  false;
			  }
	      }
	
    }

	public void searchAccount(List<Customer> customers)
	{
		 System.out.println("Search:");
		 System.out.println("Enter the customerId :");
		 int id = scanner.nextInt();

	     Iterator <Customer> i = customers.iterator();
	       
		 while(i.hasNext())
		 {
			 Customer _cust  = i.next();
			 if(_cust.getCustomerId() == id )
			 {
				 System.out.println(_cust);
			 }
		}
		
	}

	public void showAllAccount(List<Customer> customers) 
	{
		List<Customer> res = getActiveCustomers(customers);
		System.out.println(res);
	}
//---------------------------------------------------------------------------------------------------------
	public void getBalance(List<Transaction> transactions, List<Customer> customers) 
	{
		 System.out.println("For check balance:");
		 System.out.println("Enter the AccountNo :");
		 int accountNo = scanner.nextInt();
		 int amount = 0;
         
		 boolean acc = accountIsActive(accountNo,customers);    
		 if(acc)
		 {
			 Iterator <Transaction> j = transactions.iterator();
		     
			 while(j.hasNext())
				{
					Transaction t = j.next();
				    if(t.toAccount == accountNo)
				    {
				    	amount += t.amount;
				    }
				    else if(t.fromAccount == accountNo)
				    {
				    	amount -= t.amount;
				    }
				}
			System.out.println("Balance is : "+amount);
		 }			
	}
//===================================================================================
	public List<Customer> getActiveCustomers(List<Customer> customers)
	{
		List<Customer> result = new ArrayList <>();
		
		 Iterator <Customer> i = customers.iterator();
	       
		 while(i.hasNext())
		 {
			 Customer cust = i.next(); 
			 if(cust.getAccount().isActive == true)
			 {
				 result.add(cust);
			 }
		 }
		
		return result;
	}
//====================================================================================
	public Transaction transferAmount(int fromAccount, int toAccount, int transferAmount, List<Transaction> transactions) 
	{
		Transaction  trans=new Transaction();	
		
		trans.transactionDate = new Date();
		trans.amount = transferAmount;
		trans.fromAccount = fromAccount;
		trans.toAccount = toAccount;
		
		return trans;
	}
//-------------------------------------------------------------------------------------
	public Transaction withdrawAmount(List<Customer> customers, int account) 
	{
		boolean acc = accountIsActive(account,customers);
		Transaction  trans=new Transaction();
		int withDrawAmount;
		
		if(acc)
		{ 
			System.out.println("Enter the withdraw amount");
			withDrawAmount = scanner.nextInt();
			if((trans.amount - (minBalance +withDrawAmount))>=0 && withDrawAmount > 0 )
			{
					trans.amount-=withDrawAmount;
					System.out.println("--------------------------------");
					System.out.println("Updated balance is Rs."+trans.amount);
					System.out.println("--------------------------------");
			}
			else 
			{
				System.out.println("error2");
			}
			trans.transactionDate=new Date();
			trans.amount=withDrawAmount;
			trans.fromAccount = account;	
		}
		return trans;
	}

	public void sortOfAccount(List<Customer> customers) 
	{
		
	}

	public boolean accountIsActive(int account, List<Customer> customers)
	{
		List<Customer> result = getActiveCustomers(customers);
		
		Iterator <Customer> i = result.iterator();
		boolean flag = false;
	       
		 while(i.hasNext())
		 {
			 Customer cust = i.next();
			 if(cust.getAccount().accountNumber == account)
			 {
				 flag = true;
			 }
		 }
		return flag;
	}
	
	public Customer getCoustomerByAccount(int account, List<Customer> customers)
	{
		List<Customer> result = getActiveCustomers(customers);
		
		Iterator <Customer> i = result.iterator();
		Customer _cust = new Customer();
	       
		 while(i.hasNext())
		 {
			 Customer cust = i.next();
			 if(cust.getAccount().accountNumber == account)
			 {
				 _cust = cust;
			 }
		 }
		return _cust;
	}

	public Transaction depositAmount(List<Customer> customers, int account) 
	{
		boolean acc = accountIsActive(account,customers);
		Transaction  trans=new Transaction();
		int depositAmount;
		if(acc)
		{
			 System.out.println("Enter the deposit amount");
			 depositAmount = scanner.nextInt();
			if(depositAmount >0)
			{

				trans.amount+=depositAmount;
				System.out.println("--------------------------------");
				System.out.println("Updated balance is Rs."+trans.amount);
				System.out.println("--------------------------------");
			}
			else 
			{
				System.out.println("amount should be greater than 0");
			}
			trans.transactionDate=new Date();
			trans.amount=depositAmount;
			trans.toAccount = account;
		}
		
		return trans;
		
	}

	public void miniStatement(List<Customer> customers, List<Transaction> transactions, int account) 
	{
		boolean acc = accountIsActive(account,customers);
		if(acc)
		{
			Customer cust = getCoustomerByAccount(account,customers);
			System.out.println(cust);
            Iterator <Transaction> j = transactions.iterator();
		    int closingBalance = 0;
		    String  transType = "";
		    String  narration = "";
		    
		    System.out.println("Transaction date	|Narration	|Amount	|Transaction type	|Closing balanace");
		    System.out.println("==============================================================================");
			while(j.hasNext())
				{
					Transaction t = j.next();
				    if(t.toAccount == account || t.fromAccount == account)
				    {
				    	 if(t.toAccount == account)
						    {
				    		  transType = "credit";
				    		  closingBalance += t.amount;
				    		  narration = "from "+ t.fromAccount;
						    }
						    else if(t.fromAccount == account)
						    {
						      transType = "debit";
						      closingBalance -= t.amount;
						      narration = "to "+ t.toAccount;
						    }
				    	 System.out.println(t.transactionDate+ "	"+narration+ "	"+t.amount +"	"+transType+ "	" + closingBalance);
				    	 
				    }
				   
				}
			
		}
	}	
}