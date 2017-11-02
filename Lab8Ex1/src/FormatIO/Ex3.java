package FormatIO;

public class Ex3 {

	// TODO Auto-generated method stub
	private static void drawBox(Console box, int nColumns, int nRows)
	{
		// loop to add one - until int x matches nColumns
		int x = 1;
		box.print("+");
		for (x = 1; x <= nColumns; x++)
		{
			box.print("-");
		}
		box.println("+");

		for (int y = 1; y <= nRows; y++)
		{
			box.print("|");
			int j = 1;
			while (j < x)
			{
				box.print(" ");
				j++;
			}
			box.println("|");
		}	
		
		box.print("+");
		for (x = 1; x <= nColumns; x++)
		{
			box.print("-");
		}
		box.print("+");
		}
	

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			//new console created to receive user input
			
			Console con = new Console();
			
			for(;;)
			{
			con.println("How many columns would you like: ");
			int x = con.readInt();
			con.println("How many rows would you like: ");
			int y = con.readInt();

			Console box = new Console ("Box");
			drawBox(box, x, y);
			
			con.println("Do you want to play another game? ");
			String response = con.readWord();
			if(response.equals("no"))
			{
				break;
			}
			}
		}

	}
