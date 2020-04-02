package basic_programs;

public class TypeConversion 
{
   public static void main(String args[]) 
   {
	   byte no=10;
	   short no1=no; //Implicit
	   
	   byte no2=(byte)no1; //Explicit
	   System.out.println("first number" +no1);
	   System.out.println("second number" +no2);
   } 
}
