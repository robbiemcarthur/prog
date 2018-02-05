import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.sql.*;

public class GuGymGUI extends JFrame implements ActionListener {
	// GUI components
	private JPanel top, bottom;
	private JTextField memberIdField, courseIdField;
	private JButton booking, viewCourses, viewInstructors,
	viewCBookings,viewMBookings, refresh;
	private JLabel memberIdLabel, courseIdLabel;
	
	// Database connection
	private DbConnect connectDB;
	private Connection connect = null;
	
	// constants set for default font and frame height/width
	private final int FRAME_HEIGHT, FRAME_WIDTH;
	private final Font _FONT;	

	public GuGymGUI() 
	{	
		// initialise instance variables (NON-GUI Components)
		FRAME_WIDTH = 1200;
		FRAME_HEIGHT = 600;
		Font font = new Font("Verdana", Font.BOLD, 18);
		_FONT = font;

		// set initial layout and contents of JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setTitle("Glasgow University Gym Booking System");
		setLayout(new GridLayout(3, 1));

		//call helper method to set layout of components
		setLayout();
	}

	private void setLayout()
	{
		// below methods create and add relevant JPanels to JFrame
		topPanel();
		bottomPanel();
		//		bottomPanel();
	}
	private void topPanel()
	{
		//create labels and corresponding text fields for member/course ID

		// member
		memberIdLabel = new JLabel("Member ID: ");
		memberIdLabel.setFont(_FONT);

		memberIdField = new JTextField(10);
		memberIdField.addActionListener(this);
		memberIdField.setFont(_FONT);

		// course
		courseIdLabel = new JLabel("Course Number: ");
		courseIdLabel.setFont(_FONT);


		courseIdField = new JTextField(10);
		courseIdField.addActionListener(this);
		courseIdField.setFont(_FONT);

		// create the top panel and set background color to gray to enhance 
		// visibility for user
		top = new JPanel();
		top.setBackground(Color.gray);

		// add each component in appropriate order to top JPanel
		top.add(memberIdLabel);
		top.add(memberIdField);
		top.add(courseIdLabel);
		top.add(courseIdField);

		// add top JPanel to JFrame
		add(top);
	}

	private void bottomPanel()
	{
		// first create the middle panel and set new grid layout
		// the upper and lower middle panels will go on to this
		bottom = new JPanel();
		bottom.setLayout(new GridLayout(2,1));

		//UPPER MIDDLE JLABEL - Contains sale/return buttons

		// creating components (sales/return buttons) and placing on upper mid panel
		// an action listener is added to each button
		booking = new JButton("Make Booking");
		booking.setBackground(Color.LIGHT_GRAY);
		booking.addActionListener(this);
		booking.setFont(_FONT);
		
		JPanel uBottom = new JPanel();
		uBottom.add(booking);
		bottom.add(uBottom);

		viewCourses = new JButton("View Courses");
		viewCourses.setBackground(Color.LIGHT_GRAY);
		viewCourses.addActionListener(this);
		viewCourses.setFont(_FONT);

		viewInstructors = new JButton("View Instructors");
		viewInstructors.setBackground(Color.LIGHT_GRAY);
		viewInstructors.addActionListener(this);
		viewInstructors.setFont(_FONT);

		viewCBookings = new JButton("View Course Bookings");
		viewCBookings.setBackground(Color.LIGHT_GRAY);
		viewCBookings.addActionListener(this);
		viewCBookings.setFont(_FONT);

		viewMBookings = new JButton("View Member Bookings");
		viewMBookings.setBackground(Color.LIGHT_GRAY);
		viewMBookings.addActionListener(this);
		viewMBookings.setFont(_FONT);
		
		refresh = new JButton("Refresh");
		refresh.setBackground(Color.LIGHT_GRAY);
		refresh.addActionListener(this);
		refresh.setFont(_FONT);
		
		JPanel lBottom = new JPanel();
		lBottom.add(viewCourses);
		lBottom.add(viewInstructors);
		lBottom.add(viewCBookings);
		lBottom.add(viewMBookings);
		lBottom.add(refresh);
		bottom.add(lBottom);

		// Add full middle panel to JFrame
		add(bottom);
	}





	public void actionPerformed(ActionEvent e) 
	{
		connectDB = new DbConnect();
		if(e.getSource()==viewCourses)
		{
			String courses = connectDB.getCourses();
			JOptionPane.showMessageDialog(null, courses);
		}
		
		if(e.getSource()==viewInstructors)
		{
			String instructors = connectDB.getCourseInstructors();
			JOptionPane.showMessageDialog(null, instructors);
		}
		
		if(e.getSource()==viewCBookings)
		{
			String cBookings = connectDB.getCourseBookings();
			JOptionPane.showMessageDialog(null, cBookings);
		}
		
		if(e.getSource()==viewMBookings)
		{
			String mBookings = connectDB.getMemberBookings();
			JOptionPane.showMessageDialog(null, mBookings);
		}
		
		if(e.getSource()==refresh)
		{
			memberIdField.setText(null);
			courseIdField.setText(null);
			top.repaint();
			top.revalidate();
			bottom.revalidate();
		}
		
		if(e.getSource()==booking)
		{
			int memID = Integer.parseInt(memberIdField.getText());
			int cNum = Integer.parseInt(courseIdField.getText());
			
			if(memID <0 || memID>300)
			{
				JOptionPane.showMessageDialog(null, "ID not valid, either incorrect or too many members.",
						"Warning", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				connectDB.makeBooking(memID, cNum);
				JOptionPane.showMessageDialog(null,  booking);
			}
		}
		

	}

}
