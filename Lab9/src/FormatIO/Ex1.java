package FormatIO;

public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Console con = new Console ("Date Tester");
		MyDate date = new MyDate("04\\02\\91");
		con.println("The date is: " + date.getDate());
		
		MyDate day = new MyDate(4, 02, 91);
		con.println("The day is: " + day.getDay());
		
		MyDate month = new MyDate(4, 02, 91);
		con.println("The month is: " + month.getMonth());
		
		MyDate year = new MyDate(4, 02, 91);
		con.println("The year is: " + year.getYear());
		
		MyDate ddmmyyyy = new MyDate("4,02,1991");
		con.println(String.format("The date is: ", date.getDate()));
	}

}
