package FormatIO;
import FormatIO.*;

public class Ex1 {
	
	private static void drawTop(Console con, int nColumns)
	{
	// loop to add one - until int x matches nColumns
	for (int x = 1; x <= nColumns; x++)
	{
		con.print("-");
	}
	}
	private static void drawSide (Console con, int nSides)
	{
	for (int y = 1; y <= nSides; y++)
	{
		con.println("|							|");
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new console created to receive user input
	Console con = new Console ("Box");
	con.println("How many columns would you like: ");
	int nColumns = con.readInt();
	
	con.print("+");
	
	for (int x = 0; x <= nColumns; x++)
		drawTop(con, x);
	
	con.print("+");
	
	con.println("\nHow many sides do you want: ");
	int nSides = con.readInt();
	for (int y = 0; y <= nSides; y++)
	{
		drawSide(con, y);
	}
	}

}
