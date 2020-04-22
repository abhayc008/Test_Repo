package multithreading;

public class HusbandThread  implements Runnable
{
	Bank b;
	HusbandThread(Bank b)
	{
		this.b =b;
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() 
	{
		try {
			b.deposit();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
