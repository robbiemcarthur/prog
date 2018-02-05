// Robbie
import java.io.*;
import java.util.ArrayList;

/*
 * Class creates a test log object. 
 * Test log will create/overwrite file 'toptrumps.log' and print details 
 * of the game's operation to the file.
 */

public class TestLog {
	// instance variables
	private final String fin = ("toptrumps.log");
	private final File log = new File(fin);
	private final int MAX_HAND = 41;
	private String lineBreak;
	private StringBuilder sb;
	private ArrayList<Card> initDeck;
	private ArrayList<Card> shuffledDeck;
	private ArrayList<Card> currentDeck;
	private Card [] humanHand;
	private Card [] AIHand;
	private ArrayList<Card> communalPile; // need class 
	private ArrayList<Card> cardsIP;
//	private int hCount;
//	private int AICount;
	private int roundCount;
	private int playerID;

	public TestLog ()
	{
		lineBreak = "------------------------------------------------------------------------";
		sb = new StringBuilder();
		initDeck = new ArrayList<Card>();
		shuffledDeck = new ArrayList<Card>();
		humanHand = new Card[MAX_HAND];
		AIHand = new Card[MAX_HAND];
		communalPile = new ArrayList<Card>();
		cardsIP = new ArrayList<Card>();
//		hCount = 0;
//		AICount = 0;
		roundCount = 0;
		playerID = 0;
	}
	
	// receive original deck as loaded from file
	public void writeInitDeck (ArrayList<Card> deck) {
		sb.append("Displaying original deck as loaded from StarCitizenDeck.txt: \r\n");
		initDeck = deck;
		
		for (Card c : initDeck)
		{
			sb.append(c);
			sb.append(" ");
		}
		
		sb.append(lineBreak + "\r\n");
	}
	
	// receive shuffled deck
	public void writeShuffledDeck (ArrayList<Card> deck)	{
		sb.append("Displaying deck after shuffle: \r\n");
		shuffledDeck = deck;
		
		for(Card c : shuffledDeck)
		{
			sb.append(c);
			sb.append(" ");
		}
		sb.append(lineBreak + "\r\n");
	}
	
	// used to write deck after cards added/removed
	public void writeCurrentDeck (ArrayList<Card> deck) {
		sb.append("Displaying deck after cards added/removed: \r\n");
		currentDeck = deck;
		
		for (Card c : currentDeck)
		{
			sb.append(c);
			sb.append(" ");
		}
		
		sb.append(lineBreak + "\r\n");
	}
	
	// method to write hand, detecting if human/AI
	public void writeHand(Card [] hand, int playerNum) {
		sb.append("\r\nWriting player hand... ");
		playerID = playerNum;
		if (playerID == 1)
		{
			humanHand = hand;
			sb.append("Human Player " + playerID + "'s hand is:  ");
			for(Card c: humanHand)
			{
				sb.append(c);
				sb.append(" ");
			}
			sb.append(lineBreak + "\r\n");
		}
		else
		{
			AIHand = hand;
			sb.append("AI Player " + playerID + "'s hand is:  ");
			for(Card c: AIHand)
			{
				sb.append(c);
				sb.append(" ");
			}
			sb.append(lineBreak + "\r\n");
		}
			
	}
	
	// write cards in play
	public void writeCardsIP ()	{
		
	}

	// write number of human wins?
//	public void writeHumanWin (int hCnt) {
//		// write number of human wins to log
//		hCount = hCnt;
//		// test
//		System.out.println("\r\nNumber of human wins: " + hCount);
//	}

	// receive number of computer wins
//	public void writeComputerWin (int AICnt) {
//		AICount = AICnt;
//		// test
//		System.out.println("\r\nNumber of computer wins: " + AICount);
//	}

	
	// write number of rounds played
	public void writeRounds (int rCount)	{
		roundCount = rCount;
		// test 
		System.out.println("\r\n Number of rounds: " + roundCount);
		sb.append("\r\n Number of rounds: " + roundCount);
	}
	
	// writes winner of game (with type of player + player num)
	public void writeWinner (int playerNum)	{
		playerID = playerNum;
		if (playerID == 1)
		{
			sb.append("Human Player " + playerID + " wins!  ");
			sb.append("GAME OVER");
		}
		else
		{
			sb.append("AI Player " + playerID + " wins!  ");
			sb.append("GAME OVER");
		}
	}
		

	// write game log to file
	public void writeFile () {
		try {
			PrintWriter writer = new PrintWriter(log);
			writer.append(sb);
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("\r\nFile not found. ");
		}
		
	}

}
