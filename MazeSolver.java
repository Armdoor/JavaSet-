// Assignment: 11
// Name:Akshit Sanoria
// StudentID:1220420435
// Lecture:T/TH 1:30 -2:45 pm 
// Description: This is Maze Solver for Assignment 11 that implements depth first search and then prints the maze 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MazeSolver {
	// instance variables 
	private Stack<Node> stack;
	private char[][] maze;
	private int eggFound, mHeight, mWidth;
	
	//constructor method 
	public MazeSolver() 
	{
		stack = new Stack<Node>();
		eggFound=0;		
	}
	
	// depth first search method
	public void depthFirstSearch() 
	{
		// new node for initial position
		Node newNode = new Node(0,0);
		// extra nodes for south west, north and south traversing 
		Node currentNode, southNode, eastNode, westNode, northNode;
		// variables for stores x and y 
		int southx,southy,eastx,easty,northx, northy, westx,westy;
		// push the new node to the stack
		stack.push(newNode);
		// while loop for moving the pointer
		while (stack.isEmpty()==false)
		{
			// pops out the current node 
			currentNode = stack.pop();
			// conditional statement for checking the availability if egg
			if (maze[currentNode.getY()][currentNode.getX()]=='E') 
			{
				// increments the egg counter if the egg is found 
				eggFound++;
				
			}
			// marks the current node to checked
			maze[currentNode.getY()][currentNode.getX()]='x';
			
			// south traverse
			southx = currentNode.getX();
			// increment the y to move the pointer to south coordinate. 
			southy = currentNode.getY() +1 ;
			// checks the bound 
			if (southx>= 0 && southx < mWidth && southy >= 0 && southy < mHeight)   
			{
				// checks if it is a movable path 
				if ( maze[southy][southx]== '.' || maze[southy][southx]== 'E')
				{
					southNode = new Node(southx,southy);
					stack.push(southNode);
				}
			}
			
			// east traverse
			// increment the x to move the pointer to east coordinate. 
			eastx = currentNode.getX()+1;
			easty = currentNode.getY();
			if (eastx>= 0 && eastx < mWidth && easty >= 0 && easty < mHeight)   
			{
				// checks if it is a movable path 
				if ( maze[easty][eastx]== '.' || maze[easty][eastx]== 'E') 
				{
					eastNode = new Node(eastx,easty);
					stack.push(eastNode);
				}
			}
			
			// north traverse
			northx = currentNode.getX();
			// decrements the y to move the pointer to north coordinate. 
			northy = currentNode.getY()-1;
			if (northx>= 0 && northx < mWidth && northy>= 0 && northy < mHeight)   
			{
				// checks if it is a movable path 
				if (maze[northy][northx]== '.' || maze[northy][northx]== 'E') 
				{
					northNode = new Node(northx,northy);
					stack.push(northNode);
				}
			}
			
			// west traverse
			// decrements the x to move the pointer to west coordinate. 
			westx = currentNode.getX()-1;
			westy = currentNode.getY();
			if (westx>= 0 && westx < mWidth && westy>= 0 && westy < mHeight)   
			{
				// checks if it is a movable path 
				if (maze[westy][westx]== '.' || maze[westy][westx]== 'E')
				{
					westNode = new Node(westx,westy);
					stack.push(westNode);
				}
			}
	
		}
	}
	
	// returns the number of eggs found by the bunny 
	public int getEggFound() 
	{
		return eggFound;
	}
	
//method to print the maze	
	public void printMaze() 
	{
		for (int i = 0; i < mHeight; i++) {
			System.out.println();
			for (int j = 0; j < mWidth; j++) {
				System.out.print(maze[i][j]);
			}
			
			}
		System.out.println();
	}
	

	// ************************************************************************************
	// ************** Utility method to read maze from user input *************************
	// ************************************************************************************
	public void readMaze() {

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Height of the maze: ");
			String line = reader.readLine();
			mHeight = Integer.parseInt(line);

			System.out.println("Width of the maze: ");
			line = reader.readLine();
			mWidth = Integer.parseInt(line);
			maze = new char[mHeight][mWidth];

			for (int i = 0; i < mHeight; i++) {
				line = reader.readLine();
				for (int j = 0; j < mWidth; j++) {
					maze[i][j] = line.charAt(j);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
