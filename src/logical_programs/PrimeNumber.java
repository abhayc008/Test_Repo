package logical_programs;

import java.util.Scanner;

public class PrimeNumber 
{
  public static void main(String args[]) 
  {
	  int no,i;
	  
	  Scanner scanner=new Scanner(System.in);
	  
	  System.out.println("Enter a number");
	  no=scanner.nextInt();
	  scanner.close();
	  
	  for(i=2;i<=no;i++) 
	  {
		  if(no%i==0) 
		  {
			  break;
		  }
	  }
	  if(no==i) 
	  {
		  System.out.println("Number is Prime");
	  }
	  else 
	  {
		  System.out.println("Number is not prime");
	  }
  }
	  
}
