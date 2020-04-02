package logical_programs;

import java.util.Scanner;

public class Reverse 
{
   public static void main(String args[]) 
   {
	   int no,mod,rev=0;
	   
	   Scanner scanner=new Scanner(System.in);
	   
	   System.out.println("Enter a number");
	   no=scanner.nextInt();
	   scanner.close();
	   
	   while(no!=0) 
	   {
		   mod=no%10;
		   rev=rev*10+mod;
		   no=no/10;
	   }
	   System.out.println("Reverse of given number is"+rev);
   }
}
