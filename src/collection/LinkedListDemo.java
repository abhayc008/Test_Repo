package collection;

import java.awt.List;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Iterator;


public class LinkedListDemo {

	public static void main(String[] args) 
	{
		LinkedList <Integer> list = new LinkedList<>();
		
		list.add(2);
		list.add(67);
		list.add(67);
		list.add(2);
		list.add(2);
		list.addFirst(8);
		list.addLast(11);
		
		list.add(null);// No NULL value accpeted  it throws runtime exception java.lang.NullPointerException
		//list.add(null);
		
		//Collections.sort(list);
		
		Iterator <Integer> i = list.iterator();
        
		for(Integer obj: list)
		{
			System.out.print(obj+ " ");
		}
		
		System.out.println();
		
		while(i.hasNext())
		{
		   System.out.print(i.next()+ " ");
		}
		
		System.out.println();
		
		ListIterator <Integer> obj1 = list.listIterator();
		while(obj1.hasNext())
		{
			obj1.next();
		}
		while(obj1.hasPrevious())
		{
			System.out.print(obj1.previous() + " ");
		}
	}

}
