<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel='stylesheet' type='text/css' href='style.css' />
	</head>
	<body>
		<main>
		<% session.getAttribute("currentUser"); %>
			<h1>Add a Product</h1>
			
			<form method='post'>
				<label for='txtName'> Name:</label>
				<input name='txtName' type='text' value='${p.name}'/>

				<label for='txtDescription'> Description :</label>
				<input name='txtDescription' type='text' value='${p.description}'/>

				<label for='txtPrice'> Price :</label>
				<input name='txtPrice' type='number' value='${p.price}'/>

				<input name='btnSubmit' type='submit' value="Send"/>
			</form>	
		</main>
	</body>
</html>