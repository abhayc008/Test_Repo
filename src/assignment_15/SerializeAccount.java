package assignment_15;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;


public class SerializeAccount 
{
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		int count = 0, eid;
		String ename, password;
		double salary;
		
		Employee1 []emp1 = new Employee1[2]; 
		Scanner scanner = new Scanner(System.in);
		
    	System.out.println("Enter account of user");
 
    	for(int i=0;i<emp1.length;i++)
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
    		    		
    		emp1[count] = new Employee1(eid,ename,password,salary);
    		count++;
    	}
		
    	FileOutputStream write = new FileOutputStream("employee1.txt");
		ObjectOutputStream writefile = new ObjectOutputStream(write);
		writefile.writeObject(emp1);
		write.close();
		writefile.close();
		
		FileInputStream read = new FileInputStream("employee1.txt");
		ObjectInputStream readfile = new ObjectInputStream(read);
		
		Employee1 [] empread = (Employee1[])readfile.readObject();
		
		System.out.println("Deserialized Data: ");
		for(Employee1 item: empread)
		{
		System.out.println(item.toString());
		}
	}

}
