package multithreading;

class Join extends Thread
{

	@Override
	public void run()
	{
		for(int i=1;i<=5;i++)
		{
	     System.out.println(Thread.currentThread());
	     try
	     {
	    	 Thread.sleep(1000);
	     }
	     catch(InterruptedException e)
	     {
	    	 e.printStackTrace();
	     }
		}
	}
}
public class ThreadJoin {

	public static void main(String[] args) throws InterruptedException 
	{
		Join join = new Join();
		join.setName("Coder");
		
		Join join1 = new Join();
		join1.setName("Squad");

		System.out.println(join.isAlive());
		join.start();
		System.out.println(join.isAlive());
		join.join(45, 7);
		System.out.println(join.isAlive());
		join1.start();
		join1.join();
		System.out.println(join1.isAlive());
		
		//isAlive() method
		
		System.out.println();
		
		for(int i=1;i<=5;i++)
		{
	     System.out.println(Thread.currentThread());
	     try
	     {
	    	 Thread.sleep(1000);
	     }
	     catch(InterruptedException e)
	     {
	    	 e.printStackTrace();
	     }
	   }
	}

}
