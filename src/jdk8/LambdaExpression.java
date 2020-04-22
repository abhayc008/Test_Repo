package jdk8;

interface Runnable
{
	void run();
}
/* 1st way
class Person implements Runnable
{

	@Override
	public void run()
	{
		System.out.println("Run");
	}
	
}*/
public class LambdaExpression { //In normal interface we have to implements interface( note for 2nd way) 

	public static void main(String[] args) {
		/* 1st  way
		Person person = new Person();
		person.run();
        */
		
		/* 2nd way
		Runnable runnable = new LambdaExpression();		
		runnable.run();	
	}

	@Override
	public void run()
	{
	  System.out.println("Run");
	}
	*/
		Runnable runnable = ()->System.out.println("Run");// if we have only one method in interface/ functional interface 
		runnable.run();//then directly call this method using lambda exp.
	}

}
