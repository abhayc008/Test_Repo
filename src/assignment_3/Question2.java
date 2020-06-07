package assignment_3;

class Vehicle1 
{
    int  gear,speed;     
	
	public Vehicle1()
	{
	    gear = 3;
		speed = 120;
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
class Car1 extends Vehicle1
{
	int seater ;	
	Car1() 
	{
		super();
		seater=6;
	}

}
class Duster1 extends Car1
{
	int year,price;
    String engine_type,vehicleType,brand, model, color;
 
	public Duster1(int year, int price, String engine_type, String vehicleType,
			String brand, String model, String color) 
	{
	    super();	
		this.year = year;
		this.price = price;
		this.engine_type = engine_type;
		this.vehicleType = vehicleType;
		this.brand = brand;
		this.model = model;
		this.color = color;
	}
	@Override
	public String toString() 
    {
		return ("No of gear=" + super.gear + "\nspeed of car=" + super.speed + "\n No of seat available=" + super.seater+ "\n year=  " + year+ "\nengine_type=  "+engine_type+"\n vehicleType="+vehicleType+""
				+ "\n brand= "+brand+"\n model=  "+model+"\ncolor=  "+color);
	}
	
}

public class Question2 
{

	public static void main(String[] args)
	{
		Duster1 duster = new Duster1(2012,800000,"1.5L petrol Engine","Four wheeler","Renault","Duster","Red");
		System.out.println(duster.toString());
	}

}
