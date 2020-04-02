package string;

public class SubString
{
     public static void main(String args[]) 
     {
    	 String str1= "Coder Technologies";
    	 //String str2="coder";
    	 
    	 System.out.println(str1.contains("co"));
    	 
    	 System.out.println(str1.indexOf('T'));
    	 
    	 System.out.println(str1.lastIndexOf('o'));
    	 
    	 System.out.println(str1.substring(6));
    	 
    	 System.out.println(str1.substring(6,10));
     }
}
