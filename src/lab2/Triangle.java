/* I spent 30+ minutes trying to figure out how to calculate Pascal's Triangle recursively and I just can't figure it out so I did it
 * iteratively.
 */
package lab2;

import javax.swing.JOptionPane;

public class Triangle 
{
	// Pascal's triangle can be configured as a 2D matrix
	int[][] triangle;
	
	// Constructor to initialize the triangle based on the number of rows inputted by the user
	public Triangle(int n)
	{
		triangle = new int[n][n];
	}
	
	// Method that establishes the 1s on the left side of the triangle for further calculation
	public void initialize()
	{
		for(int i = 0; i < triangle.length; i++)
		{
			triangle[i][0] = 1;
		}
	}
	
	// Calculates pascal's triangle for each number by adding up the two numbers "above" it
	public void calculate()
	{
		for(int i = 1; i < triangle.length; i++)
		{
			for(int j = 1; j < triangle[0].length; j++)
			{
				triangle[i][j] = triangle[i-1][j] + triangle[i-1][j-1];
			}
		}
	}
	
	// Method to store the calculated pascal's triangle as a string
	public String getString()
	{
		String pascal = "";
		for(int i = 0; i < triangle.length; i++)
		{
			for(int j = 0; j < triangle[0].length; j++)
			{
				if(triangle[i][j] == 0)
				{
					pascal += " ";
				}
				else
				{
					pascal += triangle[i][j];
				}
			}
			
			pascal += "\n";
		}
		
		return pascal;
	}
	
	public static void main(String[] args)
	{
		// Obtain the number of rows for pascal's triangle from the user
		int n = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of rows in your Pascal's Triangle: "));
		
		Triangle pascal = new Triangle(n);
		
		// Prepare pascal's triangle
		pascal.initialize();
		
		// Calculate pascal's triangle
		pascal.calculate();
		
		// Display pascal's triangle after receiving the string from the getString() method
		JOptionPane.showMessageDialog(null, pascal.getString());	
	}
}
