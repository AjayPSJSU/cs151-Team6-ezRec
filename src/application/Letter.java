package application;

public class Letter {
	
	private String firstName;
	private String lastName;
	private String academic;
	private String personal;
	private String program;
	private String grade;
	private String course;
	private String semester;
	private String year;
	private String date;
	
	
	public Letter(String firstName, String lastName, String academic, String personal, String program, String grade,
			String course, String semester, String year, String date) {
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
	public String getAcademic() {
		return academic;
	}
	public void setAcademic(String academic) {
		this.academic = academic;
	}
	public String getPersonal() {
		return personal;
	}
	public void setPersonal(String personal) {
		this.personal = personal;
	}
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
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
	@Override
	public String toString() {
		return "Letter [firstName=" + firstName + "\n" + "lastName=" + lastName + "\n" + "academic=" + academic + "\n" + "personal="
				+ personal + "\n" + "program=" + program + "\n" + "grade=" + grade + "\n" + "course=" + course + "\n" + "semester="
				+ semester + "\n" + "year=" + year + "\n" + "date=" + date + "]";
	}
	
	
}
