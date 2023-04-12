package application;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
	private ListView<String> dropDown;
	
	@FXML
	private TextField searchBar;
	
	
	
	/*
	  * If you want to use this code to connect it with the db data
	  */
	 ArrayList<String> students = new ArrayList<>(
	            Arrays.asList()
	    );
	
	 
	public void search(ActionEvent event) {
		 dropDown.getItems().clear();
	     dropDown.getItems().addAll(searchList(searchBar.getText(),students));
	}
	
	private List<String> searchList(String searchWords, List<String> listOfStrings) {

	    // Split the search string into individual words and create a list of them.
	    List<String> searchWordsArray = Arrays.asList(searchWords.trim().split(" "));

	    // Filter the list of strings based on whether they contain all the words in the search string.
	    List<String> filteredStrings = new ArrayList<>();
	    for (String input : listOfStrings) {
	        boolean allWordsFound = true;
	        for (String word : searchWordsArray) {
	            if (!input.toLowerCase().contains(word.toLowerCase())) {
	                allWordsFound = false;
	                break;
	            }
	        }
	        if (allWordsFound) {
	            filteredStrings.add(input);
	        }
	    }

	    return filteredStrings;
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
