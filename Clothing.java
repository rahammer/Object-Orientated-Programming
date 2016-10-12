import java.text.*;
public class Clothing extends Product
{
	private String size = "?";
	private String color = "?";
	DecimalFormat fmtTotal = new DecimalFormat("$0.00"); //formats total price to two decimal places

	/**
	* Gets the product ID, the quantity, the unit price, the size
	* and the color from the ProductParser
	* @param theProductId, theQuantity, theUnitPrice, theSize, theColor
	*/
	public Clothing(String theProductId, int theQuantity, double theUnitPrice,
					String theSize, String theColor)
	{
		super(theProductId, theQuantity, theUnitPrice);
		this.size = theSize;
		this.color = theColor;
	}
	/**
	* Computes total cost by multiplying the price
	* of each unit by the total quantity
	*/
	public void computeTotalCost()
	{
		totalCost = (unitPrice * quantity);
	}
	/**
	* Converts values into a string
	*/
	public String toString()
	{
		return "\nClothing:\nProduct ID:\t\t" + productId + "\nQuantity:\t\t" +
		quantity + "\nUnit Price:\t\t$" + unitPrice + "\nTotal Cost:\t\t" +
		fmtTotal.format(totalCost) + "\nSize:\t\t\t" + size + "\nColor:\t\t\t" +
		color + "\n";
	}
}