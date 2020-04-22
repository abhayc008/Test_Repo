package string_demo;

//Reverse of words Without  using string Api

public class ReverseOfWordsWithOutUsingApi {

	public static void main(String[] args) 
	{
		String str ="Coder Technologies Vashi";
		//o/p = Vashi Technologies Coder 
		
		String reversedString = "";
		//Reverse each word's position
		char []s1 = str.toCharArray();
        for (int i = 0; i < s1.length; i++) { 
        	reversedString =(i == s1.length - 1)? (s1[i] + reversedString): (" " + s1[i] + reversedString); 
        } 
 
        // Displaying the string after reverse
        System.out.print("Reversed string : " + reversedString);
	}

}
