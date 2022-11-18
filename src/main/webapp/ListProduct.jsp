<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="tp.jee.modele.Product" %>    
<%@ page import="tp.jee.dao.ProductDAO" %>    
<%@ page import="java.sql.ResultSet" %>    
<%@ page import="tp.jee.dao.UtilConnexion" %>    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>List of Products</title>
	<link rel='stylesheet' type='text/css' href='style.css' />
	</head>
	<body>
	<main id="ListProducts">
		<section>
			<% for(Product p : ProductDAO.getAllProducts()) {%>
			<article>
				<h2><%= p.getName() %></h2>
				<p><%= p.getDescription() %></p>
				<p><%= p.getPrice() %></p>
				<small><%= p.getCreatedAt() %></small>
				<div class="button-container">
					<a href='/TP-M2i/update?id=<%= p.getId() %>'>Update</a>
					<a href='/TP-M2i/delete?id=<%= p.getId() %>'>Delete</a>
				</div>
			</article>
			<% } %>
		</section>
		<div class="button-container">
			<a href="">Add a Product</a>
		</div>
	</main>
	
	</body>
</html>