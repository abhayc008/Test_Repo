package assignment_3;

//Vehicle-car-duster
//Extend the Vehicle class by Car class and Car class by Duster class. Inherit the properties
//from Vehicle and add new properties in Car and Duster.

class Vehicle 
{
	public int  gear;
	public int speed;
	
	@Override
	public String toString() {
		return "No of gear=" + gear + "\nspeed of car=" + speed ;
	}

	
	public Vehicle(int gear, int speed)
	{
		this.gear = gear;
		this.speed = speed;
	}
	public void applyBrake(int decrement) 
	{ 
	    speed -= decrement; 
	} 
	      
	public void speedUp(int increment) 
	{ 
	    speed += increment; 
	} 
}
class Car extends Vehicle
{
	public int seater ;
	@Override
	public String toString()
	{
		return (super.toString()+ "\n No of seat available=" + seater);
	} 
	public Car(int gear, int speed, int seater) 
	{
		super(gear, speed);
		this.seater = seater;
	}

}
class Duster extends Car
{
	int year,price;
    String engine_type,vehicleType,brand, model, color;
  
    @Override
	public String toString() 
    {
		return (super.toString()+ "\n year=  " + year+ "\nengine_type=  "+engine_type+"\n vehicleType="+vehicleType+""
				+ "\n brand= "+brand+"\n model=  "+model+"\ncolor=  "+color);
	}
	public Duster(int gear, int speed, int seater, int year, int price, String engine_type, String vehicleType,
			String brand, String model, String color) {
		super(gear, speed, seater);
		this.year = year;
		this.price = price;
		this.engine_type = engine_type;
		this.vehicleType = vehicleType;
		this.brand = brand;
		this.model = model;
		this.color = color;
	}
	
}
public class Question1 {

	public static void main(String[] args) 
	{
		Duster duster = new Duster(1,120,6,2012,800000,"1.5L petrol Engine","Four wheeler","Renault","Duster","Red");
		System.out.println(duster.toString());
	}

}
