package application;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import connection.DatabaseAPI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class HomepageController {
	@FXML
	private ListView<Letter> dropDown;
	
	@FXML
	private TextField searchBar;
	
	
	
	 
	public void search(ActionEvent event) {
		Letter letter = new Letter("dinh", "nguyen", null, null, null, null, null, null, "2023", null, null, null);
		letter.setId(1);
		Letter l = new Letter("john", "robert", null, null, null, null, null, null, "2022", null, null, null);
		l.setId(2);
		dropDown.getItems().add(letter);
		dropDown.getItems().add(l);
	}
	
	private List<String> searchList() {


	    return null;
	}
	public void delete() {
		DatabaseAPI db = new DatabaseAPI();
		int index = dropDown.getSelectionModel().getSelectedIndex();
		if (index != -1) {
			Letter let = dropDown.getItems().get(index);
			dropDown.getItems().remove(index);
			db.removeLetter(let);
		}
	}
	public void handleLogout(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		Faculty.setState(false);
	}
	
	public void create(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("CreateRec.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void addInfo(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AddInfo.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void changePassword(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("ResetPassword.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
}
