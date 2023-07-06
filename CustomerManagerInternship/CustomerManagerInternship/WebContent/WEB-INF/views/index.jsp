<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Manager</title>
</head>

<body bgcolor=#85DCB>
<div align="center">
	<div style='width: 100%;height: 50px;background-color: white;text-align: center;'><h2>Customer Management System</h2></div>
	<br>
	<form method="get" action="search">
		<input type="text" name="keyword" /> &nbsp;
		<input type="submit" value="Search" />
	</form>
	<h3><a href="new">Add Customer</a></h3>
	<h4>ALL CUSTOMERS</h4>

	<table border="4" cellpadding="8" bordercolor=#C38D9E style='background-color: #E8BFC9;'>
		<tr>
			<th style='background-color:#B78D98'>ID</th>
			<th style='background-color:#B78D98'>Name</th>
			<th style='background-color:#B78D98'>E-mail</th>
			<th style='background-color:#B78D98'>Address</th>
			<th style='background-color:#B78D98'>Action</th>
		</tr>
		<c:forEach items="${listCustomer}" var="customer">
		<tr>
			<td>${customer.id}</td>
			<td>${customer.name}</td>
			<td>${customer.email}</td>
			<td>${customer.address}</td>
			<td>
				<button><a href="edit?id=${customer.id}">Edit</a></button>
				&nbsp;&nbsp;&nbsp;
				<button><a href="delete?id=${customer.id}">Delete</a></button>
			</td>
		</tr>
		</c:forEach>
	</table>
	
</div>	
</body>
</html>