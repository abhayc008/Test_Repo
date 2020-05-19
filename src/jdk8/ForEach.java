package jdk8;

import java.util.ArrayList;
import java.util.function.Consumer;

public class ForEach implements Consumer<Integer>{

	public static void main(String[] args) 
	{
		Consumer<Integer> con = new ForEach();
		ArrayList <Integer> ar = new ArrayList<Integer>();
		
		ar.add(6);
		ar.add(7);
		ar.add(9);
		ar.add(10);
		ar.add(4);
		
		ar.forEach(con);
		//ar.forEach(i -> System.out.println(i));
		
		
	}

	@Override
	public void accept(Integer t) {
		System.out.println(t);
		
	}

}
