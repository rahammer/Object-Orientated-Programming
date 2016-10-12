// Assignment #: Arizona State University CSE205 #7
//         Name: Robert Hammerschmidt
//    StudentID: 1207364973
//      Lecture: MWF 9AM-9:50AM
//  Description: Rect constructs a rectangle by taking the
//  values of the x and y coordinates, the width, the height,
//  and the color.

import java.awt.*;
import javax.swing.*;

public class Rect extends JApplet
{
	private int x = 0;
	private int y = 0;
	private Color color;
	private int width = 0;
	private int height = 0;

	//Constructs the Rectangle
	public Rect(int xCord, int yCord, int theWidth, int theHeight, Color theColor)
	{
		x = xCord;
		y = yCord;
		width = theWidth;
		height = theHeight;
		color = theColor;
	}
	//takes the color and draws the rectangle
	public void draw(Graphics image)
	{
		image.setColor(color);
		image.fillRect(x, y, width, height);
	}
}