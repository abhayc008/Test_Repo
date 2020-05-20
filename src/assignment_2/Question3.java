package assignment_2;

import java.util.Scanner;

public class Question3 
{

	public static void main(String[] args)
	{	
		System.out.println("Please enter the details of vehicle:");
		Vehicle3 vehicle3 = new Vehicle3("Car", "Maruti", "Maruti Suziki 800", "red");
		
		System.out.println(vehicle3);
		// for increase the speed of vehicle
		vehicle3.speedUp();
	    System.out.println("Current speed of vehicle is :" +vehicle3.getSpeed());
	    System.out.println(vehicle3);
	    
		for(int i=0; i<5; i++)
		{
		    vehicle3.speedUp();
		    System.out.println("Current speed of vehicle is :" +vehicle3.getSpeed());
		}
		System.out.println(vehicle3);
		/*
		System.out.println("--------------------------------------------------");
		//Brake
		for(int i=0; i<5; i++)
		{
			if(i>=0 && i<= 210)
			{
			 vehicle3.brake();
			}
			System.out.println("After brake speed of vehicle is :" +vehicle3.getSpeed());
		}*/       
	}

}
