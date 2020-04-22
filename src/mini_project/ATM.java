package mini_project;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ATM 
{
	public static void doTransactions() throws InsufficientAmountException,AmountInvalidException
	{
		List<Transaction> transactions = new ArrayList<Transaction>();
		CheckingAccount ca=new CheckingAccount();
		while(true)
		{
			try
			{
				Scanner scanner=new Scanner(System.in);
				
				//System.out.println(trans.transactionDate);
				
				int choice;
			      System.out.println();
				  System.out.println("--------Welcome----------");
				  System.out.println("-------Available Services-----------");
				  System.out.println("1.Check balance");
				  System.out.println("2.Deposit Amount");
				  System.out.println("3.Withdraw amount");
				  System.out.println("4.Mini Statement");
				  System.out.println("5.Exit");
				  System.out.println("-------------------------------");
				  System.out.println("Enter your choice");

				  System.out.println();
				  choice=scanner.nextInt();
				  switch(choice)
				  {
				  case 1:
					  ca.getBalance();
					  break;
				  case 2:
					  transactions.add(ca.depositInAccount());
					  break;
				  case 3:
					  transactions.add(ca.withDrawFromAccount());
				      break;
				  case 4:
	                   ca.miniStatement(transactions);	
	                   break;
				  case 5:
					  System.out.println("Thank you !!!");
					  System.out.println("----------------------------");
					  System.exit(0);
				  default:
					  System.out.println("Please enter valid choice !!!");
				  }			  
		     }
			  catch(AmountInvalidException ex)
	        {
		    System.out.println(ex);
	        } 
	   }
	
	}
	public static void main(String[] args) 
	{

		   while(true)
		   {

		       try
		       {
		    	   String pin, password = "1234";
		    	   
			       Scanner scanner=new Scanner(System.in);
			       System.out.println("-------------------------------");
			       System.out.println("Enter 4 digit PIN");
			       System.out.println("-------------------------------");
			       pin=scanner.next();
			       //scanner.close();
			       if(pin.equals(password))
			       {
			    	   doTransactions();
			       }
			       else{
			    	  throw new IncorrectPinException();
			       }
		       }
		       
			   catch(IncorrectPinException ex)
			     {
				    System.out.println(ex);	
				   //System.out.println(ex.getMessage());	
				   continue;	
				 }
		       catch(Exception ex)
		       {
		    	   System.out.println("Main exception");
		    	   
		       }
			 }
	  
	}
}
