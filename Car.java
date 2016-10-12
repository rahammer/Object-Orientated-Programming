public class Car{
	private String year;
	private String color;
	private double price = 0.0;

	Makes firstMakes = new Makes();
	/**
    * Accesses the String year and creates a return String
    * @return year
    */
	public String getYear()
	{
		return year;
	}
	/**
    * Accesses the String color and creates a return String
    * @return color
    */
	public String getColor()
	{
		return color;
	}
	/**
    * Accesses the double price and creates a return String
    * @return price
    */
	public double getPrice()
	{
		return price;
	}
	/**
    * Sets the string year to the input received from main
    * @param nYear
    */
	public void setYear(String nYear)
	{
		this.year = nYear;
	}
	/**
    * Sets the string color to the input received from main
    * @param nColor
    */
	public void setColor(String nColor)
	{
		this.color = nColor;
	}
	/**
    * Sets the double price to the input received from main
    * @param nPrice
    */
	public void setPrice(double nPrice)
	{
		this.price = nPrice;
	}
	/**
    * Acquires Strings from main and sends them to Makes' set methods
    * @param nBrand, nManufac, nBrand
    */
	public void setMakes(String nCountry, String nManufac, String nBrand)
	{
		firstMakes.setCountry(nCountry);
		firstMakes.setManufac(nManufac);
		firstMakes.setBrand(nBrand);
	}
	/**
    * Converts values into a string.
    */
	public String toString()
	{
		return "\n" + firstMakes + "Year:\t\t" + getYear() + "\nColor:\t\t" +
		getColor() + "\nPrice:\t\t" + getPrice()+ "\n\n";
	}

}