<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<h1>Welcome Page!</h1>
	<span>Welcome ${email}</span>
	<span>Password: ${password}</span>
	<h5>Recipes</h5>


<table>
	<thead>
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Votes</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${recipes}" var="recipe">
		<tr>
			<td>${recipe.name}</td>
			<td>${recipe.description}</td>
			<td>${recipe.vote}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<a href="/jsp/newrecipe">
	<button type="button"> New Recipe </button>
</a>

</body>
</html>