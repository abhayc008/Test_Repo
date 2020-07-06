package com.pharmacy.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import com.pharmacy.dao.CartDaoImpl;
import com.pharmacy.pojo.Cart;

public class CartTest
{

	public static void main(String[] args) 
	{
		List<Cart> cartList;
		Cart cart;

		int choice,medicineQty,medicineId,cartId;
		boolean flag;
		String  customerEmailId;
		
		Scanner scanner = new Scanner(System.in);
		
		InputStreamReader isr = new InputStreamReader(System.in);;
		BufferedReader br = new BufferedReader(isr);
		
		CartDaoImpl impl = new CartDaoImpl();
		
		
		System.out.println("------------Cart Menu--------------");
		try 
	    {
	    	while(true) 
			{
				System.out.println("1.Add cart");
			    System.out.println("2. Delete cart");
				System.out.println("3.Clear Cart");
				System.out.println("4.Show Cart");
				System.out.println("5.Exit");
				
				System.out.println("Enter your choice");
				choice = scanner.nextInt();
				
				switch(choice) 
				{
				  case 1:
						System.out.println("-------------Add cart---------");
						
						System.out.println("Enter medicine Id");
						medicineId = scanner.nextInt();
					   	
						System.out.println("Enter medicine Quantity");
						medicineQty = scanner.nextInt();
			
						System.out.println("Enter customer email address");
						customerEmailId= br.readLine();				
						
						cart = new Cart(medicineId,customerEmailId,medicineQty);
						flag = impl.addToCart(cart);
						
						if(flag) 
						{
							System.out.println("cart added successfully !!");
						}
						else 
						{
							System.out.println("failed");
						}
						
					  break;		
				  case 2:
						System.out.println("--------Delete cart--------------");
						
						System.out.println("Enter cart Id");
						cartId = scanner.nextInt();

					    flag = impl.deleteToCart(cartId);
						
						if(flag) 
						{
							System.out.println("Deleted Successfully !!!");
						}
						else 
						{
							System.out.println("Failed");
						}
					  break;
				  case 3:
					   System.out.println("-------Clear cart--------");
					   System.out.println("Enter customer email id:");
					   customerEmailId = br.readLine();
					   flag= impl.clearCart(customerEmailId);
						
						if(flag) 
						{
						  System.out.println("Cart cleared succesfully!!!");						
						}
						else 
						{
							System.out.println("cart not found with email id "+customerEmailId);
						}
					  break;
				  case 4:
					 System.out.println("----Show all cart items are----");
					 System.out.println("Enter customer email id:");
					 customerEmailId = br.readLine();
					 cartList= impl.showCart(customerEmailId);     
	                 if(!cartList.isEmpty()) 
	                 {
						 for(Cart ct:cartList) 
		                 {
		                	 System.out.println(ct);
		                 }
	                 }
	                 else 
	                 {
	                	 System.out.println("No item found with this email id"+customerEmailId);
	                 }
					 break;
				  case 5:
			    	  System.out.println("Thank you for visit!!!");
			    	  System.exit(0);
			      default:
			    	  System.out.println("Enter a valid choice!!");
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
