package basic_programs;

public class LogicalOperator
{
   public static void main(String args[]) 
   {
		int no1=20, no2=89;
		boolean check;
		
		check = no1>no2&& no1>5;
	    System.out.println(check);
	    
		check= no1>no2||no1>5;
	    System.out.println(check);
	    
		check= !(no1>no2&&no1>5);
	    System.out.println(check);	       
   }
}
