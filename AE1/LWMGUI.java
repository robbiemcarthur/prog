import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


/*
 * Ensure comments throughout project code, every class should have a description before it
 * multi line
 * like this
 * DO NOT FORGET!!!!!!!
 */
public class LWMGUI extends JFrame implements ActionListener
{
	// components as instance variables
	private JPanel top, middle, bottom;
	private JTextField nameField, quantityField, priceField, transactionField, balanceField, wineField;
	private JButton sale, rtn;
	private JLabel nameLabel, quantityLabel, priceLabel, wineLabel, transactionLabel, balanceLabel;

	//create JFrame GUI
	public LWMGUI() 
	{
		// set initial layout and contents of JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,300);
		setTitle("Lilybank Wine Merchants");
		setLayout(new GridLayout(3, 1));
		
		//call helper method to determine layout of components
		setLayout();
	}
	
	private void setLayout()
	{
		// call helper methods to add panels
		topPanel();
		midPanel();
		bottomPanel();
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if (event.getSource()==sale)
			System.out.println("sale was clicked.");
		else if (event.getSource()==rtn)
			System.out.println("Return was clicked");
	}

	//create components using helper methods

	//creating top panel containing JLabels and JTextFields for name, quantity, price
	private void topPanel()
	{
		//create label and corresponding text fields for name, quantity, price
		nameLabel = new JLabel("Name: ");
		nameField = new JTextField(15);
		quantityLabel = new JLabel("Quantity: ");
		quantityField = new JTextField(15);
		priceLabel = new JLabel("Price: �");
		priceField = new JTextField(15);
		
		// create top panel and set background color to green
		top = new JPanel();
		top.setBackground(Color.gray);
		
		// add components to top JPanel
		top.add(nameLabel);
		top.add(nameField);
		top.add(quantityLabel);
		top.add(quantityField);
		top.add(priceLabel);
		top.add(priceField);

		// add top JPanel to JFrame and position North using BorderLayout
		add(top);
	}

	//creating middle panel containing two JPanels
	private void midPanel()
	{
		//first create the middle panel with borderlayout
		// the upper and lower middle panels will go on to this
		middle = new JPanel();
		middle.setLayout(new GridLayout(2,1));
		
		//UPPER MIDDLE JLABEL
		// add button listener
	

		// creating components (sales/return buttons) and placing on upper mid panel
		sale = new JButton("Process Sale");
		sale.setBackground(Color.green);
		sale.addActionListener(this);
		
		rtn = new JButton("Process Return");
		rtn.setBackground(Color.red);
		rtn.addActionListener(this);
		
		JPanel uMiddle = new JPanel();
		uMiddle.setBackground(Color.LIGHT_GRAY);
		
		
		uMiddle.add(sale);
		uMiddle.add(rtn);
		middle.add(uMiddle);
		
		// LOWER MIDDLE JLABEL

		// creating components (wine label/textfields) and placing on lower mid panel
		
		//components
		wineLabel = new JLabel("Wine purchased: ");
		wineField = new JTextField(20);
		wineField.setBackground(Color.white);
		
		//JPanel
		JPanel lMiddle = new JPanel();
		lMiddle.setBackground(Color.white);
		
		// add components to panel and position
		lMiddle.add(wineLabel);
		lMiddle.add(wineField);


		
		middle.add(lMiddle);

		//add full middle panel to JFrame and position in center 
		add(middle);
	}

	//creating bottom panel containing amount of transaction/current balance

	private void bottomPanel()
	{
		//creating components first

		// creating JLabel/JTextField for Amount of Transaction/Current Balance
		transactionLabel = new JLabel("Amount of Transaction: ");
		transactionField = new JTextField(15);
		balanceLabel = new JLabel("Current Balance: ");
		balanceField = new JTextField(15);
		
		
		bottom = new JPanel();
		bottom.setBackground(Color.white);
		
		
		bottom.add(transactionLabel);
		bottom.add(transactionField);
		bottom.add(balanceLabel);
		bottom.add(balanceField);
		
		add(bottom);
	}
}






// label


// textfields2




