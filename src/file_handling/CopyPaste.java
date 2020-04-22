package file_handling;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyPaste {

	public static void main(String[] args) throws IOException
	{
		FileWriter fw = null, fw1 = null;
		FileReader fr = null;
		try {
			 fw = new FileWriter("copy.txt");
		     fw1 = new FileWriter("paste.txt");
		    
		    fw.write("Hello all!!!");
		    fw.flush();
		    fr = new FileReader("copy.txt");
		    int i;
			while((i= fr.read())!=-1)
		    {
		    	System.out.print((char)i);
		        fw1.write(i);
		        fw1.flush();
		    }
			
		} catch (IOException e) 
		{
			throw e;
		}
		finally
		{
			fw.close();
			fw1.close();
			fr.close();
		}

	}

}
