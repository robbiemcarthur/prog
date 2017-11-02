import java.util.*;
import java.math.*;

public class playGame {

	private static int playGame(Scanner reader, Random rand)
	{
		reader = new Scanner(System.in);
		int num = Math.abs(rand.nextInt()) %10;
		System.err.println(num);;
		System.out.println(" ");

		int count = 0;

		for(;;)
		{
			System.out.println("Guess a number: ");
			int guess = reader.nextInt();
			count++;

			if (guess == num)
			{
				System.out.println("Correct");
				System.out.println("The correct answer was " + num + " you took " + count + "guesses.");
				return count;
			}
			else if (guess>num)
			{
				System.out.println("Too high");
				count++;
			}
			else
			{
				System.out.println("Too low");
			}
		}

	}
	public static void main(String [] arg) {
		Scanner reader = new Scanner(System.in);
		Random rand = new Random();

		int totalScore = 0, numGames = 0;

		for(;;)
		{
			totalScore += playGame(reader, rand);
			numGames++;

			System.out.println("Do you want to play again? ");
			String reply = reader.next();
			if(reply.equals("no"))
			break;
		}
		double average = (double) totalScore / numGames;
		System.out.println("Thanks for playing, your average was: ");
		System.out.println(String.format("%6.2f",  average));
	}

}

