package lab2;

import javax.swing.JOptionPane;

public class Factorial 
{
	public static void main(String[] args)
	{
		// Obtain number from the user that we want to calculate factorial for and store it in n
		int n = Integer.parseInt(JOptionPane.showInputDialog("Please provide the number that you want me to calculate the factorial of: "));
		
		// Calculate factorial with method and display the answer to the user
		JOptionPane.showMessageDialog(null, n + "! = " + factorial(n));
	}
	
	// Method to calculate the result of factorial recursively since we know for example
	// 6! = 6 * 5! etc...
	public static int factorial(int n)
	{
		if(n == 0)
		{
			return 1;
		}
		return n * factorial(n - 1);
	}
}
