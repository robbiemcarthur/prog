package FormatIO;
import FormatIO.*;
import java.util.*;

public class Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Console con = new Console ("Guess");
		Random rand = new Random();
		
		//remember total score and number of games 
		int totalScore = 0, games = 0;
		
		for (;;)
		{
			totalScore += playGame(con, rand);
			games++;
			//do we need another shot
			con.println("Do you want another go?: ");
			String reply = con.readWord();
			if (reply.equals("no"));
				break;
		}
		int average = totalScore/games;
		con.println(String.format("\n\nThank you for playing, your average was: ",
				average));
		
		}
	private static int playGame(Console con, Random rand) {
		return 0;
		
	}
}