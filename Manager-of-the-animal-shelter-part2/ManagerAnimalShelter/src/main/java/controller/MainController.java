package controller;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import Mainly.Client1;
import animals.Animal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import list_animals_singleton.ListAnimalsSingleton;
import save_file.CsvOutputInput;
import save_file.DataBaseOutputInput;
import save_file.XmlOutputInput;

public class MainController {

	private ListAnimalsSingleton listAnimals;
	private static boolean isFirst = true;

	@FXML
	private Button save_button;

	@FXML
	private Label amout_animals;

	@FXML
	private TableView<Animal> list_animals;

	@FXML
	private TableColumn<Animal, String> name_tableView;

	@FXML
	private TableColumn<Animal, Integer> age_tableView;
	@FXML
	private AnchorPane mainly_containers_down;

	@FXML
	private AnchorPane mainly_containers_up;

	@FXML
	void initialize() {
		if (isFirst) {
			isFirst = false;
			load_from_database(null);
		}
		setTableView();
	}

	@FXML
	void save_animals(MouseEvent event) throws IOException {
		if (listAnimals.getListAnimals().size() == 5) {
			alertIsFull();
			return;
		}
		Parent root = FXMLLoader.load(getClass().getResource("/FXML/AnimalsShelterWindowAdd.fxml"));
		mainly_containers_down.getChildren().removeAll();
		mainly_containers_down.getChildren().setAll(root);
	}

	@FXML
	void delete_window(MouseEvent event) throws IOException {
		if (list_animals.getItems().isEmpty()) {
			alertEmpty();
			return;
		}
		Parent root = FXMLLoader.load(getClass().getResource("/FXML/AnimalsShelterWindowDelete.fxml"));
		mainly_containers_down.getChildren().removeAll();
		mainly_containers_down.getChildren().setAll(root);
	}

	@FXML
	public void get_id(MouseEvent event) {
		int id = list_animals.getSelectionModel().getSelectedIndex();
		if (id == -1)
			return;
		listAnimals.setNumberMarkLis(id);
	}

	@FXML
	void save_to_csv(ActionEvent event) {
		new CsvOutputInput().writeData();
		alertSaveData();
	}

	@FXML
	void load_from_csv(ActionEvent event) {
		new CsvOutputInput().readData();
		alertLoadData();
		this.initialize();
	}

	@FXML
	void save_to_dataBase(ActionEvent event) {
		new DataBaseOutputInput().writeData();
		alertSaveData();
		this.initialize();
	}

	@FXML
	void load_from_database(ActionEvent event) {
		new DataBaseOutputInput().readData();
		alertLoadData();
		this.initialize();
	}

	// brak mozliwosci wczytania w klasie XmlOutputInput
	// listAnimals = new XmlOutputInput().readData();
	// ListAnimalsSingleton.getInstance().setListAnimals(listAnimals.getListAnimals());
	@FXML
	void load_from_xml(ActionEvent event) throws Exception {
		new XmlOutputInput().readData();
		alertLoadData();
		this.initialize();
	}

	@FXML
	void save_to_xml(ActionEvent event) throws Exception {
		new XmlOutputInput().writeData();
		alertSaveData();
		this.initialize();
	}

	public void set_amount_animals(String amount) {
		this.amout_animals.setText(amount);
	}

	private void alertEmpty() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText("List is empty!");
		alert.showAndWait();
	}

	private void alertIsFull() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText("List is full!");
		alert.showAndWait();
	}

	private void alertSaveData() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Save");
		alert.setHeaderText(null);
		alert.setContentText("Data saved!");
		alert.showAndWait();
	}

	private void alertLoadData() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Load");
		alert.setHeaderText(null);
		alert.setContentText("Data loaded!");
		alert.showAndWait();
	}

	private void setTableView() {
		listAnimals = ListAnimalsSingleton.getInstance();
		this.list_animals.setItems(listAnimals.getListAnimals());
		this.amout_animals.setText(Integer.toString(listAnimals.getListAnimals().size()));
		this.name_tableView.setCellValueFactory(new PropertyValueFactory<Animal, String>("name_"));
		this.age_tableView.setCellValueFactory(new PropertyValueFactory<Animal, Integer>("age_"));
	}

}
