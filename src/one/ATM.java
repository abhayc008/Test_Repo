package mini_project;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ATM 
{
	public static void doTransactions()
	{
		while(true)
		{
			try
			{
				Scanner scanner=new Scanner(System.in);
				List<Transaction> transactions = new ArrayList<Transaction>();
				//System.out.println(trans.transactionDate);
				CheckingAccount ca=new CheckingAccount();
				int choice;
			      System.out.println();
				  System.out.println("Enter your choice");
				  System.out.println("1.Check balance");
				  System.out.println("2.Deposit Amount");
				  System.out.println("3.Withdraw amount");
				  System.out.println("4.Mini Statement");
				  System.out.println("5.Exit");
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
				  case 5:
					  System.exit(0);
				  default:
					  System.out.println("Please enter valid choice !!!");
				  }			  
		    }
			catch(InsufficientAmountException ex)
		     {
			  System.out.println(ex);
		     }
		   catch(AmountInvalidException ex)
	       {
		    System.out.println(ex);
	       } 
	  }
	
	}
	public static void main(String[] args) throws IncorrectPinException 
	{

		   while(true)
		   {

		       try
		       {
		    	   int pin,password = 1234;
			       Scanner scanner=new Scanner(System.in);
			       System.out.println("Enter 4 digit PIN");
			       pin=scanner.nextInt();
			       //scanner.close();
			       if(pin == password)
			       {
			    	   doTransactions();
			       }
			       else{
			    	  throw new IncorrectPinException();
			       }
		       }
		       
			   catch(IncorrectPinException ex)
			     {
				   System.out.println(ex.getMessage());	
				   continue;	
				 }
		       catch(Exception ex)
		       {
		    	   System.out.println("Main exception");
		    	   
		       }
			 }
	  
	}
}