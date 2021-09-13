package bst;

import java.util.*;

public class BinarySearchTree {
	
	private Node root;
	
	public BinarySearchTree()
	{
		root = null;
	}
	
	public Node getRoot()
	{
		return root;
	}
	
	public void setRoot(Node n)
	{
		root = n;
	}
	
	public int getMax(Node r)
	{
		if(r == null)
			return -999;
		if(r.getRight() == null)
			return r.getInfo();
		else
			return getMax(r.getRight());
	}
	
	public int getMin(Node r)
	{
		if(r == null)
			return -999;
		if(r.getLeft() == null)
			return r.getInfo();
		else
			return getMin(r.getLeft());
	}
	
	public boolean search(Node r, int key)
	{
		if(r == null)
			return false;
		else
			if(r.getInfo() == key)
				return true;
			else
				if(r.getInfo() > key)
					return search(r.getLeft(), key);
				else
					return search(r.getRight(), key);
	}
	
	public Node add(Node r, int num)
	{
		if (r == null) 
		{
	     return new Node(num);
        }

	     if (num < r.getInfo()) 
	        r.setLeft(add(r.getLeft(), num));
	     else 
	        r.setRight(add(r.getRight(), num));
	     return r;
	}
	
	public void printTree(Node r)
	{
		if(r == null)
			return;
		printTree(r.getLeft());
		System.out.println(r.getInfo());
		printTree(r.getRight());
	}
	
	public boolean isBST(Node r)
	{
		Vector<Integer> keys = new Vector<Integer>();
		storeTree(root, keys);
		if(isSorted(keys))
			return true;
		else
			return false;
	}
	
	public boolean isSorted(Vector<Integer> keys)
	{
		for(int i=1; i < keys.size()-1; i++)
		{
			if(keys.elementAt(i) <= keys.elementAt(i-1))
				return false;
		}
		return true;
	}
	
	public void storeTree(Node r, Vector<Integer> keys)
	{
		if(r != null)
		{
			storeTree(r.getLeft(), keys);
			keys.add(r.getInfo());
			storeTree(r.getRight(), keys);
		}
	}
	
	public Node delete(Node r, int value)
	{
		if(r == null)
			return null;
		if(r.getInfo() < value)
			root.setRight(delete(r.getRight(), value));
		else
			if(r.getInfo() > value)
				root.setLeft(delete(r.getLeft(), value));
			else
			{
				if(r.isLeaf())
				{
					r = null;
					return null;
				}
				else
					if(r.getLeft() == null)
					{
						Node n = r.getRight();
						r = null;
						return n;
					}
					else
						if(r.getRight() == null)
						{
							Node n = r.getRight();
							r = null;
							return n;
						}
						else
						{
							 int min = getMin(r.getRight());
							 r.setInfo(min);
							 r.setRight(delete(r.getRight(), min));
						}
			}
		return r;
	}
	


}
