package wrapper_class;

public class Wrapper 
{

	public static void main(String[] args)
	{
		int no = 10;
		
		Integer integer = new Integer(no);//Boxing- pre to obj
		
		Integer integer1 = no;//AutoBoxing
		
		int no1 = integer1.intValue();//Unboxing
		
		int no2 = integer1;//Auto-Unboxing
		
		System.out.println(+no+" "+integer+ "  "+integer1+" "+no1+" "+no2);

	}

}
