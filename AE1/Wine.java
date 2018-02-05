/*
 * Wine is a model class
 * 
 * It stores details of wines purchased/returned by the customer.
 * 
 * Instance variables for the name, price and quantity of wine
 * are declared and constructed. They are returned in their
 * respective return methods. 
 * 
 * A wine object is created and returned in the LWMGUI class.
 * 
 * The return methods return each piece of information about the wine
 * depending on the input by the user.
 */

public class Wine 
{
	// instance variables
	private String _name;
	private double _price;
	private int _quantity;

	// constructor to initialise instance variables
	public Wine(String name, int quantity, double price)
	{
		_name = name;
		_price = price;
		_quantity = quantity;
	}

	// method to return wine name
	public String getName()
	{
		return _name;
	}
	
	// method to return wine price
	public double getPrice()
	{
		return _price;
	}
	
	//method to return wine quantity
	public int getQuantity()
	{
		return _quantity;
	}
	
}
