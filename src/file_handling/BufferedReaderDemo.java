package file_handling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderDemo
{

	public static void main(String[] args) throws IOException 
	{
		//String no;
		String name, name1;
		InputStreamReader isr = new InputStreamReader(System.in);
		
		BufferedReader br = new BufferedReader(isr);
		/*
		System.out.println("Enter a no");
		no = br.readLine();
		System.out.println(no);
		*/
		
		System.out.println("Enter a  two names");
		name = br.readLine();
		name1 = br.readLine();
		System.out.println(name);
		System.out.println(name1);
	}

}
