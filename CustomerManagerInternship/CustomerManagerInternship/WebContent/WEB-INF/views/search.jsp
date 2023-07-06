<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Result</title>
</head>
<body bgcolor=#d5b8ff >
<div align="center">
	<h2>Search Result</h2>
	
	<table border="1" cellpadding="5" bordercolor=purple>
		<tr>
			<th bgcolor=#bf55ec >ID</th>
			<th bgcolor=#bf55ec >Name</th>
			<th bgcolor=#bf55ec >E-mail</th>
			<th bgcolor=#bf55ec >Address</th>
		</tr>
		<c:forEach items="${result}" var="customer">
		<tr>
			<td>${customer.id}</td>
			<td>${customer.name}</td>
			<td>${customer.email}</td>
			<td>${customer.address}</td>
		</tr>
		</c:forEach>
	</table>
</div>	
</body>
</html>