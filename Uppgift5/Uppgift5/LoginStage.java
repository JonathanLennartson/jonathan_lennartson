package Uppgift5;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginStage {
	private static Stage stage;
	private static TextField userNameField;
	private static PasswordField passwordField;
	public static void show() {
		stage = new Stage();
		stage.setOnCloseRequest(e -> {
			e.consume();
			closeProgram();
		});

		userNameField = new TextField();
		passwordField = new PasswordField();
		userNameField.setPromptText("Användarnamn");
		userNameField.setMaxWidth(200);
		passwordField.setPromptText("Lösenord");
		passwordField.setMaxWidth(200);

		Button loginBtn = new Button("Logga in");
		loginBtn.setOnAction(e -> login(userNameField.getText(), passwordField.getText()));
		Button closeBtn = new Button("Avsluta");
		closeBtn.setOnAction(e -> closeProgram());

		Label welcomeText = new Label("Välkommen till JIBS");
		welcomeText.setFont(new Font(20));
		Label newUser = new Label("Tryck här för att skapa nytt konto.");
		newUser.setOnMouseEntered(e -> newUser.setTextFill(Color.BLUE));
		newUser.setOnMouseExited(e -> newUser.setTextFill(Color.BLACK));
		newUser.setOnMouseClicked(
				e -> NewAccountStage.show());

		HBox hBox = new HBox(20);
		hBox.getChildren().addAll(loginBtn, closeBtn);
		hBox.setAlignment(Pos.BASELINE_CENTER);
		VBox vBox = new VBox(20);
		vBox.getChildren().addAll(welcomeText, userNameField, passwordField, newUser, hBox);
		vBox.setAlignment(Pos.BASELINE_CENTER);

		Scene login = new Scene(vBox, 300, 250);
		stage.setScene(login);
		stage.setTitle("JIBS - Logga in");
		stage.show();
	}

	private static void login(String userName, String password) {
		if (LoginMethod.login(userName, password) == true) {
			BankStage.show(userName, password);
			userNameField.clear();
			passwordField.clear();
		} else {
			AlertBox.show("Fel användarnamn eller lösenord", "Fel");
		}

	}

	private static void closeProgram() {
		Boolean result = ConfirmBox.display("Varning!", "Vill du avsluta programmet?");
		if (result) {
			stage.close();
		}
	}

}
