package file_handling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo
{

	public static void main(String[] args) throws IOException 
	{

		FileReader fr = null;
		try 
		{
			File file = new File("read.txt");
			file.createNewFile();
			fr = new FileReader(file);
			char arr[] = new char[10];
			fr.read(arr);
			for(int i=0;i<arr.length;i++)
			{
				System.out.print(arr[i]);
			}
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println(e.getMessage());
		}
        finally
        {
        	fr.close();
        }
		
	}

}
