package assignment_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FundTransfer 
{

	public static void main(String[] args)
	{
		System.out.println("--------Welcome----------");
		List<Customer> customers = new ArrayList<>();
		List<Transaction> transactions = new ArrayList<>();
		Operations operation =new Operations();
		
		while(true)
		{
			try
			{
				Scanner scanner=new Scanner(System.in);
				int choice;
			      System.out.println();
				  System.out.println("--------Welcome----------");
				  System.out.println("-------Available Services-----------");
				  System.out.println("1.Add Account");
				  System.out.println("2.Update Account ");
				  System.out.println("3.Delete Account");
				  System.out.println("4.Search Account");
				  System.out.println("5.Show all Account");	
				  System.out.println("6.Check balance");
				  System.out.println("7.Deposit Amount");
				  System.out.println("8.Withdraw amount");
				  System.out.println("9.Mini Statement");
				  System.out.println("10.Sort the Account id and name");
				  System.out.println("11.Transfer money");
				  System.out.println("12.Exit");
				  System.out.println("-------------------------------");
				  System.out.println("Enter your choice");

				  System.out.println();
				  choice=scanner.nextInt();
				  switch(choice)
				  {
				  case 1:
					  operation.addAccount(customers, transactions);
					  System.out.println();
					  System.out.println("Account added succesfully!!!");//done
					  break;
				  case 2:
					  operation.updateAccount(customers);
					  System.out.println("Account updated succesfully!!!");//done
					  break;
				  case 3:
					  operation.deleteAccount(customers);
					  System.out.println("Account deleted succesfully!!!");//done
				      break;
				  case 4:
					  operation.searchAccount(customers);
					  System.out.println("Account search succesfully!!!");//done
	                   break;
				  case 5:
					  System.out.println(" All accounts are...");//done
					  operation.showAllAccount(customers);
					  break;
				  case 6:
					  operation.getBalance(transactions,customers);
					  System.out.println("Successfully done!!!");
					  break;
				  case 7:
					  System.out.println("Enter the toAccount no : ");
					  int account = scanner.nextInt();				  
					  transactions.add(operation.depositAmount(customers, account));
					  System.out.println("Deposit amount successfully!!!");
				      break;
				  case 8:
					  System.out.println("Enter the toAccount no : ");
					  int account1 = scanner.nextInt();				  
					  transactions.add(operation.withdrawAmount(customers, account1));
					  System.out.println("Withdraw  amount is ...");
	                   break;
				  case 9:
					  System.out.println("Mini Statement");
					  System.out.println("Enter the account no : ");
					  int account3= scanner.nextInt();				  
					  operation.miniStatement(customers,transactions,account3);
	                   break;
				  case 10:
					  operation.sortOfAccount(customers);
					  System.out.println("Sorting of account....");
	                   break;
				  case 11:
						int transferAmount;
						int fromAccount, toAccount, closingBalance;
						System.out.println("--------------------------------");
						System.out.println("Enter the fromAccount  no: ");
						fromAccount = scanner.nextInt();
						System.out.println("Enter the toAccount no : ");
						toAccount = scanner.nextInt();
						
						boolean c1 = operation.accountIsActive(fromAccount,customers);
						operation.accountIsActive(toAccount, customers);
						
						boolean c2 = operation.accountIsActive(toAccount,customers);
						
						System.out.println("Enter the amount to deposit: ");
						transferAmount=scanner.nextInt();
						System.out.println("--------------------------------");
						
						if(c1)
						{
							if(c2)
							{
								operation.transferAmount(fromAccount,toAccount,transferAmount,transactions);
								System.out.println("Money transfered !!!!");
							}
							else
							{
								System.out.println("Coustomer 2 does not active");
							}
						}
						else
						{
							System.out.println("Coustomer 1 does not active");
						}
	                   break;
				  case 12:
					  System.out.println("Thank you !!!");
					  System.out.println("----------------------------");
					  System.exit(0);
				  default:
					  System.out.println("Please enter valid choice !!!");
				  }			  
		     }
			  catch(Exception ex)
	        {
		    System.out.println(ex);
	        } 
	   }
	
	}
}
		
