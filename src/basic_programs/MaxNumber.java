package basic_programs;

import java.util.Scanner;

public class MaxNumber 
{
    public static void main(String args[]) 
    {
    	int no1,no2,no3;
    	
    	Scanner scanner=new Scanner(System.in);
    	
    	System.out.print("Enter three nos");
    	no1=scanner.nextInt();
    	no2=scanner.nextInt();
    	no3=scanner.nextInt();
    
    	scanner.close();
    	if(no1>=no2&&no1>=no3) 
    	{
    		System.out.println("no1 is greater");
    	}
    	else if(no2>=no1&&no2>=no3) 
    	{
    		System.out.println("no2 is greater");
    	}
    	else if(no3>=no1&&no3>=no1) 
    	{
    		System.out.println("no3 is greater");
    	}
    	else 
    	{
    		System.out.println("nos are equal");
    	}
    }
}
