package assignment_2;

public class Vehicle3
{
	String typeOfVehicle, brand, model, color, year;
	int price, speed;
	
	public Vehicle3(String typeOfVehicle, String brand, String model, String color) {
		super();
		this.typeOfVehicle = typeOfVehicle;
		this.brand = brand;
		this.model = model;
		this.color = color;
		price = 4500000;
		speed = 0;	
		}
	
	@Override
	public String toString() {
		return "Vehicle3 [typeOfVehicle=" + typeOfVehicle + ", brand=" + brand + ", model=" + model + ", color=" + color
				+ ", year=" + year + ", price=" + price + ", speed=" + speed + "]";
	}

	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void speedUp()
	{
		speed += 5;
	}
	/*
	public void brake()
	{
		speed -= 5;
	}
	*/
}
