package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddInfoController {
	
	@FXML
	TextField fullName;
	
	@FXML
	TextField title;
	
	@FXML
	TextField school;
	
	@FXML
	TextField department;
	
	@FXML
	TextField email;
	
	@FXML
	TextField phone;
	
	@FXML
	TextArea semesters;
	
	@FXML
	TextArea courses;
	
	@FXML
	TextArea programs;
	
	@FXML
	TextArea personalChar;
	
	@FXML
	TextArea academicChar;
	
	public void handleSubmit(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Homepage.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	private void add() {
		
	}
}




























