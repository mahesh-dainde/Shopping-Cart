<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	color:"red";
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	background-image:url("download.jpg");
	/* Replace 'shopping_background.jpg' with your image file */
	background-size: cover;
	background-repeat: no-repeat;
}

.login-container {
	background-color: rgba(255, 255, 255, 0.8);
	/* Transparent white background */
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
	text-align: center;
}

.login-container h2 {
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

.form-group input[type="text"], .form-group input[type="password"] {
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
<body style="background-image: url('login.avif');">
	<center> <h1>${msg}</h1> </center>
	<div class="login-container">
		<h2>Login to Your Account</h2>
		<form action="customerloginvalidation" method="post">
			<div class="form-group">
				<label for="username">Username/Email:</label> <input type="text"
					id="username" name="email" required>
			</div>
			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					id="password" name="password" required>
			</div>
			<div class="form-group">
				<input type="submit" value="Login">
			</div>
		</form>
	</div>
</body>
</html>