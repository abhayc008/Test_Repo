package mini_project;

import java.util.Arrays;

public class AmountInvalidException extends Exception 
{
	String message; 
	
	public AmountInvalidException(String amt)
	{		
		if(amt == "withdraw")
		{
		message =  "AmountInvalidException [ Withdraw amount should be multiple of 100.]";
		}
		else if(amt == "deposite")
		{
			message = "AmountInvalidException [ Deposite amount should not be greater than 25000]";
		}
		else if(amt == "change")
		{
			message = "AmountInvalidException [ Deoposite amount should be multiple of 100.]";
		}
	}

	@Override
	public String toString() {
		return message;
	}
}
