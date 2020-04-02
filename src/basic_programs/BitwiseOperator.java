package basic_programs;

public class BitwiseOperator 
{
      public static void main(String args[]) 
      {
    	  int no1=8, no2=2, or, and, xor, rightShift,leftShift, UnsignedRightShift;
    	  
    	  or=no1|no2;
    	  System.out.println("print" +or);
    	  
    	  and=no1&no2;
    	  System.out.println("print" +and);
    	  
    	  xor=no1^no2;
    	  System.out.println("print" +xor);
    	  
    	  rightShift=no1>>no2;
    	  System.out.println("print" +rightShift);
    	  
    	  leftShift=no1<<no2;
    	  System.out.println("print" +leftShift);
    	  
    	  UnsignedRightShift=no1>>>no2;
    	  System.out.println("print" +UnsignedRightShift);
    	  
      }
}
