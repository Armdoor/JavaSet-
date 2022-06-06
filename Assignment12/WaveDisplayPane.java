package application;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

//Assignment: 12
//Name:Akshit Sanoria
//StudentID:1220420435
//Lecture:T/TH 1:30 -2:45 pm 
//Description: This class setps ups methods like resume play surprise and sets up the animation


public class WaveDisplayPane extends Pane {

	// Task #1: immplement instance variables, constructor, and methods
	// as outlned in the UML diagram and assignment description

	Timeline timeline;
	int time,waveLength,waveAmplitude,paneWidth;
	Color color;
	// constructor method 
	public WaveDisplayPane(int i, Color c) {
		waveAmplitude=100;
		waveLength = 50;
		time=0;
		this.color=c;
		this.paneWidth=i;
		setStyle("-fx-background-color: white");// sets pane background
		setStyle("-fx-border-color: black;");// sets pane border 
		// creates a key frame 
		KeyFrame key = new KeyFrame(Duration.millis(500),new WaveHandler());
		// creates a new timeline
		timeline= new Timeline(key);
		timeline.setCycleCount(Timeline.INDEFINITE);
		//sets up the initial speed of the animation 
		timeline.setRate(20);
		// starts the animation 
		timeline.play();
	}
	
	// this method resumes the animation 
	public void resume()
	{
		timeline.setRate(20);
		timeline.play();	
	}
	
	// this method stops the animation 
	public void suspend()
	{
		timeline.stop();
		timeline.setRate(0);
	}
	
	// this method changes the color of the wave 
	public void changeColor(Color c)
	{
		color=c;
	}
	
	//  this method clears out the pane 
	public void clearPane()
	{
		getChildren().clear();
		suspend();		
	}
	
	// setter method for wave length
	public void setWaveLength(int len)
	{
		waveLength=len;
	}
	
	// setter method for wave amplitude
	public void setWaveAmplitude(int amp)
	{
		waveAmplitude=amp;
	}

	// setter method for wave speed
	public void setRate(int sp)
	{
		timeline.setRate(sp);
	}


	// defines an event listener to draw a new point
	private class WaveHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			time++;
			int x = (waveLength * time) / 314;
			int y = (int) (waveAmplitude * Math.sin((0.0174533) * time) + 115);

			if (x < paneWidth) {
				Circle dot = new Circle(x, y, 2);
				dot.setFill(color);
				getChildren().add(dot);
			} else suspend();
		}
	}
}
