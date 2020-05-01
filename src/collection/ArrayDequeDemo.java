package collection;

import java.util.ArrayDeque;

public class ArrayDequeDemo
{

	public static void main(String[] args) 
	{
		ArrayDeque <Integer> array = new ArrayDeque <>();
		
		array.offer(4);
		array.offer(41);
		array.offer(24);
		array.offer(43);
		array.offerFirst(9);
		array.offerLast(10);
		
		//array.offer(null);// null value not accepted
		
		System.out.println(array);
		
		array.pollFirst();
		
		System.out.println(array+ " ");

	}

}
