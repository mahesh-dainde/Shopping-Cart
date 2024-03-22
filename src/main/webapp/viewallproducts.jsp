<%@page import="com.jsp.ShoppingCart.dto.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.ShoppingCart.dto.Merchant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style >

</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	Merchant merchant = (Merchant) session.getAttribute("merchantinfo");
	List<Product> products = merchant.getProducts();
	%>
	<center>
	<table cellpadding="20px" border="1" class="table">
		<th>Id</th>
		<th>Brand</th>
		<th>Model</th>
		<th>Category</th>
		<th>Price</th>
		<th>Stock</th>
		<th>Update</th>
		<th>Delete</th>
		<%
		for (Product p : products) {
		%>
		<tr>
			<td><%=p.getId()%></td>
			<td><%=p.getBrand()%></td>
			<td><%=p.getModel()%></td>
			<td><%=p.getCategory()%></td>
			<td><%=p.getPrice()%></td>
			<td><%=p.getStock()%></td>
			<td><a href="updateproduct.jsp?id=<%=p.getId()%>">Update</a></td>
			<td><a href="deleteProduct?id=<%=p.getId()%>">Delete</a></td>
		</tr>
		<%
		}
		%>
	</table>
	</center>
</body>
</html>