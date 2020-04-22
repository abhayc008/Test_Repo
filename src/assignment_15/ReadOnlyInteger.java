package assignment_15;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadOnlyInteger {

	public static void main(String[] args) throws IOException 
	{
		FileReader fis = null;
		Scanner scanner ;
		try 
		{
			 fis = new FileReader("integer.txt");
			 System.out.println("Read integer number only");
			 scanner = new Scanner(fis);
			 while(scanner.hasNextLine())
			 {
				if(scanner.hasNextInt())
				{
					System.out.println(scanner.nextInt());
				}
				else if(scanner.hasNext())
				{
					scanner.next();
				}
			 }
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			fis.close();
		}
	
	}

}
