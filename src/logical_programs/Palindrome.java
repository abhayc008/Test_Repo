package logical_programs;

import java.util.Scanner;

public class Palindrome 
{
  public static void main(String args[]) 
  {
	  int no,mod,rev=0,temp;
	  
	  Scanner scanner=new Scanner(System.in);
	  
	  System.out.println("Enter a number");
	  no=scanner.nextInt();
	  temp=no;
	  scanner.close();
	  
	  while(no!=0) 
	  {
		  mod=no%10;
		  rev=rev*10+mod;
		  no=no/10;
	  }
	  if(temp==rev) 
	  {
		  System.out.println("Palindrome");
	  }
	  else 
	  {
		  System.out.println("Not Palindrome");
	  }
  }
}
