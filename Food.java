// Assignment #: 8
//         Name: Robert Hammerschmidt
//    StudentID: 1207364973
//      Lecture: MWF 9AM-9:50AM
//  Arizona State University CSE205 Fall 2015
//  Description: The class defines a Food

import java.io.*;
public class Food implements Serializable
{
    private String category;
    private String name;
    private int id;

    //constructor
    public Food(String nCategory, String nName, int nId)
    {
		category = nCategory;
        name = nName;
        id = nId;
    }

    //accessors & mutators
    public String getCategory()
    {
        return category;
    }

    public void setCategory(String nCategory)
    {
		category = nCategory;
    }

    public String getName()
    {
		 return name;
    }

    public void setName(String nName)
    {
		name = nName;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int nId)
    {
		id = nId;
    }

    public String toString()
    {
        return "Category: " + category + "\t\tName: " + name + "\t\tID: " + id + "\n";
    }
}
