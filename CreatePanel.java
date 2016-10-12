// Assignment #: Arizona State University CSE205 #6
//         Name: Robert Hammerschmidt
//    StudentID: 1207364973
//      Lecture: MWF 9AM-9:50AM
//  Description: CreatePanel generates a panel where a user can enter
//  a car information and create a list of available cars.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class CreatePanel extends JPanel
{
   private Vector carList;
   private PurchasePanel buyPanel;
   private JButton createButton;
   private JLabel message;

   //******declare all other necessary java components here ******//
   private JPanel leftPanel, rightPanel;
   private JPanel subPanel1, subPanel2, subPanel3, subPanel4, subPanel5;
   private JTextField textField1, textField2, textField3, textField4;
   private JLabel label1, label2, label3, label4;
   private JTextArea area;

   private JScrollPane scrollPane;

 //Constructor
   public CreatePanel(Vector carList, PurchasePanel buyPanel)
   {
      this.carList = carList;
      this.buyPanel = buyPanel;

      message = new JLabel(" ");
      message.setForeground(Color.red);

      //******Initialize all instance varibles and set up  the layouts ******//
      this.setLayout(new GridLayout(1,2));
      leftPanel = new JPanel(new GridLayout(6, 1));
      rightPanel = new JPanel(new GridLayout(1,1));

      message = new JLabel("");
      message.setForeground(Color.red);

      subPanel1 = new JPanel(new GridLayout(1,1));
      label1 = new JLabel("Manufacturer");
      textField1 = new JTextField("");
      subPanel2 = new JPanel(new GridLayout(1,1));
      label2 = new JLabel("Brand Name");
      textField2 = new JTextField("");
      subPanel3 = new JPanel(new GridLayout(1,1));
      label3 = new JLabel("Year");
      textField3 = new JTextField("");
      subPanel4 = new JPanel(new GridLayout(1,1));
      label4 = new JLabel("Price");
      textField4 = new JTextField("");

      subPanel1.add(label1);
      subPanel1.add(textField1);
      subPanel2.add(label2);
      subPanel2.add(textField2);
      subPanel3.add(label3);
      subPanel3.add(textField3);
      subPanel4.add(label4);
      subPanel4.add(textField4);

      subPanel5 = new JPanel();
	  createButton = new JButton("Create a Car");
      subPanel5.add(createButton);

      leftPanel.add(message);
	  leftPanel.add(subPanel1);
	  leftPanel.add(subPanel2);
	  leftPanel.add(subPanel3);
	  leftPanel.add(subPanel4);
	  leftPanel.add(subPanel5);


	  area = new JTextArea("no car");

	  scrollPane = new JScrollPane(area);

	  this.add(leftPanel);
      this.add(scrollPane);

      //******Never forget to register the listener object with its source object, such as the following example ******//
      createButton.addActionListener(new ButtonListener());




   } //end of constructor


  //ButtonListener is a listener class that listens to
  //see if the button "Create a car" is pushed.
  //When the event occurs, it gets a car's manufacturer, brand, year and price
  //information from the relevant text fields, creates a new car and adds it inside
  //the carList. Meanwhile it will display the car's information inside the text area.
  //It also does error checking in case any of the textfields are empty.

   public class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         //******declare all necessary local varibles here ******//

			String Manufacturer = textField1.getText();
			String BrandName = textField2.getText();
			String YearText = textField3.getText();
			int Year = Integer.parseInt(YearText);
		    String PriceText = textField4.getText();
		 	double Price = Double.parseDouble(PriceText);


         //******In case any of the four textfields are empty, but the button is pushed ******//
         if (textField1.getText().length() > 0  && textField2.getText().length() > 0 && textField3.getText().length() > 0 && textField4.getText().length() > 0)
         {

		    Car theCar = new Car(Manufacturer, BrandName, Year, Price);
			carList.add(theCar);
			String x = "";
			for (int index = 0; index < carList.size(); index++)
			{
				x = (carList.get(index) + x);
				area.setText(x);
			}


            textField1.setText("");
            textField2.setText("");
            textField3.setText("");
            textField4.setText("");



			message.setText("Car Added");

         }

         if(textField1.getText().length() < 1  || textField2.getText().length() < 1 || textField3.getText().length() < 1)
         {
			message.setText("Please fill all fields");
		 }
         else
         {


            try
            {
             //******handle the button event here ******//


            }
            catch(NumberFormatException ex)
            {
               message.setText("Please enter correct data format");

            }
         }

      } //end of actionPerformed method
   } //end of ButtonListener class

} //end of CreatePanel class