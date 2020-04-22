package serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serialization implements Serializable
  
{

    private int data;

	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		Serialization serialization = new Serialization();
		serialization.data =10;
		FileOutputStream fos = new FileOutputStream("seralize.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(serialization); //for serialization of data
		
		FileInputStream fis = new FileInputStream("seralize.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Serialization ser = (Serialization)ois.readObject(); 
		System.out.println(ser.data);//for deserialization of data
	}

}