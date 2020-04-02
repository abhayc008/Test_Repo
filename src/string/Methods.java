package string;

public class Methods 
{
  public static void main(String args[]) 
  {
	  	String str1="Coder";
	  	String str2="coder";
	  	System.out.println(str1.concat(str2));
	  	System.out.println(str1.equalsIgnoreCase(str2));
	  	
	  	System.out.println(str1.toLowerCase());
	  	System.out.println(str2.toUpperCase());
	  	
	  	System.out.println(str1.isEmpty());
	  	System.out.println(str1.charAt(4));
	  	System.out.println(str1.indexOf('d'));
  }
}
