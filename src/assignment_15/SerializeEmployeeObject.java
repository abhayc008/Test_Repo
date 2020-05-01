package assignment_15;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import serialization.Employee;
import serialization.Serialization;

public class SerializeEmployeeObject 
{
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		int noOfEmployee, count = 0, eid, pincode;
		String ename, password, city, state, country;
		Address address;
		double salary;
		
		Employee3 []emp = new Employee3[2]; 
		Scanner scanner = new Scanner(System.in);
		
    	System.out.println("Enter account of user");
        noOfEmployee = emp.length;
    	for(int i=0;i<emp.length;i++)
    	{
    		System.out.println("Enter employee Id");
    		eid = scanner.nextInt();
  
    		
    		InputStreamReader isr = new InputStreamReader(System.in);
    		BufferedReader br = new BufferedReader(isr);
    		
    		System.out.println("Enter employee name");
    		ename = br.readLine();
    		
    		System.out.println("Enter the password");
    		password = br.readLine();
            
    		System.out.println("Enter salary ");
    		salary = scanner.nextDouble();
    		
    		System.out.println("Enter address of Employee");
    		System.out.print("city: ");
    		city= br.readLine();
    		
    		System.out.println("state: ");
    		state= br.readLine();
    		
    		System.out.println("country:  ");
    		country = br.readLine();
    		
    		System.out.println("Pincode");
    		pincode = scanner.nextInt();
    		
    		address = new Address(city, state, country,pincode);
    		
    		emp[count] = new Employee3(eid,ename,password,salary, address);
    		count++;
    	}
		
    	FileOutputStream write = new FileOutputStream("employee3.txt");
		ObjectOutputStream writefile = new ObjectOutputStream(write);
		writefile.writeObject(emp);
		write.close();
		writefile.close();
		
		FileInputStream read = new FileInputStream("employee3.txt");
		ObjectInputStream readfile = new ObjectInputStream(read);
		

		Employee3 [] empread = (Employee3[])readfile.readObject();
		
		System.out.println("Deserialized Data: ");
		for(Employee3 item: empread)
		{
		System.out.println(item.toString());
		}
	}

}
