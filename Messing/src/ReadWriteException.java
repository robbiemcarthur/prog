import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReadWriteException {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		// promt for input/output file names
		Scanner console = new Scanner(System.in);
		
		try {
		System.out.println("Input file: ");
		String inputFileName = console.next();
		System.out.println("Output file: ");
		String outputFileName = console.next();
		
		//Construct the Scanner and PrintWriter objects to read/write
		
		File inputFile = new File(inputFileName);
		Scanner in = new Scanner(inputFile);
		PrintWriter out = new PrintWriter(outputFileName);
		
		// read input and write output
		double total = 0;
		
		while (in.hasNextDouble())
		{
			double value = in.nextDouble();
			out.printf("\n Total: %8.2f\n", total);
			total = total + value;
		}
		
		out.printf("Total: %8.2f\n", total);
		
		in.close();
		out.close();
		}
		catch (FileNotFoundException exception)
		{
			System.out.println("Could not find file.");
		}
	}
}