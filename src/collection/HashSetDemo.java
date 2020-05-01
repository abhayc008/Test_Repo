package collection;

import java.util.HashSet;

public class HashSetDemo {

	public static void main(String[] args)
	{
		HashSet <Integer> hashset = new HashSet<>();
		
		hashset.add(7);
		hashset.add(17);
		hashset.add(71);
		hashset.add(27);
		hashset.add(70);
		hashset.add(70);
		hashset.add(null);// Single null accepted here and if entered 2 null values then only one null value entered
		hashset.add(null);
		
		System.out.println(hashset+ " ");
		

	}

}
