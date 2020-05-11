package assignment_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MapDuplicateNotAllowed
{

	public static void main(String[] args) throws IOException 
	{

		Map<Integer,String> map = new HashMap<>();
		
		Scanner scanner = new Scanner(System.in);
		
		InputStreamReader isr = new InputStreamReader(System.in);
			
	     BufferedReader br = new BufferedReader(isr);
	     
		while(true)
		{
			
			System.out.println("-----------------------------");
			System.out.println("Main menu:");
			System.out.println("1.Input data");
			System.out.println("2.Output data");
			System.out.println("3.Exit");
			System.out.println("-----------------------------");
			System.out.println("Enter your choice");
			int ch = scanner.nextInt();
			switch(ch)
			{
			case 1:
				 String answer = "";

		            do {
		                System.out.println("Please enter key: ");
		                int key = scanner.nextInt();
		                
		                System.out.println("Please enter value: ");
		                String value = br.readLine();
		                
		                if(!map.containsKey(key)) 
		                {
		                	if(!map.containsValue(value))
		                	{
		                	  	map.put(key, value);
		                	}
		                	else 
		                	{
		                		System.out.println("Duplicates values not allowed!!!");
		                	}
		                	
		                }
		                else 
		                {
		                	System.out.println("Duplicates keys not allowed!!!");
		                }
		                
		                System.out.println("Press any key to continue,'no' to exit.");
		                answer = br.readLine();
		            } while (!answer.equals("no"));
				break;
			case 2:
				System.out.println("Output of the list: " );
				System.out.println(map);
				break;
			case 3:
				System.exit(0);
			default:
				System.out.println("Please enter valid choice !!! ");
			}
		 }          
	 }
 }
		

/*package assignment_12;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MapDuplicateNotAllowed {

	public static void main(String[] args) 
	{
	   Map<Integer,String> map = new HashMap<>();
	   Map<Integer,String> map1 = new HashMap<>();
	   
	   map.put(1, "Geeta");
	   map.put(2, "Geeta");
	   map.put(3, "Kirti");
	   map.put(4, "Bhavana");
	   map.put(5,"Laxmi");
	   
	   System.out.println(map);
	   Iterator <Entry<Integer,String>> it = map.entrySet().iterator();
	   while(it.hasNext()) 
	   {
		   Entry<Integer,String> entry = it.next();
		   if(!map1.containsValue(entry.getValue()))
		   {
			   map1.put(entry.getKey(), entry.getValue());
		   }
	   }
	   System.out.println(map1);
	   System.out.println(map1.keySet());
	   System.out.println(map1.values());
       
	   
	}

}*/
