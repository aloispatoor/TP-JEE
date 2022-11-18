<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="tp.jee.modele.Product" %>    
<%@ page import="tp.jee.dao.ProductDAO" %>    
<%@ page import="tp.jee.dao.UserDAO" %>    
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
		<% session.getAttribute("currentUser"); %>
		<h1>List of Products</h1>
		<% if (request.getAttribute("error") != null) {	%>
			<h2>${error}</h2>
		<% } %>
		<div class="button-container">
			<a href="/TP-M2i/add">Add a Product</a>
			<a href="/TP-M2i/logout">Logout</a>
		</div>
		<section>
			<% for(Product p : ProductDAO.getAllProducts()) {%>
			<article>
				<h2><%=p.getName() %></h2>
				<p><%=p.getDescription() %></p>
				<p><%=p.getPrice() %> Euro</p>
				<small><%=p.getCreatedAt() %></small>
				<div class="button-container">
					<a href='/TP-M2i/update?id=<%= p.getId() %>' class="danger">Update</a>
					<a href='/TP-M2i/delete?id=<%= p.getId() %>' class="mid">Delete</a>
				</div>
			</article>
			<% } %>
		</section>
	</main>
	
	</body>
</html>