package lab2;

import javax.swing.JOptionPane;

public class Reverse 
{
	public static void main(String[] args)
	{
		// Obtain String from the user
		String theString = JOptionPane.showInputDialog("Please provide the string that you would like reversed: ");
		
		// Use recursive method to reverse the string and store it in new String
		String reversedString = reverseString(theString);
		
		// Display output to the user
		JOptionPane.showMessageDialog(null, "The string " + theString + " reversed is --> " + reversedString);
	}
	
	// Initialized method that creates a blank String where the reversed string will be stored
	public static String reverseString(String theString)
	{
		String reverseString = "";
		return reverseString(theString, reverseString);
	}
	
	// Recursive method that reverses a string by storing the last letter of theString as the next letter in the reverseString
	// at each call, then calls itself while passing theString minus its last letter, and the newly formed reverseString
	// The recursive call stops (base case) when theString has a length of 0 (empty string).
	public static String reverseString(String theString, String reverseString)
	{
		if(theString.length() == 0)
		{
			return reverseString;
		}
		reverseString += theString.charAt(theString.length() - 1);
		return reverseString(theString.substring(0, theString.length() - 1), reverseString);
	}
}
