import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/*
 * LWMGUI Class: VIEW / CONTROLLER
 * 
 * VIEW: This class provides the layout for Graphical User Interface objects.
 * 
 * CONTROLLER: This class provides the functionality to carry out tasks
 * which process or return bottles of wine depending on whether the sale or
 * return button is clicked. 
 */
@SuppressWarnings("serial")
public class LWMGUI extends JFrame implements ActionListener
{
	// declare instance variables
	// GUI components
	private JPanel top, middle, bottom;
	private JTextField nameField, quantityField, priceField, transactionField, balanceField, wineField;
	private JButton sale, rtn;
	private JLabel nameLabel, quantityLabel, priceLabel, wineLabel, transactionLabel, balanceLabel;
	// instance variables used throughout program: starting balance and customer account
	private String _sBalance;
	private CustomerAccount _customerAccount;
	// constants set for default font and frame height/width
	private final int FRAME_HEIGHT, FRAME_WIDTH;
	private final Font _FONT;	

	//VIEW METHODS
	//method to create JFrame GUI
	public LWMGUI(CustomerAccount cAccount) 
	{	
		// initialise instance variables (NON-GUI Components)
		FRAME_WIDTH = 1200;
		FRAME_HEIGHT = 600;
		Font font = new Font("Verdana", Font.BOLD, 18);
		_FONT = font;

		// cAccount passed from CustomerAccount stored assigned to instance variable
		// for use throughout GUI
		_customerAccount = cAccount;
		
		// call methods to take customers name and initial balance
		String customerName = _customerAccount.getHolder();
		double currentBalance = _customerAccount.getBalance();
		
		// pass first balance input to relevant method
		// sets initial balance as per user input
		getInitialBalance(currentBalance);

		// set initial layout and contents of JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setTitle("Lilybank Wine Merchants: " + customerName);
		setLayout(new GridLayout(3, 1));

		//call helper method to set layout of components
		setLayout();
	}

	private void setLayout()
	{
		// below methods create and add relevant JPanels to JFrame
		topPanel();
		midPanel();
		bottomPanel();
	}

	private void topPanel()
	{
		//create labels and corresponding text fields for name, quantity, price
		
		// NAME
		nameLabel = new JLabel("Name: ");
		nameLabel.setFont(_FONT);

		nameField = new JTextField(20);
		nameField.addActionListener(this);
		nameField.setFont(_FONT);

		// QUANTITY
		quantityLabel = new JLabel("Quantity: ");
		quantityLabel.setFont(_FONT);


		quantityField = new JTextField(10);
		quantityField.addActionListener(this);
		quantityField.setFont(_FONT);

		// PRICE
		priceLabel = new JLabel("Price: £");
		priceLabel.setFont(_FONT);


		priceField = new JTextField(10);
		priceField.addActionListener(this);
		priceField.setFont(_FONT);


		// create the top panel and set background color to gray to enhance 
		// visibility for user
		top = new JPanel();
		top.setBackground(Color.gray);

		// add each component in appropriate order to top JPanel
		top.add(nameLabel);
		top.add(nameField);
		top.add(quantityLabel);
		top.add(quantityField);
		top.add(priceLabel);
		top.add(priceField);

		// add top JPanel to JFrame
		add(top);
	}

	//creating middle panel containing two JPanels
	private void midPanel()
	{
		// first create the middle panel and set new grid layout
		// the upper and lower middle panels will go on to this
		middle = new JPanel();
		middle.setLayout(new GridLayout(2,1));

		//UPPER MIDDLE JLABEL - Contains sale/return buttons

		// creating components (sales/return buttons) and placing on upper mid panel
		// an action listener is added to each button
		sale = new JButton("Process Sale");
		sale.setBackground(Color.green);
		sale.addActionListener(this);
		sale.setFont(_FONT);

		rtn = new JButton("Process Return");
		rtn.setBackground(Color.red);
		rtn.addActionListener(this);
		rtn.setFont(_FONT);

		// Create upper middle JPanel
		JPanel uMiddle = new JPanel();
		uMiddle.setBackground(Color.LIGHT_GRAY);

		// Add button components to JPanel
		uMiddle.add(sale);
		uMiddle.add(rtn);
		// Upper middle pannel is added to the middel JPanel
		middle.add(uMiddle);

		// LOWER MIDDLE JLABEL - Contains wine label and text field to display 
		// wine name input for each transaction

		// Creating components
		wineLabel = new JLabel(""); // empty until sale/process initialised
		wineLabel.setFont(_FONT);
		wineLabel.setBackground(Color.GRAY);


		wineField = new JTextField(20);
		wineField.setEditable(false); // input is set from the wine name input box
		wineField.setBackground(Color.LIGHT_GRAY);
		wineField.setFont(_FONT);


		// Create lower middle JPanel
		JPanel lMiddle = new JPanel();
		lMiddle.setBackground(Color.white);

		// Add components
		lMiddle.add(wineLabel);
		lMiddle.add(wineField);


		// Add lower middle JPanel to the middle panel
		middle.add(lMiddle);

		// Add full middle panel to JFrame
		add(middle);
	}

