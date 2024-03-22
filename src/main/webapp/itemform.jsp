<%@page import="com.jsp.ShoppingCart.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% Product p=(Product) request.getAttribute("productobj");
	%>
	<center>
	<form action="additemtocart">
		<input type="hidden" name="id" value=<%=p.getId() %> readonly="true" ><br><br> 
		Brand    : <input type="text" name="brand" value=<%=p.getBrand() %> readonly="true"><br><br>
		Model    : <input type="text" name="model" value=<%=p.getModel() %> readonly="true"><br><br>
		Category : <input type="text" name="category" value=<%=p.getCategory() %> readonly="true" > <br><br>
		Price    : <input type="number" name="price" value=<%=p.getPrice() %> readonly="true" ><br><br>
		Quantity : <input type="number" name="quantity"  ><br><br>
		<input type="submit" value="Add to Cart">
	</form>
	</center>
</body>
</html>