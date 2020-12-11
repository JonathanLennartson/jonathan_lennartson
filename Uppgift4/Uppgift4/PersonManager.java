package Uppgift4;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PersonManager extends Application {
	Scene scene;
	Button addBtn;
	Button deleteBtn;
	Button updateBtn;
	Button saveBtn;
	Button loadBtn;
	TableView<Person> table;
	TextField firstName, surname, age;
	PersonList list = new PersonList();
	Person person;
	Boolean update = true;

	public static void main(String[] args) {
		launch(args);

	}

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage stage) throws Exception {

		TableColumn<Person, String> nameColumn = new TableColumn<>("Förnamn");
		nameColumn.setMinWidth(200);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

		TableColumn<Person, String> surnameColumn = new TableColumn<>("Efternamn");
		surnameColumn.setMinWidth(200);
		surnameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

		TableColumn<Person, String> ageColumn = new TableColumn<>("Ålder");
		ageColumn.setMinWidth(80);
		ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

		table = new TableView<Person>();
		table.setMaxSize(480, 290);
		table.getColumns().addAll(nameColumn, surnameColumn, ageColumn);

		addBtn = new Button("Lägg till");
		addBtn.setStyle("-fx-font-size: 14; -fx-padding: 5 20 5 20; -fx-height: 10;");
		addBtn.setOnAction(e -> addPerson());
		deleteBtn = new Button("Ta bort");
		deleteBtn.setStyle("-fx-font-size: 14; -fx-padding: 5 20 5 20; -fx-height: 10;");
		deleteBtn.setOnAction(e -> deletePerson());
		updateBtn = new Button("Hämta info");
		updateBtn.setStyle("-fx-font-size: 14; -fx-padding: 5 20 5 20; -fx-height: 10;");
		updateBtn.setOnAction(e -> updateList());
		saveBtn = new Button("Spara");
		saveBtn.setStyle("-fx-font-size: 14; -fx-padding: 5 20 5 20; -fx-height: 10;");
		saveBtn.setOnAction(e -> saveList());
		loadBtn = new Button("Hämta");
		loadBtn.setStyle("-fx-font-size: 14; -fx-padding: 5 20 5 20; -fx-height: 10;");
		loadBtn.setOnAction(e -> loadList());

		firstName = new TextField();
		firstName.setPromptText("Förnamn");
		firstName.setMinWidth(195);

		surname = new TextField();
		surname.setPromptText("Efternamn");
		surname.setMinWidth(190);

		age = new TextField();
		age.setPromptText("Ålder");
		age.setMinWidth(75);
		age.setMaxWidth(75);

		VBox vBox = new VBox(20);

		HBox buttons = new HBox(10);
		buttons.setStyle("-fx-padding: 5 0 0 0");
		buttons.setAlignment(Pos.BASELINE_CENTER);
		buttons.getChildren().addAll(addBtn, deleteBtn, updateBtn, saveBtn, loadBtn);

		HBox textFields = new HBox(10);
		textFields.setAlignment(Pos.BASELINE_CENTER);
		textFields.getChildren().addAll(firstName, surname, age);

		HBox tableView = new HBox();
		tableView.setAlignment(Pos.BASELINE_CENTER);
		tableView.getChildren().add(table);

		vBox.getChildren().addAll(buttons, textFields, tableView);

		scene = new Scene(vBox, 500, 400, Color.BEIGE);

		stage.setScene(scene);
		stage.setTitle("Jonathans personhanterare");
		stage.show();
	}

	private void addPerson() {
		Person person = new Person();
		person.setFirstName(firstName.getText());
		person.setLastName(surname.getText());
		person.setAge(Integer.valueOf(age.getText()));
		list.setList(person);
		table.getItems().add(person);
		firstName.clear();
		surname.clear();
		age.clear();

	}

	private void deletePerson() {		
		table.getItems().remove(table.getSelectionModel().getSelectedItem());
		
	}

	private void updateList() {
		person = table.getSelectionModel().getSelectedItem();

		if (update) {
			firstName.setText(person.getFirstName());
			surname.setText(person.getLastName());
			age.setText(String.valueOf(person.getAge()));
			update = false;
			updateBtn.setText("Uppdatera");

		} else {
			person.setFirstName(firstName.getText());
			person.setLastName(surname.getText());
			person.setAge(Integer.valueOf(age.getText()));
			table.getItems().add(person);
			table.getItems().remove(table.getSelectionModel().getSelectedItem());
			update = true;
			updateBtn.setText("Hämta info");
			firstName.clear();
			surname.clear();
			age.clear();

		}

	}

	private void saveList() {
		XMLhandler.encode(list.getList());

	}

	private void loadList() {
		table.getItems().clear();
		XMLhandler.decode();
		for (Person person : XMLhandler.list) {
			table.getItems().addAll(person);
		}

	}

}
