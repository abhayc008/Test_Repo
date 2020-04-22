package jdk8;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

public class LocalDateDemo {

	public static void main(String[] args) 
	{
		Date date = new Date();
		System.out.println(date);
		
		LocalDate localdate =  LocalDate.now();
		System.out.println(localdate);

		LocalDate localdate1 =  LocalDate.of(2020, Month.APRIL,04 );
		System.out.println(localdate1);
		
		LocalDate localdate2 =  LocalDate.of(2020, 5, 04);
		System.out.println(localdate2);

	}

}
