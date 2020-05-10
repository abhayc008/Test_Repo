package assignment_13;

public class OddEven 
{
	 int start = 1, max = 14;
	 
	 public void printEven()
	 {
		 while(start < max)
		 {
			 synchronized(this)
			 {
				 if(start%2 == 0)
				 {
					 System.out.print("*");
					 start ++;
					 notify();
				 }
				 else 
				 {
					try 
					{
						wait();
					}
					catch (InterruptedException e) 
					{
						System.out.println(e);
				    }
 			     }
		     }
	     }
	 }
	 public void printOdd()
	 {
		 while(start < max)
		 {
			 synchronized(this)
			 {
				 if(start%2 != 0)
				 {
					 System.out.print("//");
					 start ++;
					 notify();
				 }
				 else 
				 {
					try
					{
						wait();
					}
					catch (InterruptedException e) 
					{
						System.out.println(e);
					}
				 }
 			 }
		 }
	 }
}
 