package string_demo;

import java.util.Scanner;

public class CheckMaleFemale {

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name");
		String name = scanner.next();
		
		if(name.endsWith("i") ||name.endsWith("a") )
		{
			System.out.println(name+ " is Female " );
		}
		else
		{
			System.out.println(name+ " is male " );
		}
	}

}
