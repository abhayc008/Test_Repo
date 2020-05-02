package collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class FoodOperations
{
      Scanner scanner = new Scanner(System.in);
      
      InputStreamReader isr = new InputStreamReader(System.in);
		
      BufferedReader br = new BufferedReader(isr);

  public Food addFood() throws IOException
  {
	       Food food = new Food();
	       System.out.println("Add Food");
	    
	       System.out.println("Enter a  FoodId: ");
               food.foodId= scanner.nextInt();
		
               System.out.println("Enter a name of Food: ");
               food.foodName =  br.readLine();
		
		System.out.println("Enter foodType: ");
		food.foodType =  br.readLine();;
		
		System.out.println("Enter Food Category: ");
		food.foodCategory=  br.readLine();

		System.out.println("Enter Food price: ");
		food.foodPrice= scanner.nextInt();
		
		return food;
				
  }

public void updateFood(List<Food> foods) throws IOException  
  {
	  System.out.println("Update:");
	  System.out.println("Enter the foodId:");
	  int id = scanner.nextInt();
	
	  for (int i=0; i<foods.size() ; i++)
	  {
		  
		  if(foods.get(i).foodId == id)
		  {
			    
			    System.out.println("Enter a name of Food: ");
				foods.get(i).foodName =  br.readLine();
			
				System.out.println("Enter foodType: ");
				foods.get(i).foodType =  br.readLine();
				
				System.out.println("Enter Food Category: ");
				foods.get(i).foodCategory=  br.readLine();
				
				System.out.println("Enter Food Price: ");
				foods.get(i).foodPrice = scanner.nextInt();
					
		  }
		  else
		  {
				System.out.println("Food id does not exist.. ");
		  }
	  }
	  
  }
  
  public void showAllFood(List<Food> foods)  
  {
	  System.out.println("Output of the food list: " );
	  for(Food i : foods)
		{
			System.out.println(i.foodId+"  "+i.foodName+ " " + i.foodCategory+" "+i.foodType+" "+i.foodPrice);
		}
	  
  }

public void searchFood(List<Food> foods) 
{
	  System.out.println("Search:");
	  System.out.println("Enter the foodId:");
	  int id = scanner.nextInt();
	  /*
	  for(Food i : foods)
	  {
		if(i.foodId == id)
		{
			System.out.println(i.foodId+"  "+i.foodName+ " " + i.foodCategory+" "+i.foodType+" "+i.foodPrice);
		}
	  }*/
	  
	  for (int i=0; i<foods.size() ; i++)
	  {
		  
		  if(foods.get(i).foodId == id)
		  {
			  System.out.println(foods.get(i).foodId+"  "+foods.get(i).foodName+ " " + foods.get(i).foodCategory+" "+foods.get(i).foodType+" "+foods.get(i).foodPrice);
		  }
	  }
	  System.out.println();
	  
}

public void deleteFood(List<Food> foods)
{
 	  System.out.println("Delete:");
	  System.out.println("Enter the foodId:");
	  int id = scanner.nextInt();
	  
	  /*
	  for(Food i : foods)
	  {
		if(i.foodId == id)
		{
			foods.remove(i);
			System.out.println(i.foodId+"  "+i.foodName+ " " + i.foodCategory+" "+i.foodType+" "+i.foodPrice);
		}
	  }*/
	  
	  for (int i=0; i<foods.size() ; i++)
	  {
		  
		  if(foods.get(i).foodId == id)
		  {
			  foods.remove(i);
		  }
	  }
	
}
 
}
