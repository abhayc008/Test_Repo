package string_demo;

public class Rhyme {

	public static void main(String[] args)
	{
		String str = "I got the job Then  I saw the pot in window He love me a lot . Forget me not ";
		String [] str1 = str.split(" ");
        
		for(String item: str1)
		{
			if(item.endsWith("ot"))
			{
				System.out.print(item+" ");
			}
		}
	}

}
