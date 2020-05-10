package assignment_13;

public class PrintStar 
{
	public static void main(String[] args) 
	{
		 
		OddEven oep = new OddEven();
		
		Thread t1 = new Thread(new Runnable() {
 
			@Override
			public void run() {
				oep.printEven();
 
			}
		});
		Thread t2 = new Thread(new Runnable() {
 
			@Override
			public void run() {
				oep.printOdd();
 
			}
		});
 
		t1.start();
		t2.start();
	}
}
