package basic_programs;

import java.util.Scanner;

public class NestedIfStatement 
{
   public static void main(String args[]) 
   {
	int no;
	
	Scanner scanner=new Scanner(System.in);
	
	System.out.println("Enter a number");
	no=scanner.nextInt();
	
	if(no>0) 
	{
		if(no%2==0) 
		{
			System.out.println("no is even");
		}
		else 
		{
			System.out.println("no is odd");
		}
	}
	else
	{
		System.out.println("enter a valid number");
	}
	scanner.close();
   }
}
