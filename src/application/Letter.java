package application;

import java.util.ArrayList;


import connection.DatabaseAPI;


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


	public String completeDraft() {
		DatabaseAPI data = new DatabaseAPI();
		Faculty faculty = data.getFaculty();
		String genString = gender.equals("Male") ? "He" : "She";
		StringBuilder result = new StringBuilder();
		result.append("Letter of Recommendation\n\n");
		result.append("For: " + firstName + " " + lastName + "\n\n");
		result.append("Date: " + date + "\n\n");
		result.append("To: Graduate Admissions Committee\n\n");
		result.append("I am writing this letter to recommend my former student " + firstName + " " + lastName + " who is applying for the " + program + " in your school.\n\n" );
		result.append("I met " + firstName + " in " + semester + " when he enrolled in my " + course.get(0) + " course.\n\n" );
		result.append(firstName + " earned " + grade.get(0) + " from this tough course, and this shows how knowledgeable and hard worker " + genString.toLowerCase() + " is.\n\n");
		if (course.size() > 1) {
			
			String tempString = genString + " also earned ";
			for (int i = 1; i < course.size(); i++) tempString = tempString + grade.get(i) + " from my " + course.get(i) + ", ";
			result.append(tempString.substring(0, tempString.length() - 2) + "\n\n");
		}
		
		String tempString = firstName + " ";
		for (int i = 0; i < academic.size(); i++) tempString = tempString + academic.get(i) + ", ";
		result.append(tempString.substring(0, tempString.length() - 2) + "\n\n");
		
		String tempStr = genString + " was always";
		for (int i = 0; i < personal.size(); i++) tempStr = tempStr + personal.get(i) + ", ";
		result.append(tempStr.substring(0, tempStr.length() - 2) + "\n\n");
		
		result.append("Furthermore, I noticed from the term project result, " + genString.toLowerCase() + "developed leadership, time management, and problem-solving skills. ");
		result.append(genString + " worked effectively with the team members and delegated tasks appropriately. They were able to deliver a successful project in a timely fashion.\n\n");
		result.append("I believe that " + firstName + " has the capacity to excel at higher education program and this is my pleasure to highly recommend him.\n\n");
		result.append("Please do not hesitate to contact me with further questions.\n\n\n");
		result.append("Very Respectfully,\n\n");
		result.append(faculty.getName() + "\n\n" +
					  faculty.getTitle() + "\n" + 
					  faculty.getSchool() + ", " + faculty.getDepartment() + "\n" +
					  faculty.getEmail() + "\n" + faculty.getPhone());
		return result.toString();
		
	}
	

	@Override
	public String toString() {
		return firstName + " " + lastName + " " + year;
	}
	
	
}
