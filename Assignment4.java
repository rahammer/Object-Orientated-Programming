// Assignment : Arizona State U. CSE205 #4
// Name: Robert Hammerschmidt
// StudentID: 1207364973
// Lecture: MWF 9AM-9:50AM
// Description: Assignment 4 class displays a menu of choices to a user
//        and performs the chosen task. It will keep asking a user to
//        enter the next choice until the choice of 'Q' (Quit) is entered.
// Time spent:

import java.io.*;    //to use InputStreamReader and BufferedReader
import java.util.*;

public class Assignment4
 {
  public static void main (String[] args)
   {
       // local variables, can be accessed anywhere from the main method
       char input1 = 'Z';
       String inputInfo;
       String year, color;
       double price;
       String country, manufacturer, brand;
       String line = new String();

       // instantiate a Pet object
       Car car1 = new Car();

       printMenu();

       //Create a Scanner object to read user input
       Scanner scan = new Scanner(System.in);


       do  // will ask for user input
        {
         System.out.print("What action would you like to perform?\n");
         line = scan.nextLine();

         if (line.length() == 1)
          {
           input1 = line.charAt(0);
           input1 = Character.toUpperCase(input1);

           // matches one of the case statement
           switch (input1)
            {
             case 'A':   //Add Car
               System.out.print("Please enter the car information:\n");
               System.out.print("Who is the car\'s manufacturer?\n");
               manufacturer = scan.nextLine();

               System.out.print("What is the car brand?\n");
               brand = scan.nextLine();
               System.out.print("Which country is the car made?\n");
               country = scan.nextLine();

               car1.setMakes(country, manufacturer, brand);


               System.out.print("what year was the car made?\n");
               year = scan.nextLine();
               car1.setYear(year);

               System.out.print("What color is the car?\n");
               color = scan.nextLine();
               car1.setColor(color);

               System.out.print("How much was the car\'s price?\n");
               //price = scan.nextDouble();
               price = Double.parseDouble(scan.nextLine());
               car1.setPrice(price);

               break;
             case 'D':   //Display Pet
               System.out.print(car1);
               break;
             case 'Q':   //Quit
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

  /** The method printMenu displays the menu to a user **/
  public static void printMenu()
   {
     System.out.print("Choice\t\tAction\n" +
                        "------\t\t------\n" +
                        "A\t\tAdd a Car\n" +
                        "D\t\tDisplay Car\n" +
                        "Q\t\tQuit\n" +
                        "?\t\tDisplay Help\n\n");
  }
}
