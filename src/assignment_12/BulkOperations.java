package assignment_12;

import java.util.ArrayList;

public class BulkOperations {

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
        /*ar1.add(1);
        ar1.add(2);
        ar1.add(3);*/
        ar1.add(4);
        
        System.out.println("elements of ar1"+ar1);//[4, 41, 46, 48, 94, 100, 1, 2, 3]

        
        System.out.println("contains"+ar1.containsAll(ar));//true if ar is a subset of ar1
        
        System.out.println("retain"+ar1.retainAll(ar));//false transform ar into ar^ar1
        System.out.println(ar);//[4, 41, 46, 48, 94, 100]

        
        ar1.removeAll(ar);//transform ar1 into ar1-ar containg all elements which is not in ar
        System.out.println(ar1);//[1, 2, 3]

        
        ar1.clear();
        System.out.println(ar1);//[]
        
	}

}
