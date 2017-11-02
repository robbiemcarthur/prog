package FormatIO;

public class ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Program designed to create a new console asking
		 * user what is their favourite colour. The input
		 * is saved as a string and manipulated using the
		 * StringIn object to demonstrate different value output*/
		
		Console con = new Console();
		con.println("What is your favourite colour?");
		String colour = con.readLine();
		StringIn sin = new StringIn(colour);
		String colour1 = sin.readWord();
		System.err.println(colour1);
		
		con.println("What is your favourite number?");
		String number = con.readLine();
		StringIn sinnum = new StringIn(number);
		double number2 = sinnum.readDouble();
		System.err.println("" + number2);
	}

}
