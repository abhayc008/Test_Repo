package string_demo;

import java.util.Arrays;

public class SortOfStringWithApi {

	public static void main(String[] args) 
	{
		String s = "Coder Technology";
		//String original = "edcba";
		String[] s1 = s.split(" ");
		for(String item:s1)
		{
			char[] chars = item.toCharArray();
	        Arrays.sort(chars);
	        String sorted = new String(chars);
	        System.out.print(" " +sorted);
		}	
   }

}
