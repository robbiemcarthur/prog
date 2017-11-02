package FormatIO;

public class Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*This program is designed to extract String and number
		 * data types from a file from the directory. Once the
		 * relevant data is extracted it is used to calculate
		 * the area of the circle and output the answer on
		 * a new file created at the end of the program*/

		//PROGRAM STARTS//

		/*file "radius.txt. brought into program for reading*/

		FileIn fin = new FileIn("radius.txt");

		/*Compiler instructed to read first String word in file 
		 * and assign to variable 'radius', which is printed 
		 * to console*/	

		String radius = "";
		radius = fin.readWord();
		System.out.println(radius);

		/*Program reads next character as an integer and assigns
		 * to variable x, also printing to console*/

		int x;
		x = fin.readInt();
		System.out.println(x);

		/*Program reads next character as a double number type
		 * and assigns to variable y, printing to console*/

		double y;
		y = fin.readDouble();
		System.out.println(y);

		/*Program reads remainder of the line saving as variable
		 * equals*/ 

		String equals = "";
		equals = fin.readLine();
		System.out.println(equals);

		/*variables created to assign double values required to
		 * calculate correct area of circle*/

		double z = 7;
		double a = 3.14;
		double b = Math.sqrt(z);
		double correctArea =(b*a);

		/*Program carrys out calculation of area and outputs to
		 * two newly created consoles*/

		Console con1 = new Console();
		con1.print("The correct area is " + correctArea);
		Console con2 = new Console();
		con2.print("The correct area is " + correctArea);

		/*Program create new file and prints string with message
		 * containing correct area*/	

		FileOut fout = new FileOut("correctArea.txt");
		fout.println("The correct area is " + correctArea);
	}

}
