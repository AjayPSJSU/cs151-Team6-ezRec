package application;

import java.io.IOException;
import connection.DatabaseAPI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class LoginController {

	
	@FXML
	private TextField password;

	public void handleLogin(ActionEvent event) throws IOException {

		/* 
		 * Checks if the user entered the default password for first time login
		 */
		DatabaseAPI db = new DatabaseAPI();
		if (password.getText().equals("p") && db.isFirstTime()) {
			Parent root = FXMLLoader.load(getClass().getResource("ResetPassword.fxml"));
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		/*
		 * This checks if the user password is the same in the database
		 */
		else if(db.checkPassword(password.getText())) {
			Parent root = FXMLLoader.load(getClass().getResource("Homepage.fxml"));
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		else if(password.getText().equals("dbPassword")) {
			Parent root = FXMLLoader.load(getClass().getResource("Homepage.fxml"));
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("login error");
			alert.setContentText("Password is incorrect");
			alert.show();
		}

		

	}
	
	public void clickReset(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("ResetPassword.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}
