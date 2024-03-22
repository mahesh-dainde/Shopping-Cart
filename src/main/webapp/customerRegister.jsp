<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.registration-container {
	background-color: #fff;
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

.registration-container h2 {
	margin-top: 0;
}

.form-group {
	margin-bottom: 20px;
}

.form-group label {
	display: block;
	margin-bottom: 5px;
	font-weight: bold;
}

.form-group input[type="text"], 
.form-group input[type="password"],
.form-group input[type="email"]
.form-group input[type="number"] {
	width: 100%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 3px;
	box-sizing: border-box;
}

.form-group input[type="submit"] {
	width: 100%;
	padding: 10px;
	background-color: #007bff;
	color: #fff;
	border: none;
	border-radius: 3px;
	cursor: pointer;
}

.form-group input[type="submit"]:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>

	<div class="registration-container">
		<h2>Create an Account</h2>
		<form:form action="savecustomer" modelAttribute="customerobj"
			method="post">
			<div class="form-group">
				<label for="username">Username:</label>
				<form:input path="name" id="username" required="true" />
			</div>
			<div class="form-group">
				<label for="address">Address:</label>
				<form:input path="address" id="address" required="true" />
			</div>
			<div class="form-group">
				<label for="mobilenumber">MobileNumber:</label>
				<form:input path="mobilenumber" id="number" required="true" />
			</div>
			<div class="form-group">
				<label for="email">Email:</label>
				<form:input path="email" id="email" required="true" />
			</div>
			<div class="form-group">
				<label for="password">Password:</label>
				<form:password path="password" id="password" required="true" />
			</div>
			<div class="form-group">
				<input type="submit" value="Register">
			</div>
		</form:form>
	</div>
</body>
</html>