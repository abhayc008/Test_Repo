package string_demo;

public class SortOfStringWithOUtUsingAPI
{

	public static void main(String[] args) 
	{
	 char temp;
     String s = "Coder Technology";	   
     char []chars = s.toCharArray();
    
     for(int i =0; i<chars.length;i++)
     {
    	 for(int j=0;j<chars.length;j++)
    	 {
    		if(chars[j]>chars[i])
    		{
    			temp = chars[i];
    			chars[i] = chars[j];
    			chars[j] = temp;
    		}
         }
     }
     for(int k=0;k<chars.length;k++)
     {
    	 System.out.print(chars[k]);
     }
	}
}
