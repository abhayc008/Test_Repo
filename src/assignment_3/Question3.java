package assignment_3;

//Vehicle-car-duster
class Vehicle2 
{
	public int  gear;
	public int speed;
	
	Vehicle2(int gear)
	{
		this.gear = gear;
	}
	 Vehicle2() {
		// TODO Auto-generated constructor stub
	}
	public int speedUp(int speed) 
	{
		speed = speed +5;
		return speed;
	}
     
}
class Car2 extends Vehicle2
{
	int seater ;
	
	Car2(int gear, int seater) 
	{
		super(gear);
		this.seater = seater;
	}
	public int speedUp(int speed) 
	{
		super.speedUp(super.speed);
		speed =speed +5;
		return speed;
	}

}
class Duster2 extends Car2
{
	int year,price;
    String engine_type,vehicleType,brand, model, color;
  
	public Duster2(int gear, int seater, int year, int price, String engine_type, String vehicleType,
			String brand, String model, String color) {
		super(gear, seater);
		this.year = year;
		this.price = price;
		this.engine_type = engine_type;
		this.vehicleType = vehicleType;
		this.brand = brand;
		this.model = model;
		this.color = color;
	}
	
	public String toString() 
    {
		return (super.toString()+ "\n year=  " + year+ "\nengine_type=  "+engine_type+"\n vehicleType="+vehicleType+""
				+ "\n brand= "+brand+"\n model=  "+model+"\ncolor=  "+color);
	}
	public int speedUp(int speed) 
	{
		super.speedUp(super.speed);
		speed +=5;
		return speed;
	}
	
}
public class Question3{

	public static void main(String[] args) 
	{
		Duster2 duster = new Duster2(1,6,2012,800000,"1.5L petrol Engine","Four wheeler","Renault","Duster","Red");
		System.out.println(duster.toString());
		
		Vehicle2 vehicle = new Vehicle2(10);
		//System.out.println(vehicle.speedUp());
        
		System.out.println(duster.speedUp(5));
	}

}
