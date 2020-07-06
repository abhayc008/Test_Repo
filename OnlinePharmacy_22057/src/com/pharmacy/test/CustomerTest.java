package com.pharmacy.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.pharmacy.dao.CustomerDaoImpl;
import com.pharmacy.pojo.Customer;

public class CustomerTest
{

	public static void main(String[] args)
	{
		List<Customer> custList ;
		Customer customer;
		
		int choice, customerId;
		long customerContactNo;
		boolean flag;
		String customerName,customerAddress, customerEmailId, customerPassword;
		
		Scanner scanner = new Scanner(System.in);
		
		InputStreamReader isr = new InputStreamReader(System.in);;
		BufferedReader br = new BufferedReader(isr);
		
		CustomerDaoImpl impl = new CustomerDaoImpl();
		
		
		System.out.println("------------Customer--------------");
		try 
	    {
	    	while(true) 
			{
				System.out.println("1.Add Customer");
				System.out.println("2. Update Customer");
				System.out.println("3. Delete Customer");
				System.out.println("4. Search Customer by Id");
				System.out.println("5. Search Customer by name");
				System.out.println("6. Search Customer by email id");
				System.out.println("7.Show all Customer");
				System.out.println("8.Exit");
				
				System.out.println("Enter your choice");
				choice = scanner.nextInt();
				
				switch(choice) 
				{
				  case 1:
						System.out.println("-------------Add Customer---------");
						
						System.out.println("Enter Customer Name");
						customerName = br.readLine();
					   	
						System.out.println("Enter Customer Email Id ");
						customerEmailId = br.readLine();
						
						System.out.println("Enter Customer Password");
						customerPassword = br.readLine();
			
						System.out.println("Enter Customer Contact No.");
						customerContactNo = scanner.nextLong();
						
						System.out.println("Enter Customer Address");
						customerAddress = br.readLine();				
						
						customer = new Customer(customerName,customerEmailId,customerPassword,
								 customerContactNo,customerAddress);
						flag = impl.addCustomer(customer);
						
						if(flag) 
						{
							System.out.println("Customer added successfully !!");
						}
						else 
						{
							System.out.println("failed");
						}
						
					  break;
				  case 2:
					  System.out.println("-------------Update Customer---------");
						
					    System.out.println("Enter existing customer id");
						customerId= scanner.nextInt();
						
						custList = impl.showAllCustomer();
						Iterator <Customer> cust = custList.iterator();
						
						Customer objCustomer= null;
						
						while(cust.hasNext()) 
						{
							Customer i = cust.next();
							if(i.getCustomerId()==customerId) 
							{
								objCustomer = i;
							}
						}
						
						if(objCustomer != null && objCustomer.getCustomerId() > 0)
						{
						
								System.out.println("Enter Customer Name");
								customerName = br.readLine();
							   	
								System.out.println("Enter Customer Email Id ");
								customerEmailId = br.readLine();
								
								System.out.println("Enter Customer Password");
								customerPassword = br.readLine();
								
								System.out.println("Enter Customer Contact No.");
								customerContactNo = scanner.nextLong();
								
								System.out.println("Enter Customer Address");
								customerAddress = br.readLine();				
								
								customer = new Customer(customerName,customerEmailId,customerPassword,
										 customerContactNo,customerAddress);
								
								customer.setCustomerId(customerId);
								
								flag = impl.updateCustomer(customer);
								
								if(flag) 
								{
									System.out.println("Customer Updated successfully !!");
								}
								else 
								{
									System.out.println("falied");	
								}
							 }
							else 
							{
								System.out.println("Customer id doesn't exist" +customerId);								
							}					
						
					  break;
				  case 3:
						System.out.println("--------Delete Customer--------------");
						
						System.out.println("Enter customer Id");
						customerId = scanner.nextInt();

					    flag = impl.deleteCustomer(customerId);
						
						if(flag) 
						{
							System.out.println("Deleted Successfully !!!");
						}
						else 
						{
							System.out.println("Failed");
						}
					  break;
				  case 4:
						System.out.println("Enter customer id");
						 customerId = scanner.nextInt();
						 customer = impl.searchCustomerById( customerId);
						
						if(customer !=null) //if(customer.getCustomerId()>0)
						{
							System.out.println(" customerId ||  customerName || customerEmailId ||  customerPassword "
									+ "||  customerContactNo ||  customeraddress");
							System.out.println("  "+customer.getCustomerId()+ " "+customer.getCustomerName()+ " "+customer.getCustomerEmailId()+" "
									+ customer.getCustomerPassword()+ " "+customer.getCustomerContactNo()+ " "+customer.getCustomerAddress()+" ");
												
						}
						else 
						{
							System.out.println("Customer not found with id "+customerId);
						}
					  break;
				  case 5:
						System.out.println("Enter customer name");
						customerName = br.readLine();
						custList  = impl.searchCustomerByCustomerName(customerName);
						if(!custList.isEmpty()) 
						{
							System.out.println(custList);	
						}
						else 
						{
							System.out.println("No such a customer for this name"+customerName);
						}
						
						break;	
				  case 6:
					   System.out.println("Enter customer Email ID");
					   customerEmailId = br.readLine();
					   customer  = impl.searchCustomerByEmailId(customerEmailId);
					   
					   if(customer !=null) //if(customer.getCustomerId()>0)
						{
							System.out.println(" customerId ||  customerName || customerEmailId ||  customerPassword "
									+ "||  customerContactNo ||  customeraddress");
							System.out.println("  "+customer.getCustomerId()+ " "+customer.getCustomerName()+ " "+customer.getCustomerEmailId()+" "
									+ customer.getCustomerPassword()+ " "+customer.getCustomerContactNo()+ " "+customer.getCustomerAddress()+" ");
												
						}
						else 
						{
							System.out.println("Customer not found with id "+customerEmailId);
						}
					   
					  break;
				  case 7:
					  System.out.println("----All Customer details are----");
					  
					   custList = impl.showAllCustomer();
	                    
					   if(!custList.isEmpty()) 
					   {
						   for(Customer cust2: custList )
							{
								System.out.println(" "+cust2);
							}
						   
					   }
					   else 
					   {
						   System.out.println("No record found!!!");
					   }
					  break;

				  case 8:
			    	  System.out.println("Thank you for visit!!!");
			    	  System.exit(0);
			      default :
			    	  System.out.println("Please enter valid choice !!!");
				}
		
			}
	    }
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		finally 
		{
			scanner.close();
		}
	}
}
