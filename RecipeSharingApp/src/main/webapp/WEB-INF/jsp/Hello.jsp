<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN</title>
</head>
<body>
	<h1>Login Page</h1>
	<form action="/api/login" method="post">
		<input type="email" placeholder="Email" name="email">
		<input type="password" placeholder="Password" name="password">
		<button type="submit"> Login </button>
	</form>
	
	<h2>Welcome ${email}</h2>
</body>
</html>