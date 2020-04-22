package assignment_15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
//wtemp = rinput
// winput = routput
//woutput= rtemp 
public class SwappingOfContentUsingStream {

	public static void main(String[] args) throws IOException 
	{
		FileInputStream rinput = null, routput = null, rtemp =null;
		FileOutputStream woutput = null , wtemp = null , winput = null;
  		int content = 0;
		try 
		{
			rinput = new FileInputStream("input.txt");
			wtemp = new FileOutputStream("temp.txt");
			while(content != -1)
			{
				content = rinput.read();
				if(content == -1)
				break;
				wtemp.write((char)content);
				wtemp.flush();
				System.out.print((char)content);
			}
			int content1=0;
			routput = new FileInputStream("output.txt");
			winput = new FileOutputStream("input.txt");
			while(content1 != -1)
			{
				content1 = routput.read();
				if(content1 == -1)
				break;
				winput.write((char)content1);
				winput.flush();
				System.out.print((char)content1);
			}
			int content2=0;
			rtemp = new FileInputStream("temp.txt");
			woutput = new FileOutputStream("output.txt");
			while(content2 != -1)
			{
				content2 = rtemp.read();
				if(content2 == -1)
				break;
				woutput.write((char)content2);
				woutput.flush();
				System.out.print((char)content2);
			}
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			rinput.close();
		    routput.close();
		    rtemp.close();
		    
		}
		
	}

}
