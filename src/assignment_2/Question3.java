package assignment_2;

import java.util.Scanner;

public class Question3 
{

	public static void main(String[] args)
	{
		String typeOfVehicle, model;
		
		Vehicle3 vehicle3 = new Vehicle3();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please enter the details of vehicle:");
		
		System.out.println("Vehicle Tpye:");
		typeOfVehicle = scanner.nextLine();
		
		System.out.println("Model :");
		model = scanner.nextLine();
		
		// for increase the speed of vehicle
		for(int i=0; i<5; i++)
		{
		    vehicle3.accelerate();
		    System.out.println("Current speed of vehicle is :" +vehicle3.getSpeed());
		}
		
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
