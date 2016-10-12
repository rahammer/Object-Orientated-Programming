// Assignment #: Arizona State University CSE205 #6
//         Name: Robert Hammerschmidt
//    StudentID: 1207364973
//      Lecture: MWF 9AM-9:50AM
//  Description: The Assignment 6 class creates a Tabbed Pane with
//               two tabs, one for Car creation and one for
//               Car purchasing. and adds it as its Applet content
//               and also sets its size.

import javax.swing.*;
import java.util.*;

public class Assignment6 extends JApplet
 {

   private int APPLET_WIDTH = 500, APPLET_HEIGHT = 300;

   private JTabbedPane tPane;
   private CreatePanel createPanel;
   private PurchasePanel purchasePanel;
   private Vector carList;

   //The method init initializes the Applet with a Pane with two tabs
   public void init()
    {
	 //list of car to be used in both CreatePanel & PurchasePanel
	 carList = new Vector();

	 //register panel uses the list of courses
	 purchasePanel = new PurchasePanel(carList);

     createPanel = new CreatePanel(carList, purchasePanel);

     //create a tabbed pane with two tabs
     tPane = new JTabbedPane();
     tPane.addTab("Car creation", createPanel);
     tPane.addTab("Car purchase", purchasePanel);

     getContentPane().add(tPane);
     setSize (APPLET_WIDTH, APPLET_HEIGHT); //set Applet size
    }
}

