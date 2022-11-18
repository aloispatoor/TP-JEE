package tp.jee.modele;

import java.util.Date;

public class Product {
	private int id;
	private User user;
	private String name;
	private String description;
	private float price;
	private Date createdAt;
	private Date updatedAt;
	
	public Product(int id, String name, String description, float price, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	
	public Product(int id, String name, User user, String description, float price, Date updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.user = user;
		this.description = description;
		this.price = price;
		this.updatedAt = updatedAt;
	}


	public Product(String name, User user, String description, float price, Date createdAt) {
		super();
		this.name = name;
		this.user = user;
		this.description = description;
		this.price = price;
		this.createdAt = createdAt;
	}
	
	


	public Product(String name, String description, float price, Date createdAt) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.createdAt = createdAt;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = new Date(System.currentTimeMillis());
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = new Date(System.currentTimeMillis());
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
