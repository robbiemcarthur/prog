import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

/** 
 * Programming AE2
 * Class to display cipher GUI and listen for events
 */
public class CipherGUI extends JFrame implements ActionListener
{
	//instance variables which are the components
	private JPanel top, bottom, middle;
	private JButton monoButton, vigenereButton;
	private JTextField keyField, messageField;
	private JLabel keyLabel, messageLabel;

	//application instance variables
	//including the 'core' part of the textfile filename
	//some way of indicating whether encoding or decoding is to be done
	private MonoCipher mcipher;
	private VCipher vcipher;
	private LetterFrequencies lFrequencies;

	private String keyword;
	private String encryptDecrypt;

	private int [] aCounts;
	private char [] alphabet; 

	private final int SIZE = 26;

	/**
	 * The constructor adds all the components to the frame
	 */
	public CipherGUI()
	{
		this.setSize(500,250);
		this.setLocation(100,100);
		this.setTitle("Cipher GUI");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.layoutComponents();

		// create alphabet and counter
		alphabet = new char [SIZE];
		for (int i = 0; i < SIZE; i++)
			alphabet[i] = (char)('A' + i);

		aCounts = new int[SIZE];
	}

	/**
	 * Helper method to add components to the frame
	 */
	public void layoutComponents()
	{
		//top panel is yellow and contains a text field of 10 characters
		top = new JPanel();
		top.setBackground(Color.yellow);
		keyLabel = new JLabel("Keyword : ");
		top.add(keyLabel);
		keyField = new JTextField(10);
		top.add(keyField);
		this.add(top,BorderLayout.NORTH);

		//middle panel is yellow and contains a text field of 10 characters
		middle = new JPanel();
		middle.setBackground(Color.yellow);
		messageLabel = new JLabel("Message file : ");
		middle.add(messageLabel);
		messageField = new JTextField(10);
		middle.add(messageField);
		this.add(middle,BorderLayout.CENTER);

		//bottom panel is green and contains 2 buttons

		bottom = new JPanel();
		bottom.setBackground(Color.green);
		//create mono button and add it to the top panel
		monoButton = new JButton("Process Mono Cipher");
		monoButton.addActionListener(this);
		bottom.add(monoButton);
		//create vigenere button and add it to the top panel
		vigenereButton = new JButton("Process Vigenere Cipher");
		vigenereButton.addActionListener(this);
		bottom.add(vigenereButton);
		//add the top panel
		this.add(bottom,BorderLayout.SOUTH);
	}

