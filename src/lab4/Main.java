package lab4;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Main
{
	// The user options
	final static String[] OPTIONS = {"Open File", "Search", "Print", "Exit"};
	// The binary tree
	static BinaryTree tree = new BinaryTree();
	
	// The main method
	public static void main(String[] args)
	{
		mainMenu();
	}
	// The mainMenu method
	public static void mainMenu()
	{
		int selection = JOptionPane.showOptionDialog(null, "Please choose one of the following",
				"Main Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, OPTIONS, 0);
		
		switch(selection)
		{
			case 0:
				openFile();
				break;
			case 1:
				search();
				break;
			case 2:
				print();
				break;
			case 3:
				System.exit(0);
				break;
		}
	}
	
	public static void openFile()
	{
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("text", "txt");
		fileChooser.setFileFilter(filter);
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		fileChooser.showOpenDialog(fileChooser);
		File toOpen = fileChooser.getSelectedFile();
		
		try
		{
			Scanner fileScanner = new Scanner(toOpen);
			
			while(fileScanner.hasNext())
			{
				String node = fileScanner.next();
				tree.insert(node);
			}
			
			fileScanner.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		mainMenu();
	}
	
	public static void search()
	{
		String word = JOptionPane.showInputDialog("Enter word to find");
		
		JOptionPane.showMessageDialog(null, word + " found: " + tree.search(word));
		
		mainMenu();
	}
	
	public static void print()
	{
		// Decided to use a JScrollPane since the JOptionPane show message was visibly restrictive
		JFrame window = new JFrame("Binary Search Tree:");
		JTextArea text = new JTextArea(tree.print());
		text.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(text);
		JButton mainMenu = new JButton("Main Menu");
		
		window.setLocation(800, 500);
		window.setSize(400, 400);
		window.add(scrollPane, BorderLayout.CENTER);
		window.add(mainMenu, BorderLayout.PAGE_END);
		window.setResizable(false);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		mainMenu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				window.dispose();
				mainMenu();
			}
		});
	}
}
