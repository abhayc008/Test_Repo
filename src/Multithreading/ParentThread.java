package multithreading;

class Parent extends Thread
{

	@Override
	public void run()
	{
		for(int i=1;i<=5;i++)
		{
	     System.out.println(Thread.currentThread());
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
public class ParentThread {

	public static void main(String[] args) 
	{
		Parent parent1 = new Parent();
		parent1.setName("Coder");
		
		Parent parent2 = new Parent();
		parent2.setName("Squad");

		parent1.start();
		parent2.start();
		
		for(int i=1;i<=5;i++)
		{
	     System.out.println(Thread.currentThread());
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
