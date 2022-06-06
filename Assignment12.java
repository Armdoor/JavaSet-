// Assignment: 12
// Name:Akshit Sanoria
// StudentID:1220420435
// Lecture:T/TH 1:30 -2:45 pm 
// Description: This is main class for assignment 12 
import application.MainPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Assignment12 extends Application {
	private final int WIDTH = 780;
	private final int HEIGHT = 480;

	public void start(Stage primaryStage) {
		// create a ControlPane object
		MainPane pane = new MainPane(WIDTH, HEIGHT);
		//pane.setStyle("-fx-border-color: black;");
		// put pane onto the rootPane
		Pane rootPane = new Pane();
		//rootPane.setStyle("-fx-border-color: black;");
		rootPane.getChildren().add(pane);

		// Create a scene and place rootPane in the stage
		Scene scene = new Scene(rootPane, WIDTH, HEIGHT);

		primaryStage.setTitle("Big Waves!");
		
		// Place the scene in the stage
		primaryStage.setScene(scene); 
		
		// Display the stage
		primaryStage.show(); 
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}