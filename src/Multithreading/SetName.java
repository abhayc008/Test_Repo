package multithreading;

class MyThread3 implements Runnable
{
	@Override
	public void run()
	{
		for(int i=1;i<=5;i++)
		{
	     System.out.println(Thread.currentThread().getName());
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
public class SetName{

	public static void main(String[] args) {
		MyThread3 mythread = new MyThread3();
		Thread thread3 = new Thread(mythread,"Geeta");
		thread3.start();

	}

}
