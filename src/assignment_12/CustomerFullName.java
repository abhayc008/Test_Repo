package assignment_12;

import java.util.Comparator;

public class CustomerFullName implements Comparator<Customer>{

	@Override
	public int compare(Customer o1, Customer o2) 
	{
		String f1 = o1.getFirstName()+ " " +o1.getLastName();
		String f2 = o2.getFirstName() + " " + o2.getLastName();
		return f1.compareTo(f2);
		}

}
