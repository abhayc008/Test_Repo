package file_handling;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintWriterClass
{

	public static void main(String[] args) throws FileNotFoundException 
	{
		PrintWriter pw = new PrintWriter("print.txt");
		pw.write("Hello abhay !!!");
		pw.flush();
		PrintWriter pw1 = new PrintWriter(System.out);
		pw1.print("Hii all !!!");
		pw1.flush();

	}

}
