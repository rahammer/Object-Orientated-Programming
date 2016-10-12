public class ProductParser
{
	/**
	* Parses and pulls out the string passed to send it
	* to either the food or clothing class and then return
	* it to the calling method
	* @param lineToParse
	* @return foodProduct or clothProduct
	*/
	public static Product parseStringToProduct(String lineToParse)
	{
		String[] allProductInfo = new String[6];
		allProductInfo = lineToParse.split("/");
		String productType = allProductInfo[0];
		String theId = allProductInfo[1];
		int quantityIntege = Integer.parseInt(allProductInfo[2]);
		double unit$Price = Double.parseDouble(allProductInfo[3]);
		String nameOrSize = allProductInfo[4];
		String colors = allProductInfo[5];
		if (allProductInfo.length > 6)
		{
			String expirationDates = allProductInfo[6];
			double damageRates = Double.parseDouble(allProductInfo[5]);
			Food foodProduct = new Food(theId, quantityIntege, unit$Price, nameOrSize, damageRates, expirationDates);
			return foodProduct;
		}
		else
		{
			Clothing clothProduct = new Clothing(theId, quantityIntege, unit$Price, nameOrSize, colors);
			return clothProduct;
		}
	}
}
