package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareToDemo {

	public static void main(String[] args)
	{
		ArrayList<Laptop> list = new ArrayList<>();
		list.add(new Laptop(16 , "Hp", 32000));
		list.add(new Laptop(6 , "Lenovo", 20000));
		list.add(new Laptop(16 , "Sony", 15000));
		list.add(new Laptop(64 , "Dell", 70000));
		list.add(new Laptop(56 , "Mac", 80000));
		
		for(Laptop lap: list)
		{
			System.out.println(lap);
		}
		
	    System.out.println("Sorting using reference--");

	    Collections.sort(list, new Ram());//on the basis of ram
		//Collections.sort(list, new Brand());
	    System.out.println();
	    System.out.println();
	    
	    for(Laptop lap: list)
		{
			System.out.println(lap);
		}
		System.out.println("Using anonymous class--");
	    //Using Anonymous class
		
		Comparator com = new Comparator<Laptop>()
		{
			@Override
			public int compare(Laptop o1, Laptop o2)
			{
				return o1.getRam()-o2.getRam();
			}
	    	
			
		};
		Collections.sort(list, com);
		/*
		Collections.sort(list,  new Comparator<Laptop>()
	    {

			@Override
			public int compare(Laptop o1, Laptop o2)
			{
				return o1.getRam()-o2.getRam();
			}
	    	
	    });
        */
	    for(Laptop lap: list)
		{
			System.out.println(lap);
		}
	   
	   
	    System.out.println("---------Anonymous---"); 
	    Comparator<Laptop> com1 = (Laptop o1, Laptop o2) -> (int)(o1.getPrice() - o2.getPrice());
	    Collections.sort(list, com1);
	    
	    for(Laptop lap: list)
	  		{
	  			System.out.println(lap);
	  		}
	  //Using Lambda Expression
	    Collections.sort(list, (Laptop o1, Laptop o2) -> o1.getBrand().compareTo(o2.getBrand()));
		System.out.println("Using lambda-------");

	    for(Laptop lap: list)
  		{
  			System.out.println(lap);
  		}
	}

}
