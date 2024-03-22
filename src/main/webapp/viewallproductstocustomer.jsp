<%@page import="com.jsp.ShoppingCart.dto.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.ShoppingCart.dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	List<Product> products = (List<Product>) request.getAttribute("productlist");
	%>

	<center>
		<h1>
			<a href="fetchitemsfromcart">View Cart</a>
		</h1>
		<table cellpadding="20px" border="3">
			<th>Brand</th>
			<th>Model</th>
			<th>Category</th>
			<th>Price</th>
			<th>Add to Cart</th>
			<%
			for (Product p : products) {
			%>
			<tr>
				<td><%=p.getBrand()%></td>
				<td><%=p.getModel()%></td>
				<td><%=p.getCategory()%></td>
				<td><%=p.getPrice()%></td>
				<td><a href="additem?id=<%=p.getId()%>">add</a></td>
			</tr>
			<%
			}
			%>
		</table>
	</center>


</body>
</html>