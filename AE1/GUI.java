import javax.swing.*;
import java.awt.*;

public class GUI 
{
	public static void main (String[] args) 
	{
		// frame + component (button)
		JFrame myFrame = new JFrame();
		JButton myButton = new JButton("Click me!");
		
		// frame layout
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.add(myButton);
		myFrame.setSize(1500, 1500);
		myFrame.setVisible(true);
	}	
}
