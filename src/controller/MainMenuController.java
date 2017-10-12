package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainMenuController {

	@FXML
	private Label lblErrorMessage;

	@FXML
	private void createNewGame(ActionEvent event) throws IOException {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/views/chooseNewGame.fxml"));
			Scene tableViewScene = new Scene(root, 600, 600);

			// This line gets the Stage information
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			window.setScene(tableViewScene);
			window.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	@FXML
	private void selectGameType(ActionEvent event) throws IOException {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/views/selectGameType.fxml"));
			Scene tableViewScene = new Scene(root, 600, 600);

			// This line gets the Stage information
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			window.setScene(tableViewScene);
			window.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void addParticipants(ActionEvent event) throws IOException {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/views/chooseNewGame.fxml"));
			Scene tableViewScene = new Scene(root, 600, 600);

			// This line gets the Stage information
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			window.setScene(tableViewScene);
			window.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void predictWinner(ActionEvent event) throws IOException {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/views/chooseNewGame.fxml"));
			Scene tableViewScene = new Scene(root, 600, 600);

			// This line gets the Stage information
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			window.setScene(tableViewScene);
			window.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void startGame(ActionEvent event) throws IOException {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/views/chooseNewGame.fxml"));
			Scene tableViewScene = new Scene(root, 600, 600);

			// This line gets the Stage information
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			window.setScene(tableViewScene);
			window.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void viewGameResults() {
		lblErrorMessage.setText("Game Results!");
	}

	@FXML
	private void viewAthleteResults() {
		lblErrorMessage.setText("Athlete Results!");
	}

	@FXML
	private void closeApplication() {
		System.out.println("Application Exitted!");
		System.exit(0);
	}

}
