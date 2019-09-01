package controller;

import java.io.IOException;

import Mainly.Client1;
import animals.Animal;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import list_animals_singleton.ListAnimalsSingleton;

public class AddController {

	@FXML
    private Button save_button_Add;

	@FXML
	private TextField name_field;

    @FXML
    private TextField age_field;

	@FXML
    void initialize() {
		
	}
	
	private void alertWrongValue() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText("You gave the wrong value!");
		alert.showAndWait(); 
	}	
	
	@FXML
    void back_to_main_window(MouseEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/FXML/AnimalsShelterWindow.fxml")); 
		Client1.stage.getScene().setRoot(root);
	}
	
	@FXML
	void save_animals(MouseEvent event) throws IOException {
		if (name_field.getText().isEmpty() || age_field.getText().isEmpty()) {
			alertWrongValue();
			return;
		}
		else if (!age_field.getText().chars().allMatch( Character::isDigit )) {
			alertWrongValue();
			return;
		}	
		String name = name_field.getText();
		int age = Integer.parseInt(age_field.getText());
		ListAnimalsSingleton.getInstance().setAnimal(new Animal(name, age));
		Parent root = FXMLLoader.load(getClass().getResource("/FXML/AnimalsShelterWindow.fxml")); 
		Client1.stage.getScene().setRoot(root);
	}
	

   
}
