package string_demo;

import java.util.Arrays;
import java.util.Comparator;

public class SplitNoOfWords {

	public static void main(String[] args)
	{
		String s = "Coder Technology hi a";
		String temp = "";
		//String original = "edcba";
		String[] s1 = s.split(" ");
		/*
	    System.out.println("-- sorting array of string --");
        Arrays.sort(s1, Comparator.comparing(String::length));
        Arrays.stream(s1).forEach(System.out::println);
        */
	    for(int i=s1.length -1;i>0;i--)
	    {
	    	for(int j=0;j<=i;j++)
			{
			   if(s1[i].length()<s1[i+1].length())
			   {
				   temp = s1[j];
				   s1[j] = s1[j+1];
				   s1[j+1] = temp;
			   }
			}	
	     }
	    System.out.println(temp);
	  }
}
