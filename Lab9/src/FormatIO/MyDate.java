package FormatIO;
import FormatIO.*;

public class MyDate // public class, so can be used by MyTime objects
{             
	// instance variables, initialised by constructors below
	private int day, month, year; 
	private String date;
	
	// constructor 1, returns day, month, year. IVs day, month, year, 
	//initialised by d,m,y
	public MyDate (int d, int m, int y) // d,m,y are the parameters of the constructor
	{
		day = d;
		month = m;
		year = y;
	}
	
	//constructor 2, returns date in ddmmyy form

	
	// 4 Accessor Methods: 1 = day, 2 = month, 3 = year, 4 = date
	
	//first 3 below, returning day, month and year
	// accessor 1
	public int getDay() {return day; }     // return
	
	// accessor 2
	public int getMonth() {return month; } // IVs 
	
	//accessor 3
	public int getYear() {return year; } // one by one
	
	
	
	//constructor 2, returns date in ddmmyy form
	public MyDate (String ddmmyy)
	{
		date = ddmmyy;
		String.format("The date is: (a),(b),(y)", day, month, year);
	}
	
	//accessor 4    ** NEEDS TO BE RETURNED AS STRING IN DD/MM/YY FORMAT **
	public String getDate() {return date;} 
}
