package string_demo;

public class NumberByDigit {

	public static void main(String[] args)
	{
		String str = "There are two balss in bucket . I picked up one ball and then I put three balls";
		String [] str1 = {"one", "two", "three", "four", "five", "six"};
		String [] str2 = {"1", "2", "3", "4", "5", "6"};
		
		for(int i=0; i<str1.length; i++)
		{
		str = str.replace(str1[i], str2[i]);
		}
		System.out.println(str);
	}

}
