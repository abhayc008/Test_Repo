package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Task
{

	public static void main(String[] args) 
	{

		List <Integer> list = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
	            
		while(true)
		{
			
			System.out.println("-----------------------------");
			System.out.println("Main menu:");
			System.out.println("1.Input data");
			System.out.println("2.Output data");
			System.out.println("3.Exit");
			System.out.println("-----------------------------");
			System.out.println("Enter your choice");
			int ch = scanner.nextInt();
			switch(ch)
			{
			case 1:
				 String answer = "";

		            do {
		                System.out.println("Please enter number: ");
		                int num1 = scanner.nextInt();
		                
		                if(list.indexOf(num1) == -1)                	
		                	list.add(num1);
		                else
		                	System.out.println(num1 +" is already added in list.Element at position "+list.indexOf(num1));
		                
		                System.out.println("Press any key to continue,'no' to exit.");
		                answer = scanner.next();
		            } while (!answer.equals("no"));
				break;
			case 2:
				System.out.println("Output of the list: " );
				Iterator <Integer> obj1 = list.iterator();
				while(obj1.hasNext())
				{
					System.out.println(obj1.next());
				}
				break;
			case 3:
				System.exit(0);
			default:
				System.out.println("Please enter valid choice : ");
			}
		 }          
	 }
 }
		