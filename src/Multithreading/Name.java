package multithreading;

class MyThread1 extends Thread
{
	public void run()
	{
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread());
	}
}

public class Name {

	public static void main(String[] args) {
		MyThread1 mythread1  = new MyThread1();
		mythread1.setName("Coder");
		mythread1.start();

	}

}
