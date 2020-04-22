package jdk8;
 interface DefaultInterface
{
	void run();
	void waik();
	default void sleep()
	{
		System.out.println("Sleep");
	}
	static void breathing()
	{
		System.out.println("Breathing");
	}
}
public class Demo implements DefaultInterface 
{

	public static void main(String[] args)
	{
		Demo obj = new Demo();
		obj.run();
		obj.waik();
		obj.sleep();
		DefaultInterface.breathing();//to call static method

	}

	@Override
	public void run() {
		System.out.println("Run");		
	}

	@Override
	public void waik() {
		System.out.println("Walk");		
	}

}
