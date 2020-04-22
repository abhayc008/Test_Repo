package string_demo;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) 
	{
		String input, reverse = "";
		int len;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the string");
		input = scanner.next();
		len = input.length();
		for(int i= len-1; i>=0; i--)
		{
			reverse = reverse + input.charAt(i);
		}
        if(input.equalsIgnoreCase(reverse))
        {
        	System.out.println("String is palindrome");
        }
        else 
        {
        	System.out.println("String is not palindrome");
        }
	}

}
