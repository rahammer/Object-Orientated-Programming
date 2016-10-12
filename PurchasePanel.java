// Assignment #: Arizona State University CSE205 #6
//         Name: Robert Hammerschmidt
//    StudentID: 1207364973
//      Lecture: MWF 9AM-9:50AM
//  Description: PurchasePanel displays a list of available cars
//  from which a user can select to buy. It also shows how many
//  cars are selected and what is the total amount.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class PurchasePanel extends JPanel
{
   //carList is used to create the "Available car(s)" list - cList
   //selectedList is used to create the "Purchased car(s)" list - buyList
   private Vector carList, selectedList;
   private JList cList, buyList; //

   //******declare all other necessary instance varibles here ******//
   private JLabel availableLabel1, selectedlabel2;
   private JButton pickButton, removeButton;
   private JPanel thePanel;
   private JPanel subPanel;


   //Constructor. Initialize each instance varibles by order and set up the layouts
   public PurchasePanel(Vector carList)
   {
      this.carList = carList;
      selectedList = new Vector();

      cList = new JList(carList);
      buyList = new JList(selectedList);
      cList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      buyList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

      //set the foreground color of the selected cell
	  cList.setSelectionForeground(Color.red);
	  buyList.setSelectionForeground(Color.red);

      //set the background color of the selected cell
      cList.setSelectionBackground(Color.gray);
	  buyList.setSelectionBackground(Color.gray);


      //returns the number of visible rows displayed without a scrollbar(default is 8)
      cList.setVisibleRowCount(8);
      buyList.setVisibleRowCount(8);
      //add scrollpane to the JList in case there are more countries to display
      JScrollPane csp = new JScrollPane(cList);
      JScrollPane bsp = new JScrollPane(buyList);

      //Panel thePanel contains a label and an input text field
	  thePanel = new JPanel(new GridLayout(3, 1));

      subPanel = new JPanel(new GridLayout(1,2));
      pickButton = new JButton("Pick a Car");
      removeButton = new JButton("Remove a Car");
      subPanel.add(pickButton);
      subPanel.add(removeButton);

      thePanel.add(cList);
      thePanel.add(subPanel);
      thePanel.add(buyList);

	  this.add(thePanel);
      this.add(csp);
      this.add(bsp);


      //******Never forget to register the listener object with its source object ******//
		pickButton.addActionListener(new ButtonListener());
		removeButton.addActionListener(new ButtonListener());

   }//end of constructor

 //This method refresh the JList "cList" with pdated vector carList information
   public void updateCarList()
   {
      //write codes here
      cList.updateUI();
      buyList.updateUI();
   }

 //ButtonListener class listens to see if any of "Pick a car" or "Remove a car"
 //button is pushed. When "Pick a car" button is pushed, a selected car
 //name in the "Available car(s)" list on top will be added to the "Selected car(s)" list at the bottom
 //provided that the car was not added before.
 //When "Remove a car" button is pushed, a selected car in the "Selected car(s)" list
 //will be removed.
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
		 Object source = event.getSource();

		 if(source == pickButton)
            {

			}

      }
   } //end of ButtonListener class

} //end of PurchasePanel class