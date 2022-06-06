package application;

//Assignment: 12
//Name:Akshit Sanoria
//StudentID:1220420435
//Lecture:T/TH 1:30 -2:45 pm 
//Description: This is class creates buttons, labels, and sliders and also implements the handlers for them 

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;


public class WaveControlPane extends Pane  {

	private WaveDisplayPane wavePane;
	private int width, height;
	private Color color;
	private ColorPicker picker;

	// ******************************************************************
	// Task #2a: add instance variables for sliders, buttons, and labels
	// ******************************************************************
	private Button start , stop, clear,surprise;
	private Slider speedS,widthS,heightS;
	private Label speedL,widthL,heightL;

	// constructor to create all components, set their handler/listener,
	// and arrange them using layout panes.
	public WaveControlPane(int h, int w, Color initialColor) {
		this.color = initialColor;
		this.width = (int) (h * 0.68);
		this.height = w - 10;

		// creates a pane to display waves with the specified color
		wavePane = new WaveDisplayPane(width, color);
		wavePane.setMinSize(width, height);
		wavePane.setMaxSize(width, height);

		// create a color picker with the specified initial color
		picker = new ColorPicker(color);
		picker.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		// ************************************************************************
		// Task #2b: create 4 buttons and resize them to the width of the VBox pane,
		// then add them to the VBox buttonPane instantiated below.
		// *************************************************************************
		start=new Button("Start");
		stop=new Button("Stop");
		clear=new Button("Clear");
		surprise=new Button("Surprise!");
		start.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
		stop.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
		clear.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
		surprise.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
		// VBox for the button and colors 
		VBox buttonPane = new VBox(start,stop,clear,surprise, picker);
		
		buttonPane.setPrefSize(100, 100);
		buttonPane.setAlignment(Pos.CENTER);
		
		// ************************************************************************
		// Task #2c: create 3 sliders and 3 labels and add them to the VBox panes
		// instantiated below. 
		// *************************************************************************
		
		speedS = new Slider();
		speedL =new Label ("Speed");
		widthS = new Slider();
		widthL =new Label ("Width");
		heightS = new Slider();
		heightL =new Label ("Height");
		speedS.setOrientation(Orientation.VERTICAL);
		widthS.setOrientation(Orientation.VERTICAL);
		heightS.setOrientation(Orientation.VERTICAL);
		speedS.setShowTickLabels(true);
		speedS.setShowTickMarks(true);
		speedS.setMajorTickUnit(10);
		speedS.setMinorTickCount(5);
		speedS.setMin(5);
		speedS.setMax(100);
		speedS.setValue(20);
		widthS.setShowTickLabels(true);
		widthS.setShowTickMarks(true);
		widthS.setMajorTickUnit(10);
		widthS.setMinorTickCount(5);
		widthS.setMin(5);
		widthS.setMax(100);
		widthS.setValue(20);
		heightS.setShowTickLabels(true);
		heightS.setShowTickMarks(true);
		heightS.setMajorTickUnit(10);
		heightS.setMinorTickCount(5);
		heightS.setMin(5);
		heightS.setMax(100);
		heightS.setValue(20);
		
		VBox speedSliderPane = new VBox(speedL,speedS);
		VBox waveLengthSliderPane = new VBox(widthL,widthS);
		VBox waveAmplitudeSliderPane = new VBox(heightL,heightS);

		TilePane sliderPane = new TilePane();
		sliderPane.setPrefColumns(3);
		sliderPane.setPadding(new Insets(5, 5, 5, 5));
		sliderPane.setAlignment(Pos.CENTER);
		sliderPane.getChildren().addAll(speedSliderPane, waveLengthSliderPane, waveAmplitudeSliderPane);

		HBox controls = new HBox(buttonPane, sliderPane);
		controls.setAlignment(Pos.CENTER);

		BorderPane controlsAndWaves = new BorderPane();
		controlsAndWaves.setLeft(controls);
		controlsAndWaves.setCenter(wavePane);

		this.getChildren().add(controlsAndWaves);

		// ************************************************************************
		// Task #2d: Register the buttons, sliders, and color picker with the
		// appropriate handler object 
		// *************************************************************************

		start.setOnAction(new StartButtonHandler());
		stop.setOnAction(new StopButtonHandler());
		clear.setOnAction(new CLearButtonHandler());
		surprise.setOnAction(new SurpriseButtonHandler());
		picker.setOnAction(new ColorHandler());
		speedS.valueProperty().addListener(new SpeedHandler()); 
		widthS.valueProperty().addListener(new WaveLengthHandler());
		heightS.valueProperty().addListener(new WaveAmplitudeHandler());
	}

	// ************************************************************************
	// Task #3: Implement event handlers for the four buttons (task #3a), 
	// the color picker (task #3b), the speed slider (task #3c), and the
	// sliders for wave amplitude and legth (tasks #3d, #3e)
	// *************************************************************************

// button handler for the start button 
	private class StartButtonHandler implements EventHandler<ActionEvent> 
	{
		public void handle(ActionEvent event) 
		{
			wavePane.resume();	
		}
	}
	// button handler for the stop button
	private class StopButtonHandler implements EventHandler<ActionEvent> 
	{
		public void handle(ActionEvent event) 
		{
			wavePane.suspend();
		}
	}
	// button handler for the clear button
	private class CLearButtonHandler implements EventHandler<ActionEvent> 
	{
		public void handle(ActionEvent event) 
		{
			wavePane.clearPane();
		}
	}
	// button handler for the surprise button
	private class SurpriseButtonHandler implements EventHandler<ActionEvent> 
	{
		public void handle(ActionEvent event) 
		{
			wavePane.suspend();
			wavePane.time=0;
			wavePane.setRate((int) (Math.random()*100));
			wavePane.setWaveAmplitude((int) (Math.random()*100));
			wavePane.setWaveLength((int) (Math.random()*100));
			wavePane.changeColor(Color.rgb((int) (Math.random()*100), (int) (Math.random()*100), (int) (Math.random()*100)));
			wavePane.resume();
		}
	}
	// event handler for the color selecter 
	private class ColorHandler implements EventHandler<ActionEvent> 
	{
		public void handle(ActionEvent event)
		{
			color= picker.getValue();
			wavePane.changeColor(color);
		}
		}
	// slider  handler for the speed  slider
	private class SpeedHandler implements ChangeListener<Number>
	{
		public void changed(ObservableValue<? extends Number> ov,Number oldValue, Number newValue)
	     {
			wavePane.setRate((int)speedS.getValue());	
	     }
	}
	// slider  handler for the wave length  slider
	private class WaveLengthHandler implements ChangeListener<Number> 
	{
		public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
		{
			wavePane.suspend();
			width = (int) ( widthS.getValue());
			wavePane.setWaveLength(width);
			wavePane.time = 0;
			wavePane.resume();
		}
	}
	
	// slider  handler for the wave amplitude  slider
	private class WaveAmplitudeHandler implements ChangeListener<Number> 
	{
		public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
		{
			wavePane.suspend();
			height= (int) heightS.getValue();
			wavePane.setWaveAmplitude(height);
			wavePane.time=0;
			wavePane.resume();
		}
	}


}
