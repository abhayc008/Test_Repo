package logical_programs;

import java.util.Scanner;

public class Factorial 
{
	public static void main(String args[]) 
	{
		int no,fact=1;
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter a number");
		no=scanner.nextInt();
		scanner.close();
		
		for(int i=1;i<=no;i++) 
		{
			fact=fact*i;
		}
		System.out.println("Factorial of given number is "+fact);
	}

}
