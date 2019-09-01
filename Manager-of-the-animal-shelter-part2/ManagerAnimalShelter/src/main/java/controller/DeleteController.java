package controller;

import java.io.IOException;

import Mainly.Client1;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import list_animals_singleton.ListAnimalsSingleton;

public class DeleteController {

	@FXML
    void initialize() {
		
	}
	
	@FXML
    void back_to_main_window(MouseEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/FXML/AnimalsShelterWindow.fxml")); 
		Client1.stage.getScene().setRoot(root);
    }

	@FXML
	void delete_animals(MouseEvent event) throws IOException {
		if (ListAnimalsSingleton.getInstance().getNumberMarkLis() == -1) return;
		int id = ListAnimalsSingleton.getInstance().getNumberMarkLis();
		ListAnimalsSingleton.getInstance().getListAnimals().remove(id);
		Parent root = FXMLLoader.load(getClass().getResource("/FXML/AnimalsShelterWindow.fxml")); 
		Client1.stage.getScene().setRoot(root);
    }
}
