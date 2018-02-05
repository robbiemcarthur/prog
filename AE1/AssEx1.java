import javax.swing.*;

/*
 * AssEx1: Contains main method.
 * 
 * Takes user input from JOptionPane dialog boxes and creates an LWMGUI 
 * and Customer Account object.
 * 
 * User input from the dialog boxes is passed to the Customer Account object,
 * which in turn is passed to the LWMGUI object.
 * 
 * The input sets the initial balance and name of the account holder.
 */
@SuppressWarnings("serial")
public class AssEx1 extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* 
		 * Set variables required to hold account holder name and
		 * double/string version of account balance
		 * 
		 * Not created within loops due to scope issues that 
		 * would arise.
		*/ 
		 String accountHolder="";
		 double currentBalance = 0;
		 String sBalance = "";

		 // set boolean variables used in exception handling loops
		 boolean validHolder = false;
		 boolean validBalance = false;

		 // loop handles event where account holders name input is empty string
		 while(!validHolder) {
			 try
			 {
				 accountHolder = JOptionPane.showInputDialog(null, "Enter your name: ");

				 // test for empty string
				 if (accountHolder.trim().isEmpty())
				 {
					 // if empty, exit program
					 System.exit(0);
				 }
				 else
				 {
					 validHolder = true;
				 }
			 }
			 catch(NullPointerException e)
			 {
				 // if null value entered i.e. 'X' or 'Cancel' button pressed, exit program
				 System.exit(0);
			 }
		 }


		 // loop handles event where balance is empty string or not numerical format
		 while(!validBalance) {
			 try 
			 {
				 sBalance = JOptionPane.showInputDialog(null, "Enter Starting Balance: ");

				 // handles empty string
				 if (sBalance.trim().isEmpty())
				 {
					 System.exit(0);
				 }
				 // converts balance string to double and exits loop
				 else
				 {
					 currentBalance = Double.parseDouble(sBalance);
					 validBalance = true;
				 }
			 }
			 // catches null input i.e. if 'X' or 'Cancel' button pressed
			 catch(NullPointerException exe)
			 {
				 System.exit(0);
			 }
			 // catches non-numerical input
			 catch(NumberFormatException ex) 
			 {
				 JOptionPane.showMessageDialog(null, "Please enter a number. ", "Warning", JOptionPane.ERROR_MESSAGE);
			 }

		 }
		 // Dialog box displayed confirming entry of customer name and their initial balance
		 JOptionPane.showMessageDialog(null, "Customer Name: " + accountHolder + " \n"
				 +	"Starting Balance: " + sBalance);
		 
		 // Create CustomerAccount object, passing account holder name and balance as parameters
		 CustomerAccount cAccount = new CustomerAccount(accountHolder, currentBalance);
		 
		 //Create LWMGUI object and pass above Customer Account object as parameter
		 LWMGUI LWMGUI = new LWMGUI(cAccount);
		 
		 // Set LWMGUI object visibility to true so user can see it
		 LWMGUI.setVisible(true);
	}

}
