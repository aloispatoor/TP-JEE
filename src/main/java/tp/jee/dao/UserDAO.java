package tp.jee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import tp.jee.modele.User;

public class UserDAO {
	public static boolean createUser(User u) {
			
		try {
			Connection con = UtilConnexion.seConnecter();
			
			PreparedStatement ps = con.prepareStatement("INSERT INTO users(username, email, password) VALUE( ?, ?, ?);");
			
			ps.setString(1, u.getLogin());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
			
			ps.executeUpdate();
			
			con.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean ConnectUser(String login, String password) {
		try {
			Connection con = UtilConnexion.seConnecter();
			ResultSet rs = con.createStatement().executeQuery("SELECT * FROM users;");
			
			while ( rs.next() ) {
				String BDDLogin = rs.getString("username");
				String BDDPassword = rs.getString("password");
				if(login.equals(BDDLogin) && password.equals(BDDPassword)) {
					return true;
				}
			}
			
			rs.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;	
	}

	
	public static boolean isValidUser(String email, String login, String password, String confirmation) {
		if ( email == null) email ="";
		if ( login == null) login = "";
		if ( password == null) password = "";
		if ( confirmation == null) confirmation = "";
		
		if (!email.contains("@") || login == null || "".equals(login) || password.length() < 8 || !confirmation.equals(password) || "".equals(confirmation)){
			return false;
		} 
		return true;
	}
}
