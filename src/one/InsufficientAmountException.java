package mini_project;

public class InsufficientAmountException extends Exception
{
	double balance;
	InsufficientAmountException(double balanace)
	{
		this.balance = balance;
	}
	@Override
	public String toString()
	{
		return "InsufficientFundsException  [ your account balance is =" + balance + "]";
	}

}
