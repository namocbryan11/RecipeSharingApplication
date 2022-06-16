<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form action="/jsp/newrecipe" method="post">
		<label for="name"> Name </label>
		<input type="text" name="name" id="name"> 
		<label for="name"> Description </label>
		<input type="text" name="description" id="description"> 
		
		<input type="submit" value="submit">
	</form>
		
</body>
</html>