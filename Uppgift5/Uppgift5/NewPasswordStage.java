package Uppgift5;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NewPasswordStage{
	static Stage stage;
	public static void show(String userName, String password) {
		stage = new Stage();
		PasswordField currentPassword = new PasswordField();
		PasswordField newPassword = new PasswordField();
		PasswordField repeatNewPassword = new PasswordField();
		VBox vBox = new VBox(20);
		HBox hBox = new HBox(20);
		Label changePass = new Label("�ndra l�senord");		
		Button changeBtn = new Button("�ndra");
			changeBtn.setOnAction(e -> changeBtnPressed(userName, password, currentPassword.getText(), newPassword.getText(), repeatNewPassword.getText()));
		Button cancelBtn = new Button("Avbryt");		
			cancelBtn.setOnAction(e -> stage.close());
		
		changePass.setFont(new Font(20));
		currentPassword.setMaxWidth(200);
		currentPassword.setPromptText("Nuvarande l�senord");
		newPassword.setMaxWidth(200);
		newPassword.setPromptText("Nytt l�senord");
		repeatNewPassword.setMaxWidth(200);
		repeatNewPassword.setPromptText("Upprepa nya l�seordet");		
		hBox.getChildren().addAll(changeBtn, cancelBtn);
		hBox.setAlignment(Pos.BASELINE_CENTER);
		vBox.getChildren().addAll(changePass, currentPassword, newPassword, repeatNewPassword, hBox);
		vBox.setAlignment(Pos.BASELINE_CENTER);

		Scene changePasswordScene = new Scene(vBox, 300, 250);
		
		stage.initModality(Modality.APPLICATION_MODAL);		
		stage.setScene(changePasswordScene);
		stage.setTitle("�ndra l�senord");
		stage.showAndWait();
	}

	private static void changeBtnPressed(String userName, String password, String currentPassword, String newPassword, String repeatNewPassword) {
		Boolean verify = NewPasswordMethod.newPassword(userName, password, currentPassword, newPassword, repeatNewPassword);
		
		if (verify == true) {
			stage.close();
		}
	}

	
}
