package file_handling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo1 
{

	public static void main(String[] args) throws IOException 
	{
		try {
			FileInputStream fis = new FileInputStream("text.txt");
			//byte []arr = new byte[10];//it return only hii geeta becauase size is 10
			//byte []arr = new byte[20];//it will return whole data and size is 20 so in place of empty value it return square type image 
			int count = fis.available();
			byte []arr = new byte[count];
			fis.read(arr);
			for(int i=0;i<arr.length;i++)
			{
				System.out.print((char)arr[i]);
			}
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println(e.getMessage());
		}

	}

}
