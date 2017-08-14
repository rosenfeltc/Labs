package lab5;

public class StackCalculatorException extends Exception
{
	// Field
	private String error;
	
	// Constructor
	public StackCalculatorException(int code)
	{
		// Use the passed in parameter code to update the String error to the appropriate message to display
		switch(code)
		{
			case 1: // Empty Stack exception
				error = "ERROR! Empty Stack! Resetting!";
				break;
				
			case 2: // Not enough arguments exception
				error = "ERROR! Not enough arguments! Resetting!";
				break;
				
			case 3: // Division by zero exception
				error = "ERROR! Division by Zero! Resetting!";
				break;
		}
	}
	
	// Error Getter for the Calculator.java class to display any potential thrown errors
	public String getError()
	{
		return error;
	}
}
