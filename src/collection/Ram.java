package collection;

import java.util.Comparator;

public class Ram implements Comparator<Laptop>
{

	@Override
	public int compare(Laptop l1, Laptop l2) 
	{
		return l1.getRam()- l2.getRam();
	}

}
