package application;

import javafx.scene.Scene;

public class StateDraftForm {
	private static Letter letter;
	private static Scene scene;
	private static Letter oldLetter;
	
	
	public static Letter getLetter() {
		return letter;
	}
	
	public static void setLetter(Letter letter) {
		StateDraftForm.letter = letter;
	}
	
	public static Scene getScene() {
		return scene;
	}
	
	public static void setScene(Scene scene) {
		StateDraftForm.scene = scene;
	}

	public static Letter getOldLetter() {
		return oldLetter;
	}

	public static void setOldLetter(Letter oldLetter) {
		StateDraftForm.oldLetter = oldLetter;
	}
	
	

}
