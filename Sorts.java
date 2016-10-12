// Assignment #: 8
//         Name: Robert Hammerschmidt
//    StudentID: 1207364973
//      Lecture: MWF 9AM-9:50AM
//  Arizona State University CSE205 Fall 2015

import java.util.ArrayList;
import java.io.*;
import java.util.Comparator;

public class Sorts
{

	public static void sort(ArrayList<Food> foodList, Comparator<Food> xComparator)
	{
		int min;	//smallest number's index
		Food temp;

		for (int index = 0; index < foodList.size()-1; index++)
		{
			min = index;
		    for (int scan = index+1; scan < foodList.size(); scan++)
		    {
					//compare the two objects at index "scan" and "min" by using the xComparator
    	    		if ( xComparator.compare(foodList.get(scan), foodList.get(min)) < 0 )
    	           			min = scan;
		    }

		    // Swap the two objects
		    temp = foodList.get(min);
		    foodList.set(min, foodList.get(index));
		    foodList.set(index, temp);
		}
	}
}