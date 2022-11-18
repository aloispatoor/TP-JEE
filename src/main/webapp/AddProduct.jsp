<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Add a Product</title>
	<link rel='stylesheet' type='text/css' href='style.css' />
	</head>
	<body>
		<main>
		<% session.getAttribute("currentUser"); %>
			<h1>Add a Product</h1>
			<% if (request.getAttribute("error") != null) {	%>
				<h2>${error}</h2>
			<% } %>
			
			<form method='post'>
				<label for='txtUserId'> User:</label>
				<input name='txtUserId' type='text' value='${currentUser.id}'/>
				
				<label for='txtName'> Name:</label>
				<input name='txtName' type='text' value='${name}'/>

				<label for='txtDescription'> Description :</label>
				<input name='txtDescription' type='text' value='${description}'/>

				<label for='txtPrice'> Price :</label>
				<input name='txtPrice' type='number' value='${price}'/>

				<input name='btnSubmit' type='submit'/>
			</form>	
		</main>
	
	</body>
</html>