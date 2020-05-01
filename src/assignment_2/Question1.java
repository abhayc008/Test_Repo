package assignment_2;

import java.util.Scanner;

public class Question1
{

	public static void main(String[] args) 
	{
		
		Vehicle1 vehicle = new Vehicle1();
		/*
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Ënter the details of vehicle: ");
		
		System.out.println("Name: ");
		vname = scanner.nextLine();
		
		System.out.println("Make:");
		make = scanner.nextLine();
		
		System.out.println("Color");
		color = scanner.nextLine();
		
		System.out.println("Engine State:");
		engineState = scanner.nextBoolean();
		*/
		
		vehicle.vname = "Motorcycle";
		vehicle.make = "Herohonda";
		vehicle.color = "Black";
		
		System.out.println("Details of vehicle is......");
		vehicle.showDetails();
		
		System.out.println("Starting engine......");
		vehicle.startEngine();
        
		System.out.println("-------------------");
		
		vehicle.startEngine();

 
	}

}
