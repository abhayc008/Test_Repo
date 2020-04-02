package nested_class;

class Outer3
{
		interface A
	{
		void trial();
	}
}

public class Extra implements Outer3.A 
{
	@Override
	public void trial() 
	{
		System.out.println("Trial");
	}
    public static void main(String args[]) 
    {
    	Extra extra=new Extra();
    	extra.trial();
    }
	
}
