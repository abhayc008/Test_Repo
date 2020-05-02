package collection;

import java.util.ArrayList;

public class Bulk {

	public static void main(String[] args)
	{
        ArrayList <Integer> ar = new ArrayList<>();
		
		ar.add(4);
		ar.add(41);
		ar.add(46);
		ar.add(48);
		ar.add(94);
		ar.add(100);
		
        ArrayList <Integer> ar1 = new ArrayList<>();
        ar1.addAll(ar);
        System.out.println(ar1);
        
        System.out.println(ar1.containsAll(ar));
        
        ar1.removeAll(ar);
        System.out.println(ar1);
        
        ar1.clear();
        System.out.println(ar1);
        
		
		

	}

}
