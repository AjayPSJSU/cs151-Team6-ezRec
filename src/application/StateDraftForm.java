package application;



public class StateDraftForm {

	private static Letter oldLetter;
	
	
	public static Letter getOldLetter() {
		return oldLetter;
	}

	public static void setOldLetter(Letter oldLetter) {
		StateDraftForm.oldLetter = oldLetter;
	}
	
	

}
