package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GameController implements Initializable {

	@FXML
	private ComboBox<String> cbGameType;
	private ObservableList<String> myComboBoxData = FXCollections.observableArrayList();

	@FXML
	private Label lblErrorMessage;

	@FXML
	private TextField txtStartTime;

	@FXML
	private TextField txtEndTime;

	@FXML
	private Button btnCreateGame;

	@FXML
	private Button btnBack;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnBack.setVisible(false);
		btnCreateGame.setVisible(true);

		myComboBoxData.add("Swimming");
		myComboBoxData.add("Cycling");
		myComboBoxData.add("Running");
		cbGameType.setItems(myComboBoxData);

		cbGameType.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			lblErrorMessage.setText("Game Type Selected: " + newValue.toString() + "\n");
			if (newValue.toString().equals("Swimming")) {
				txtStartTime.setText("101");
				txtEndTime.setText("200");
			} else if (newValue.toString().equals("Cycling")) {
				txtStartTime.setText("501");
				txtEndTime.setText("800");
			} else if (newValue.toString().equals("Running")) {
				txtStartTime.setText("11");
				txtEndTime.setText("20");
			}
		});

		btnCreateGame.setOnAction((event) -> {
			if (cbGameType.getValue().toString().equals("Swimming")
					|| cbGameType.getValue().toString().equals("Cycling")
					|| cbGameType.getValue().toString().equals("Running")) {
				btnBack.setVisible(true);
				btnCreateGame.setVisible(false);
				lblErrorMessage.setText("Game Type Selected. Click Back to Return to Create New Game.");
			}
		});
		
		btnBack.setOnAction((event) -> {
			
			try {

				Parent root = FXMLLoader.load(getClass().getResource("/views/MainMenu.fxml"));
				Scene tableViewScene = new Scene(root, 600, 600);


				// This line gets the Stage information
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

				window.setScene(tableViewScene);
				window.show();

			} catch (IOException e) {
				e.printStackTrace();
			}
		});

	}

}
