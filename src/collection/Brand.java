package collection;

import java.util.Comparator;

public class Brand implements Comparator<Laptop>
{

	@Override
	public int compare(Laptop o1, Laptop o2) 
	{
		return o1.getBrand().compareTo(o2.getBrand());
	}

}
