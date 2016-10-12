// Assignment #: Arizona State University CSE205 #7
//         Name: Robert Hammerschmidt
//    StudentID: 1207364973
//      Lecture: MWF 9AM-9:50AM
//  Description: The whole panel creates components for the whole panel
//  of this applet. It also contains CanvasPanel, ButtonListener, ColorListener,
//  and PointListner classes.

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class WholePanel extends JPanel
{
   private Color currentColor;
   private CanvasPanel canvas;
   private JPanel primary, buttonPanel, leftPanel;
   private JButton erase, undo;
   private ArrayList rectList;
   private JRadioButton[] colorRButtons;
   private Color[] colors;
   private int x1, y1, x2, y2, x3, y3;
   private boolean mouseDragged = false;

	//Constructs the Panel which holds the radiobuttons, buttons, and canvas
   public WholePanel()
   {
	   rectList = new ArrayList();
	  //default color to draw rectangles is black
		currentColor = Color.black;
      //create buttons
		undo = new JButton("Undo");
		erase = new JButton("Erase");
		undo.addActionListener (new ButtonListener());
		erase.addActionListener (new ButtonListener());
		buttonPanel = new JPanel(new GridLayout(2, 1));
		buttonPanel.add(undo);
		buttonPanel.add(erase);
		colorRButtons = new JRadioButton[5];
      //create radio buttons for 5 colors
      //at the bginning, black will be chosen by default
   	    colorRButtons[0] = new JRadioButton("black");
        colorRButtons[1] = new JRadioButton("red");
        colorRButtons[2] = new JRadioButton("blue");
        colorRButtons[3] = new JRadioButton("green");
        colorRButtons[4] = new JRadioButton("orange");
      //store 5 colors in an array
        colors = new Color[5];
        colors[0] = Color.black;
        colors[1] = Color.red;
        colors[2] = Color.blue;
        colors[3] = Color.green;
        colors[4] = Color.orange;
      //Create a group of radio buttons so that at any time only one can be selected,
        ButtonGroup group = new ButtonGroup();
        group.add(colorRButtons[0]);
        group.add(colorRButtons[1]);
        group.add(colorRButtons[2]);
        group.add(colorRButtons[3]);
        group.add(colorRButtons[4]);
      //add ColorListener to each of the radio buttons
	  	colorRButtons[0].addActionListener(new ColorListener());
		colorRButtons[1].addActionListener(new ColorListener());
		colorRButtons[2].addActionListener(new ColorListener());
		colorRButtons[3].addActionListener(new ColorListener());
		colorRButtons[4].addActionListener(new ColorListener());
      //primary panel contains all radiobuttons, add the radio buttons to the panel
        primary = new JPanel(new GridLayout(5,1));
        primary.add(colorRButtons[0]);
	    primary.add(colorRButtons[1]);
	    primary.add(colorRButtons[2]);
	    primary.add(colorRButtons[3]);
        primary.add(colorRButtons[4]);
        leftPanel = new JPanel(new GridLayout(2,1));
        leftPanel.add(primary);
        leftPanel.add(buttonPanel);
      //canvas panel is where rectangles will be drawn, thus
      //it will listen to a mouse event.
        canvas = new CanvasPanel();
        canvas.setBackground(Color.white);
      //add MouseListener & MouseMotionListener to canvas
	    canvas.addMouseMotionListener(new PointListener());
	    canvas.addMouseListener(new PointListener());
        JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, canvas);
	    setLayout(new BorderLayout());
        add(sp);

    }
   //ButtonListener defined actions to take in case "Create",
   //"Undo", or "Erase" is chosed.
   private class ButtonListener implements ActionListener
    {
      public void actionPerformed (ActionEvent event)
      {
			if( event.getSource()== undo )
			{
				rectList.remove(rectList.size() - 1);

			}
			else if( event.getSource() == erase )
			{
				rectList.clear();
			}
			canvas.repaint();
	    }
   } // end of ButtonListener

   // listener class to set the color chosen by a user using
   // the radio buttons.
   private class ColorListener implements ActionListener
    {
		public void actionPerformed(ActionEvent event)
		 {
						if( event.getSource()== colorRButtons[0] )
						{
							currentColor = Color.black;
						}
						else if ( event.getSource() == colorRButtons[1] )
						{
							currentColor = Color.red;
						}
						else if ( event.getSource() == colorRButtons[2] )
						{
							currentColor = Color.blue;
						}
						else if ( event.getSource() == colorRButtons[3] )
						{
							currentColor = Color.green;
						}
						else if ( event.getSource() == colorRButtons[4] )
						{
							currentColor = Color.orange;
						}
	     }
    }
 //CanvasPanel is the panel where rectangles will be drawn
 private class CanvasPanel extends JPanel
  {
     //this method draws all rectangles specified by a user
	 public void paintComponent(Graphics page)
      {
   	   super.paintComponent(page);

		//Rect newRect = new Rect(x1, y1, (x2 - x1), (y2 - y1), currentColor);
		//rectList.add(newRect);

          //Only draw an outline of the rectangle when the mouse is draaged but not released
          //fill the whole rectangel with the correct color when mouse is released.
          if (mouseDragged == true)
           {
				page.drawRect(x1, y1, (x3 - x1), (y3 - y1));
	       }
		   for(int i = 0; i < rectList.size(); i++ )
		   {
		  	if (rectList.get(i) != null)
		  	{
				Rect newRectangle = (Rect) rectList.get(i);
				newRectangle.draw(page);
			}
		//((Rect)rectList.get(i)).draw(page);
		   }
	  }
    } //end of CanvasPanel class

   // listener class that listens to the mouse
   public class PointListener implements MouseListener, MouseMotionListener
    {
	 //in case that a user presses using a mouse,
	 //record the point where it was pressed.
     public void mousePressed (MouseEvent event)
      {
		//after "create" button is pushed.
			//getPoint() returns a Point object containing the x & y-coordinates
			x1 = event.getPoint().x;
			y1 = event.getPoint().y;
      }

     //mouseReleased method takes the point where a mouse is released,
     //using the point and the pressed point to create a rectangle,
     //add it to the ArrayList "rectList", and call paintComponent method.
     public void mouseReleased (MouseEvent event)
      {
			mouseDragged = false;
			x2 = event.getPoint().x;
			y2 = event.getPoint().y;
	        Rect newRect = new Rect(x1, y1, (x2 - x1), (y2 - y1), currentColor);
		    rectList.add(newRect);
		    canvas.repaint();
	  }

     //mouseDragged method takes the point where a mouse is dragged
     //and call paintComponent nethod
	 public void mouseDragged(MouseEvent event)
	  {
			mouseDragged = true;
			x3 = event.getPoint().x;
			y3 = event.getPoint().y;
			  canvas.repaint();
	  }

     public void mouseClicked (MouseEvent event) {}
     public void mouseEntered (MouseEvent event) {}
     public void mouseExited (MouseEvent event) {}
     public void mouseMoved(MouseEvent event) {}
    } // end of PointListener
} // end of Whole Panel Class