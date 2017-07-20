package lab1;

import javax.swing.JOptionPane;
import java.util.Random;
public class Sudoku 
{
	private int[][] puzzle;
	
	public Sudoku()
	{
		// Java automatically sets all elements in the array to 0 when initialized
		puzzle = new int[9][9];
	}
	
	public void initialize()
	{
		int[][]game =
			{
					{1, 2, 3, 4, 5, 6, 7, 8, 9},
					{4, 5, 6, 7, 8, 9, 1, 2, 3},
					{7, 8, 9, 1, 2, 3, 4, 5, 6},
					{2, 3, 1, 5, 6, 4, 9, 7, 8},
					{5, 6, 4, 9, 7, 8, 2, 3, 1},
					{9, 7, 8, 2, 3, 1, 5, 6, 4},
					{3, 1, 2, 6, 4, 5, 8, 9, 7},
					{6, 4, 5, 8, 9, 7, 3, 1, 2},
					{8, 9, 7, 3, 1, 2, 6, 4, 5},
			};
		
		puzzle = game;
	}
	
	public void randomize(int n)
	{
		final int upperBound = 9;
		int randomNumber1;
		int randomNumber2;
		int index = 0;
		Random generator = new Random();
		
		while(index < n)
		{
			// Obtain the two random variables from 1 to 9
			randomNumber1 = generator.nextInt();
			randomNumber1 = Math.abs(randomNumber1);
			randomNumber1 %= upperBound;
			randomNumber1 += 1;
			
			randomNumber2 = generator.nextInt();
			randomNumber2 = Math.abs(randomNumber1);
			randomNumber2 %= upperBound;
			randomNumber2 += 1;
			
			for(int i = 0; i < 9; i++)
			{
				for(int j = 0; j < 9; j++)
				{
					if(puzzle[i][j] == randomNumber1)
					{
						puzzle[i][j] = randomNumber2;
					}
					else if(puzzle[i][j] == randomNumber2)
					{
						puzzle[i][j] = randomNumber1;
					}
				}
			}
			index++;
		}
	}
	
	public void generate(int n, String difficulty)
	{
		int start = 0;
		int index = 0;
		int randomNumber;
		Random generator = new Random(n);
		
		switch(difficulty)
		{
		case "solved":
			index = 0;
			break;
		case "very easy":
			index = 18;
			break;
		case "easy":
			index = 27;
			break;
		case "normal":
			index = 36;
			break;
		case "hard":
			index = 45;
			break;
		case "very hard":
			index = 63;
			break;
		default:
			JOptionPane.showMessageDialog(null, "Invalid Difficulty entered. Game will now exit!");
			System.exit(1);
			break;
		}
		
		while(start < index)
		{
			for(int i = 0; i < 9; i++)
			{
				for(int j = 0; j < 9; j++)
				{
					// Bounded random goes from 0 inclusive to parameter exclusive
					randomNumber = generator.nextInt(9);
					if(start >= index)
					{
						break;
					}
					if (j == randomNumber && puzzle[i][j] != 0)
					{
						puzzle[i][j] = 0;
						start++;
					}
				}
			}
		}
	}
	
	public void launch()
	{
		String game = "";
		
		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				if(puzzle[i][j] == 0)
				{
					game += "[] ";
				}
				else
				{
					game += puzzle[i][j] + " ";
				}
			}
			game += "\n";
		}
		
		JOptionPane.showMessageDialog(null, game);
	}
	
	public static void main(String[] args)
	{
		int id = Integer.parseInt(JOptionPane.showInputDialog("Please enter an ID number (number must be from 1 to 10,000,000)"));
		String difficulty = JOptionPane.showInputDialog("Please specify the difficulty of the game:\n Choose among: 'solved', 'very easy', 'easy', 'normal', 'hard', or 'very hard'.");
		difficulty = difficulty.toLowerCase();
		Sudoku game = new Sudoku();
		game.initialize();
		game.randomize(id);
		game.generate(id, difficulty);
		game.launch();
		
	}
}
