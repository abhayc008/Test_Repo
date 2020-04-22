package string_demo;

import java.util.Scanner;

public class ReverseWithoutAPI 
{

	public static void main(String[] args) 
	{
		//String s = "Coder Technology";
		String input;
		String reverse = "";
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input a string");
		input = scanner.nextLine();
		//int len=s.length();
		int len = input.length();
		for(int i=len-1;i>=0;i--)
		{
			reverse = reverse + input.charAt(i);
		}
		System.out.println(reverse);
	}

}
