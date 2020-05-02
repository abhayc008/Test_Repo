package collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

	public static void main(String[] args)
	{
		HashMap<Integer, String> hashMap = new HashMap<>();
		
		hashMap.put(1, "Kirti");//key & value = entry
		hashMap.put(2,"Bhavana");
		hashMap.put(3,"Geeta");
		hashMap.put(4,"Somesh");	
		hashMap.put(5,"Prabhat");
		hashMap.put(6,"Geeta");

		
		System.out.println(hashMap);
		System.out.println(hashMap.keySet());
		System.out.println(hashMap.values());
		
		for(Map.Entry<Integer, String> hash: hashMap.entrySet())
		{
			System.out.print(hash);
			System.out.println(hash.getKey()+ " "+hash.getValue());
		}

	}

}
