package assignment_13;


public class ChildThread implements Runnable
{
	Thread thread;
	
	ChildThread() throws InterruptedException
	{
		Thread thread = new Thread(this);
		thread.setName("geeta");
		
		Thread thread1 = new Thread(this);
		thread1.setName("geeta1");
		
		Thread thread2 = new Thread(this);
		thread2.setName("geeta2");
		
		System.out.println(thread.isAlive());
		thread.start();
		
		System.out.println(thread.isAlive());
		thread.join();
		
		System.out.println(thread.isAlive());
        thread1.start();
        
        System.out.println(thread1.isAlive());
        
        thread1.join();
        System.out.println(thread1.isAlive());
        
        thread2.start();
        System.out.println(thread2.isAlive());
        
        thread2.join();
        System.out.println(thread.isAlive());
		
	}
	@Override
	public void run()
	{
		System.out.println(Thread.currentThread());
	}
}

