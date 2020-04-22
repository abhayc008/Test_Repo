package multithreading;

public class WifeThread implements Runnable{

	Bank b;
	WifeThread(Bank b) 
	{
	   this.b = b;
	   Thread thread = new Thread(this);
	   thread.start();
	}

	@Override
	public void run() 
	{
	  try {
		b.withdraw();
	} 
	  catch (InterruptedException e) 
	   {
		e.printStackTrace();
	   }
		
	}

}
