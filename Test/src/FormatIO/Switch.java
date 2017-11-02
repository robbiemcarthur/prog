package FormatIO;
import FormatIO.*;

public class Switch {

	private static boolean isLeap(int year)
	{
		return year % 4 == 0 && year % 100 != 0
				|| year % 400 == 0;
	}

	private static int daysInMonth(int month, int year)
	{
		switch (month) {
		case 4:
		case 6:
		case 9:
		case 11: 
			return 30;

		case 2:
		return (isLeap(year)) ? 29 : 28;

		default:
			return 31;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Console con = new Console("Days in Month");
		
		for(;;)
		{
			con.println("Would you like to know the days in the month?");
			String response = con.readWord();
			if (response.equals("no"))
				break;

			{
				con.println("Enter month: ");
				int monthNum = con.readInt();
				con.println("Enter year: ");
				int yearNum = con.readInt();

				int numDays = daysInMonth(monthNum, yearNum);
				con.println("The number of days this month is " + numDays+ "\n");
			}
		}
	}
}

