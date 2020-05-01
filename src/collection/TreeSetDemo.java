package collection;

import java.util.TreeSet;

public class TreeSetDemo 
{
   public static void main(String args[])
   {
	   TreeSet tree = new TreeSet();
	   
	   tree.add(92);
	   tree.add(19);
	   tree.add(98);
	   tree.add(79);
	   tree.add(90);
	   
	   //tree.add(null);//not accepted throw NULLPOINTERException
	   System.out.println(tree+ " ");
	   
   }
}
