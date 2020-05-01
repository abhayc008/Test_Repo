package assignment_2;

public class Vehicle3
{
	private int year;
	private String make;
	private int speed;
	   
	Vehicle3()
	{
	  year = 2006;
	  make = "  ";
	  speed = 0;
	}
    public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void accelerate()
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
