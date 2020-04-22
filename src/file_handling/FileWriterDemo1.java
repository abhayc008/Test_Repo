package file_handling;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo1 
{
	public static void main(String[] args) throws IOException
	{
		FileWriter fw= null;
		try
		{
			fw = new FileWriter("charwrite.txt", true);// to append into existing data
			fw.write(68);
			fw.write('A');
			char arr[] = {'h','e','l','l','o'};
			fw.write(arr);
			fw.write("Geeta");
		} 
		catch (IOException e)
		{
            System.out.println(e.getMessage());
      	}
		finally
		{
			fw.flush();
			fw.close();
        }
	}
}
