package com.pharmacy.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.pharmacy.dao.FeedbackDaoImpl;
import com.pharmacy.pojo.Feedback;

public class FeedbackTest
{
	public static void main(String[] args) 
	{
        int choice,rateUs,rateMedicine;
		String customerEmailId, customerName,suggestion,medicineName;
		boolean flag;	
		
		FeedbackDaoImpl impl = new FeedbackDaoImpl();
		Feedback feed;

		Scanner scanner = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		try 
		{
		   while(true) 
		   {
			   System.out.println("Menu: \n"
			   		+ "1.Enter a feedback\n"
			   		+ "2.Show all feedback to admin");
			   System.out.println("Enter a choice");
			   choice = scanner.nextInt();
			   switch(choice) 
			   {
			   case 1:
				       System.out.println("Enter a feedback");			   
                                      
                       System.out.println("Enter Full Name");
    				   customerName = br.readLine();
    				   
    				   System.out.println("Enter Email");
    				   customerEmailId = br.readLine();
    				   
                	   System.out.println("Rate our service between 1 to 10");
    				   rateUs = scanner.nextInt();
    				   
    				   System.out.println("Medicine name");
    				   medicineName= br.readLine();
    				   
    				   System.out.println("Rate medicine between 1 to 10");
    				   rateMedicine = scanner.nextInt();
    				   
    				   System.out.println("Feedback");
    				   suggestion = br.readLine();
    				   
    				   feed = new Feedback(rateUs,medicineName,rateMedicine,customerEmailId,customerName,suggestion);
                       
    				   flag = impl.addFeedback(feed);
    				   
    				   if(flag) 
    				   {
    					   System.out.println("Successfully added!!");
    				   }
    				   else 
    				   {
    					   System.out.println("Failed");
    				   }
    				      
 				   break;
			   case 2:
				   System.out.println("Feedback list are....");
				   
				   List<Feedback> feedList = new ArrayList<>();
				   feedList = impl.showAllFeedback();
				   if(!feedList.isEmpty()) 
				   {
					   for(Feedback fed: feedList)
						{
							System.out.println(" "+fed);
						}   
				   }
				   else 
				   {
					   System.out.println("No record found!!!");
				   }
				   break;
			   case 3:
				   System.out.println("Thank you for visiting");
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
