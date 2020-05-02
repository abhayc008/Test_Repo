package collection;

import java.util.ArrayList;
import java.util.Vector;

public class ConvertIntoOtherClass {

	public static void main(String[] args)
	{
		ArrayList <Integer> ar = new ArrayList<>();
		
		ar.add(4);
		ar.add(41);
		ar.add(46);
		ar.add(48);
		ar.add(94);
		ar.add(100);
		
		Vector vector = new Vector(ar);
		System.out.println(vector);
	}
}
