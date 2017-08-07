package lab4;

public class BinaryTree 
{
	private Node root;
	private int count; // Keep track of how many Nodes are in the tree
	private int arrayCount; // Keeps track of the position in the String array;
	
	// Explicit Constructor
	public BinaryTree()
	{
		this.root = null;
		this.count = 0;
		this.arrayCount = 0;
	}
	
	// Root Getter
	private Node getRoot()
	{
		return this.root;
	}
	
	// Root Setter
	private void setRoot(Node root)
	{
		this.root = root;
	}
	
	// Count Getter
	private int getCount()
	{
		return this.count;
	}
	
	// Count Incrementer
	private void incrementCount()
	{
		this.count++;
	}
	
	// No need for a count setter since we aren't deleting nodes from the tree
	
	// Array Count Getter
	private int getArrayCount()
	{
		return this.arrayCount;
	}
	
	// Array Count Setter
	private void setArrayCount(int arrayCount)
	{
		this.arrayCount = arrayCount;
	}
	
	// Array Count Incrementer
	private void incrementArrayCount()
	{
		this.arrayCount++;
	}
	
	// Is the tree currently empty?
	private boolean isEmpty()
	{
		return getRoot() == null;
	}
	
	// Insert method
	public void insert(String word)
	{
		// Create the Node
		Node newNode = new Node(word);
		
		// Is the tree currently empty?
		if(isEmpty())
		{
			setRoot(newNode);
			incrementCount();
		}
		else
		{
			// Call recursive insert method helper
			insert(getRoot(), newNode);
		}
	}//END insert method
	
	// Insert recursive helper method
	private void insert(Node current, Node newNode)
	{
		// Does the Node already exist with the same word?
		if(newNode.getWord().equalsIgnoreCase(current.getWord()))
		{
			// Increment the Nodes internal counter - duplicates
			current.incrementCounter();
		}
		// the word is lexicographically less than the current Node's word
		else if(newNode.getWord().compareToIgnoreCase(current.getWord()) < 0)
		{
			// The left spot is available, insert
			if(current.getLeft() == null)
			{
				current.setLeft(newNode);
				incrementCount(); // How many Nodes in the tree
			}
			// Left spot is occupied, recursive insert through left subtree
			else
			{
				insert(current.getLeft(), newNode);
			}
		}
		// the word is lexicographically greater than the current Node's word
		else
		{
			// The right spot is available, insert
			if(current.getRight() == null)
			{
				current.setRight(newNode);
				incrementCount(); // How many Nodes in the tree
			}
			// Right spot is occupied, recursive insert through right subtree
			else
			{
				insert(current.getRight(), newNode);
			}
			
		}
	}//END insert recursive helper
	
	// Search method
	public boolean search(String word)
	{
		// Tree is empty
		if (isEmpty())
		{
			return false;
		}
		// Otherwise recursive search within the tree
		else
		{
			return search(getRoot(), word);
		}
	}
	
	// Recursive search helper method
	private boolean search(Node current, String word)
	{
		// Did we reach a dead-end? word not found
		if(current == null)
		{
			return false;
		}
		// We found the word
		else if(word.equalsIgnoreCase(current.getWord()))
		{
			return true;
		}
		// Word is lexicographically less than the current word
		else if(word.compareToIgnoreCase(current.getWord()) < 0)
		{
			return search(current.getLeft(), word);
		}
		// Word is lexicographically greater than the current word
		else if(word.compareToIgnoreCase(current.getWord()) > 0)
		{
			return search(current.getRight(), word);
		}
		
		// Eclipse requires this although program would never reach here
		return false;
	}
	
	public String print()
	{
		// Is the tree empty?
		if(isEmpty())
		{
			return "The tree is empty so there is nothing to print!";
		}
		
		// Tree is not empty so create a temporary String array that will be used to obtain
		// the words at each Node
		String[][] temp = new String[getCount()][2];
		setArrayCount(0);
		
		// Call the inorder method to traverse the Tree inorder and store the strings in the array
		inorder(temp, getRoot());
		
		// Create the one String that contains the information required by the user
		String result = new String();
		
		for(int i = 0; i < temp.length; i++)
		{
			result += temp[i][0] + ": " + temp[i][1] + "\n";
		}
		
		return result;
	}
	
	private void inorder(String[][] temp, Node current)
	{
		if(current != null)
		{
			// Traverse left subtree
			inorder(temp, current.getLeft());
			
			// Store the current Node word in the temp String array
			temp[getArrayCount()][0] = current.getWord();
			temp[getArrayCount()][1] = Integer.toString(current.getCounter());
			incrementArrayCount();
			
			// Traverse right subtree
			inorder(temp, current.getRight());
		}
	}
	// Private Node class
	private class Node
	{
		private String word;
		private int counter;
		private Node left;
		private Node right;
		private Node parent;
		
		// Constructor
		private Node(String word)
		{
			this.word = word;
			this.counter = 1;
			this.left = null;
			this.right = null;
			this.parent = null;
		}
		
		// Word Getter
		private String getWord()
		{
			return this.word;
		}
		
		// Word Setter
		private void setWord(String word)
		{
			this.word = word;
		}
		
		// Counter Getter
		private int getCounter()
		{
			return this.counter;
		}
		
		// Counter incrementer
		private void incrementCounter()
		{
			this.counter++;
		}
		
		// Don't need a counter setter since we aren't deleting any words
		
		// Left Getter
		private Node getLeft()
		{
			return this.left;
		}
		
		// Left Setter
		private void setLeft(Node left)
		{
			this.left = left;
		}
		
		// Right Getter
		private Node getRight()
		{
			return this.right;
		}
		
		// Right Setter
		private void setRight(Node right)
		{
			this.right = right;
		}
		
		// Parent Getter
		private Node getParent()
		{
			return this.parent;
		}
		
		// Parent Setter
		private void setParent(Node parent)
		{
			this.parent = parent;
		}
		
		// Is the node a leaf?
		private boolean isLeaf()
		{
			return getLeft() == null && getRight() == null;
		}
	}
}
