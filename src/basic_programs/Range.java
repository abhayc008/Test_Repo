package basic_programs;

import java.util.Scanner;

public class Range 
{
    public static void main(String args[]) 
    {
    	int no;
    	
    	Scanner scanner=new Scanner(System.in);
    	
    	System.out.println("Enter a number");
    	no=scanner.nextInt();
    	scanner.close();
    	if(no>1&&no<100) 
    	{
        	System.out.println("no is between 1 to 100");
    	}
    	else if(no>100&&no<1000) 
    	{
        	System.out.println("no is between 100 to 1000");
    	}
    	else 
    	{
        	System.out.println("Eneter a valid number");
    	}
    	
    }
}
