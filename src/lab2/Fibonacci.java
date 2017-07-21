package lab2;

import javax.swing.JOptionPane;

public class Fibonacci 
{
	public static void main(String[] args)
	{
		// Obtain the number for the fibonacci sequence as a string
		String fib = JOptionPane.showInputDialog("Please provide the number you would like me to display the Fibonacci sequence up to: ");
		
		// Display the fibonacci sequence
		JOptionPane.showMessageDialog(null, fibonacci(fib));
	}
	
	// Method that obtains the fibonacci number as a string and parses it as an int to use it as the maximum of our while loop
	// meanwhile inside the while loop, our previously created empty string is adding the result of our recursive fibonacci method that
	// takes an integer
	public static String fibonacci(String n)
	{
		String theString = "";
		int index = 0;
		int number = Integer.parseInt(n);
		
		// Only up to the number provided for the fibonacci sequence
		while(index < number)
		{
			// Call the recursive fibonacci method and store the result of each iteration as a string in theString
			theString += fibonacci(index) + " ";
			index++;
		}
		
		return theString;
	}
	
	// Recursive fibonacci method that takes an int n and returns the fibonacci result recursively with the use of the base cases of
	// n == 0 -> 0 and n == 1 -->
	public static int fibonacci(int n)
	{
		if(n == 0)
		{
			return 0;
		}
		else if(n == 1)
		{
			return 1;
		}
		else
		{
			return fibonacci(n - 2) + fibonacci(n - 1);
		}
	}
}
