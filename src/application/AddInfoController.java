package application;

import java.io.IOException;

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
	TextField semesters;
	
	@FXML
	ListView<String> semesterList;
	
	@FXML
	TextField courses;
	
	@FXML
	ListView<String> coursesList;
	
	@FXML
	TextField programs;
	
	@FXML
	ListView<String> programList;
	
	@FXML
	TextField personalChar;
	
	@FXML
	ListView<String> personalList;
	
	@FXML
	TextField academicChar;
	
	@FXML
	ListView<String> academicList;
	
	public void handleSubmit(ActionEvent event) throws IOException {
		add();
		Parent root = FXMLLoader.load(getClass().getResource("Homepage.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void handleCancel(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Homepage.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	private void add() {
		Faculty faculty = new Faculty(fullName.getText(), title.getText(), school.getText(), department.getText(), email.getText(), phone.getText());
		DatabaseAPI db = new DatabaseAPI();
		db.addFaculty(faculty);
		for (int i = 0; i < semesterList.getItems().size(); i++) 
			db.addSemester(semesterList.getItems().get(i));
		
	
		for (int i = 0; i < coursesList.getItems().size(); i++) 
			db.addCourses(programList.getItems().get(i));
		
		
		for (int i = 0; i < programList.getItems().size(); i++) 
			db.addPrograms(programList.getItems().get(i));
		
	
		for (int i = 0; i < personalList.getItems().size(); i++) 
			db.addPersonal(personalList.getItems().get(i));
		
		for (int i = 0; i < academicList.getItems().size(); i++) 
			db.addAcademic(academicList.getItems().get(i));
	}
	
	public void semesterAdd() {

		semesterList.getItems().add(semesters.getText());
		
	}
	public void semesterRemove() {
		int selectID = semesterList.getSelectionModel().getSelectedIndex();
		if (selectID != -1) semesterList.getItems().remove(selectID);
		
	}
	
	public void courseAdd() {

		coursesList.getItems().add(courses.getText());
		
	}
	public void courseRemove() {
		int selectID = coursesList.getSelectionModel().getSelectedIndex();
		if (selectID != -1) coursesList.getItems().remove(selectID);
		
	}
	
	public void programAdd() {

		programList.getItems().add(programs.getText());
		
	}
	public void programRemove() {
		int selectID = programList.getSelectionModel().getSelectedIndex();
		if (selectID != -1) programList.getItems().remove(selectID);
		
	}
	
	public void personalAdd() {

		personalList.getItems().add(personalChar.getText());
		
	}
	public void personalRemove() {
		int selectID = personalList.getSelectionModel().getSelectedIndex();
		if (selectID != -1) personalList.getItems().remove(selectID);
		
	}
	
	public void academicAdd() {

		academicList.getItems().add(academicChar.getText());
		
	}
	public void academicRemove() {
		int selectID = academicList.getSelectionModel().getSelectedIndex();
		if (selectID != -1) academicList.getItems().remove(selectID);
		
	}
	
	
}




