	// BOTTOM PANEL - Contains textfields and labels to display 
	// the amount of transaction and current balance

	private void bottomPanel()
	{
		//creating components
		transactionLabel = new JLabel("Amount of Transaction: ");
		transactionLabel.setFont(_FONT);

		transactionField = new JTextField(15);
		transactionField.setEditable(false);
		transactionField.setFont(_FONT);


		balanceLabel = new JLabel("Current Balance: ");
		balanceLabel.setFont(_FONT);


		balanceField = new JTextField(15);
		balanceField.setEditable(false);
		balanceField.setText(_sBalance);
		balanceField.setFont(_FONT);

		// Creating JPanel
		bottom = new JPanel();
		bottom.setBackground(Color.white);

		// Adding components to JPanel
		bottom.add(transactionLabel);
		bottom.add(transactionField);
		bottom.add(balanceLabel);
		bottom.add(balanceField);

		// Adding bottom JPanel to JFrame
		add(bottom);
	}


	// CONTROLLER METHODS
	
	// actionPerformed: method detects and event where the user clicks on of the two buttons.
	// It carries out wine transactions (sale or return depending on user input). 
	// Exception handlers are included to ensure user inputs information in correct format.
	
	public void actionPerformed(ActionEvent event)
	{
		// set variables for quantity/price and total
		int quantity =0;
		double price = 0;
		double t = 0;	
		
		String name = nameField.getText().trim();
		String q = quantityField.getText().trim();
		String p = priceField.getText().trim();
		
		// test wine input is not an empty string
		if (name.isEmpty())
			JOptionPane.showMessageDialog(null, "Please enter a valid wine name.", "Warning", JOptionPane.ERROR_MESSAGE);

		// try to parse strings to int/double types
		try
		{
			quantity = Integer.parseInt(q);
			price = Double.parseDouble(p);
		}
		// catch format errors occurring during conversion attempt 
		catch (NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null, "Please enter correct number format.", "Warning", JOptionPane.ERROR_MESSAGE);
			clearInput();
		}

		// New wine object created to provide information for calculations
		Wine newWine = new Wine(name, quantity, price);

		/*
		 * Below code processes a sale or transaction by calling the relevant method from 
		 * customer account, depending on which button is clicked.
		 * 
		 * Exception handling loop included: ensure wines purchased/returned cannot have a negative
		 * 
		 * In the event of such exception, error message displayed and input cleared.
		*/ 
		
		if (event.getSource()==sale) {
			if (price >0 && quantity >0)
			{
				t = _customerAccount.processSale(newWine);
				wineLabel.setText("Wine purchased: ");
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Please enter a positive number.", "Warning", JOptionPane.ERROR_MESSAGE);
				clearInput();
			}
		}
		else if (event.getSource()==rtn)
			if(price >0 && quantity >0)
			{
				t = _customerAccount.processReturn(newWine);
				wineLabel.setText("Wine returned: ");
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Please enter a positive number.", "Warning", JOptionPane.ERROR_MESSAGE);
				clearInput();
			}

		// format and display the wine name, updated balance and amount of transaction
		double total = _customerAccount.getBalance();
		String updatedBalance = getUpdatedBalance(total);
		String transaction = String.format("%.2f", t);

		transactionField.setText(transaction);
		wineField.setText(name);
		balanceField.setText(updatedBalance);
		
		// clear user input upon completion of sale/return
		clearInput();
	}	
	
	/*
	 * getInitialBalance sets initial balance in GUI.
	 * 
	 * Code ensures correct format and deals with negative input by displaying
	 * "CR" when customer is in credit
	 */
	private String getInitialBalance(double currentBalance){

		// test if balance positive/negative
		if (currentBalance <0)
		{
			// convert negative to positive
			currentBalance = currentBalance *-1;
			// format double to two decimal places
			_sBalance = String.format("%.2f", currentBalance);
			// add "CR" if customer in credit
			_sBalance = "CR " + currentBalance;
		}
		else
		{
			_sBalance = String.format("%.2f", currentBalance);
		}
		// balance returned in correct format
		return _sBalance;
	}

	/*
	 * getUpdatedBalance: returns updated balance to be displayed after sale/return
	 * 
	 * Formats and displays positive/negative balance accordingly
	 */
	private String getUpdatedBalance(double total) {
		String updatedBalance;

		if (total < 0)
		{
			// convert to positive value
			total = (total * -1);
			// format to 2 DP
			updatedBalance = String.format("%.2f", total);
			// Add CR if customer in credit
			updatedBalance = "CR " + updatedBalance;
		}
		else
		{
			updatedBalance = String.format("%.2f", total);
		}
		return updatedBalance;
	}

	/*
	 * clearInput: method clears the three text boxes used to take user input
	 * 
	 * Called after completion of transactions/occurrence of exceptions
	 */
	public void clearInput()
	{
		nameField.setText("");
		quantityField.setText("");
		priceField.setText("");
	}
}
