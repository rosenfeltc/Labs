/* This is the Window class that extends JFrame to show information in a Window
 * Coded by Christopher Rosenfelt for CSI 213
 */
package lab3;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Window extends JFrame 
{
	public Window(String list)
	{
		JTextArea text = new JTextArea(list);
		JScrollPane scrollPane = new JScrollPane(text);
		
		setSize(500, 500);
		setTitle("The list!");
		add(scrollPane);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	public Window(int number)
	{
		String text = "<html><body><br><img src=\"http://andrewboggio.com/andrew.jpg\"></img></body></html>";
		JLabel theLabel = new JLabel (text, JLabel.CENTER);
		setSize(1000, 1000);
		setTitle("The list!");
		add(theLabel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
}