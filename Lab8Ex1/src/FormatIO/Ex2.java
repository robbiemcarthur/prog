package FormatIO;
import FormatIO.*;

public class Ex2 {


	private static void drawTop(Console box, int nColumns)
	{
		// loop to add one - until int x matches nColumns
		for (int x = 1; x <= nColumns; x++)
		{
			box.print("-");
		}
	}

	private static void drawSide(Console box, int nSide)
	{
		// loop to add one - until int x matches nColumns
		for (int y = 1; y <= nSide; y++)
		{
			String z = "      ";
			box.println("|" + z + "|");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new console created to receive user input

		Console con = new Console();
		con.println("How many columns would you like: ");
		int x = con.readInt();
		
		Console box = new Console ("Box");
		box.print("+");
		drawTop(box, x);
		box.println("+");
		
		con.println("How many sides would you like?");
		int y = con.readInt();
		drawSide(box, y);
		
		box.print("+");
		drawTop(box, x);
		box.print("+");
	}

}
