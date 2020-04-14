package mini_project;

import java.util.Arrays;

public class AmountInvalidException extends Exception 
{
	String Message; 
	
	public AmountInvalidException(String flag)
	{		
		if(flag == "withdraw")
		{
			Message =  "AmountInvalidException [ Amount should be multiple of 100.]";
		}
		else if(flag == "deposite")
		{
			Message = "AmountInvalidException [ Amount should be greater than or equals to 25000 and  multiple of 100.]";
		}
	}

	@Override
	public String toString() {
		return Message;
	}
}
