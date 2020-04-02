package nested_class;

abstract class Animal
{
	public abstract void eat();
}
abstract class Human
{
	public abstract void sleep();
	public abstract void walk();
}
class Vampire extends Animal
{

	@Override
	public void eat() 
	{
		System.out.println("Eat");
		
	}
	
}
public class AnonymousInnerClass 
{

	public static void main(String[] args) 
	{
		Vampire vampire=new Vampire();
		vampire.eat();
		vampire.eat();
		
		Human human=new Human() //new human() compiler create the object of anonymous class
		{

			@Override
			public void sleep() 
			{
				System.out.println("Sleep");
				
			}

			@Override
			public void walk() 
			{
				System.out.println("Walk");
				
			}
			
		};//when only one method .sleep();
		human.sleep();
		human.walk();
		//human.sleep();
	}

}
