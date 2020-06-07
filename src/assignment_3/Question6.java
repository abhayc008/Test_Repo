package assignment_3;

class Vehicle5
{
	 void display() 
	{
		System.out.println("Vehicle Class");
	}
}
class Car5 extends Vehicle5
{
	 protected void display() // in place of protected write final
	{
		System.out.println("Car Class");
	}
	
}
class Duster5 extends Car5
{
	public void display() 
	{
		System.out.println("Duster Class");
	}
}

public class Question6
{
	public static void main(String args[]) 
	{
		Duster5 dust= new Duster5();	
		dust.display();
		
		Car5 car = new Car5();
		car.display();
	}

}
