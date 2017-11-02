// a model class
/*
 * Wine class to store details of wine including the name, price
 * and quantity
 */
public class Wine 
{
	// instance variables
	private String _name;
	private double _price;
	private int _quantity;

	public Wine(String name, int quantity, double price)
	{
		// constructor method to initialise instance variables
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