	/**
	 * Listen for and react to button press events
	 * (use helper methods below)
	 * @param e the event
	 */
	public void actionPerformed(ActionEvent e)
	{
		// try to find file to read
		try
		{
			File inputFile = new File(messageField.getText()+".txt");
			Scanner in = new Scanner(inputFile);

			// if monocipher option chose, file processed
			if (e.getSource()==monoButton)
			{
				getKeyword();
				processFileName(inputFile);
				mcipher = new MonoCipher(keyword);
				lFrequencies = new LetterFrequencies();

				// check if file to be encrypted
				if (encryptDecrypt.equals("P"))
				{
					// new file created to write encrypted message to
					PrintWriter monocipher = new PrintWriter("messageC.txt");
					// loop while still text in file
					while (in.hasNextLine())
					{
						// next line stored as string to be read
						// formatted to start new line after each line
						String s = in.nextLine() + "\r\n";
						for(int i = 0; i < s.length();i++)
						{
							char ch = s.charAt(i);
							// check next char not empty space
							if(ch != ' ')
							{
								// if valid, character passed to monocipher
								// for encryption
								ch = mcipher.encode(ch);
								monocipher.print(ch);
								lFrequencies.addChar(ch);
								System.out.print(ch);
								// printed to file and console for tutor
							}
							else
							{
								// if char is a space, space is inserted
								System.out.print(" ");
								monocipher.print(" ");
							}
						}

					}
					// files closed
					in.close();
					monocipher.close();
					// get max method called and printed to console for tutor
					System.out.println(lFrequencies.getMaxPC());
					// get report method called and printed to console for tutor
					System.out.println(lFrequencies.getReport());
					//file/keyword cleared for further input
					clearFile();
					clearKey();
				}

				// or to decrypt
				// below has same functions as code to encrypt
				else if (encryptDecrypt.equals("C"))
				{
					PrintWriter decipher = new PrintWriter("messageD.txt");
					while (in.hasNextLine())
					{
						String s = in.nextLine() + "\r\n";
						for(int i = 0; i < s.length();i++)
						{
							char ch = s.charAt(i);
							if(ch != ' ')
							{
								ch = mcipher.decode(ch);
								decipher.print(ch);
								lFrequencies.addChar(ch);
								System.out.print(ch);
							}
							else
							{
								System.out.print(" ");
								decipher.print(" ");
							}

						}
					}
					in.close();
					decipher.close();
					System.out.println(lFrequencies.getMaxPC());
					System.out.println(lFrequencies.getReport());
					//file/keyword cleared for further input
					clearFile();
					clearKey();
				}
				// below button should control function to
				// encrypt file using vigenere method
				else if(e.getSource()==vigenereButton)
				{
					System.exit(0);
				}
			}
		}

		// catch exception where file not found
		//display error message and clear file/key fields
		catch (FileNotFoundException ex)
		{
			JOptionPane.showMessageDialog(null, "File not found.", 
					"Warning", JOptionPane.ERROR_MESSAGE);
			clearFile();
			clearKey();
		}
	}
	/** 
	 * Obtains cipher keyword
	 * If the keyword is invalid, a message is produced
	 * @return whether a valid keyword was entered
	 */
	private boolean getKeyword()
	{
		keyword = keyField.getText();
		boolean isUpperCase = keyword.equals(keyword.toUpperCase());

		// keyword checked to ensure not empty, all uppercase
		// and no duplicate letters.
		// error messages displayed as appropriate. 
		for(;;)
			if (keyword.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Keyword is empty.", 
						"Warning", JOptionPane.ERROR_MESSAGE);
				clearKey();
				break;
			}
			else if (!isUpperCase)
			{
				JOptionPane.showMessageDialog(null, "Keyword must be in uppercase.", 
						"Warning", JOptionPane.ERROR_MESSAGE);
				clearKey();
				break;
			}
			else
			{
				for (int j = 0; j<keyword.length(); j++)
				{
					for(int i = 0; i <SIZE; i++)
					{
						char ch = keyword.charAt(j);
						if(keyword.charAt(j) == alphabet[i])
						{
							aCounts[i]++;
						}
						if(aCounts[i] > 1)
						{
							JOptionPane.showMessageDialog(null, "Keyword contains duplicate.", 
									"Warning", JOptionPane.ERROR_MESSAGE);
							clearKey();
							break;
						}

					}

				}
				// method resets alpha count from text field
				// other wise values still stored from first
				// string read. 
				resetAlpha();
				break;
			}
		return true;
	}
	
	// method to reset alphabet count values
	public void resetAlpha()
	{
		for(int i = 0; i < SIZE; i++)
		{
			aCounts[i] = 0;
		}
	}

	/** 
	 * Obtains filename from GUI
	 * The details of the filename and the type of coding are extracted
	 * If the filename is invalid, a message is produced 
	 * The details obtained from the filename must be remembered
	 * @return whether a valid filename was entered
	 */
	private boolean processFileName(File inputFile)
	{
		// method converts filename to string and checks it is valid
		// i.e. if it ends in "C" or "P"
		String fileCheck = inputFile.toString();
		int fileLen = fileCheck.length();
		char c = fileCheck.charAt(fileLen-5);
		encryptDecrypt = Character.toString(c);

		if (encryptDecrypt.equals("C") || encryptDecrypt.equals("P"))
		{
			return true;
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Please enter a valid file name",
					"Warning", JOptionPane.ERROR_MESSAGE);
			clearFile();
			clearKey();
		}
		return true;
	}

	// below 2 methods clear file and keyword text fields
	// placing an empty string in their position
	private void clearFile()
	{
		messageField.setText("");
	}

	private void clearKey()
	{
		keyField.setText("");
	}

	/** 
	 * Reads the input text file character by character
	 * Each character is encoded or decoded as appropriate
	 * and written to the output text file
	 * @param vigenere whether the encoding is Vigenere (true) or Mono (false)
	 * @return whether the I/O operations were successful
	 */
	private boolean processFile(boolean vigenere)
	{
		return true;  // replace with your code
	}
}
