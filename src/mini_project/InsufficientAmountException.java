package mini_project;

public class InsufficientAmountException extends Exception
{
	double balance;
	InsufficientAmountException(double balance)
	{
		this.balance = balance;
	}
	@Override
	public String toString()
	{
		return "InsufficientAmountException [ your account balance is =" + balance + "Rs. and minimum balance required 1000 Rs.]";
	}

}
