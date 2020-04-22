package exception;

import java.util.Scanner;

public class ExceptionEx 
{
	public static void divide()
	{
		try
		{
			int no1,no2,div;
			Scanner scannner=new Scanner(System.in);
			System.out.println("Enter nos");
			no1=scannner.nextInt();
			no2=scannner.nextInt();
			scannner.close();
			div=no1/no2;
			System.out.println("Divide"+div);
			System.out.println("Completed Successfully");
		}
		catch(ArithmeticException ex)
		{
			System.out.println("Eror occured from ArithmeticException block in divide");
			//throw ex;
		}
		catch(Exception ex)
		{
			System.out.println("Eror occured in divide");
			System.out.println();
			//throw ex;
		}
		finally{
			System.out.println("Finally called in divide");
		}
		
	}
	public static void division() 
	{
		try
		{
			divide();
		}
		catch(Exception ex)
		{
			System.out.println("Eror occured in division");
			System.out.println();
			//throw ex;
		}		
		finally{
			System.out.println("Finally called in division");
		}
	}
	public static void main(String[] args) 
	{
		try
		{
         division();
		}
		catch(Exception ex)
		{
			System.out.println("Eror occured in Main");
			System.out.println();
			
		}
		finally
		{
			System.out.println("Run succeessfully");
		}

	}
					
}
