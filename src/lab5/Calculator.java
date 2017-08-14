package lab5;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Calculator
{
	// Fields
	JTextField calculatorDisplay;
	JTextArea stackDisplay;
	JButton push, add, subtract, multiply, divide, clear, exit;
	JPanel top, center, bottom;
	JFrame calculator, stackWindow;
	String display;
	boolean isWrong;
	
	// Constructor
	public Calculator(Stack theStack)
	{
		// Instantiate variables
		calculatorDisplay = new JTextField();
		calculatorDisplay.setPreferredSize(new Dimension(100, 50));
		stackDisplay = new JTextArea();
		stackDisplay.setPreferredSize(new Dimension(100, 400));
		stackDisplay.setEditable(false);
		push = new JButton("Push");
		add = new JButton("+");
		subtract = new JButton("-");
		multiply = new JButton("*");
		divide = new JButton("\u00F7");
		clear = new JButton("Clear Stack");
		exit = new JButton("Exit");
		top = new JPanel();
		display = new String();
		isWrong = false;
		
		// Panels with their respective buttons
		// Top
		top.add(calculatorDisplay);
		top.add(push);
		
		//Center
		center = new JPanel();
		center.add(add);
		center.add(subtract);
		center.add(multiply);
		center.add(divide);
		
		// Bottom
		bottom = new JPanel();
		bottom.add(clear);
		bottom.add(exit);
		
		// Button Actions
		push.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				isWrong = false;
				display = calculatorDisplay.getText();
				calculatorDisplay.setText("");
				double value = 0.0;
				 try
				 {
					 value = Double.parseDouble(display);
				 }
				 catch(Exception problem)
				 {
					 isWrong = true;
				 }
				 
				 if(display.isEmpty() || isWrong)
				 {
					 JOptionPane.showMessageDialog(null, "Must input a number!");
				 }
				 else
				 {
					 theStack.push(value);
					 stackDisplay.setText(theStack.display());
				 }	
			}
		});
		
		add.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					JOptionPane.showMessageDialog(null, "The answer is " + theStack.operation(1));
					stackDisplay.setText(theStack.display());
				}
				catch (StackCalculatorException problem)
				{
					JOptionPane.showMessageDialog(null, problem.getError());
				}
			}
		});
		
		subtract.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					JOptionPane.showMessageDialog(null, "The answer is " + theStack.operation(2));
					stackDisplay.setText(theStack.display());
				}
				catch (StackCalculatorException problem)
				{
					JOptionPane.showMessageDialog(null, problem.getError());
				}
			}
		});
		
		multiply.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					JOptionPane.showMessageDialog(null, "The answer is " + theStack.operation(3));
					stackDisplay.setText(theStack.display());
				}
				catch (StackCalculatorException problem)
				{
					JOptionPane.showMessageDialog(null, problem.getError());
				}
			}
		});
		
		divide.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					JOptionPane.showMessageDialog(null, "The answer is " + theStack.operation(4));
					stackDisplay.setText(theStack.display());
				}
				catch (StackCalculatorException problem)
				{
					JOptionPane.showMessageDialog(null, problem.getError());
					stackDisplay.setText(theStack.display());
				}
			}
		});
		
		clear.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				theStack.clear();
				stackDisplay.setText(theStack.display());
			}
		});
		
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		
		// The two Windows
		calculator = new JFrame("Stack Calculator");
		calculator.setLocation(500, 500);
		calculator.setSize(300, 200);
		calculator.add(top, BorderLayout.PAGE_START);
		calculator.add(center, BorderLayout.CENTER);
		calculator.add(bottom, BorderLayout.PAGE_END);
		calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calculator.setVisible(true);
		
		stackWindow = new JFrame("Stack Display");
		stackWindow.setLocation(800, 500);
		stackWindow.setSize(100, 400);
		stackWindow.add(stackDisplay, BorderLayout.CENTER);
		stackWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		stackWindow.setVisible(true);
		
	}
}
