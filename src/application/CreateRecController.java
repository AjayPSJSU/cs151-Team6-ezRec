package application;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import connection.DatabaseAPI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class CreateRecController implements Initializable {
	@FXML
	TextField firstName;
	
	@FXML
	TextField lastName;
	
	@FXML
	DatePicker date;
	
	@FXML
	TextField school;
	
	@FXML
	TextField year;

	@FXML
	private ChoiceBox<String> gender;

	@FXML
	private ChoiceBox<String> programName;

	@FXML
	private ChoiceBox<String> firstSemester;

	@FXML
	private MenuButton otherCoursesDrop;

	@FXML
	private MenuButton personalCharDrop;

	@FXML
	private MenuButton academicCharDrop;

	DatabaseAPI database = new DatabaseAPI();


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		ArrayList<String> otherCourses = database.getCourse();
		ArrayList<String> personalChars = database.getPcharacteristics();
		ArrayList<String> academicChars = database.getAcharacteristics();
		
		gender.getItems().addAll(Arrays.asList("Male", "Female"));
		programName.getItems().addAll(database.getPrograms());
		firstSemester.getItems().addAll(database.getSemester());

		// Dropdown for other courses
		for (String course : otherCourses) {
			CheckBox checkBox = new CheckBox(course);
			TextField textField = new TextField();
			textField.setPromptText("Enter grade");
			textField.setStyle("-fx-background-color: transparent; -fx-border-color: #0598ff; -fx-border-width: 0px 0px 2px 0px;");
			HBox hbox = new HBox(checkBox,textField);
			hbox.setSpacing(10);
			CustomMenuItem customMenuItem = new CustomMenuItem(hbox);
			customMenuItem.setHideOnClick(false);
			otherCoursesDrop.getItems().add(customMenuItem);
		}

		// Dropdown for personal characteristics
		for (String personal : personalChars) {
			CheckBox checkBox = new CheckBox(personal);
			CustomMenuItem customMenuItem = new CustomMenuItem(checkBox);
			customMenuItem.setHideOnClick(false);
			personalCharDrop.getItems().add(customMenuItem);
		}

		// Dropdown for academic characteristics
		for (String academic : academicChars) {
			CheckBox checkBox = new CheckBox(academic);
			CustomMenuItem customMenuItem = new CustomMenuItem(checkBox);
			customMenuItem.setHideOnClick(false);
			academicCharDrop.getItems().add(customMenuItem);
		}
		if (StateDraftForm.getOldLetter() != null)  AutoFill();
			
		
	}

	private void AutoFill() {
		Letter letter = StateDraftForm.getOldLetter();
		if (letter == null)  return;
		
		firstName.setText(letter.getFirstName()); 
		lastName.setText(letter.getLastName());
		date.setValue(LocalDate.parse(letter.getDate()));
		year.setText(letter.getYear());
		school.setText(letter.getSchool());
		gender.getSelectionModel().select(letter.getGender());
		programName.getSelectionModel().select(letter.getProgram());
		firstSemester.getSelectionModel().select(letter.getSemester());
		
		for (int i = 0; i < otherCoursesDrop.getItems().size(); i++) {
			CustomMenuItem tempCustomMenuItem = (CustomMenuItem) otherCoursesDrop.getItems().get(i);
			HBox hbox = (HBox) tempCustomMenuItem.getContent();
			CheckBox checkBox = (CheckBox) hbox.getChildren().get(0);
			TextField gradeField = (TextField) hbox.getChildren().get(1);
			int index = letter.getCourse().indexOf(checkBox.getText());
			if (index != -1) {
				checkBox.setSelected(true);
				gradeField.setText(letter.getGrade().get(index));
				
			}

		}
		
		for (int i = 0; i < personalCharDrop.getItems().size(); i++) {
			CustomMenuItem tempCustomMenuItem = (CustomMenuItem) personalCharDrop.getItems().get(i);
			CheckBox checkBox = (CheckBox) tempCustomMenuItem.getContent();
			if (letter.getPersonal().contains(checkBox.getText()))checkBox.setSelected(true); 
		}
		for (int i = 0; i < academicCharDrop.getItems().size(); i++) {
			CustomMenuItem tempCustomMenuItem = (CustomMenuItem) academicCharDrop.getItems().get(i);
			CheckBox checkBox = (CheckBox) tempCustomMenuItem.getContent();
			if (letter.getAcademic().contains(checkBox.getText()))checkBox.setSelected(true); 
		}
		
	}
	

	public void compile(ActionEvent event) throws IOException {
		//delete letter in database if user pick edit

		
		Letter letter = new Letter(firstName.getText(), lastName.getText(), getAcademic(), getPersonal(), 
				programName.getValue(), getGrade(), getCourse(), firstSemester.getValue(), year.getText(), date.getValue().toString(), gender.getValue(), school.getText());
			
		letter.setDraft(letter.completeDraft());
		
		//save Letter to database
		database.saveForm(letter);
		if (StateDraftForm.getOldLetter() != null) {
			database.removeLetter(StateDraftForm.getOldLetter());
			
		}
		
		//return to homepage
		Parent root = FXMLLoader.load(getClass().getResource("Homepage.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
		
		StateDraftForm.setOldLetter(null);
		System.out.println(letter);
	}
	
	public void cancelRec(ActionEvent event) throws IOException {

		StateDraftForm.setOldLetter(null);
		Parent root = FXMLLoader.load(getClass().getResource("Homepage.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	
	
	private ArrayList<String> getPersonal() {
		ArrayList<String> persoString = new ArrayList<>();
		for (int i = 0; i < personalCharDrop.getItems().size(); i++) {
			CustomMenuItem tempCustomMenuItem = (CustomMenuItem) personalCharDrop.getItems().get(i);
			CheckBox checkBox = (CheckBox) tempCustomMenuItem.getContent();
			if (checkBox.isSelected()) persoString.add(checkBox.getText());
			
		}
		
		return persoString;
		
	}
	
	
	private ArrayList<String> getAcademic() {
		ArrayList<String> persoString = new ArrayList<>();
		for (int i = 0; i < academicCharDrop.getItems().size(); i++) {
			CustomMenuItem tempCustomMenuItem = (CustomMenuItem) academicCharDrop.getItems().get(i);
			CheckBox checkBox = (CheckBox) tempCustomMenuItem.getContent();
			if (checkBox.isSelected()) persoString.add(checkBox.getText());

		}
		
		return persoString;
		
	}
	
	private ArrayList<String> getCourse() {
		ArrayList<String> persoString = new ArrayList<>();
		for (int i = 0; i < otherCoursesDrop.getItems().size(); i++) {
			CustomMenuItem tempCustomMenuItem = (CustomMenuItem) otherCoursesDrop.getItems().get(i);
			HBox hbox = (HBox) tempCustomMenuItem.getContent();
			CheckBox checkBox = (CheckBox) hbox.getChildren().get(0);
			if (checkBox.isSelected()) persoString.add(checkBox.getText());

		}
		
		return persoString;
		
	}
	
	private ArrayList<String> getGrade() {
		ArrayList<String> persoString = new ArrayList<>();
		for (int i = 0; i < otherCoursesDrop.getItems().size(); i++) {
			CustomMenuItem tempCustomMenuItem = (CustomMenuItem) otherCoursesDrop.getItems().get(i);
			HBox hbox = (HBox) tempCustomMenuItem.getContent();
			CheckBox checkBox = (CheckBox) hbox.getChildren().get(0);
			TextField gradeField = (TextField) hbox.getChildren().get(1);
			if (checkBox.isSelected()) persoString.add(gradeField.getText());

		}
		
		return persoString;
		
	}
	
}
