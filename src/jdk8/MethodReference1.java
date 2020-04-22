package jdk8;

interface Walkable1
{
	void hello(String name);
}
public class MethodReference1 
{
	public static void main(String[] args) 
	{
	     Walkable1 walkable1 = System.out::print;
	     walkable1.hello("Geeta");
	}

}
