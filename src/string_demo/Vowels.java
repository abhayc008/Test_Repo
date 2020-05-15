package string_demo;

public class Vowels {

	public static void main(String[] args)
	{ 
		String vowel ="";
		String vowels = "aeiou";
		String str = "India is my country. I love my country";
		
		for(int i=0; i<str.length(); i++)
		{
		    if(vowel.toLowerCase().indexOf(str.toLowerCase().charAt(i)) < 0 && vowels.toLowerCase().indexOf(str.toLowerCase().charAt(i))>= 0)
		    {
		        vowel += str.charAt(i); 	
		    }
		}
		System.out.println(vowel);
        
	}
}