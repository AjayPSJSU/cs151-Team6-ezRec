package application;

public class Faculty {
	String name;
	String title;
	String school;
	String department;
	String email;
	String phone;
	private static boolean state = false;
	
	
	public Faculty(String name, String title, String school, String department, String email, String phone) {
		super();
		this.name = name;
		this.title = title;
		this.school = school;
		this.department = department;
		this.email = email;
		this.phone = phone;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}


	public static boolean isState() {
		return state;
	}

	public static void setState(boolean state) {
		Faculty.state = state;
	}
	
}
