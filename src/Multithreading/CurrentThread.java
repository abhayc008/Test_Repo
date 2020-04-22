package multithreading;

class Current extends Thread
{
	@Override
	public void run()
	{
		for(int i=1;i<=5;i++)
		{
	     System.out.println(Thread.currentThread());
	     System.out.println(Thread.activeCount());
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
class Current1 extends Thread
{
	@Override
	public void run()
	{
		for(int i=1;i<=5;i++)
		{
	     System.out.println(Thread.currentThread());
	     System.out.println(Thread.activeCount());
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
public class CurrentThread {

	public static void main(String[] args) {
       Current current = new Current();
       Current1 current1 = new Current1();
       
       current.start();
       current1.start();

	}

}
