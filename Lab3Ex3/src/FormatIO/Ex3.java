package FormatIO;

import FormatIO.*;

/*
 * This program asks the user for first name, last name 
 * and day, month and year of birth.  It writes the information
 * to a file in a neat format
 * 
 * Ron Poet 17 Sep 2007
 */

public class Ex3 {
public static void main(String[] arg)
{
	// Create the Console for user interaction
	Console con = new Console();
	FileOut fout = new FileOut("Lab3personnel.txt");

	// Get name and date of birth.
	con.print("Enter first name followed by last name: ");
	String firstName = con.readWord();
	String lastName  = con.readWord();
	con.print("Enter day month and year of birth: ");
	int day   = con.readInt();
	int month = con.readInt();
	int year  = con.readInt();
	
	// Format the information
	String out = String.format("%12s  %12s  %02d/%02d/%04d", 
			firstName, lastName, day, month, year);
	
	// Write to the file
	fout.println(out);
	fout.close();
}
}
