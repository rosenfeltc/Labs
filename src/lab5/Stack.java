package lab5;

public class Stack
{
	// Fields
	private Node top;
	private int size;
	
	// Constructor
	public Stack()
	{
		top = null;
		size = 0;
	}
	
	// Push Method
	public void push(double data)
	{
		Node newNode = new Node(data);
		
		if(size == 0)
		{
			top = newNode;
		}
		else
		{
			newNode.setNext(top);
			top = newNode;
		}
		
		size++;
	}
	
	// Pop Method
	public double pop() throws StackCalculatorException
	{
		if(size == 0)
		{
			throw new StackCalculatorException(1);
		}
		
		double temp = top.getData();
		
		top = top.getNext();
		size--;
		
		return temp;
		
	}
	
	// Operation Method
	public double operation(int operand) throws StackCalculatorException
	{
		if (size == 0)
		{
			throw new StackCalculatorException(1);
		}
		
		double arg1, arg2;
		
		switch(operand)
		{
			case 1:
				if(size == 1)
				{
					throw new StackCalculatorException(2);
				}
				return pop() + pop();
			case 2:
				if(size == 1)
				{
					throw new StackCalculatorException(2);
				}
				arg2 = pop();
				arg1 = pop();
				
				return arg1 - arg2;
			case 3:
				if(size == 1)
				{
					throw new StackCalculatorException(2);
				}
				return pop() * pop();
			case 4:
				if(size == 1)
				{
					throw new StackCalculatorException(2);
				}
				arg2 = pop();
				
				if(arg2 == 0.0)
				{
					throw new StackCalculatorException(3); 
				}
				arg1 = pop();
				
				return arg1 / arg2;
		}
		
		// Will never reach here
		return 0.0;
	}
	
	// Display Method
	public String display()
	{
		if(size == 0)
		{
			return "Stack is Empty.";
		}
		
		String content = "--->";
		Node traverser = top;
		content += traverser.getData();
		traverser = traverser.getNext();
		
		while(traverser != null)
		{
			content += "\n      " + traverser.getData();
			traverser = traverser.getNext();
		}
		
		return content;
		
	}
	
	// Clear Stack Method
	public void clear()
	{
		top = null;
		size = 0;
	}
	private class Node
	{
		// Fields
		private double data;
		private Node next;
		
		// Constructor
		private Node(double data)
		{
			this.data = data;
			next = null;
		}
		
		// Data Getter
		private double getData()
		{
			return data;
		}
		
		// Next Getter
		private Node getNext()
		{
			return next;
		}
		
		// Node Setter
		private void setNext(Node next)
		{
			this.next = next;
		}
	}
}
