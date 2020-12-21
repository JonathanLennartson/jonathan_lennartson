package Uppgift5;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AlertBox {

	public static void show(String message, String title) {
		Stage stage = new Stage();

		Label label = new Label(message);
		label.setFont(new Font(14));
		
		Button okBtn = new Button("Ok");
		okBtn.setOnAction(e -> stage.close());
		okBtn.setMinWidth(40);
		
		VBox layout = new VBox(20);
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(label, okBtn);

		Scene scene = new Scene(layout, 250, 100);

		stage.setScene(scene);
		stage.setTitle(title);
		stage.show();
	}

}
