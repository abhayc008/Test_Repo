package nested_class;

class Outer1
{
	class Inner1
	{
		public void in() 
		{
			System.out.println("Inner Method");
		}
	}
}
public class RegularClass {

	public static void main(String[] args) 
	{
		//first way
		Outer1.Inner1 inner1=new Outer1().new Inner1();
		inner1.in();
		
		//second way
		Outer1 outer=new Outer1();
		Outer1.Inner1 inner2=outer.new Inner1();
		inner2.in();
	}

}

