package assignment_2;

public class Question2 
{
	public static void main(String args[])
	{
	
		Vehicle2 vehicle2 = new Vehicle2();
		vehicle2.showData();
		System.out.println("-----------------------------");
		
		Vehicle2 vehicle3 = new Vehicle2("Scooty" ,"Hero motocorp", "Activa", "White", "2002", 60000, 60);
		vehicle3.showData();
		
		System.out.println("-----------------------------");
        Vehicle2 vehicle4 = new Vehicle2("Car", "Maruti", "Maruti Suziki 800", "red");
        vehicle4.showData();
        
        System.out.println("-----------------------------");
	}
}
