/* This is the LinkedList class which also contains the private Class node. It has all the necessary variables and methods to create a Linked
 * List and perform simple add, search and display operations.
 * Coded by Christopher Rosenfelt for CSI 213
 */
package lab3;

public class LinkedList 
{
	// Field for LinkedList
	private Node root;
	
	// Constructor, not necessary to be explicit but why not get the practice???
	public LinkedList()
	{
		root = null;
	}
	
	// Getter
	private Node getRoot()
	{
		return root;
	}
	
	// Setter
	private void setRoot(Node root)
	{
		this.root = root;
	}
	
	// Check if the list is empty and return true if it is or false if it's not
	private boolean isEmpty()
	{
		return root == null;
	}
	
	// Method that takes as parameters a String name and String number and uses the Node constructor to create a new node
	// which is then added to the front of the list
	public void add(String name, String number)
	{
		Node newNode = new Node(name, number);
		
		// Is the list empty?
		if(isEmpty())
		{
			setRoot(newNode);
		}
		// Otherwise add it to the beginning of the list
		// since there are no requirements to keep it in any specific order
		else
		{
			newNode.setNext(getRoot());
			setRoot(newNode);
		}
	}
	
	// Method that returns the list as a String
	public String toString()
	{
		Node traverse = getRoot();
		String list = new String();
		
		while(traverse != null)
		{
			list += traverse.getName() + ": " + traverse.getNumber() + "\n";
			traverse = traverse.getNext();
		}
		
		return list;
	}
	
	// Method that searches for the given name and return the number for that given name if found otherwise 
	// returns the String 'no'
	public String search(String name)
	{
		Node traverse = getRoot();
		
		while(traverse != null)
		{
			if(traverse.getName().equalsIgnoreCase(name))
			{
				return traverse.getNumber();
			}
			
			traverse = traverse.getNext();
		}
		
		return "no";
	}
	// Node class as a private class inside LinkedList
	private class Node
	{
		private String name;
		private String number;
		private Node next;
		
		// Constructor
		public Node(String name, String number)
		{
			this.name = name;
			this.number = number;
			next = null;
		}
		
		// Getter
		private String getName()
		{
			return name;
		}
		
		// Getter
		private String getNumber()
		{
			return number;
		}
		
		// Getter
		private Node getNext()
		{
			return next;
		}
		
		// Setter
		private void setNext(Node next)
		{
			this.next = next;
		}
	}
}
