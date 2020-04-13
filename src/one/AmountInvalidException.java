package mini_project;

import java.util.Arrays;

public class AmountInvalidException extends Exception 
{

	@Override
	public String toString() {
		return "AmountInvalidException [ Amount should be multiple of 100.]";
	}
}
