package assignment_3;

class Vehicle3
{
	 int  seater=6;
	 void display() 
	 {
		 System.out.println("In Vehicle\n"
		 		+ "Seater="+seater);
	 }
}
class Car3 extends Vehicle3
{
	int gear=3, speed=120;
	
	void display() 
	{
		System.out.println("In car \n"
				+ "gear="+gear+"\n speed="+speed);
	}
}
class Duster3 extends Car3
{
	int year=2012, price=8000000;
	String engineType="1.5L petrol Engine", vehicleType="Four wheeler", brand="Renault", model="Duster", color="Yellow";
	
	void display() 
	{
		System.out.println("In duster\n"
				+ "year= "+year+"\n price="+price+"\n engineType="+engineType+""
						+ "\n vehicleType="+vehicleType+"\nbrand= "+brand+"\n color="+color);
	}
}

public class Question4 
{

	public static void main(String[] args) 
	{
		Duster3 dust = new Duster3();
		
		Car3 car = new Car3();
		
		Vehicle3 vehicle = new Vehicle3();
		
		dust.display();
		car.display();
		vehicle.display();
		
	}

}
