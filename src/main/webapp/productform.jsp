<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<form:form action="saveproduct" modelAttribute="productobj">
			Enter Brand    : <form:input path="brand" />
			<br>
			<br>
			Enter Model    : <form:input path="model" />
			<br>
			<br>
			Enter Category : <form:input path="category" />
			<br>
			<br>
			Enter Price    : <form:input path="price" />
			<br>
			<br>
			Enter Stock    : <form:input path="stock" />
			<br>
			<br>
			<input type="submit">
		</form:form>
	</center>
</body>
</html>