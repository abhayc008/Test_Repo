package assignment_2;

class Vehicle1
{
	String vname;
	String make;
	String color;
	boolean engineState;
	
	void startEngine()
	{
		if(engineState == true)
		{
			System.out.println("Engine is already on... ");
		}
		else
		{
			engineState = true;
			System.out.println("Engine is now on... ");
		}
	}
	
	void showDetails()
	{
		System.out.println("Vehicle name is " +vname);
		System.out.println("nmake is  " + make);
		System.out.println("color is "+color);
	}
}