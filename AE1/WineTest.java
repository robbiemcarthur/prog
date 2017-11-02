import javax.swing.*;
import java.io.*;
import java.util.*;


// class with main method to test wine class

public class WineTest 
{
	public static void main(String[] args) 
	{
		Wine tester = new Wine();
		
		String name = tester.getName();
		System.out.println(name);
		double price = tester.getPrice();
		System.out.println(price);
		int quantity = tester.getQuantity();
		System.out.println(quantity);
	}
}
