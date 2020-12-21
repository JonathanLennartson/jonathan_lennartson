package Uppgift5;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NewAccountStage {

	static Stage stage;

	public static void show() {

		stage = new Stage();
		TextField user = new TextField();
		PasswordField password = new PasswordField();
		PasswordField repeatPassword = new PasswordField();
		VBox vBox = new VBox(20);
		HBox hBox = new HBox(20);
		Label label = new Label("Ny användare");
		Button okBtn = new Button("Ok");
		okBtn.setOnAction(e -> okBtnPressed(user.getText(), password.getText(), repeatPassword.getText()));
		Button cancelBtn = new Button("Avbryt");
		cancelBtn.setOnAction(e -> stage.close());

		label.setFont(new Font(20));
		user.setMaxWidth(200);
		user.setPromptText("Användarnamn");
		password.setMaxWidth(200);
		password.setPromptText("Lösenord");
		repeatPassword.setMaxWidth(200);
		repeatPassword.setPromptText("Upprepa lösenord");
		hBox.getChildren().addAll(okBtn, cancelBtn);
		hBox.setAlignment(Pos.BASELINE_CENTER);
		vBox.getChildren().addAll(label, user, password, repeatPassword, hBox);
		vBox.setAlignment(Pos.BASELINE_CENTER);

		Scene changePasswordScene = new Scene(vBox, 300, 250);

		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setScene(changePasswordScene);
		stage.setTitle("Ny användare");
		stage.showAndWait();

	}

	public static void okBtnPressed(String userName, String password, String repeatPassword) {
		Boolean verify = NewAccountMethod.NewUser(userName, password, repeatPassword);

		if (verify == true) {
			stage.close();
		} else if (verify == false) {
			AlertBox.show("Något blev fel, försök igen", "FEL!");
		}
		
	}
}



