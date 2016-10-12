// Assignment #: 8
//         Name: Robert Hammerschmidt
//    StudentID: 1207364973
//      Lecture: MWF 9AM-9:50AM
//  Arizona State University CSE205 Fall 2015
//  Description: The Assignment 8 class displays a menu of choices to a user
//               and performs the chosen task. It will keep asking a user to
//               enter the next choice until the choice of 'Q' (Quit) is
//               entered.

import java.io.*;
import java.util.*;

public class Assignment8
 {
  public static void main (String[] args)
   {
     char input1;
     String category, name, idStr;
     int id;
     boolean operation = false;
     int operation2 = 0;
     String line;
     String filename;

     // create a GroceryStore object. This is used throughout this class.
     GroceryStore store1 = new GroceryStore();

     try
      {
       // print out the menu
       printMenu();

       // create a BufferedReader object to read input from a keyboard
       InputStreamReader isr = new InputStreamReader (System.in);
       BufferedReader stdin = new BufferedReader (isr);

       do
        {
         System.out.print("What action would you like to perform?\n");
         line = stdin.readLine().trim();  //read a line
         input1 = line.charAt(0);
         input1 = Character.toUpperCase(input1);

         if (line.length() == 1)          //check if a user entered only one character
          {
           switch (input1)
            {
             case 'A':   //Add Food
               try
                {
                 System.out.print("Please enter the food category to add:\n");
                 category = stdin.readLine().trim();
                 System.out.print("Please enter the food's name to add:\n");
                 name = stdin.readLine().trim();
                 System.out.print("Please enter the food ID to add:\n");
                 idStr = stdin.readLine().trim();
                 id = Integer.parseInt(idStr);

                 operation = store1.addFoodById(category, name, id);
                 if (operation == true)
                  System.out.print("Food added\n");
                 else
                  System.out.print("Food exists\n");
                }
/************************************************************************************
***  Complete the follwing catch statement, if exception is caught, show
"Food Id is not entered as integer. Food not added\n" on screen
***********************************************************************************/
               catch( NumberFormatException  exception )
                {
					System.out.println("Food Id is not entered as integer. Food not added");
                }
               break;
             case 'D':  //Search by Food ID
              try
               {
                 System.out.print("Please enter a food id to search:\n");
                 idStr = stdin.readLine().trim();
                 id = Integer.parseInt(idStr);
                 operation2=store1.idExists(id);

                 if (operation2 > -1)
                   System.out.print("Food found\n");
                 else
                   System.out.print("Food not found\n");
                }
/************************************************************************************
***  Complete the follwing catch statement, if exception is caught, show
"Food Id is not entered as integer. Food not added\n" on screen
***********************************************************************************/
               catch( NumberFormatException exception )
                {
					System.out.println("Food Id is not entered as integer.  Food not added\n");
                }
               break;
             case 'C':  //Search by Category and Name
                System.out.print("Please enter a food category to search:\n");
                category = stdin.readLine().trim();
                System.out.print("Please enter a food name to search:\n");
                name = stdin.readLine().trim();
                operation2=store1.categAndNameExists(category, name);

                if (operation2 > -1)
                    System.out.print("category and name found\n");
                else
                    System.out.print("category and name not found\n");
                break;
             case 'L':   //List all foods
               System.out.print(store1.listFood());
               break;
             case 'O':  // Sort by food ID
               store1.sortById();
               System.out.print("sorted by id\n");
               break;
             case 'P':  // Sort by categories and names
               store1.sortByCategAndName();
               System.out.print("sorted by categories and names\n");
               break;
             case 'Q':   //Quit
               break;
             case 'R':  //Remove by ID
              try
               {
                 System.out.print("Please enter a food ID to remove:\n");
                 idStr = stdin.readLine().trim();
                 id = Integer.parseInt(idStr);
                 operation=store1.removeById(id);

                 if (operation == true)
                    System.out.print("ID removed\n");
                 else
                    System.out.print("ID not found\n");
                }
/************************************************************************************
***  Complete the follwing catch statement
***********************************************************************************/
               catch( NumberFormatException exception  )
                {
					System.out.println("The number entered is not an integer");
                }
               break;
                case 'S':  //Remove by category and name
                    System.out.print("Please enter a category to remove:\n");
                    category = stdin.readLine().trim();
                    System.out.print("Please enter a name to remove:\n");
                    name = stdin.readLine().trim();
                    operation=store1.removeByCategAndName(category, name);

                    if (operation == true)
                        System.out.print("category and name removed\n");
                    else
                        System.out.print("category and name not found\n");
                    break;
             case 'T':  //Close GroceryStore
               store1.closeGroceryStore();
               System.out.print("Grocery store closed\n");
               break;
             case 'U':  //Write Text to a File
               System.out.print("Please enter a file name to write:\n");
               filename = stdin.readLine().trim();
/************************************************************************************
***  ADD your code to write a text (string) to the specified file, if any exceptions
     are thrown, catch it with showing message "Text file written exception\n" on screen.
************************************************************************************/
    System.out.print("Please enter a string to write in the file:\n");
    String inputStr = stdin.readLine().trim();
    try
    {
		File outputFile = new File("theOutputThatWorks.txt");
	    if(outputFile.exists())
	    {
			 System.out.println("File already exists");
			 System.exit(0);
	 	}
	    PrintWriter output = new PrintWriter(outputFile);
	    output.println(inputStr);
	    output.close();

    }
    catch(IOException exception)
    {
		System.out.println("IOexception was found");
    }
      break;
     case 'V':  //Read Text from a File
               System.out.print("Please enter a file name to read:\n");
               filename = stdin.readLine().trim();
/******************************************************************************************
***  ADD your code to read a text (string) from the specified file, if file not found
     and any exceptions are thrown, catch it with showing message "filename + "was not
     found\n" on screen.
******************************************************************************************/
      File theFile = null;
      try
      {
		theFile = new File("theInputThatWorks.txt");
		Scanner input = new Scanner(theFile);
		input.close();
      }
      catch (FileNotFoundException exception)
      {
		System.out.println("filename " + theFile.getPath() + "was not found\n");
      }

               break;
      case 'W':  //Serialize GroceryStore to a File
               System.out.print("Please enter a file name to write:\n");
               filename = stdin.readLine().trim();
/********************************************************************************************
***  ADD your code to write the grocery store object to the specified file, if any exceptions
     are thrown, catch them by showing "Data file written exception" message on screen.
*********************************************************************************************/
      try
      {
		  File file = new File(filename);

		  //check whether the file's name already exists in the current directory
		  if(file.exists())
		  {
		  		System.out.println("File already exists");
		  	 	System.exit(0);
		  }

		  //(1)create an output stream to the file
		  FileOutputStream fos = new FileOutputStream(file);

		 //(2)create an ObjectOutputStream for fos
		 ObjectOutputStream output = new ObjectOutputStream(fos);

		 //Write the object myCar to the file
		 output.writeObject(store1);

		 //once finishing writing, close the file
		 output.close();
       }
       catch (NotSerializableException exception)
       {
			System.out.println("Data file written exception");
       }
       catch (IOException exception)
      {
		System.out.println("Data file written exception");
      }

               break;
              case 'X':  //Deserialize GroceryStore object from a File
               System.out.print("Please enter a file name to read:\n");
               filename = stdin.readLine().trim();
/***********************************************************************************************************
***  ADD your code to read a grocery store object from the specified file, if any exception
     is thrown, catch it by showing "Not serializable exception\n" or "Data file read excepiton\n"
     or "Class not found exception\n" on screen.
*************************************************************************************************************/
         try
         {

			File aFile = new File(filename);
		   //(1)in order to read, create an input stream for file "myCar.dat" first
		      FileInputStream fis = new FileInputStream(aFile);

		      ObjectInputStream input = new ObjectInputStream(fis);

		      //Read the data out from the ObjectInputStream (**order matters)
		      store1 = (GroceryStore) input.readObject();

		      //once finish the reading, close the file
		      input.close();

		 }

         catch (ClassNotFoundException exception)
         {
			System.out.println("Class not found exception\n");
         }

         catch (NotSerializableException exception)
       {
			System.out.println("Not serializable exception\n");
       }
       catch (IOException exception)
      {
		System.out.println("Data file read exception\n");
      }

               break;
             case '?':   //Display Menu
               printMenu();
               break;
             default:
               System.out.print("Unknown action\n");
               break;
            }
         }
        else
         {
           System.out.print("Unknown action\n");
          }
        } while (input1 != 'Q' || line.length() != 1);
      }
     catch (IOException exception)
      {
        System.out.print("IO Exception\n");
      }
   }

  /** The method printMenu displays the menu to a user **/
  public static void printMenu()
   {
     System.out.print("Choice\t\tAction\n" +
                      "------\t\t------\n" +
                      "A\t\tAdd Food\n" +
                      "D\t\tSearch food by ID\n" +
                      "C\t\tSearch food by Category and Name\n" +
                      "L\t\tList Food\n" +
                      "O\t\tSort Food by ID\n" +
                      "P\t\tSort Food by Category and Name\n" +
                      "Q\t\tQuit\n" +
                      "R\t\tRemove Food by ID\n" +
                      "S\t\tRemove Food by Category and Name\n" +
                      "T\t\tClose Grocery Store\n" +
                      "U\t\tWrite Text to File\n" +
                      "V\t\tRead Text from File\n" +
                      "W\t\tSerialize GroceryStore to File\n" +
                      "X\t\tDeserialize GroceryStore from File\n" +
                      "?\t\tDisplay Help\n\n");
  }
} // end of Assignment8 class


