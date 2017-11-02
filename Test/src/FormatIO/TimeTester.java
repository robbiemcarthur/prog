package FormatIO;

public class TimeTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Console con = new Console("Time Tester");
		MyTime newTime1 = new MyTime(10, 30);
		con.println("The first time is " +String.format("%04d", newTime1.getHhmm()));
		
		MyTime newTime2 = new MyTime(2, 17);
		con.println("The second time is " +String.format("%04d", newTime2.getHhmm()));
		
		MyTime newTime3 = newTime1.addTime(newTime2);
		con.println("The third time is " +String.format("%04d", newTime2.getHhmm()));
		
		MyTime newTime4 = newTime2.subTime(newTime1);
		con.println("The fourth time is " +String.format("%04d", newTime1.getHhmm()));
	}

}
