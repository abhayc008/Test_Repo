package jdk8;
import java.time.LocalTime;

public class LocalTimeDemo {

	public static void main(String[] args) 
	{
		
		LocalTime localtime =  LocalTime.now();
		System.out.println(localtime);

		LocalTime localtime1 =  LocalTime.of(7, 35);
		System.out.println(localtime1);
		
		LocalTime localtime2 =  LocalTime.of(7, 35, 5, 9897);
		System.out.println(localtime2);
		
		LocalTime localtime3 =  LocalTime.of(7, 35, 9);
		System.out.println(localtime3);

	}

}
