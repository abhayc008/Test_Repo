package interface_demo;

public class Cat implements Animal
{
    public static void main(String args[]) 
    {
      Cat cat=new Cat();
      cat.eat();
      cat.sleep();
    }
	@Override
	public void eat() 
	{
        System.out.println("Eat");	
	}

	@Override
	public void sleep() 
	{
        System.out.println("Sleep");
	}
	

}
