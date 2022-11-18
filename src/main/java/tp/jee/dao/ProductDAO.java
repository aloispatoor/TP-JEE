package tp.jee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import tp.jee.modele.Product;
import tp.jee.modele.User;

public class ProductDAO {
	
	public static List<Product> getAllProducts(){
		List<Product> listp = new ArrayList<>();
		
		try {
			Connection con = UtilConnexion.seConnecter();
			ResultSet rs = con.createStatement().executeQuery("SELECT * FROM products;");
			
			while ( rs.next() ) {
				listp.add(new Product(
					rs.getInt("id"),
					rs.getString("name"),
					rs.getString("description"),
					rs.getFloat("price"),
					rs.getDate("created_at"),
					rs.getDate("updated_at")
					));
			}
			
			rs.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listp;
	}
	
	public static Product getProdById(int id) {
		Product prod = null;
		
		try {
			Connection con = UtilConnexion.seConnecter();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM products WHERE id=?;");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if ( rs.next()) {
				prod = new Product(
					rs.getInt("id"),
					rs.getString("name"),
					rs.getString("description"),
					rs.getFloat("price"),
					rs.getDate("createdAt"),
					rs.getDate("updatedAt")
				);
			}
			
			rs.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prod;
	}
	
	public static boolean addProduct(String name, String description, User user, float price, Date createdAt) {
		return addProduct(new Product(name, user, description, price, createdAt));
	}
	
	public static boolean addProduct(Product p) {
		
		try {
			Connection con = UtilConnexion.seConnecter();
			
			PreparedStatement ps = con.prepareStatement("INSERT INTO products(name, description, price, user_id) VALUE( ?, ?, ?);");
			ps.setString(1, p.getName());
			ps.setString(2, p.getDescription());
			ps.setFloat(3, p.getPrice());
			ps.setInt(4, p.getUser().getId());
			
			ps.executeUpdate();
			
			con.close();
			System.out.println("Product Added");
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean deleteProduct(int id) {
		try {
			Connection con = UtilConnexion.seConnecter();
			
			PreparedStatement ps = con.prepareStatement("DELETE FROM products WHERE id=?;");
			ps.setInt(1, id);
			ps.executeUpdate();
			
			con.close();
			
			System.out.println("Product Deleted");

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean updateProduct(int id, String name, User user, String description, float price, Date updatedAt) {
		return updateProduct(new Product(id, name, user, description, price, updatedAt));
	}
	
	public static boolean updateProduct(Product p) {
		
		try {
			Connection con = UtilConnexion.seConnecter();
			
			PreparedStatement ps = con.prepareStatement("UPDATE products SET name=?, description=?, price=? WHERE id=?;");
			ps.setString(1, p.getName());
			ps.setString(2, p.getDescription());
			ps.setFloat(3, p.getPrice());
			ps.setInt(4, p.getId());
			
			ps.executeUpdate();
			
			con.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
}
