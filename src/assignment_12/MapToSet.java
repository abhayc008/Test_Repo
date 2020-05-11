package assignment_12;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapToSet {

	public static void main(String[] args) 
	{
		   Map<Integer,String> map = new HashMap<>();	
		   
		   
		   map.put(1, "Geeta");
		   map.put(2, "Laxmi");
		   map.put(3, "Kirti");
		   map.put(4, "Bhavana");
		   map.put(5,"Kunal");
		   
		   System.out.println(map);
		   System.out.println(map.keySet());
		   System.out.println(map.values());
		   
		   Set<Integer> set = new HashSet<>(map.keySet());
		   System.out.println(set);

	}

}
