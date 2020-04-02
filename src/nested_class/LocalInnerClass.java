package nested_class;

class Outer2
{
	public void outerMethod() 
	{
		class Inner2
		{
			public void in() 
			{
				System.out.println("Inner class method");
			}
		}
		Inner2 inner=new Inner2();
		inner.in();
	}
}
public class LocalInnerClass 
{
     
	public static void main(String[] args) 
	{
    Outer2 outer=new Outer2();
    outer.outerMethod();

	}

}
