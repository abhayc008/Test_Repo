package assignment_15;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AppendContent
{

	public static void main(String[] args) throws IOException 
	{
		FileReader input = null;
		FileWriter output = null;
		try
		{
			input = new FileReader("input.txt");
		    output = new FileWriter("output.txt", true) ;// for appending it must be true
  		    int i;
  			while((i= input.read())!=-1)
  		    {
  		    	System.out.print((char)i);
  		        output.append((char)i);
  		        output.flush();
  		    }		  

		}
		catch(FileNotFoundException  e)
		{
			System.out.println(e.getMessage());
		}
		 finally
		 {
			 input.close();
			 output.close();
		 }
	}

}
