import java.io.*;
import java.util.*;

/*
 * class to demonstrate reading/writing text files 
 */

public class ReadWrite {
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		//declare variables to use
		
		int dob = 40291;
		double age = 26.75;
		String fname = "Robbie", sname = "McArthur";
		String profession = "Computer Scientist";
		String role = "Software Developer";
		
		// reading from file
		File inputFile = new File("input.txt");
		Scanner in = new Scanner(inputFile);
		
		//while loop until all text in file is read
		while (in.hasNextLine())
		{
		System.out.println(in.nextLine());
		}
		in.close();
		
		// writing to file
		PrintWriter out = new PrintWriter("output.txt");
		out.println("You're name is " + fname + " " + sname + " ");
		out.println("You are a " + profession + " and currently operate as a " + role);
		out.println("Your date of birth is " + dob + " you are " + age + " years old");
		out.println(dob);
		out.println(age);
		out.close();
		
		File fin = new File("output.txt");
		Scanner reader = new Scanner(fin);
		System.out.println(reader.nextLine());
		System.out.println(reader.nextLine());
		System.out.println(reader.next());
		System.out.println(reader.next().trim());
		System.out.println(reader.next().trim());
		System.out.println(reader.next().trim());
		System.out.println(reader.next().trim());
		System.out.println(reader.nextInt());
		System.out.println(reader.next().trim());
		System.out.println(reader.next());
		System.out.println(reader.nextDouble());
		reader.close();
	}

}
