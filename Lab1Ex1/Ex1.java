import FormatIO.*;
public class Ex1 {
	public static void main (String[] arg)
	{
		Console con = new Console();
		con.println("Hello World");
		FileOut fout = new FileOut("greeting.txt");
		fout.println("Hi David");
	}
}
