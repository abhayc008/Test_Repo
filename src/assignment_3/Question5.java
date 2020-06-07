package assignment_3;

class Vehicle4
{
	Vehicle4()
	{
		System.out.println("Vehicle Class");
	}
}
class Car4 extends Vehicle4
{
	Car4()
	{
		super();
		System.out.println("Car Class");
	}
	
}
final class Duster4 extends Car4
{
	Duster4()
	{
		super();
		System.out.println("Duster Class");
	}	
}

public class Question5 
{
	public static void main(String args[]) 
	{
		Duster4 dust= new Duster4();		
	}

}
