// Assignment #: 8
//         Name: Robert Hammerschmidt
//    StudentID: 1207364973
//      Lecture: MWF 9AM-9:50AM
//  Arizona State University CSE205 Fall 2015

import java.util.Comparator;
public class CategAndNameComparator implements Comparator<Food>
{
	public int compare(Food first, Food second)
	{
        String category1 = ((Food)first).getCategory(); //Food 1's category
        String category2 = ((Food)second).getCategory(); //Food 2's category

        String Name1 = ((Food)first).getName(); //Food 1's name
        String Name2 = ((Food)second).getName(); //Food 2's name

        if ( category1.equals(category2) )
        	return Name1.compareTo(Name2);
        else
        	return category1.compareTo(category2);
	}
}