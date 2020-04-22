package multithreading;

class MyThread4 implements Runnable
{
	Thread thread;
	MyThread4()
	{
		Thread thread = new Thread(this);
		System.out.println(Thread.currentThread().getName());
		thread.start();
	}
	@Override
	public void run()
	{
		System.out.println(Thread.currentThread());
	}
}
public class MultipleThread {

	public static void main(String[] args) {
		MyThread4 mythread = new MyThread4();
		MyThread4 mythread1 = new MyThread4();
		MyThread4 mythread2 = new MyThread4();
	}

}
