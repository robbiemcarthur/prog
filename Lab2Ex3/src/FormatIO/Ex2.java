package FormatIO;

public class Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileIn fin = new FileIn("radius.txt");
			
			String radius = "";
			radius = fin.readWord();
			System.out.println(radius);

			int x;
			x = fin.readInt();
			System.out.println(x);
			
			double y;
			y = fin.readDouble();
			System.out.println(y);

			String equals = "";
			equals = fin.readLine();
			System.out.println(equals);
			
	}

}
