public class Makes{
	private String country = "?";
	private String manufacturer = "?";
	private String brandName = "?";
	/**
    * Takes the String country and creates a return String
    * @return theCountry
    */
	public String getCountry()
	{
		String theCountry = country;
		return theCountry;
	}
	/**
    * Takes the String Manufacturer and creates a return String
    * @return theManufac
    */
	public String getManufac()
	{
		String theManufac = manufacturer;
		return theManufac;
	}
	/**
    * Takes the String brandName and creates a return String
    * @return theBrandName
    */
	public String getBrand()
	{
		String theBrandName = brandName;
		return theBrandName;
	}
	/**
    * Sets the String country to the input received from Main
    * @param nCountry
    */
	public void setCountry(String nCountry)
	{
		this.country = nCountry;
	}
	/**
    * Sets the String Manufacturer to the input received from Main
    * @param nManufac
    */
	public void setManufac(String nManufac)
	{
		this.manufacturer = nManufac;
	}
	/**
    * Sets the string brandName to the input received from main
    * @param nBrand
    */
	public void setBrand(String nBrand)
	{
		this.brandName = nBrand;
	}
	/**
    * Converts values into a string.
    */
	public String toString()
	{
		return "\nCountry:\t" + getCountry() + "\nManufacturer:\t"
		+ getManufac() + "\nBrand:\t\t" + getBrand() + "\n";
	}
}