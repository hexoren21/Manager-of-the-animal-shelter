package Mainly;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Client1 extends Application {
	public static Stage stage = null;
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("/FXML/AnimalsShelterWindow.fxml"));
		StackPane stackPane = loader.load();
		
		Scene scene = new Scene(stackPane);
		stage.setScene(scene);
		this.stage = stage;
		this.stage.setTitle("Manager animal shelter");
		stage.show();
	}
}
