package basic_programs;

import java.util.Scanner;

public class EvenOdd 
{
    public static void main(String args[]) 
    {
    	int no;
    	Scanner scanner=new Scanner(System.in);
    	
    	System.out.println("Enter a number ");
    	no=scanner.nextInt();
    	scanner.close();
    	if(no%2==0) 
    	{
    		System.out.println("no is even");
    	}
    	else 
    	{
    		System.out.println("no is odd");
    	}
    	
    }
}
