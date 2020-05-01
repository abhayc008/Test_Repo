package assignment_2;

public class Vehicle2 
{
	
	String typeOfVehicle, brand, model, color, year;
	int price, speed;
	
	Vehicle2()
	{
		typeOfVehicle = "Motorcycle";
		brand = "Hero MotorCorp";
		model = "Hero Splendor Plus";
		color = "yellow ";
		year = "1998 ";
		price = 50000 ;
		speed = 45 ;
	}
	public Vehicle2(String typeOfVehicle, String brand, String model, String color, String year, int price, int speed) 
	{
		super();
		this.typeOfVehicle = typeOfVehicle;
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.year = year;
		this.price = price;
		this.speed = speed;
	}
	
	public Vehicle2(String typeOfVehicle, String brand, String model, String color) {
		super();
		this.typeOfVehicle = typeOfVehicle;
		this.brand = brand;
		this.model = model;
		this.color = color;
		price = 4500000;
		speed = 120;
	}
	
	void showData()
	{
		System.out.println("Vehicle type is:" +typeOfVehicle);
		System.out.println("brand :" +brand);
		System.out.println("model :" +model);
		System.out.println("color :" +color);
		System.out.println("price:" +price);
		System.out.println("speed is:" +speed+ "k/h");
	}
   
   
}
