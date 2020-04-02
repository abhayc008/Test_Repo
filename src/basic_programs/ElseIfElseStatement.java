package basic_programs;

import java.util.Scanner;

public class ElseIfElseStatement 
{
   public static void main(String args[]) 
   {
	   int no1,no2;
	   
	   Scanner scanner=new Scanner(System.in);
	   
	   System.out.println("Enter two numbers");
	   no1=scanner.nextInt();
	   no2=scanner.nextInt();
	   scanner.close();
	   if(no1>no2) 
	   {
		   System.out.println("no1 is greater than no1");
	   }
	   else if(no1==no2) 
	   {
		   System.out.println("no1 is equal to no2");
	   }
	   else 
	   {
		   System.out.println("no2 is greater than no1");
	   }
   }
}
