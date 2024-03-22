<%@page import="com.jsp.ShoppingCart.dto.Merchant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	Merchant merchant = (Merchant) session.getAttribute("merchantinfo");
	%>
	<%
	if (merchant != null) {
	%>
	<center>

		<h1 style="color: green">${msg}</h1>
		<br>
		<h1>
			<a href="addproduct">Add Product</a>
		</h1>
		<br>

		<h1>
			<a href="viewallproducts.jsp">View All Products</a>
		</h1>
		<br>
	</center>
	<%
	} else {
	%>
	<h1>
		<a href="merchantLoginForm.jsp">Please Login First</a>
	</h1>
	<%
	}
	%>
</body>
</html>

