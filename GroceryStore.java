// Assignment #: 8
//         Name: Robert Hammerschmidt
//    StudentID: 1207364973
//      Lecture: MWF 9AM-9:50AM
//  Arizona State University CSE205 Fall 2015

import java.util.ArrayList;
import java.io.*;
public class GroceryStore implements Serializable
{
	private ArrayList<Food> foodList;

	public GroceryStore()
	{
		 foodList = new ArrayList();
	}
	public int idExists(int foodId)
	{
		for(int index = 0; index < foodList.size(); index++)
		{
			if(foodList.get(index).getId() == foodId)
				return foodList.get(index).getId();
		}
			return -1;
	}
	public int categAndNameExists(String nCategory, String nName)
	{
		for(int index = 0; index < foodList.size(); index++)
		{
			if(foodList.get(index).getName().equals(nName) && foodList.get(index).getCategory().equals(nCategory))
				return index;
		}
			return -1;
	}
	public boolean addFoodById(String category, String name, int id)
	{
		for(int index = 0; index < foodList.size(); index++)
		{
			if(foodList.get(index).getId() == id)
				return false;
		}
		Food nextFood = new Food(category, name, id);
		foodList.add(nextFood);
		return true;
	}
	public boolean removeById(int id)
	{
		for(int index = 0; index < foodList.size(); index++)
		{
			if(foodList.get(index).getId() == id)
			{
				foodList.remove(index);
				return true;
			}
		}
			return false;

	}
	public boolean removeByCategAndName(String category, String name)
	{
		for(int index = 0; index < foodList.size(); index++)
		{
			if(foodList.get(index).getName().equals(name) && foodList.get(index).getCategory().equals(category))
			{
				foodList.remove(index);
				return true;
			}
		}
			return false;
	}
	public void sortByCategAndName()
	{
		CategAndNameComparator CategAndNameComp = new CategAndNameComparator();
		Sorts.sort(foodList, CategAndNameComp);
	}
	public void sortById()
	{
		IdComparator IdComp = new IdComparator();
		Sorts.sort(foodList, IdComp);
	}
	public String listFood()
	{
		String allFood = "";
		String[] allTheFood = new String[foodList.size()];
		if(foodList.size() > 0)
		{
			for (int index = 0; index < foodList.size(); index++)
			{
				allTheFood[index] = foodList.get(index).toString();
				allFood += allTheFood[index];
			}

			return allFood;
		}
			return "no food";
	}
	public void closeGroceryStore()
	{
		foodList.clear();
	}


}