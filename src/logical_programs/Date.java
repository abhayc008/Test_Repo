package logical_programs;
import java.util.Scanner;

public class Date 
{
    public static void main(String args[]) 
    {
    	int dd,mm,yy,noOfDays=0;
    	
    	Scanner scanner=new Scanner(System.in);
    	
    	System.out.println("Enter dd: ");
    	dd=scanner.nextInt();
    	
    	System.out.println("Enter mm: ");
    	mm=scanner.nextInt();
    	
    	System.out.println("Enter yy: ");
    	yy=scanner.nextInt();
    	
    	scanner.close();
    	
    	switch(mm) 
    	{
    	case 1:case 3:case 5:case 7:case 8:case 10:case 12:
    		noOfDays=31;
    		break;
    	case 4:case 6:case 9:case 11:
    		noOfDays=30;
    		break;
    	case 2:
    		if(yy%4==0) 
    		{
    			System.out.println("This year is leap year");
    			noOfDays=29;
    		}
    		else 
    		{
    			System.out.println("This year is not a leap year");
    			noOfDays=28;
    		}
    		break;
    	 default:
    		 System.out.println("This month is invalid");
    	}
    	 if(dd>noOfDays)
 	     {
 	    	System.out.println("Date is invalid"); 
 	     }
 	     else 
 	     {
 	    	System.out.println(+dd+"/"+mm+"/"+yy);
 	     }
    }
}
