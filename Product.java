public abstract class Product
{
	protected String productId = "?";
	protected int quantity = 0;
	protected double unitPrice = 0.0;
	protected double totalCost = 0.0;
	/**
	* Initializes the product ID, the quantity and the unit price
	* @param theProductId, theQuantity, theUnitPrice
	*/
	public Product(String theProductId, int theQuantity, double theUnitPrice)
	{
		this.productId = theProductId;
		this.quantity = theQuantity;
		this.unitPrice = theUnitPrice;
	}
	/**
    * Accesses the String ProductId and creates a return String
    * @return productId
    */
	public String getProductId()
	{
		return productId;
	}
	/**
	* Computes the total cost of the product
	**/
	public abstract void computeTotalCost();
	/**
	* Converts values into a string
	*/
	public String toString()
	{
		return "\nProduct ID:\t\t" + productId + "\nQuantity:\t\t" + quantity
		+ "\nUnit Price:\t\t" + unitPrice + "\nTotal Cost:\t\t" + totalCost +
		"\n";
	}
}