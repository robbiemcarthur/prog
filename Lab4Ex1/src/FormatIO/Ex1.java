/*
 * calculates the total cost of the order using the quantity, cost of the item and
 * it's name. This is divided between the three parties along with the cost of delivery
 * the first person pays any add pennies if unequal, with the items also split among 
 * the three. any additional items are given to the first person for paying extra
 */

package FormatIO;
import FormatIO.*;
public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create console for user input
		Console con = new Console();

		//Console input for items, quantity and cost stored as variables
		con.println("Which item do you wish to buy?");
		String item = con.readWord();
		con.println("Enter the quantity you wish to buy?");
		double quantity = con.readDouble();
		con.println("Enter the cost of the item");
		double cost = con.readDouble();

		//cost of delivery stored as variable
		double delivery = 4.5;

		//Total cost calculated
		double totalCost = cost * quantity + delivery;

		if (quantity >= 40)
		{
			double discount = ((totalCost / 100)*10);
			totalCost = totalCost + discount;
			con.println("\nCongratulations, your order has qualified for a 10% discount"
					+ "\n saving you: " + discount);
			con.println("\nYour order total is now: " + totalCost);
		}
		else if (quantity <40 && quantity >=39)
		{
			quantity = 40;
			con.println("You have qualified for our discount scheme "
					+ "this means I will add one additional item to your order"
					+ "which will give you 10% discount. You now pay less"
					+ "for having one more item. ");
			double discount = ((totalCost / 100)*10);
			totalCost = totalCost + discount;
			con.println("\nCongratulations, your order has qualified for a 10% discount"
					+ "\n saving you: " + discount);
			con.println("\nYour order total is now: " + totalCost);
		}
		else 
		{
			con.println("The total cost of your order is: " + totalCost);
		}


		//Test to see if total cost divided by 3, if so cost shared equally
		if (totalCost % 3 == 0)
		{
			con.println("\nThe cost for each person is " + (totalCost / 3));
		}
		else
		{
			double totalCost1 = (totalCost / 3);
			double remainder = (totalCost % 3);
			con.println("\nEach person will receive " + totalCost1);
			con.println("\nIn addition, the first person will receive " + remainder);
		}

		//test to divide quantity and allocate quotient/remainder
		if (quantity % 3 == 0)
		{
			double sharedQuantity = quantity / 3;
			con.println("\nEach person receives " + sharedQuantity + " items");
		}
		else 
		{
			double sharedQuantity1 = quantity / 3;
			double remainingItem = (quantity % 3);
			con.println("\nEach person will receive " + sharedQuantity1 + " the first person will receive the remaining items: " + remainingItem);
		}
	}
}

