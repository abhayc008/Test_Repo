package nested_class;

interface Readable
{
	void read();
}
/*
class Person implements Readable
{

	@Override
	public void read()
	{
		System.out.println("Read");
		
	}
	
}*/
public class AnonymousInterface 
{
   public static void main(String args[]) 
   {
   /*Person person=new Person();
   person.read();*/
	new Readable() 
	{

		@Override
		public void read()
		{
			System.out.println("Read");
			
		}
		
	}.read();
   }
}
