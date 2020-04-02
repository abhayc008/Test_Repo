package interface_demo;

class Human implements Walkable
{
    
	@Override
	public void eat() {
		System.out.println("Eat");
		
	}

	@Override
	public void sleep() {
		System.out.println("Sleep");
		
	}

	@Override
	public void walk() {
		System.out.println("Walk");
		
	}
}
	public class ExtendedInterface
	{
	   public static void main(String args[]) 
	   {
           Human human=new Human();
		   human.eat();
		   human.walk();
		   human.sleep();
	   }
    }