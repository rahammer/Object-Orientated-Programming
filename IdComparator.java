// Assignment #: 8
//         Name: Robert Hammerschmidt
//    StudentID: 1207364973
//      Lecture: MWF 9AM-9:50AM
//  Arizona State University CSE205 Fall 2015

import java.util.*;
public class IdComparator implements Comparator<Food>
{

	public int compare(Food first, Food second)
	{
		return first.getId() - second.getId();
	}

}