<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="tp.jee.modele.User" %>    
	<%@ page import="tp.jee.dao.UserDAO" %>    
	<%@ page import="java.sql.ResultSet" %>    
	<%@ page import="tp.jee.dao.UtilConnexion" %>  
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Log In</title>
	<link rel='stylesheet' type='text/css' href='style.css' />
	</head>
	<body>
		<main id="login">
			<h1>Log in</h1>
			<% if (request.getAttribute("error") != null) {	%>
				<h2>${error}</h2>
			<% } %>
			<form method="POST" action="login">
				<input name="txtLogin" type="text" value="${login}" placeholder="login">
				<input name="txtPassword" type="password" value="${password}" placeholder="password">
				<input name="btnConnect" type="submit" value="Send">
			</form>
		</main>
	
	</body>
</html>