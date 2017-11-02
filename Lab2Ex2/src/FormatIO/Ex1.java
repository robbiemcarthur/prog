package FormatIO;

public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Console con = new Console();
		con.println("What is your first name?");
		String firstName = con.readLine();
		System.err.println(firstName);
		
		con.println("What is your last name?");
		String lastName = con.readLine();
		System.err.println(lastName);
		
		String fullName = firstName + lastName;
		String message = "Hi " + fullName + " Welcome to Glasgow";
		con.println(message);
	}

}
