package FormatIO;
import FormatIO.*;
public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// create console to take user input
		Console con = new Console("Bank Account Manager");
		
		//create first bank account
		con.println("Welcome to Account Manager");
		con.println("\nEnter your account number: ");
		String accountNumber = con.readLine();
		con.println("Welcome to account: " +accountNumber);
		con.println("Please enter your balance: ");
		double balance = con.readDouble();
		con.println(String.format("\nYour balance is: £%.2f", balance));
		
		//write first account details to file
		String fileName = "account-"+accountNumber+".txt";
		String accountLine = accountNumber + balance;
		FileOut fout = new FileOut(fileName);
		fout.print(accountLine);
		fout.close();
		
		//create second bank account
		con.println("\nPlease enter your account number: ");
		String accountNumber2 = con.readLine();
		con.println("Welcome to account: " +accountNumber);
		con.println("Please enter your balance: ");
		double balance2 = con.readDouble();
		con.println(String.format("\nYour balance is: £%.2f", balance));
		
		//write second account details to file
		String fileName2 = "account-"+accountNumber+".txt";
		String accountLine2 = accountNumber + balance;
		fout = new FileOut(fileName2);
		fout.println(fileName2);
		fout.close();
		
		//make rental payment for rent * duration of stay deducting from one bank acc
		con.println("Setting up direct debit for apartment rental");
		con.println("How much is the rent?: ");
		double rent = con.readDouble();
		con.println("How many months are you staying for?: ");
		int instalments = con.readInt();
		
		while (instalments>0);
		{
			rent =+ rent;
			con.println(String.format("Your rent has been paid, the total now stands at: £%.2f", rent));
			--instalments;
			con.print(instalments);
		}
		
		con.println("Toal rent paid: " + rent);
	}

}
