package interface_demo;

@FunctionalInterface
interface Fun
{
   void doormat();
   
}
public class FunctionalInterface1 implements Fun
{   
	@Override
	public void doormat() 
	{
        System.out.println("doormat");	
	}
	public static void main(String[] args) 
	{
	   FunctionalInterface1 fun=new FunctionalInterface1();
	   fun.doormat();
	   if( fun instanceof FunctionalInterface1) 
		{
			System.out.println("True");
		}
		else 
		{
			System.out.println("False");
		}
	}
}
