package basic_programs;

public class ConditionalOperator 
{
   public static void main(String args[]) 
   {
	int no1=20, no2=89, see;
	boolean check;
	
	check = no1>no2?true:false;
    System.out.println(check);
    
	see = no1>no2?no1:no2;
    System.out.println(see);
    
    System.out.println(no1>no2?"no1 is greater than no2":"no2 is greater than no1");
    
   }
}
