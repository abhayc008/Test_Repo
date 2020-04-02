package logical_programs;
import java.util.Scanner;

public class Swapping 
{
   public static void main(String args[]) 
   {
	   int no1,no2;
	   //int temp;
	   
	   Scanner scanner=new Scanner(System.in);
	   
	   System.out.println("Enter two values");
	   no1=scanner.nextInt();
	   no2=scanner.nextInt();
	   scanner.close();
	   
	   System.out.println("Number before Swapping");
	   System.out.println("First number " +no1);
	   System.out.println("Second number " +no2);
	   
	   /*temp=no1;
	   no1=no2;
	   no2=temp;*/
	   
	   no1=no1+no2;
	   no2=no1-no2;
	   no1=no1-no2;
	   
	   System.out.println("After Swappping");
	   System.out.println("First number " +no1);
	   System.out.println("Second number " +no2);
	   
   }
}
