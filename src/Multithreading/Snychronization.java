package multithreading;

public class Snychronization {

	public static void main(String[] args)
	{
		Bank bank = new Bank();
		HusbandThread husbandthread = new HusbandThread(bank);
		WifeThread wifethread = new WifeThread(bank);
	}

}
