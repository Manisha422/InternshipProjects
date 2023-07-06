<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Customer</title>
</head>
<body bgcolor= #FBF7D5>
	<div align="center">
		<h2>Edit Customer</h2>
		<form:form action="save" method="post" modelAttribute="customer">
			<table border="0" cellpadding="5">
				<tr>
					<td>ID: </td>
					<td>${customer.id}
						<form:hidden path="id"/>
					</td>
				</tr>			
				<tr>
					<td>Name: </td>
					<td><form:input required="required" path="name" /></td>
				</tr>
				<tr>
					<td>Email: </td>
					<td><form:input required="required" path="email" type="email" /></td>
				</tr>
				<tr>
					<td>Address: </td>
					<td><form:input required="required" path="address" /></td>
				</tr>		
				<tr>
					<td colspan="2"><center><input type="submit" value="Save"></center></td>
				</tr>						
			</table>
		</form:form>
	</div>
</body>
</html>