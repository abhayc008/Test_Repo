package assignment_12;

import java.util.Comparator;

public class AccountIdComparator implements Comparator<Customer> {

	@Override
	public int compare(Customer o1, Customer o2)
	{
		return  o1.getAccount().accountId - o2.getAccount().accountId;
	}

}
