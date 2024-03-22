<%@page import="com.jsp.ShoppingCart.dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<style>
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	Customer customer = (Customer) session.getAttribute("customerinfo");
	if (customer != null) {
	%>
	<center>
		<h1 style="color: green">${msg}</h1>
		<h2>
			<a href="displayproducts">Display All Products</a>
		</h2>
		<h2>
			<a href="readBrandFromCustomer.jsp">Display Product By Brand</a>
		</h2>
		<h2>
			<a href="#">Display Product By Category</a>
		</h2>
		<h2>
			<a href="#">Display Product Between Range</a>
		</h2>
	</center>

	<%
	} else {
	%>
	<center>
		<h1>
			<a href="customerLoginForm.jsp">Please Login First</a>
		</h1>
	</center>
	<%
	}
	%>
</body>
</html>