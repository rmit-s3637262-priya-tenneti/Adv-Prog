package assignment;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utilities.Data;

public class Driver extends Application {

	public Driver() {
		// initiateParticipants();
		Data.loadAthlethes();
		Data.loadOfficials();
	}

	@Override
	public void start(Stage primaryStage) {
	
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/views/MainMenu.fxml"));

			Scene scene = new Scene(root, 600, 600);

			primaryStage.setTitle("Ozlympic Game");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void begin(String[] args) {
		launch(args);
	}
}
