package jdk8;

interface Walkable
{
	void walk(int i);
}
public class MethodReference 
{
	public void show(int i)
	{
		System.out.println(++i);
	}

	public static void main(String[] args) 
	{
	     Walkable walkable = new  MethodReference()::show;
	     walkable.walk(6);
	     
	}

}
