package string;

public class LengthString
{

	public static void main(String[] args) 
	{
		String str1=" Coder Technologies";
		String str2="coder";
		
		System.out.println(str1.length());
		
		System.out.println(str1.endsWith("er"));
		
		System.out.println(str1.startsWith("B"));
        
		System.out.println(str1.trim());
		
		System.out.println(str2.contains("der"));
		
		System.out.println(str2.indexOf('o'));//start with 0
		
	}

}
