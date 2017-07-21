package lab2;

import javax.swing.JOptionPane;

public class Pairs 
{
	public static void main(String[] args)
	{
		// Obtain the string from the user
		String theString = JOptionPane.showInputDialog("Please provide a string that you would like me to check pairs for ");
		
		// Calculate and store the number of pairs from the user provided string with method
		int pairs = checkPairs(theString);
		
		// If else statement to return the proper singular or plural of pair/s
		if(pairs == 1)
		{
			JOptionPane.showMessageDialog(null, "The string " + theString + " has " + pairs + " pair in it.");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "The string " + theString + " has " + pairs + " pairs in it.");
		}
			
	}
	
	// Method that calculates the number of pairs, since a pair in this definition involves a letter matching the letter
	// after the subsequent letter, then there are no possible pairs after the string is a length of 2 or less
	// Method checks the first letter of a string for a pair possibility and then recursively calls itself with the string
	// removed from its first letter. i.e. cats --> ats
	public static int checkPairs(String theString)
	{
		if(theString.length() <= 2)
		{
			return 0;
		}
		else
		{
			if(theString.charAt(0) == theString.charAt(2))
			{
				return 1 + checkPairs(theString.substring(1, theString.length()));
			}
			else
			{
				return 0 + checkPairs(theString.substring(1, theString.length()));
			}
		}
	}
}
