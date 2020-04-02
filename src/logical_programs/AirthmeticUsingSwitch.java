package logical_programs;

import java.util.Scanner;

public class AirthmeticUsingSwitch 
{
	public static void main(String args[]) 
	{
		int no1,no2,res,ch;
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter two nos");
		no1=scanner.nextInt();
		no2=scanner.nextInt();
		
		System.out.println("1.Addition");
		System.out.println("2.Substraction");
		System.out.println("3.Multiplication");
		System.out.println("4.Division");
		System.out.println("5.Mod");
		System.out.println("6.Exit");
        
		while(true)
		{
			System.out.println("Enter your choice");
			ch=scanner.nextInt();
			scanner.close();
		    switch(ch) 
		    {
		    case 1:
		    	res=no1+no2;
		    	System.out.println("Addition of two nos is "+res);
		    	break;
		    case 2:
		    	res=no1-no2;
		    	System.out.println("Substraction of two nos is "+res);
		    	break;
		    case 3:
		    	res=no1*no2;
		    	System.out.println("Multiplication of two nos is "+res);
		    	break;
		    case 4:
		    	res=no1/no2;
		    	System.out.println("Division of two nos is "+res);
		    	break;
		    case 5:
		    	res=no1%no2;
		    	System.out.println("Mod of two nos is "+res);
		    	break;
		    case 6:
		    	System.exit(0);
		    }
		}
	}

}
