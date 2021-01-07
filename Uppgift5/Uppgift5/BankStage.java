package Uppgift5;

import java.util.HashMap;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class BankStage {
	static BorderPane bP;
	static Label moneySaldo;
	static Label transactionDateTime;

	@SuppressWarnings({ "static-access" })
	public static void show(String userName, String password) {
		XMLhandler.decode();
		HashMap<String, Account> userHashList = XMLhandler.list;
		Account account = new Account();
		Stage stage = new Stage();
		Label header = new Label("Välkommen till Jonathan International Banking System");
		Label version = new Label("Version 1.0");
		Text accountNumber = new Text();
		Text accNum = new Text("Kontonummer");
		bP = new BorderPane();
		VBox vBox1 = new VBox(20);
		VBox vBox2 = new VBox(20);
		VBox saldo = new VBox(20);
		Button logOutBtn = new Button("Logga ut");
		Button changePassBtn = new Button("Byt lösenord");
		Button withdraw = new Button("Uttag");
		Button deposit = new Button("Insättning");
		GridPane meny = new GridPane();
		TextField input = new TextField();
		HBox hBox1 = new HBox(20);
		HBox hBox2 = new HBox(20);
		moneySaldo = new Label();
		transactionDateTime = new Label();

		account = userHashList.get(userName);
		moneySaldo.setStyle("-fx-font-size: 50;");
		
		if (account.getSaldo() == null) {
			account.setSaldo(0.0);
		}
		moneySaldo.setText("Saldo: " + String.valueOf(account.getSaldo()));
		transactionDateTime.setText("Senaste transaktionsdatumet: " + String.valueOf(account.getDateTime()));

		input.setPromptText("Insättning/Uttag");

		accountNumber.setText(String.valueOf(userHashList.get(userName).getAccountNumber(userName)));

		header.setFont(new Font(30));

		logOutBtn.setOnAction(e -> {
			XMLhandler.encode(userHashList);
			stage.close();
		});
		changePassBtn.setOnAction(e -> NewPasswordStage.show(userName, password));

		withdraw.setOnAction(e -> withdraw(input.getText(), userName, userHashList));
		deposit.setOnAction(e -> deposit(input.getText(), userName, userHashList));

		hBox1.getChildren().addAll(accNum, accountNumber);
		hBox2.getChildren().addAll(deposit, withdraw);
		vBox1.getChildren().addAll(changePassBtn, logOutBtn);
		vBox2.getChildren().addAll(hBox1, input, hBox2);
		saldo.getChildren().addAll(moneySaldo, transactionDateTime);
		saldo.setAlignment(Pos.CENTER);

		meny.setMargin(vBox1, new Insets(230, 0, 0, 0));
		meny.add(vBox2, 0, 0);
		meny.add(vBox1, 0, 1);

		bP.setPadding(new Insets(10, 10, 10, 10));

		bP.setAlignment(header, Pos.CENTER);
		bP.setMargin(header, new Insets(10, 10, 10, 10));

		bP.setAlignment(version, Pos.BOTTOM_RIGHT);
		bP.setMargin(version, new Insets(10, 10, 10, 10));

		bP.setTop(header);
		bP.setBottom(version);
		bP.setLeft(meny);
		bP.setCenter(saldo);

		Scene bankScene = new Scene(bP, 800, 500);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setScene(bankScene);
		stage.setTitle("JIBS - Jonathan International Banking System");
		stage.showAndWait();
	}

	private static void withdraw(String input, String userName, HashMap<String, Account> userHashList) {
		try {
			Account account = new Account();
			account = userHashList.get(userName);
			DateAndTime dateTime = new DateAndTime();

			account.setWithdraw(Double.valueOf(input));
			double withdraw = account.getWithdraw();

			double saldo = account.getSaldo();
			double summa = saldo - withdraw;
			if (summa < 0) {
				AlertBox.show("Otillräckligt med pengar på kontot", "Inge para");
			} else {
				account.setSaldo(summa);
				moneySaldo.setText("Saldo: " + String.valueOf(account.getSaldo()));
				dateTime.setDateTime();
				account.setDateTime(dateTime.getDateTime());
				transactionDateTime.setText("Senaste transaktionsdatumet: " + String.valueOf(dateTime.getDateTime()));
				XMLhandler.encode(userHashList);
			}
		} catch (Exception NullPointerException) {
			System.out.println("e");
		}
	}

	private static void deposit(String input, String userName, HashMap<String, Account> userHashList) {

		Account account = new Account();
		account = userHashList.get(userName);
		
		DateAndTime dateTime = new DateAndTime();
		account.setDeposit(Double.valueOf(input));
		
		if (account.getSaldo() != null) {		
			
			double deposit = account.getDeposit();
			double saldo = account.getSaldo();
			account.setSaldo(saldo + deposit);
			
		} else {
			double deposit = account.getDeposit();
			account.setSaldo(0.0);
			double saldo = account.getSaldo();
			account.setSaldo(saldo + deposit);
		}
		
		moneySaldo.setText("Saldo: " + String.valueOf(account.getSaldo()));
		dateTime.setDateTime();
		account.setDateTime(dateTime.getDateTime());
		transactionDateTime.setText("Senaste transaktionsdatumet: " + String.valueOf(dateTime.getDateTime()));
		XMLhandler.encode(userHashList);
	}

}
