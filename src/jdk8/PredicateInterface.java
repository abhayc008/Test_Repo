package jdk8;

import java.util.function.Predicate;

public class PredicateInterface implements Predicate<Integer> {

	public static void main(String[] args)
	{
		Predicate<Integer> per = new PredicateInterface();
		System.out.println(per.test(3));

	}

	@Override
	public boolean test(Integer t) {
		if(t>5)
			return true;
		else
		    return false;
	}

}
