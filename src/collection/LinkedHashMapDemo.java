package collection;

import java.util.LinkedHashMap;
import java.util.Map;

//follow insertion order

public class LinkedHashMapDemo {

	public static void main(String[] args) 
	{
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
		
        map.put(1, "Kirti");//key & value = entry
        map.put(5,"Bhavana");
        map.put(6,"Geeta");
        map.put(2,"Somesh");	
        map.put(4,"Prabhat");
        map.put(3,"Geeta");
        map.put(null, "somesh");//only one null  allowed
        map.put(null, "somesh");
		
		System.out.println(map);
		
		System.out.println(map.keySet());
		System.out.println(map.values());
		
		for(Map.Entry<Integer, String> hash: map.entrySet())
		{
			System.out.print(hash);
			System.out.println(hash.getKey()+ " "+hash.getValue());
		}


	}

}
