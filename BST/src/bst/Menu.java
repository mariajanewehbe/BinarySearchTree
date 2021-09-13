package bst;

import java.util.Scanner;

public class Menu {
	
	public static int getNumberFromUser()
	{
		Scanner scan = new Scanner(System.in);
		try {
			String s = scan.next();
			return Integer.parseInt(s);
		}
		catch(NumberFormatException e) {
			System.out.println("Incorrect. Please try again.");
			return getNumberFromUser();	
		}
	}
	
	public static void main(String[] args)
	{
		BinarySearchTree BST = new BinarySearchTree();
		int choice = 0;
		
		do {
			System.out.println("Enter a choice:");
			System.out.println("1. Return maximum.");
			System.out.println("2. Add a value.");
			System.out.println("3. Remove a value.");
			System.out.println("4. Search for a value.");
			System.out.println("5. Check if the tree is a Binary Search Tree.");
			System.out.println("6. Print all the values in an increasing order.");
			System.out.println("7. Exit.");
			choice = getNumberFromUser();
			
			switch(choice)
			{
				case 1:
					int max = BST.getMax(BST.getRoot());
					System.out.println("The maximum number is: " + max);
					break;
					
				case 2:
					System.out.println("Enter the value you wish to add.");
					int value = getNumberFromUser();
					if(BST.search(BST.getRoot(), value))
						System.out.println("We cannot add a duplicated value.");
					else
						BST.setRoot(BST.add(BST.getRoot(), value));
					break;
					
				case 3:
					System.out.println("Enter the value you wish to delete.");
					value = getNumberFromUser();
					BST.delete(BST.getRoot(), value);
					break;
					
				case 4:
					System.out.println("What is the value you want to search for?");
					value = getNumberFromUser();
					BST.search(BST.getRoot(), value);
					break;
					
				case 5:
					if(BST.isBST(BST.getRoot()))
						System.out.println("This tree is a binary search tree.");
					else
						System.out.println("This tree is not a binary search tree.");
					break;
					
				case 6:
					BST.printTree(BST.getRoot());
					break;
					
				case 7:
					System.out.println("Exiting the program...");
					break;

				default:
					System.out.println("Not a valid choice. Please try again."); 				
			}
		}while(choice != 7);
	}

}
