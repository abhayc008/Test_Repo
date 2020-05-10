package assignment_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class CollectionOfWords
{
	public static void main(String args[]) throws IOException 
	{
		
		  Map<String, String> words = new HashMap<>();
		  
		  InputStreamReader isr = new InputStreamReader(System.in);
		  BufferedReader br = new BufferedReader(isr);
	
			while(true)
			{
				
					Scanner scanner=new Scanner(System.in);		
					int choice;
				      System.out.println();
					  System.out.println("--------Welcome----------");
					  System.out.println("-----------Menu---------------");
					  System.out.println("1.Adding new Word");
					  System.out.println("2.Updating meaning of existing word");
					  System.out.println("3.Deleting existing word");
					  System.out.println("4.Searching meaning of particular word");
					  System.out.println("5. Displaying all words");
					  System.out.println("6.Sorting the words in ascending order");
					  System.out.println("7.Exit");
					  System.out.println("-------------------------------");
					  System.out.println("Enter your choice");

					  System.out.println();
					  choice=scanner.nextInt();
					  switch(choice)
					  {
					  case 1:
						  String word, meaning;
				          System.out.println("Enter new word");
				          word = br.readLine();
				          System.out.println("Enter the meaning of word");
				          meaning = br.readLine();
				          words.put(word, meaning);
						  break;
					  case 2:
						  String find, newMeaning;
				          System.out.println("Enter existing word");
				          find = br.readLine();
				          
				          Iterator<Entry<String, String>> it = words.entrySet().iterator();
				          while(it.hasNext()) 
				          {
				        	 Entry<String, String> fd = it.next();
				        	 if(fd.getKey().equalsIgnoreCase(find)) 
						       {
						         System.out.println("Enter the meaning of word");
						         newMeaning = br.readLine();
						         fd.setValue(newMeaning);
						         System.out.println("Successfully Updated!!!");
						       }
				          }
				         break;
					  case 3:
						  String delete;
				          System.out.println("Enter existing word");
				          delete = br.readLine();
				          
				          Iterator<Entry<String, String>> de = words.entrySet().iterator();
				          while(de.hasNext()) 
				          {
				        	 Entry<String, String> del = de.next();
				        	 
				        	 if(del.getValue().equalsIgnoreCase(delete)) 
						       {
				        		 words.remove(del.getKey());
							     System.out.println("Deleted successfully!!!");
							   }  
						    }
					      break;
					  case 4:
						  String search;
				          System.out.println("Enter existing word");
				          search = br.readLine();
				          
				          Iterator<Entry<String, String>> se = words.entrySet().iterator();
				          while(se.hasNext()) 
				          {
				        	 Entry<String, String> sea = se.next();
				        	 
				        	 if(sea.getValue().equalsIgnoreCase(search)) 
						       {
				        		 System.out.println(sea.getKey()+ " : "+sea.getValue());
				        		 System.out.println("Search successfully!!!");
							     
						       }
				          }
		                   	
		                   break;
                      case 5:
                    	  Iterator<Entry<String, String>> sh = words.entrySet().iterator();
                    	  System.out.println("All data is ........");
				          while(sh.hasNext()) 
				          {
				        	 Entry<String, String> show = sh.next();
				        	 System.out.println(show.getKey()+ ": "+show.getValue());
				          }
						  break;
					  case 6:
				          Iterator<Entry<String, String>> st = words.entrySet().iterator();
				          while(st.hasNext()) 
				          {
				        	 Entry<String, String> sort = st.next();
				        	 //sort.getKey().
  				          }
					      break;
					  case 7:
						  System.out.println("Thank you !!!");
						  System.out.println("----------------------------");
						  System.exit(0);
					  default:
						  System.out.println("Please enter valid choice !!!");
					  }			  
			     } 
		   }
		
	}