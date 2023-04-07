package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ResetPasswordController {
	
	@FXML
	private TextField oldPassword;
	
	@FXML
	private TextField newPassword;
	
	@FXML
	private TextField confirmNewPassword;

	public void handleReset(ActionEvent event) throws IOException {
		
		if(oldPassword.getText().equals("blank") && newPassword.getText().equals(confirmNewPassword.getText())) {
			Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		else if(oldPassword.getText().equals("blank") && !newPassword.getText().equals(confirmNewPassword.getText())) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Passwords don't match!");
			alert.setContentText("Please enter matching passwords.");
			alert.show();
		}
	}
}
