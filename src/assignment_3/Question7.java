package assignment_3;

class Engine
{
	String engineType="1.5L petrol Engine";
	
	public void start() 
	{
		System.out.println("Engine type is"+engineType);
		System.out.println("Engine started");
	}
	public void stop() 
	{
		System.out.println("Engine stopped");
	}
}

class Vehicle7 
{

	private int maxSpeed;
	private String vehicleType, brand,color;
	
    public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public void carInfo() 
	{

		System.out.println("In car:  max speed="+maxSpeed+""
				+ "\n vehicleType="+vehicleType+"\nbrand= "+brand+"\n color="+color);
	}
}
class Car7 extends Vehicle7
{
	public void carDemo() 
	{
		Engine e = new Engine();
		e.start();
		e.stop();
	}
}

public class Question7
{

	public static void main(String[] args) 
	{
		Car7 car=new Car7();
		car.setColor("White");
		car.setMaxSpeed(120);
		car.setVehicleType("Four Wheeler");
		car.setBrand("Maruti");
		
		car.carInfo();
		car.carDemo();
	}

}
