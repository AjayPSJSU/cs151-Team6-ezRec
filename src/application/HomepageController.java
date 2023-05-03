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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class HomepageController {
	@FXML
	private ListView<Letter> dropDown;
	
	@FXML
	private TextField searchBar;
	
	@FXML
	private TextArea letterShow;
	
	

	
	 
	public void search() {
		DatabaseAPI db = new DatabaseAPI();
		ArrayList<Letter> letters = db.searchLetter(searchList());
		if (dropDown.getItems().size() > 0) 
			dropDown.getItems().clear();
		
		dropDown.getItems().addAll(letters);
		
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
	public void edit(ActionEvent event) throws IOException {
		
		int index = dropDown.getSelectionModel().getSelectedIndex();
		
		if (index != -1) {
			Letter letter = dropDown.getItems().get(index);
			StateDraftForm.setOldLetter(letter);
			Parent root = FXMLLoader.load(getClass().getResource("CreateRec.fxml"));
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	}
	

	private String searchList() {

	    // Split the search string into individual words and create a list of them.
	    List<String> searchWordsArray = Arrays.asList(searchBar.getText().trim().split(" "));
	    String str = "";
	    for (int i = 0; i < searchWordsArray.size(); i++) 
			str = str + "'" + searchWordsArray.get(i) + "', ";
	    return str.substring(0, str.length() - 2);
	}
	public void click() {
		int index = dropDown.getSelectionModel().getSelectedIndex();
		if (index != -1) {
			Letter letter = dropDown.getItems().get(index);
			letterShow.setText(letter.getDraft());


		}
	}
	
	public void edit() {
		
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
