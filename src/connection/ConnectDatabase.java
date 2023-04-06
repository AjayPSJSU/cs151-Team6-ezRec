package connection;


import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;


public class ConnectDatabase {
	
	private static Connection conn;  
	
	public static Connection connect() throws SQLException, ClassNotFoundException {  
    	Class.forName("org.sqlite.JDBC");
    	String url = "jdbc:sqlite:Database/Test2.db";   
           
       conn = DriverManager.getConnection(url);  
       return conn;
   }  

	

}
