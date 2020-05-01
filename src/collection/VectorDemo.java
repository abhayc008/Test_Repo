package collection;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class VectorDemo {

	public static void main(String[] args)
	{
	   Vector <String> vector = new Vector<>(); 
	   vector.addElement("Bharati");
	   vector.addElement("Priyanka");
	   vector.addElement("Geeta");
	   vector.addElement("Kirti");
	   vector.addElement("Nayan");
	   vector.addElement("Nayan");
	   
	   vector.addElement(null);//any nos of null values accepted 
	   vector.addElement(null);
	   
	   Enumeration <String> em = vector.elements();
	   
	   System.out.println("Using Enumeration:");
	   while(em.hasMoreElements())
	   {
		   System.out.print(em.nextElement()+ " ");
	   }
	   
	   Iterator <String> i = vector.iterator();
	   
	   System.out.println("Using Iterator:");
	   while(i.hasNext())
	   {
		   System.out.print(i.next()+ " ");
	   }
	   
	}

}
