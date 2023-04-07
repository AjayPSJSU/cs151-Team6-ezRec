package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

	
	@FXML
	private TextField password;

	public void handleLogin(ActionEvent event) throws IOException {

		/* 
		 * Checks if the user entered the default password for first time login
		 */
		if (password.getText().equals("blank")) {
			Parent root = FXMLLoader.load(getClass().getResource("ResetPassword.fxml"));
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		/*
		 * This checks if the user password is the same in the database
		 */
		else if(password.getText().equals("dbPassword")) {
			Parent root = FXMLLoader.load(getClass().getResource("Homepage.fxml"));
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
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
