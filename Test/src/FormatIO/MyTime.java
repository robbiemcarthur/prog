package FormatIO;

public class MyTime {

	private int totMins;

	public MyTime(int h, int m) // constructor method, initialised IVs hours/mins
	{
		totMins = 60 * h + m;
	}

	public MyTime(int hhmm)
	{
		int h = hhmm / 100;
		int m = hhmm % 100;
		totMins = 60 * h + m;
	}

	// accessor methods 
	
	//returns number of hours
	public int getHours()                // These can be written in different ways
	{
		return totMins / 60;
	}
	//returns number of mins
	public int getMins() { return totMins % 60; } // ^^^^^^^^^^^^^^^^^^^^^^^^^^^

	//returns time in hhmm representation 
	public int getHhmm() { return 100 * getHours() + getMins(); }

	public MyTime addTime (MyTime otherTime)
	{
		int otherTimeTotMins = 60 * otherTime.getHours()
				+ otherTime.getMins();

		int newTotMins = this.totMins + otherTimeTotMins;

		if (newTotMins >= 1440)
			newTotMins -= 1440;

		return new MyTime(newTotMins/60, newTotMins%60);
	}

	public MyTime subTime(MyTime otherTime)
	{
		int otherTimeTotMins = 60 * otherTime.getHours() + otherTime.getMins();
		int newTotMins = this.totMins - otherTimeTotMins;

		if (newTotMins < 0)
			newTotMins += 1440;
		return new MyTime(newTotMins/60, newTotMins%60);
	}
}