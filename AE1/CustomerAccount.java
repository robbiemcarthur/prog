
public class CustomerAccount {
	private int currentBalance;
	private String accountHolder;
	private final double SERVICE_CHARGE = 0.20;
	
	public CustomerAccount()
	{
		currentBalance = 0;
		accountHolder = "";
	}
	
	public double processSale(int numBottles, double costBottle)
	{
		double wSale = numBottles * costBottle;
		currentBalance += wSale;
		return currentBalance;
	}
	
	public double processReturn(int numBottles, double costBottle)
	{
		double retn = numBottles*costBottle;
		double discount = retn * SERVICE_CHARGE;
		double wReturn = retn + discount;
		currentBalance -= wReturn;
		return currentBalance;
	}
}
