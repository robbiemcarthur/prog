package FormatIO;

import FormatIO.*;

public class Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// create new bank account 
		Console con = new Console("Bank Account");
		con.println("Welcome to your bank account.");

		// Get account number from user
		con.println("\nPlease enter your account number: ");
		String accountNumber = con.readLine();

		// Take initial deposit from user
		con.println("\nPlease enter the amount you wish to deposit: ");
		double initialDeposit = con.readDouble();

		// store initial details in file
		String fileName = "account"+accountNumber+".txt";     //assign filename to string
		String accountLine = accountNumber + " " + initialDeposit; //assign data to single string variable
		FileOut fout = new FileOut (fileName); //use fileName to create new file
		fout.println(accountLine); //print data from variable into newly created file
		con.println("\nAccount file <"+fileName+"> created");
		fout.close();

		// read account details from file
		con.println("\n\nReading account balance");
		con.println("Enter your account number: ");
		accountNumber = con.readWord();
		fileName = "account"+accountNumber+".txt";
		FileIn fin = new FileIn (fileName);

		accountNumber = fin.readWord();
		double balance = fin.readDouble();
		fin.close();

		con.println(String.format("\nThe balance of account %s is £%.2f",  accountNumber, balance));


		// Get a transaction from the user which updates the balance contained in file
		con.println("\nMaking a transaction ");
		con.println("\nWhich account would you like to access?");
		accountNumber = con.readLine();
		con.println("\nHow much would you like to withdraw / deposit: ");
		double transaction = con.readDouble();
		double updatedBalance = balance + transaction;
		fout = new FileOut("account"+accountNumber+".txt");
		fout.println(accountNumber);
		fout.println(updatedBalance);
		fout.close();

		fin = new FileIn("account"+accountNumber+".txt");
		accountNumber = fin.readWord();
		balance = fin.readDouble();
		fin.close();

		con.println(String.format("\nOkay, your updated balance is: £%.2f", updatedBalance));

		con.println("\nPrinting account statement");
		con.println(String.format("\nYour account information is as follows: \nAccount Number: %s"
				+ "\nTransaction: £%.2f "
				+ "\nFinal Balance: £%.2f", accountNumber, transaction, updatedBalance));
	}

}
