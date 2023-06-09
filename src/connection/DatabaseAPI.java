package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import application.Faculty;
import application.Letter;

public class DatabaseAPI {
	
	
	private ArrayList<String> helper(ResultSet resultSet, String querry) throws SQLException {
		ArrayList<String> resultArrayList = new ArrayList<String>();
		while (resultSet.next()) {
			if (querry.equals("Semesters")) 
				resultArrayList.add(resultSet.getString("semesters"));
			if (querry.equals("Programs")) 
				resultArrayList.add(resultSet.getString("name"));
			if (querry.equals("Pcharacteristics")) 
				resultArrayList.add(resultSet.getString("characteristics"));
			if (querry.equals("Acharacteristics")) 
				resultArrayList.add(resultSet.getString("characteristics"));
			if (querry.equals("Course")) 
				resultArrayList.add(resultSet.getString("course"));
			if (querry.equals("Accounts")) 
				resultArrayList.add(resultSet.getString("Password"));
		}
		
		return resultArrayList;
		
	}
	public ArrayList<String> getSemester() {
		Connection dataConnection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<String> temp = null;
		try {
			
			dataConnection = ConnectDatabase.connect();
			String queryString = "select * from Semesters";
			statement = dataConnection.createStatement();		
			resultSet =  statement.executeQuery(queryString);			
			temp = helper(resultSet, "Semesters");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				statement.close();
				resultSet.close();
				dataConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return temp;
		
	}
	public ArrayList<String> getPrograms() {
		Connection dataConnection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<String> temp = null;
		try {
			
			dataConnection = ConnectDatabase.connect();
			String queryString = "select * from Programs";
			statement = dataConnection.createStatement();		
			resultSet =  statement.executeQuery(queryString);			
			temp = helper(resultSet, "Programs");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				statement.close();
				resultSet.close();
				dataConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return temp;
		
	}
	public ArrayList<String> getCourse() {
		Connection dataConnection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<String> temp = null;
		try {
			
			dataConnection = ConnectDatabase.connect();
			String queryString = "select * from Courses";
			statement = dataConnection.createStatement();		
			resultSet =  statement.executeQuery(queryString);			
			temp = helper(resultSet, "Course");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				statement.close();
				resultSet.close();
				dataConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return temp;
		
	}
	public ArrayList<String> getPcharacteristics() {
		Connection dataConnection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<String> temp = null;
		try {
			
			dataConnection = ConnectDatabase.connect();
			String queryString = "select * from Pcharacteristics";
			statement = dataConnection.createStatement();		
			resultSet =  statement.executeQuery(queryString);			
			temp = helper(resultSet, "Pcharacteristics");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				statement.close();
				resultSet.close();
				dataConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return temp;
		
	}
	public ArrayList<String> getAcharacteristics() {
		Connection dataConnection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<String> temp = null;
		try {
			
			dataConnection = ConnectDatabase.connect();
			String queryString = "select * from Acharacteristics";
			statement = dataConnection.createStatement();		
			resultSet =  statement.executeQuery(queryString);			
			temp = helper(resultSet, "Acharacteristics");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				statement.close();
				resultSet.close();
				dataConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return temp;
		
	}
	public String getPassword() {
		Connection dataConnection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<String> temp = null;
		try {
			
			dataConnection = ConnectDatabase.connect();
			String queryString = "select * from Accounts";
			statement = dataConnection.createStatement();		
			resultSet =  statement.executeQuery(queryString);			
			temp = helper(resultSet, "Accounts");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				statement.close();
				resultSet.close();
				dataConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		String out = temp.size() > 0 ? temp.get(0) : "p";
		return out;
		
	}

	
	public void saveForm(Letter letter) {
		Connection dataConnection = null;
		PreparedStatement  statement = null;
		try {
			
			dataConnection = ConnectDatabase.connect();
			String queryString = "insert into Letter(FirstName, LastName, academic, personal, program, grade, course, semester, year, date, gender, draft, school) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			statement = dataConnection.prepareStatement(queryString);
			
			String acaString = letter.getAcademic().toString();
			String perString = letter.getPersonal().toString();
			String course = letter.getCourse().toString();
			String grade = letter.getGrade().toString();
			
			statement.setString(1, letter.getFirstName());
			statement.setString(2, letter.getLastName());
			statement.setString(3, acaString.substring(1, acaString.length()-1));
			statement.setString(4, perString.substring(1, perString.length()-1));
			statement.setString(5, letter.getProgram());
			statement.setString(6, grade.substring(1, grade.length()-1));
			statement.setString(7, course.substring(1, course.length()-1));
			statement.setString(8, letter.getSemester());
			statement.setString(9, letter.getYear());
			statement.setString(10, letter.getDate());
			statement.setString(11, letter.getGender());

			statement.setString(12, letter.getDraft());
			statement.setString(13, letter.getSchool());
			
			statement.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				statement.close();
				dataConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void setPassword(String newPassword) {
		Connection dataConnection = null;
		Statement statement = null;
		try {
			
			dataConnection = ConnectDatabase.connect();
			String deleteString = "delete from Accounts";
			statement = dataConnection.createStatement();	
			statement.executeUpdate(deleteString);	
			String insertString = "insert into Accounts values(\"" + newPassword + "\",0)";
			statement.executeUpdate(insertString);	

			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				statement.close();
				dataConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	public boolean checkPassword(String input) {
		String correctPw = getPassword();
		return input.equals(correctPw);
	}
	public boolean isFirstTime() {
		Connection dataConnection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<String> temp = null;
		try {
			
			dataConnection = ConnectDatabase.connect();
			String queryString = "select * from Accounts";
			statement = dataConnection.createStatement();		
			resultSet =  statement.executeQuery(queryString);			
			temp = helper(resultSet, "Accounts");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				statement.close();
				resultSet.close();
				dataConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return temp.size() == 0;

	}
	
	public void addSemester(String semester) {
		Connection dataConnection = null;
		PreparedStatement  statement = null;
		try {
			
			dataConnection = ConnectDatabase.connect();
			String queryString = "insert into Semesters(semesters) VALUES(?)";
			statement = dataConnection.prepareStatement(queryString);		
			statement.setString(1, semester);			
			statement.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				statement.close();
				dataConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
		public void addCourses(String course) {
			Connection dataConnection = null;
			PreparedStatement  statement = null;
			try {
				
				dataConnection = ConnectDatabase.connect();
				String queryString = "insert into Courses(course) VALUES(?)";
				statement = dataConnection.prepareStatement(queryString);		
				statement.setString(1, course);			
				statement.executeUpdate();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					statement.close();
					dataConnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
		
		public void addPrograms(String program) {
			Connection dataConnection = null;
			PreparedStatement  statement = null;
			try {
				
				dataConnection = ConnectDatabase.connect();
				String queryString = "insert into Programs(name) VALUES(?)";
				statement = dataConnection.prepareStatement(queryString);		
				statement.setString(1, program);			
				statement.executeUpdate();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					statement.close();
					dataConnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
		public void addPersonal(String personal) {
			Connection dataConnection = null;
			PreparedStatement  statement = null;
			try {
				
				dataConnection = ConnectDatabase.connect();
				String queryString = "insert into Pcharacteristics(characteristics) VALUES(?)";
				statement = dataConnection.prepareStatement(queryString);		
				statement.setString(1, personal);			
				statement.executeUpdate();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					statement.close();
					dataConnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
		
		public void addAcademic(String academic) {
			Connection dataConnection = null;
			PreparedStatement  statement = null;
			try {
				
				dataConnection = ConnectDatabase.connect();
				String queryString = "insert into Acharacteristics(characteristics) VALUES(?)";
				statement = dataConnection.prepareStatement(queryString);		
				statement.setString(1, academic);			
				statement.executeUpdate();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					statement.close();
					dataConnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
		
		public void addFaculty(Faculty faculty) {
			Connection dataConnection = null;
			PreparedStatement  statement = null;
			try {
				
				dataConnection = ConnectDatabase.connect();
				String queryString = "insert into Faculty(name, title, school, department, email, phone) VALUES(?,?,?,?,?,?)";
				statement = dataConnection.prepareStatement(queryString);	
				
				statement.setString(1, faculty.getName());
				statement.setString(2, faculty.getTitle());
				statement.setString(3, faculty.getSchool());
				statement.setString(4, faculty.getDepartment());
				statement.setString(5, faculty.getEmail());
				statement.setString(6, faculty.getPhone());

				
				statement.executeUpdate();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					statement.close();
					dataConnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

		public Faculty getFaculty() {
			Connection dataConnection = null;
			Statement statement = null;
			ResultSet resultSet = null;
			Faculty faculty = null;
			try {
				
				dataConnection = ConnectDatabase.connect();
				String queryString = "select * from Faculty";
				statement = dataConnection.createStatement();		
				resultSet =  statement.executeQuery(queryString);			
				faculty = new Faculty(resultSet.getString("name"), resultSet.getString("title"), 
											  resultSet.getString("school"), resultSet.getString("department"), 
											  resultSet.getString("email"), resultSet.getString("phone"));
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					statement.close();
					resultSet.close();
					dataConnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		
			return faculty;
			
		}
		public ArrayList<Letter> searchLetter(String str) {
			Connection dataConnection = null;
			Statement statement = null;
			ResultSet resultSet = null;
		
			ArrayList<Letter> letters = new ArrayList<>();
			try {
				
				dataConnection = ConnectDatabase.connect();
				String queryString = "SELECT * FROM Letter WHERE FirstName IN (" + str + ") OR LastName IN (" + str + ") OR year IN (" +  str + ")";
				statement = dataConnection.createStatement();		
				resultSet =  statement.executeQuery(queryString);			
				while(resultSet.next()) {
					ArrayList<String> academic = new ArrayList<String>( Arrays.asList(resultSet.getString("academic").trim().split(", ")));
					ArrayList<String> personal = new ArrayList<String>(  Arrays.asList(resultSet.getString("personal").trim().split(", ")));
					ArrayList<String> course = new ArrayList<String>( Arrays.asList(resultSet.getString("course").trim().split(", ")));
					ArrayList<String> grade = new ArrayList<String>(  Arrays.asList(resultSet.getString("grade").trim().split(", ")));
					
					Letter l = new Letter(resultSet.getString("FirstName"), resultSet.getString("LastName"), academic, personal, 
										  resultSet.getString("program"), grade, course, resultSet.getString("semester"), 
										  resultSet.getString("year"), resultSet.getString("date"), resultSet.getString("gender"), resultSet.getString("draft"), resultSet.getString("school"));
				
					l.setId(resultSet.getInt("Letter_id"));
					
					letters.add(l);
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					statement.close();
					resultSet.close();
					dataConnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		
			return letters;
			
		}

		public void removeLetter(Letter letter) {
			Connection dataConnection = null;
			PreparedStatement  statement = null;
			try {
				
				dataConnection = ConnectDatabase.connect();
				String queryString = "DELETE FROM Letter WHERE rowid = " + letter.getId();
				statement = dataConnection.prepareStatement(queryString);		
						
				statement.executeUpdate();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					statement.close();
					dataConnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

}
