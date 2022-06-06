// Assignment: 11
// Name:Akshit Sanoria
// StudentID:1220420435
// Lecture:T/TH 1:30 -2:45 pm 
// Description: This is main class for assignment 11 
public class Assignment11 {

	public static void main(String[] args) {
		MazeSolver mazeSolver = new MazeSolver();
		mazeSolver.readMaze();

		System.out.println("Original maze: ");
		mazeSolver.printMaze();

		mazeSolver.depthFirstSearch();

		System.out.println("Maze after Easter Bunny traverse: ");
		mazeSolver.printMaze();

		if (mazeSolver.getEggFound() == 0)
			System.out.println("The Bunny was unable to recover the eggs, Easter is cancelled!");
		else
			System.out.println("The Easter Bunny found " + mazeSolver.getEggFound() + " egg(s)!");
	}
}
