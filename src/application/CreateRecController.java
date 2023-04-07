package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.MenuButton;

public class CreateRecController implements Initializable {

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

	ArrayList<String> genderList = new ArrayList<>(Arrays.asList("Male", "Female", "Other"));

	ArrayList<String> programs = new ArrayList<>(Arrays.asList("Undergraduate", "Masters"));

	ArrayList<String> semesters = new ArrayList<>(Arrays.asList("Fall", "Spring"));

	ArrayList<String> otherCourses = new ArrayList<>(Arrays.asList("CS151 A", "CS122 A", "CS166 B+", "CS146 A-"));

	ArrayList<String> personalChars = new ArrayList<>(Arrays.asList("Responsible", "Hard-working", "Creative"));

	ArrayList<String> academicChars = new ArrayList<>(
			Arrays.asList("Able to collaborate with others", "Good leadership"));

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		gender.getItems().addAll(genderList);
		programName.getItems().addAll(programs);
		firstSemester.getItems().addAll(semesters);

		// Dropdown for other courses
		for (String course : otherCourses) {
			CheckBox checkBox = new CheckBox(course);
			CustomMenuItem customMenuItem = new CustomMenuItem(checkBox);
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
	}

}
