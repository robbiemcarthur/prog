import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.*;


/**
 * Programming AE2
 * Processes report on letter frequencies
 */
public class LetterFrequencies
{
	/** Size of the alphabet */
	private final int SIZE = 26;

	/** Count for each letter */
	private int [] alphaCounts;

	/** The alphabet */
	private char [] alphabet; 

	/** Average frequency counts */
	private double [] avgCounts = {8.2, 1.5, 2.8, 4.3, 12.7, 2.2, 2.0, 6.1, 7.0,
			0.2, 0.8, 4.0, 2.4, 6.7, 7.5, 1.9, 0.1, 6.0,  
			6.3, 9.1, 2.8, 1.0, 2.4, 0.2, 2.0, 0.1};

	/** Character that occurs most frequently */
	private char maxCh;

	/** Total number of characters encrypted/decrypted */
	private int totChars;

	/**
	 * Instantiates a new letterFrequencies object.
	 */
	public LetterFrequencies()
	{
		//create alphabet
		alphabet = new char [SIZE];
		for (int i = 0; i < SIZE; i++)
			alphabet[i] = (char)('A' + i);

		// create counts for letters in alphabet
		alphaCounts = new int[SIZE];
	}



	/**
	 * Increases frequency details for given character
	 * @param ch the character just read
	 */
	public void addChar(char ch)
	{
		// add each char as read from file to be encrypted/decrypted
		for(int i=0;i<SIZE;i++)
		{
			// loops through every letter in alphabet to check 
			// if it matches pass char
			if (ch == alphabet[i])
			{
				// where there is a match, count incremented on that
				// letter. Total characters read incremented.
				alphaCounts[i]++;
				totChars++;
			}
		}
	}

	/**
	 * Gets the maximum frequency
	 * @return the maximum frequency
	 */
	public double getMaxPC()
	{
		double max = alphaCounts[0];
		for(int i = 0; i<SIZE; i++)
			if (alphaCounts[i] > max)
			{
				// maximum frequency of letter stored using simple loops
				// to text max against current frequency and overwrite 
				// if greater.
				max = alphaCounts[i];
				// value of character with greatest frequency stored
				maxCh = alphabet[i];
			}
		return max;
	}

	/**
	 * Returns a String consisting of the full frequency report
	 * @return the report
	 */
	public String getReport()
	{
		String report ="";
		try
		{
			// new text file created to write report to 
			PrintWriter FrequencyReport = new PrintWriter("FreqReport.txt");
			double maxFreq = 0;
			
			// String sets out title and subtitles
			report = "LETTER ANALYSIS" + "\r\n" 
					+ "Letter    Freq    Freq%    AvgFreq%    Diff" + "\r\n";
			
			// loop displays each letter, their frequency and
			// calculates and displays the frequency %, avgFrequency%
			// and difference between the frequency and avg frequency %s
			for (int i=0;i<SIZE;i++)
			{
				double pFreq = ((double)alphaCounts[i]*100/totChars);
				double difference = (pFreq-avgCounts[i]);

				if (pFreq > maxFreq)
				{
					maxFreq = pFreq;
				}
				String freqP = String.format("%.1f", pFreq);
				String difFreq = String.format("%.1f", difference);
				report = report + "   " + alphabet[i] + "      " + alphaCounts[i] + "       " + freqP
						+"       "	+ avgCounts[i] + "       " + difFreq + "\r\n";
			}
			String mFreq = String.format("%.1f", maxFreq);
			report = report + "The most frequent letter is " + maxCh + " at " + mFreq;
			FrequencyReport.print(report);
			FrequencyReport.close();
		}
		catch (FileNotFoundException ex)
		{
			JOptionPane.showMessageDialog(null, "File not found.", 
					"Warning", JOptionPane.ERROR_MESSAGE);
		}
		return report;
	}
}