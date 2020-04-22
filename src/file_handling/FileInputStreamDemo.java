package file_handling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo {

	public static void main(String[] args) throws IOException 
	{
		try 
		{
			FileInputStream fis = new FileInputStream("text.txt");
			int data = fis.read();
			System.out.println(data);//return ascii value of First character(i.e. H)
			System.out.println((char)data);//return First character(i.e. H)
		}
		catch (FileNotFoundException e) 
		{
			System.out.println(e.getMessage());
		}
		
	}

}
