package jdk8;

import java.util.StringJoiner;

public class StringJoinerDemo {

	public static void main(String[] args)
	{
		StringJoiner stringjoiner = new StringJoiner("@","[","]");
		stringjoiner.add("Geeta");
		stringjoiner.add("Laxmi");
		stringjoiner.add("Kirti");
		
		System.out.println(stringjoiner);
		
		StringJoiner stringjoiner1 = new StringJoiner("||","(",")");
		stringjoiner1.add("Geeta");
		stringjoiner1.add("Laxmi");
		stringjoiner1.add("Kirti");
		
		System.out.println(stringjoiner1);

		StringJoiner stringjoiner3 = stringjoiner.merge(stringjoiner1);
		
		System.out.println(stringjoiner3);
		
		stringjoiner.setEmptyValue("Empty!!!!");
		
		System.out.println(" ======="+stringjoiner);


	}

}
