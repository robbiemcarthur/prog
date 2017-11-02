import java.util.*;


public class drawTriangle {

	public static void drawRow(Scanner reader, int nStars)
	{
		for(int i = 0; i < nStars; i++)
		{
			System.out.print("*");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("How many stars: ");
		int nRows = reader.nextInt();
		
		for (int i = 0; i <= nRows; i++)
		{
			drawRow(reader, i);
		}
			
	}
}
