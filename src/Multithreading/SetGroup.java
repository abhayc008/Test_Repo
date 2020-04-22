package multithreading;

class Group implements Runnable
{
	@Override
	public void run()
	{
	     System.out.println(Thread.currentThread());
	}
}


public class SetGroup {

	public static void main(String[] args) {
      
		Group group = new Group();
		Group group1 = new Group();
		Group group2 = new Group();
		
		ThreadGroup threadgroup = new ThreadGroup("Thane");
		
		Thread thread = new Thread(threadgroup,group,"Coder");
		Thread thread1 = new Thread(group);
		Thread thread2 = new Thread(threadgroup,group1);
	
		thread.start();
		thread1.start();
		thread2.start();

	}

}
