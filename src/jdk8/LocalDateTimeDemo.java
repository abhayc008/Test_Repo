package jdk8;

import java.time.LocalDateTime;

public class LocalDateTimeDemo {

	public static void main(String[] args) 
	{
		LocalDateTime localdatetime =  LocalDateTime.now();
		System.out.println(localdatetime);

		LocalDateTime localdatetime1 =  LocalDateTime.of(2020, 04, 14, 12, 49);
		System.out.println(localdatetime1);
		
	}

}
