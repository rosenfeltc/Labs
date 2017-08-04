/* This is the Lab3 class which runs the main method that calls on the different static methods that implement the different options
 * that are available to the user. This class also uses the LinkedList class to perform operations on the list and the Window class to 
 * display information in a new window.
 * Coded by Christopher Rosenfelt for CSI 213
 */

package lab3;

// Import the necessary libraries/packages
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Lab3 
{
	// Create the List object that will be used to store the information from a File into a linked list
	static LinkedList theList = new LinkedList();
	// Create a String array holding the available options for the user - to be used with JPane's option Dialog
	static final String[] OPTIONS = {"Open File", "Display List", "Search", "Exit"};
	
	// Main method, just calls the main menu method, this will allow certain selections to loop
	// back to the main menu
	public static void main(String[] args)
	{
		mainMenu();
	}
	
	// Main menu method that optains a selection from the user and then uses switch to either execute the selection
	// or call the appropriate static method that will execute the selection
	public static void mainMenu()
	{
		int selection = JOptionPane.showOptionDialog(null, "Please choose an option",
				"Main Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, OPTIONS, 0);
		
		switch(selection)
		{
			case 0:
				loadFile();
				break;
			case 1:
				displayList();
				break;
			case 2:
				searchList();
				break;
			case 3:
				System.exit(0);
				break;
		}
	}
	
	// Method that loads a CSV-type File selected by the user, obtains the two strings from each line in the File and passes
	// them as parameters to the add method of linked list which will create the Node for each line and link them together
	public static void loadFile()
	{
		JFileChooser fileChooser = new JFileChooser();
		// Show only .csv files for the user's selection
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Comma Separated Value", "csv");
		fileChooser.setFileFilter(filter);
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		JOptionPane.showMessageDialog(null, "Please select the CSV-type file from the correct directory");
		fileChooser.showOpenDialog(fileChooser);
		
		// Reference the selected file by the user
		File openFile = fileChooser.getSelectedFile();
		// This will hold the name and phone number of each line from the File
		String[] data = new String[2];
		
		try
		{
			// Use scanner to read each line from the file
			Scanner fileScanner = new Scanner(openFile);
			
			while(fileScanner.hasNextLine())
			{
				// use String splitter to create two strings, name and phone number
				data = fileScanner.nextLine().split(",");
				theList.add(data[0], data[1]);
			}
			
			fileScanner.close();
		}
		// Catch any potential errors when trying to use Scanner to read the file
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(null, "Unable to open File! Exiting program...");
			System.exit(0);
		}
		
		mainMenu();
	}
	
	// Display the list in a new window
	public static void displayList()
	{
		Window window = new Window(theList.toString());
	}
	
	// Search the list for the name of the person that the user provided, if found, return
	// that person's phone number
	public static void searchList()
	{
		String toSearch = JOptionPane.showInputDialog(null,"Please provide the name of the person whose phone number you want");
		// If the LinkedList search method returns the string 'no' then the name was not found in the list
		boolean isAndrew = toSearch.equalsIgnoreCase("andrew");
		
		if(theList.search(toSearch).equalsIgnoreCase("no"))
		{
			JOptionPane.showMessageDialog(null, toSearch + " was nout found in the list!");
		}
		else
		{
			// Is the search for Andrew?
			if(isAndrew)
			{
				Window specialWindow = new Window(1);
				JOptionPane.showMessageDialog(null, toSearch + "'s phone number: " + theList.search(toSearch));
				return;
			}
			else
			{
				JOptionPane.showMessageDialog(null, toSearch + "'s phone number: " + theList.search(toSearch));
			}
		}
		
		mainMenu();
	}
}
