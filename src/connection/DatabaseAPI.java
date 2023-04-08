package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
			String queryString = "insert into Letter(FirstName, LastName, academic, personal, program, grade, course, semester, year, date) VALUES(?,?,?,?,?,?,?,?,?,?)";
			statement = dataConnection.prepareStatement(queryString);	
			
			statement.setString(1, letter.getFirstName());
			statement.setString(2, letter.getLastName());
			statement.setString(3, letter.getAcademic());
			statement.setString(4, letter.getPersonal());
			statement.setString(5, letter.getProgram());
			statement.setString(6, letter.getGrade());
			statement.setString(7, letter.getCourse());
			statement.setString(8, letter.getSemester());
			statement.setString(9, letter.getYear());
			statement.setString(10, letter.getDate());
			
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
			System.out.println(deleteString);
			String insertString = "insert into Accounts values(\"" + newPassword + "\",0)";
			statement.executeUpdate(insertString);	
			System.out.println(insertString);
			

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

}
