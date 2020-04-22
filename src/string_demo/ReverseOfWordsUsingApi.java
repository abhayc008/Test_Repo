package string_demo;

import java.util.Arrays;

public class ReverseOfWordsUsingApi {

	public static void main(String[] args)
	{
		String str ="Coder Technologies Vashi";
		//o/p = Vashi Technologies Coder
		String[] s1 = str.split(" ");
		for(int i=s1.length-1;i>=0;i--)
		{
			if(i == s1.length-1)
			{
				System.out.print(s1[i]);
			}
			else 
			{
				System.out.print(" "+s1[i]);
			}
		}
	
	}
}
