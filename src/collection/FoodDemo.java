package collection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FoodDemo 
{
    public static void main(String args[]) throws IOException
    {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Food> foods = new ArrayList<>();
		FoodOperations fo = new FoodOperations();
		int choice;
        while(true)
        {
        	System.out.println("Main menu:");
        	System.out.println("-----------------------------");
    		System.out.println("1.Add Food");
    		System.out.println("2.Update Food");
    		System.out.println("3.Delete Food");
    		System.out.println("4.Search Food");
    		System.out.println("5.Show all Food");
    		System.out.println("6.Exit");
    		System.out.println("-----------------------------");
        	System.out.println("Enter your choice");
        	System.out.println("-----------------------------");
            choice = scanner.nextInt();
            switch(choice)
            {
            case 1:
            	Food food= fo.addFood();
            	foods.add(food);
            	System.out.println(food.foodId+"  "+food.foodName+ " " + food.foodCategory+" "+food.foodType+" "+food.foodPrice);
    		System.out.println("Data added Successfully !!!");
    		System.out.println("-----------------------------");
            	break;
            case 2:
            	fo.updateFood(foods);
            	System.out.println("-----------------------------");
            	System.out.println("Successfully Updated !!!");
            	System.out.println("-----------------------------");
            	break;
            case 3:
            	fo.deleteFood(foods);
            	System.out.println("-----------------------------");
    		System.out.println("Deleted Successfully !!!");
    		System.out.println("-----------------------------");
            	break;
            case 4:
            	fo.searchFood(foods);
            	System.out.println("-----------------------------");
        	System.out.println("Search Successfully !!!");
        	System.out.println("-----------------------------");
            	break;
            case 5:
             	fo.showAllFood(foods);
             	System.out.println("-----------------------------");
            	break;
            case 6:
            	System.exit(0);
            default:
            	System.out.println("Enter a valid choice !!!");
            }
        }
    }
}
    
