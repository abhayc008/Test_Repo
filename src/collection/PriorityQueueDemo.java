package collection;

import java.util.PriorityQueue;

public class PriorityQueueDemo 
{

	public static void main(String[] args) 
	{
		PriorityQueue <Integer> queue = new PriorityQueue<>();
		
		queue.add(5);
		queue.add(1);
		queue.add(7);
		queue.add(6);
		queue.add(9);
		queue.add(2);
		
		System.out.print(queue+ " ");
		
		queue.offer(5);
		queue.offer(1);
		queue.offer(7);
		queue.offer(6);
		queue.offer(9);
		queue.offer(2);
		queue.offer(10);
		
		//queue.offer(null);//No null value accepted here
		
		System.out.println(queue.peek()+ " ");
		
		System.out.println();

		System.out.println(queue+ " ");
		
		queue.poll();//remove the value from highest priority
		
		System.out.println(queue);
		
		queue.poll();
		
		System.out.println(queue);

	}

}
