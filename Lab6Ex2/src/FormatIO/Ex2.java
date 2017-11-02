/*
 * calculates the total cost of the order using the quantity, cost of the item and
 * it's name. This is divided between the three parties along with the cost of delivery
 * the first person pays any add pennies if unequal, with the items also split among 
 * the three. any additional items are given to the first person for paying extra
 */

package FormatIO;
import FormatIO.*;
public class Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create console for user input
		Console con = new Console();

		//Console input for items, quantity and cost stored as variables
		double cost = 0;
		con.println("Which item do you wish to buy?");
		String item = con.readWord();
		con.println("You are going to buy: " + item);

		// if statement to determine if special item
		if (item.equals("battery"))
		{
			cost = 0.5;
			con.println(String.format("The cost of batteries are : £%.2f", cost));
		}
		else if (item.equals("lightbulb"))
		{
			cost = 0.77;
			con.println(String.format("The cost of lightbulbs are : £%.2f", cost));
		}
		else if (item.equals("torch"))
		{
			cost = 3.99;
			con.println(String.format("The cost of torches are : £%.2f", cost));
		}
		else
		{
			con.println("Enter the cost of the item");
			cost = con.readDouble();
		}

		con.println("Enter the quantity you wish to buy?");
		int quantity = con.readInt();

		//cost of delivery stored as variable
		double delivery = 4.5;

		//Total cost calculated
		double totalCost = (cost * quantity) + delivery;

		/*if statement to determine whether customer qualifies for discount
		 * else if included to qualify order if number of items == 39		
		 */
		if (quantity >= 40)
		{
			double discount = ((totalCost / 100)*10);
			totalCost = totalCost + discount;
			con.println("\nCongratulations, your order has qualified for a 10 percent discount");
			con.println(String.format("\nThe value of your discount is: £%.2f", discount));
			con.println(String.format("\nYour order total is now: £%.2f", totalCost));
		}
		else if (quantity <40 && quantity >=39)
		{
			quantity = 40;
			con.println("You have qualified for our discount scheme"
					+ " \nthis means I will add one additional item to your order"
					+ " \nwhich will give you 10% discount. You now pay less"
					+ " \nfor taking one more item.");
			double discount = ((totalCost / 100)*10);
			totalCost = totalCost + discount;
			con.println(String.format("\nCongratulations, your order has qualified for a 10% discount"
					+ "\n saving you: £%.2f", discount));
			con.println(String.format("\nYour order total is now: £%.2f", totalCost));
		}
		else 
		{
			con.println(String.format("\nThe total cost of your order is: £%.2f", totalCost));
		}


		//Test to see if total cost divided by 3, if so cost shared equally
		if ((int)totalCost % 3 == 0)
		{
			con.println(String.format("\nThe cost for each person is £%.2f", (totalCost / 3)));
		}
		else
		{
			double totalCost1 = (totalCost / 3);
			double remainder = (totalCost1 % 1);
			con.println(String.format("\nEach person will receive £%.2f", totalCost1));
			con.println(String.format("\nIn addition, the first person will receive £%.2f", remainder));
		}

		//test to divide quantity and allocate quotient/remainder
		if (quantity % 3 == 0)
		{
			double sharedQuantity = quantity / 3;
			con.println("\nEach person receives " + sharedQuantity + " " + item);
		}
		else 
		{
			double sharedQuantity1 = quantity / 3;
			double remainingItem = (sharedQuantity1 % 1);
			con.println("\nEach person will receive " + sharedQuantity1 + " the first person will receive the remaining items: " + remainingItem);
		}
	}
}

