import java.sql.*;

import javax.swing.JOptionPane;

public class DbConnect {

	//instance variables
	private Connection connection =null;

	public DbConnect() 
	{
		
	}
	
	public void connect()
	{
		String dbname = "GuGym";
		String userName = "postgres";
		String password = "tgsrmyyu123";

		try 
		{
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname,userName,password);
		}

		catch(SQLException e ) 
		{
			System.err.println("Connection Failed.");
			e.printStackTrace();
			return;
		}
		if (connection != null) 
		{
			System.out.println("Connection successful.");
		}
		else 
		{
			System.err.println("Failed to make connection!");
		}
		Statement stmtSchema=null;
		try 
		{
			stmtSchema=connection.createStatement();
			String sUpdate="SET search_path = gugym";
			stmtSchema.executeUpdate(sUpdate);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void dbDisconnect()
	{
		try {
			connection.close();
			System.out.println("\r\nConnection closed");
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Connection could not be closed – SQL exception");
		}
	}

	public String getCourses()
	{
		String getCourses ="";
		Statement stmtCourse=null;
		String cQuery="SELECT*FROM courses";
		try
		{
			stmtCourse=connection.createStatement();
			ResultSet rsc = stmtCourse.executeQuery(cQuery);

			String display = ("Displaying Course Information: \r\n");

			while(rsc.next())
			{
				int course_id = rsc.getInt("courseid");
				String cName = rsc.getString("name");
				String cCost = rsc.getString("cost");
				int cPlaces = rsc.getInt("places");
				String num = ("Course Number: " + course_id + " ");
				String name = ("Name: " + cName + " ");
				String cost = ("Price: " + cCost + " ");
				String places = (" Max Places: " + cPlaces + "\r\n");
				getCourses = getCourses + num + " " + name + " " + cost + " " + places;
			}
			getCourses = display + getCourses;
		}
		catch (SQLException e ) 
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"error executing query " + cQuery);
		}
		System.out.println(getCourses);
		return getCourses;


	}

	public String getCourseInstructors()
	{
		String instructors ="";
		Statement stmtInstructors=null;
		String iQuery="SELECT instructors.fname,instructors.sname,instructors.qualificationlevel,instructors.email, courses.name\r\n" + 
				"FROM instructors\r\n" + 
				"INNER JOIN courses\r\n" + 
				"ON instructors.staffid=courses.instructor";
		try
		{
			stmtInstructors=connection.createStatement();
			ResultSet rsi = stmtInstructors.executeQuery(iQuery);

			String display = ("\r\nDisplaying Course Instructors: \r\n");

			while(rsi.next())
			{
				String ins_fname = rsi.getString("fname");
				String ins_sname = rsi.getString("sname");
				String ins_course = rsi.getString("name");
				String ins_level = rsi.getString("qualificationlevel");
				String ins_email = rsi.getString("email");

				String name = ("Instructor: " + ins_fname + " " + ins_sname + " ");
				String course = (" Course: " + ins_course + " ");
				String level = (" Level: " + ins_level + " ");
				String email = (" Email: " + ins_email + "\r\n");
				instructors = instructors + name + " " + course + " " + level + " " + email;
			}
			instructors = display + instructors + " \r\n";
		}
		catch (SQLException e ) 
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"error executing query " + iQuery);
		}
		return instructors;
	}

	public String getCourseBookings()
	{
		String cBookings = "";
		Statement stmtBookings=null;
		String bQuery="SELECT DISTINCT courses.name, COUNT (bookings.course)\r\n" + 
				"FROM courses\r\n" + 
				"LEFT JOIN bookings on courses.courseid = bookings.course\r\n" + 
				"GROUP BY name";
		try
		{
			stmtBookings=connection.createStatement();
			ResultSet rsb = stmtBookings.executeQuery(bQuery);

			String display = ("\r\nDisplaying Course Booking Numbers: \r\n");

			while(rsb.next())
			{
				String bk_name = rsb.getString("name");
				int bk_count = rsb.getInt("count");

				String booking = ("Course: " + bk_name + " Bookings: " + bk_count + "\r\n ");
				cBookings = cBookings + booking;
			}
			cBookings = display + cBookings;
		}
		catch (SQLException e ) 
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"error executing query " + bQuery);
		}
		return cBookings;
	}

	public String getMemberBookings()
	{
		String mBookings = "";
		Statement stmtMBookings=null;
		String mbQuery="SELECT bookingref, m.fname, m.sname, m.memberid, c.name\r\n" + 
				"FROM bookings AS b\r\n" + 
				"INNER JOIN members AS m on b.member= m.memberid \r\n" + 
				"INNER JOIN courses AS c on b.course = c.courseid\r\n" + 
				"GROUP BY memberid, bookingref,c.name";
		try
		{
			stmtMBookings=connection.createStatement();
			ResultSet rsmb = stmtMBookings.executeQuery(mbQuery);

			String display = ("\r\nDisplaying Member Bookings: \r\n");

			while(rsmb.next())
			{
				int mbk_ref = rsmb.getInt("bookingref");
				String mbk_fname = rsmb.getString("fname");
				String mbk_sname = rsmb.getString("sname");
				int mbk_id = rsmb.getInt("memberid");
				String mbk_cname = rsmb.getString("name");


				String ref = ("Booking Ref: " + mbk_ref + " ");
				String name = ("Member Name: " + mbk_fname + " " + mbk_sname +" ");
				String id = ("Member ID: " + mbk_id+" ");
				String course = ("Course: " +mbk_cname+ " ");
				mBookings = mBookings +  ref + " " + name + " " + id + " " + course + " \r\n";
			}
			mBookings = display + mBookings;
		}
		catch (SQLException e ) 
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"error executing query " + mbQuery);
		}
		return mBookings;
	}

	public String makeBooking(int memID, int cNum)
	{
		String booking = "";
		String ref = memID + "" + cNum;
		int refs = Integer.parseInt(ref);
		Statement bookstmt=null;
		int membID = memID;
		int crseNum = cNum;

		String bookingUpdate = "INSERT INTO Bookings(bookingRef,member,course)\r\n" + 
				"	VALUES("+refs+","+membID+","+crseNum+")";

		try 
		{
			bookstmt=connection.createStatement();
			bookstmt.executeUpdate(bookingUpdate);
			JOptionPane.showMessageDialog(null, "Booking successful.");
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"error executing query " + bookingUpdate);
		}
		return booking;
	}
}
