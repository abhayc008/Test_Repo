package com.pharmacy.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.pharmacy.dao.LoginDaoImpl;

public class LoginTest 
{

	public static void main(String[] args) throws IOException 
	{
		String userName,newPassword,password;
		int choice;
		boolean flag;
		
		LoginDaoImpl ldao = new LoginDaoImpl();
		
		Scanner scanner=new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try 
		{
			while(true) 
			{
				
				System.out.println("Enter details:\n"
						+ "1.User Login \n"
						+ "2.User Change Password\n"
						+ "3.Admin Login\n"
						+ "4.Admin Change Password\n"
						+ "5.Exit");
				System.out.println("Enter your choice");
				choice = scanner.nextInt();
				
				switch(choice) 
				{
				case 1:
					System.out.println("Enter UserName");
					userName = br.readLine();
					System.out.println("Enter Password");
					password = br.readLine();
					
					flag = ldao.userLogin(userName,password);
					
					if(flag) 
					{
					   System.out.println("Login Successfully !!!");	
					}
					else 
					{
						System.out.println("Failed");
					}
					break;
				case 2:
					System.out.println("Enter UserName");
					userName = br.readLine();
					System.out.println("Enter new Password");
					newPassword = br.readLine();
					
					flag = ldao.userChangePassword(userName, newPassword);
					
					if(flag) 
					{
					   System.out.println("Successfully Changed!!!");	
					}
					else 
					{
						System.out.println("Failed");
					}
					break;
				case 3:
					System.out.println("Enter UserName");
					userName = br.readLine();
					System.out.println("Enter Password");
					password = br.readLine();
					
					flag = ldao.adminLogin(userName,password);
					
					if(flag) 
					{
					   System.out.println("Login Successfully !!!");	
					}
					else 
					{
						System.out.println("Failed");
					}
					break;
				case 4:
					System.out.println("Enter UserName");
					userName = br.readLine();
					System.out.println("Enter new Password");
					newPassword = br.readLine();
					
					flag = ldao.adminChangePassword(userName, newPassword);
					
					if(flag) 
					{
					   System.out.println("Successfully Changed!!!");	
					}
					else 
					{
						System.out.println("Failed");
					}
					break;
				case 5:
					System.out.println("Thank you for Visiting!!!");
					System.exit(0);
					break;
				default:
					System.out.println("Please enter a valid choice!!!");
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
