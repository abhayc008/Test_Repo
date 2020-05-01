package collection;

import java.awt.List;
import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args)
	{
		ArrayList list = new ArrayList();//upcasting
		
		System.out.println(list.isEmpty());
		
		list.add(67);
		list.add('a');
		list.add("geeta");
		list.add(90.0);
		list.add(7.0f);
		list.add(67);
		list.add(67);
		
		list.add(2);
		list.add(2);
		
		list.remove(2);
		list.remove(new Integer(2));
		list.remove(new Integer(2));
		
		list.remove(new Integer(67));
        
		list.add(null);//any nos of null accepted
		list.add(null);
		
		System.out.println(list.isEmpty());
		System.out.println(list);
		System.out.println(list.size());
		
		
		//Using for loop
		for(int i=0; i<list.size(); i++)
		{
			System.out.print(" "+list.get(i));
		}
		System.out.println();

		//Using for each loop
		
		for(Object a: list)
		{
			System.out.print(" "+a);
		}
			

	}

}
