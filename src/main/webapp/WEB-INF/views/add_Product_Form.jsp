<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD PRODUCT</title>
</head>
<body>
	<h1>ADD PRODUCT</h1>
	<form action="handleForm" method="post">
	
	Product name:<input type="text" name="name" placeholder="Enter Product Name"><br>
	
	Product description:
	<textarea name="description" rows="5" placeholder="Enter Product description"></textarea><br>
	
	Product price:
	<input type="text" name="price" placeholder="Enter Product price"><br>
	
	<a href="${pageContext.request.contextPath }/">Back</a>
	
	<button type="submit">Add</button>
	
	
	</form>
</body>
</html>