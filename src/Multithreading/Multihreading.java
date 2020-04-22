package multithreading;

class Hi extends Thread
{
	public void run()
	{
		for(int i=1;i<=5;i++)
		{
	     System.out.println("Hi");
	     try
	     {
	    	 Thread.sleep(3000);
	     }
	     catch(InterruptedException e)
	     {
	    	 e.printStackTrace();
	     }
		}
	}
	
}
class Hello extends Thread
{
	public void run()
	{
		for(int i=1;i<=5;i++)
		{
	     System.out.println("Hello");
	     try
	     {
	    	 Thread.sleep(3000);
	     }
	     catch(InterruptedException e)
	     {
	    	 e.printStackTrace();
	     }
		}
	}
	
}
public class Multihreading {

	public static void main(String[] args)
	{
		Hi hi = new Hi();
		hi.start();
		Hello hello = new Hello();
		hello.start();
	}
}