package tp.jee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.DatabaseMetaData;

public class UtilConnexion {
	
	public static Connection seConnecter() throws Exception {
			
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/tpjee","root","root");
			
		} catch (ClassNotFoundException e) {
			throw new Exception("ClassNotFoundException :" + e.getMessage()); 
		} catch (SQLException e) {
			throw new Exception("ClassNotFoundException :" + e.getMessage()); 
		}
	}
	
}
