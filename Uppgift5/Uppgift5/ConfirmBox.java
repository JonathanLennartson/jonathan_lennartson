package Uppgift5;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {
	
	private static Boolean answer;
	
	public static Boolean display(String title, String message) {
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setOnCloseRequest(e -> answer = false);
		
		Label label = new Label(message);
		label.setFont(new Font(14));
		
		Button yes = new Button("Ja");
		yes.setMinWidth(40);
		yes.setOnAction(e -> {
			answer = true;	
			stage.close();
		});
		Button no = new Button("Nej");
		no.setMinWidth(40);
		no.setOnAction(e -> {
			answer = false;	
			stage.close();
		});
		HBox hBox = new HBox(20);
		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().addAll(yes, no);
		
		VBox vBox = new VBox(10);
		vBox.setAlignment(Pos.CENTER);
		vBox.getChildren().addAll(label, hBox);
		
		Scene scene = new Scene(vBox, 250, 100);
		stage.setScene(scene);
		stage.setTitle(title);
		stage.showAndWait();
		
		return answer;
		
	}

}
