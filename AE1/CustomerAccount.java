/*
 * Customer Account is a model class
 * 
 * it updates and stores the customers current balance on an 
 * ongoing basis.
 * 
 * After the methods to process a sale or return are carried out, 
 * the customers balance is updated to reflect the change. 
 */

public class CustomerAccount {
	
	// instance variables
	private String _accountHolder;
	private double _currentBalance;
	
	//  declare constant - service charge is always the same
	private final double SERVICE_CHARGE = 0.20;
	
	// constructor - initialise instance variables
	public CustomerAccount(String accountHolder, double currentBalance)
	{
		this._accountHolder = accountHolder;
		this._currentBalance = currentBalance;
	}
	
	// The following return methods return the value of the instance variables
	// i.e. name of the account holder and current balance
	public String getHolder()
	{
		return _accountHolder;
	}
	
	public double getBalance()
	{
		return _currentBalance;
	}
	
	//the below methods process a sale or transaction
	public double processSale(Wine newWine)
	{
		int quantity = newWine.getQuantity();
		double price = newWine.getPrice();
		
		double wineSale = price*quantity;
		_currentBalance = _currentBalance + wineSale;
		return wineSale;
	}
	
	public double processReturn(Wine newWine)
	{
		int quantity = newWine.getQuantity();
		double price = newWine.getPrice();
		
		double rtn = quantity*price;
		double credit = (rtn*SERVICE_CHARGE) + rtn;
		_currentBalance = _currentBalance - credit;
		return credit;
	}
}
