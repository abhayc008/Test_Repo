package mini_project;

import java.util.Arrays;

public class IncorrectPinException extends Exception {

	@Override
	public String getMessage() 
	{
		return "IncorrectPinException [ Incorrect pin please try Again!!!]";
	}

	/*@Override
	public String toString() {
		return "IncorrectPinException [ Incorrect pin please try Again!!!]";
	}*/

}
