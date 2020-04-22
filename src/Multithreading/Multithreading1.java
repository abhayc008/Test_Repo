package multithreading;

class MyThread implements Runnable
{
	@Override
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
public class Multithreading1 {

	public static void main(String[] args) {
		MyThread mythread = new MyThread();
		Thread thread = new Thread(mythread);
		thread.start();

	}

}
