package nested_class;

class Outer
{
   static class Inner
   {
	   public void innermethod() 
	   {
		   System.out.println("Inner Instance Method");
	   }
   }
}
public class StaticNestedClass 
{
   public static void main(String args[]) 
   {
	   Outer.Inner inner=new Outer.Inner();
	   inner.innermethod();
	   
   }
}
