package assignment_15;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

// temp = fr; t=x
//fr = fr1  x = y
//fr1 = temp; y=t

public class SwappingOfContent {

	public static void main(String[] args) throws IOException 
	{
		FileWriter temp =null;
		try 
		{			
             int i;
             FileReader fr = new FileReader("text.txt"); //hi geeta !!!
             temp = new FileWriter("temp.txt");
		     while ((i=fr.read()) != -1)
		     {
		    	   System.out.print((char)i);
			        temp.write(i);
			        temp.flush();
		     }
		     FileReader fr1 = new FileReader("charwrite.txt");// hi abhay!!! 
		     FileWriter fw = new FileWriter("text.txt") ;
		     int j;
		     while ((j=fr1.read()) != -1)
		     {
		    	   System.out.print((char)j);
			       fw.write(j);
			       fw.flush();
		     }
		     FileReader temp1 = new FileReader("temp.txt");
		     FileWriter fw1 = new FileWriter("charwrite.txt") ;
		     int k;
		     while ((k=temp1.read()) != -1)
		     {
		    	   System.out.print((char)k);
			       fw1.write(k);
			       fw1.flush();
		     }
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			temp.close();
			/*
			fr.close();
			fr1.close();
			temp.close();
			temp1.close();
			fw.close();
			fw1.close();
			*/
		}
		


	}

}
