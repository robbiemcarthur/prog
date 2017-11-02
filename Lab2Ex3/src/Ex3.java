import FormatIO.Console;
import FormatIO.FileIn;

public class Ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileIn fin = new FileIn("radius.txt");

		String radius = "";
		radius = fin.readWord();
		System.out.println(radius);

		String radius1 = "";
		radius1 = fin.readWord();
		System.out.println(radius1);

		double radius3;
		radius3 = fin.readDouble();
		System.out.print(radius3);

		double sqrt = Math.sqrt(radius3);
		double area = sqrt * 3.14;

		Console con = new Console();
		con.println(area);
	}

}
