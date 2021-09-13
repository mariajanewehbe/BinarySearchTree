package bst;

public class Node {
	
	private int info;
	private Node right;
	private Node left;
	
	public Node(int i)
	{
		left = right = null;
		info = i;
	}
	
	public int getInfo()
	{
		return info;
	}
	
	public void setInfo(int i)
	{
		info = i;
	}
	
	public Node getRight()
	{
		return right;
	}
	
	public void setRight(Node n)
	{
		right = n;
	}
	
	public Node getLeft()
	{
		return left;
	}
	
	public void setLeft(Node n)
	{
		left = n;
	}
	
	public boolean isLeaf()
	{
		return left == null && right == null;
	}
	
	public void preOrderPrint()
	{
		System.out.println(info);
		if(left != null)
			left.preOrderPrint();
		if(right != null)
			right.preOrderPrint();
	}

}
