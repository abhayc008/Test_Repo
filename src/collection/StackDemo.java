package collection;

import java.util.Stack;

public class StackDemo {

	public static void main(String[] args) 
	{
		Stack <Integer> stack = new Stack<>();
		
		stack.push(5);
		stack.push(15);
		stack.push(52);
		stack.push(25);
		stack.push(50);
		
		stack.push(null);//any nos of null values accepted
		stack.push(null);
		
		stack.pop();//remove the top most value
		System.out.println(stack.peek());//return you the top most value
		System.out.println(stack+ " ");

	}

}
