package com.pharmacy.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import com.pharmacy.dao.OrderDaoImpl;
import com.pharmacy.pojo.Order;

public class OrderTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int choice;
		String customerEmailId;
		
		Scanner scanner = new Scanner(System.in);
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OrderDaoImpl impl = new OrderDaoImpl();
		Order order ;
		List<Order> ordList;
		
		//Order order=new Order();
		
		try 
		{
			while(true) 
			{
				System.out.println("Menu : \n"
						+ "1.Place order\n"
						+ "2.Show all order to customer\n"
						+ "3.Cancel order\n"
						+ "4. show all order for admin\n"
						+ "5.Exit");
				System.out.println("Enter your choice");
				choice = scanner.nextInt();
				switch(choice) 
				{
				  case 1:
					  System.out.println("------------Place order--------");
					  
					  System.out.println("Enter customer Email id");
					  customerEmailId = br.readLine();
					  
					  order = impl.placeOrder(customerEmailId);
					  
					  System.out.println("Your order is placed and your order id   "+order.getOrderId());
					  
					  System.out.println(order);
					  
					  break;
				  case 2:
					  System.out.println("Show all order to customer");
					  System.out.println("Enter customer Email id");
					  customerEmailId = br.readLine();
					  
					  ordList = impl.showAllOrder(customerEmailId);
					  
					  if(!ordList.isEmpty()) 
					  {
						  for(Order od:ordList) 
						  {
							  System.out.println(od);
						  }
					  }
					  else 
					  {
						  System.out.println("No order is placed with this "+customerEmailId+"email id");
					  }
					  break;
				  case 3:
					  System.out.println("Cancel order");
					  System.out.println("Enter order id");
					  int orderId = scanner.nextInt();
					  
					  boolean  flag = impl.cancelOrder(orderId);
					  
					  if(flag) 
					  {
						  System.out.println("Order cancelled");
					  }
					  else 
					  {
						  System.out.println("Failed");
					  }
					  break;
				  case 4:
					  System.out.println("Show all order to admin");
					  
					  ordList = impl.showAllOrder();
					  
					  if(!ordList.isEmpty()) 
					  {
						  for(Order od:ordList) 
						  {
							  System.out.println(od);
						  }  
					  }
					  else 
					  {
						  System.out.println("No record found!!!");
					  }
					  break;
				  case 5:
					  System.out.println("Thank you visting!!!");
					  System.exit(0);
				  default:
					  System.out.println("Enter a valid choice!!!");
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