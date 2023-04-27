package application;

import java.io.IOException;

import connection.DatabaseAPI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class DraftController {
	DatabaseAPI database = new DatabaseAPI();
	@FXML TextArea textRe;
	
	
	public void save(ActionEvent event) throws IOException {
		
		if (StateDraftForm.getOldLetter() != null) 
			database.removeLetter(StateDraftForm.getOldLetter());
		
		database.saveForm(StateDraftForm.getLetter());
		Parent root = FXMLLoader.load(getClass().getResource("Homepage.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void cancel(ActionEvent event) {
		StateDraftForm.setLetter(null);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(StateDraftForm.getScene());
		stage.show();
	}
	

}
