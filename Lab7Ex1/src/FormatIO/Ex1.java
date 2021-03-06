package FormatIO;
import FormatIO.*;
import java.util.*;
import java.lang.*;


public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Console con = new Console();
		Random rand = new Random();
		int num = Math.abs(rand.nextInt()) % 10;
		int count = 0;

		//loop until correct
		for (;;)
		{
			con.print("Guess a number: ");
			int guess = con.readInt();
			count++;


			//print results 
			if (guess == num)
			{
				con.println("Congratulations, you got the correct answer: " + guess);
				con.println("It took you " + count + "guesses.");
			}
			else if (guess < num)
			{
				con.println("Too low");
				count++;
			}
			else
			{
				con.println("Too high");
				count++;
			}
			break;
		}

	}

}
