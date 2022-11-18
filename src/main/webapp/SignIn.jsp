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
		<main id="signin">
			<h1>Sign In</h1>
	
			<% if (request.getAttribute("error") != null) {	%>
				<h2>${error}</h2>
			<% } %>
		
			<form method='post'>
				<label for='txtEmail'> Email :</label>
				<input name='txtEmail' type='text' value='${email}'/>

				<label for='txtLogin'> Login :</label>
				<input name='txtLogin' type='text' value='${login}'/>

				<label for='txtPassword'> Password :</label>
				<input name='txtPassword' type='password' value='${password}'/>

				<label for='txtPasswordConfirmation'> Confirmation :</label>
				<input name='txtPasswordConfirmation' type='password' value='${confirmation}'/>

				<input name='btnSubmit' type='submit'/>
			</form>	
		</main>
	</body>
</html>