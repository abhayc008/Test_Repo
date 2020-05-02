package collection;

import java.util.ArrayList;
import java.util.Collections;

public class ComparableDemo  {

	public static void main(String[] args)
	{
		ArrayList<Mobile> list = new ArrayList<>();
		list.add(new Mobile(16 , "sumsung", 12000));
		list.add(new Mobile(6 , "redmi", 20000));
		list.add(new Mobile(16 , "sony", 15000));
		list.add(new Mobile(64 , "Iphone", 12000));
		list.add(new Mobile(56 , "Moto G", 16000));
		
		for(Mobile mob: list)
		{
			System.out.println(mob);
		}
		Collections.sort(list);
		System.out.println();
		for(Mobile mob: list)
		{
			System.out.println(mob);
		}
                        
	}


}
