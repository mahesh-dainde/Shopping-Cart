<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: #8524">
	<center>
		<h1 style="color: red">${msg}</h1>
		<form action="loginvalidation" method="post">
			Enter Email : <input type="email" name="email"
				placeholder="Enter Email" required="required"><br><br><br>
			Enter Password : <input type="password" name="password"
				placeholder="Enter Password" required="required"><br><br><br><br><br>
			<input type="submit">
		</form>
	</center>
</body>
</html>