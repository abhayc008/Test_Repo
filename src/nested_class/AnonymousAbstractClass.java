package nested_class;

abstract class Person1
{
	public abstract void display();
	public abstract void read();
}
/*class Person2 extends Person1
{

	@Override
	public void display() 
	{
         System.out.println("Hello geeta");		
	}
}*/
public class AnonymousAbstractClass 
{
   public static void main(String args[]) 
   {   
	   /*
	   Person1 person1=new Person2();
	   person1.display();*/
	   
	   Person1 person1=new Person1()
	   {

		@Override
		public void display() 
		{
			System.out.println("Hello Geeta");
		}

		@Override
		public void read() 
		{
			System.out.println("Reading Newspaper");
			
		}
		   
	   };
	   person1.display();
	   person1.read();
   }
}
