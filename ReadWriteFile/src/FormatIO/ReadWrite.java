package FormatIO;
import FormatIO.*;
public class ReadWrite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Console con = new Console();
		con.println("Hi Robbie");
		
		// writing to file
		String fileName = ("greetings.txt");
		FileOut fout = new FileOut(fileName);
		fout.println("Hi Robbie");
		
		// reading from file 
		FileIn fin = new FileIn(fileName);
		String word = fin.readWord();
		con.println(word);
	}

}
