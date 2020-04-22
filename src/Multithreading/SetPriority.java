package multithreading;

class Priority extends Thread
{
	public void run()
	{
		System.out.println(Thread.currentThread().getPriority());
	}
}

public class SetPriority {

	public static void main(String[] args) {
		Priority priority = new Priority();
		priority.setPriority(10);
		priority.start();//default priority is 5

	}

}
