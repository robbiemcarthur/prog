
public class AE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DbConnect db = new DbConnect();
		db.connect();
		GuGymGUI GGGUI = new GuGymGUI();
		GGGUI.setVisible(true);
	}

}
