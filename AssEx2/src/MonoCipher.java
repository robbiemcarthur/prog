/**
 * Programming AE2
 * Contains monoalphabetic cipher and methods to encode and decode a character.
 */
public class MonoCipher
{
	/** The size of the alphabet. */
	private final int SIZE = 26;

	/** The alphabet. */
	private char [] alphabet;

	/** The cipher array. */
	private char [] cipher;

	/**
	 * Instantiates a new mono cipher.
	 * @param keyword the cipher keyword
	 */
	public MonoCipher(String keyword)
	{
		//create alphabet
		alphabet = new char [SIZE];
		for (int i = 0; i < SIZE; i++)
			alphabet[i] = (char)('A' + i);
		System.out.println(alphabet);

		// create first part of cipher from keyword
		cipher = new char [SIZE];
		int currentSize = keyword.length();
		char[] kword = new char [currentSize];
		int reverse = 0;


		for (int i = 0; i < currentSize; i++)
		{
			kword[i] = (keyword.charAt(i));
		}
		
		// create remainder of cipher from the remaining characters of the alphabet
		for(int x = 0; x < SIZE; x++)
		{
			cipher[x] = (char)('Z'-reverse);
			reverse++;
		}
		System.out.println(cipher);

		// swaps keyword chars with letters already in cipher to produce 
		// final cipher with kword first followed by alphabet backwards
		for(int kIndex=currentSize-1; kIndex>-1;kIndex--)
		{
			for(int aIndex=0; aIndex<SIZE;aIndex++)
				if (kword[kIndex] == cipher[aIndex])
				{		
					for(int foundChar = aIndex; foundChar > 0; foundChar--) 
					{
						char tempChar = cipher[foundChar - 1];
						cipher[foundChar - 1] = cipher[foundChar];
						cipher[foundChar] = tempChar;
					}
				}
		}

		// print final cipher array for testing and tutors
		System.out.println(cipher);
	}



	/**
	 * Encode a character
	 * @param ch the character to be encoded
	 * @return the encoded character
	 */
	
	public char encode(char ch)
	{
		// loop encodes each char by finding its pos
		//in alphabet and swapping it with value in cipher
		// pos
		for(int i =0;i<SIZE;i++)
		{
			if (ch == alphabet[i])
			{
				ch = cipher[i];
				break;
			}
		}
		
		
		return ch;  
	}

	/**
	 * Decode a character
	 * @param ch the character to be encoded
	 * @return the decoded character
	 */
	public char decode(char ch)
	{
		// reverse of encode method
		for(int i=0;i<SIZE;i++)
		{
			if (ch == cipher[i])
			{
				ch = alphabet[i];
				break;
			}
		}
		return ch;  
	}
}
