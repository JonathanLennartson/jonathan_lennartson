package Uppgift3;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Stoppur extends Application {
	Scene scene;
	VBox vBox;
	Button startStopButton;
	Button clearTableButton;
	Text time;
	Timeline timeline;
	int mins = 0, secs = 0, millis = 0;
	boolean startOrStop = true;
	String stopTime;
	TableView<DateAndTime> timeList;
	
	
	public static void main(String[] args) {
		launch(args);
	}
	

	void change(Text time) {

		if (millis == 1000) {
			secs++;
			millis = 0;
		}
		if (secs == 60) {
			mins++;
			secs = 0;
		}

		time.setText((((mins / 10) == 0) ? "0" : "") + mins + ":" + (((secs / 10) == 0) ? "0" : "") + secs + "."
				+ (((millis / 10) == 0) ? "00" : (((millis / 100) == 0) ? "0" : "")) + millis++);

		stopTime = String.valueOf((((mins / 10) == 0) ? "0" : "") + mins + ":" + (((secs / 10) == 0) ? "0" : "") + secs
				+ "." + (((millis / 10) == 0) ? "00" : (((millis / 100) == 0) ? "0" : "")) + millis);
	}


	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage stage) {

		time = new Text("00:00.000");
		time.setStyle("-fx-font-size: 50; -fx-padding: 5 50 5 50; -fx-height: 10;");
		
		timeline = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				change(time);
			}
		}));
		
		timeline.setCycleCount(Timeline.INDEFINITE);
				
		startStopButton = new Button("Start");
		startStopButton.setStyle("-fx-font-size: 15; -fx-font-weight: bold; -fx-padding: 5 50 5 50; -fx-height: 10;");
		startStopButton.setOnAction(new EventHandler<ActionEvent>() {
		

			@Override
			public void handle(ActionEvent event) {
				if (startOrStop) {
					timeline.play();
					startOrStop = false;
					startStopButton.setText("Stop");

				} else {
					timeline.pause();
					startOrStop = true;
					mins = 0;
					secs = 0;
					millis = 0;
					timeline.pause();
					if (!startOrStop) {
						startOrStop = true;
					}
					startStopButton.setText("Start");
					
					DateAndTime dateStop = new DateAndTime();
					dateStop.setDateTime();
					dateStop.setStopTime(stopTime);
										
					timeList.getItems().add(dateStop);					

				}
			}
		});
		
		clearTableButton = new Button("Rensa historiken");
		clearTableButton.setStyle("-fx-font-size: 15; -fx-font-weight: bold; -fx-padding: 5 50 5 50; -fx-height: 10;");
		clearTableButton.setOnAction(e -> clearTableButtonClicked());

		TableColumn<DateAndTime, String> dateTimeCol = new TableColumn<>("Tid och datum");
		dateTimeCol.setMinWidth(200);
		dateTimeCol.setCellValueFactory(new PropertyValueFactory<>("dateTime"));
		
		TableColumn<DateAndTime, String> stopTimeCol = new TableColumn<>("Stopptid");
		stopTimeCol.setMinWidth(200);
		stopTimeCol.setCellValueFactory(new PropertyValueFactory<>("stopTime"));

		timeList = new TableView<>();
		timeList.getColumns().addAll(dateTimeCol, stopTimeCol);
		
		vBox = new VBox(30);
		
		vBox.setAlignment(Pos.CENTER);
		vBox.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
		vBox.getChildren().addAll(time, startStopButton, timeList, clearTableButton);
 
		scene = new Scene(vBox, 400, 700, Color.WHITE);
		stage.setScene(scene);
		stage.setTitle("Jonathans Stoppur");
		stage.show();
	}


	private void clearTableButtonClicked() {
		timeList.getItems().clear();
		
	}
	
}