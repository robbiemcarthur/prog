package FormatIO;

public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*This program is designed to generate a console asking
		 * the user to input their first name, then their
		 * second name, both of which are assigned variables and
		 * printed to the console. 
		 * 
		 * A variable is then created which adds the values of 
		 * those variables together.
		 * 
		 * This is used to print a welcome message in the console
		 * using your full name.
		 * 
		 * In Eclipse, the console will output your first and 
		 * second name as red as they are assigned to variables*/
		
		//PROGRAM STARTS//
		
		/* new console created with string message "What is your 
		 * first name?". Con asked to read user input and save as 
		 * variable 'firstName'. Variable printed in red to the
		 * Eclipse console*/
		
		Console con = new Console();
		con.println("\nWhat is your first name?\n");
		String firstName = con.readLine();
		System.err.println(firstName + "" + "\n");

		/*create second string in console "What is your second 
		 * name?". con is asked to save the input as a variable
		 *'secondName. Variable printed in red to the Eclipse 
		 * console*/
		
		con.println("\nWhat is your last name?\n");
		String lastName = con.readLine();
		System.err.println(lastName);

		/*Finally, I create a variable called fullName, which is
		 *result of fullName and secondName. This is used to 
		 *print a string message to the console greeting the
		 *user by their full name and welcoming them to the city*/
		
		String fullName = firstName + " " + lastName;
		String message = "\n\nHi" + "\n\n" + fullName + "\n\nWelcome to Glasgow";
		con.println(message);
	}

}
