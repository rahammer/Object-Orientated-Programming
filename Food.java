import java.text.*;
public class Food extends Product
{
	private String name = "?";
	private double damageRate = 0.0;
	private String expirationDate = "?";
	DecimalFormat fmtRate = new DecimalFormat("0.00%");  //formats a decimal to a percentage of two decimal places
	DecimalFormat fmtTotal = new DecimalFormat("$0.00");  //formats total price to two decimal places
	/**
	* Gets the product ID, the quantity, the unit price, the name,
	* the damage rate, and the expiration date from the ProductParser
	* @param theProductId, theQuantity, theUnitPrice, theName, theDamageRate, theExpirationDate
	*/
	public Food(String theProductId, int theQuantity, double theUnitPrice,
	String theName, double theDamageRate, String theExpirationDate)
	{
		super(theProductId, theQuantity, theUnitPrice);
		this.name = theName;
		this.damageRate = theDamageRate;
		this.expirationDate = theExpirationDate;
	}
	/**
	* Computes total cost by multiplying the price
	* of each unit by the total quantity and by multiplying
	* that value by one plus the damage rate
	*/
	public void computeTotalCost()
	{
		totalCost = (unitPrice * quantity) * (1 + damageRate);
	}
	/**
	* Converts values into a string
	*/
	public String toString()
	{
		return "\nFood:\n" + "Product ID:\t\t" + productId + "\nQuantity:\t\t" +
		quantity + "\nUnit Price:\t\t$" + unitPrice + "\nTotal Cost:\t\t" +
		fmtTotal.format(totalCost) + "\nFood Name:\t\t" + name + "\nDamage Rate:\t\t"
		+ fmtRate.format(damageRate) + "\nExpiration date:\t" + expirationDate + "\n";
	}
}