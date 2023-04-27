package application;

import java.util.ArrayList;

public class Letter {
	
	private String firstName;
	private String lastName;
	private ArrayList<String> academic;
	private ArrayList<String> personal;
	private String program;
	private ArrayList<String> grade;
	private ArrayList<String> course;
	private String semester;
	private String year;
	private String date;
	private String gender;
	private String draft;
	private String school;
	private int id;
	
	
	public Letter(String firstName, String lastName, ArrayList<String> academic, 
			  ArrayList<String> personal, String program, ArrayList<String> grade,
			  ArrayList<String> course, String semester, String year, String date, String gender, String school) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.academic = academic;
		this.personal = personal;
		this.program = program;
		this.grade = grade;
		this.course = course;
		this.semester = semester;
		this.year = year;
		this.date = date;
		this.gender = gender;
		this.school = school;

	}
	
	public Letter(String firstName, String lastName, ArrayList<String> academic, 
				  ArrayList<String> personal, String program, ArrayList<String> grade,
				  ArrayList<String> course, String semester, String year, String date, String gender, String draft, String school) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.academic = academic;
		this.personal = personal;
		this.program = program;
		this.grade = grade;
		this.course = course;
		this.semester = semester;
		this.year = year;
		this.date = date;
		this.gender = gender;
		this.draft = draft;
		this.school = school;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public ArrayList<String> getAcademic() {
		return academic;
	}
	public void setAcademic(ArrayList<String> academic) {
		this.academic = academic;
	}
	public ArrayList<String> getPersonal() {
		return personal;
	}
	public void setPersonal(ArrayList<String> personal) {
		this.personal = personal;
	}
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public ArrayList<String> getGrade() {
		return grade;
	}
	public void setGrade(ArrayList<String> grade) {
		this.grade = grade;
	}
	public ArrayList<String> getCourse() {
		return course;
	}
	public void setCourse(ArrayList<String> course) {
		this.course = course;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDraft() {
		return draft;
	}

	public void setDraft(String draft) {
		this.draft = draft;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	@Override
	public String toString() {
		return "Letter [firstName=" + firstName + "\n" + "lastName=" + lastName + "\n" + "academic=" + academic + "\n" + "personal="
				+ personal + "\n" + "program=" + program + "\n" + "grade=" + grade + "\n" + "course=" + course + "\n" + "semester="
				+ semester + "\n" + "year=" + year + "\n" + "date=" + date + "]";
	}
	
	
}
