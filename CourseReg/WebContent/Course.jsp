<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Course</title>
</head>
<body>
<form action="">
<h3>Course Details</h3>
<label for="courseDetails">Select Course:</label>
<select name="course" >
 
  <option value="Devops">Devops</option>
  <option value="Iot">IOt</option>
  <option value="Ml">ML</option>
  <option value="springBoot">Spring Boot</option>
  <option value="All">All</option>
</select><br>
<input type="submit" value="Submit">
</form>


<%
String course = request.getParameter("course");
if(course != null){
%>
<table>
<tr>
<td>Student Id</td>
<td>Student Name</td>
<td>Phone Number</td>
<td>Email</td>
<td>Branch</td>
<td>Current Year</td>
<td>Gender</td>
<td>Courses</td>
<tr>
<%
try{
Class.forName("com.mysql.cj.jdbc.Driver");
java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/coursereg","root","root");
ResultSet rs=null;
if(course.equals("All"))
{
	PreparedStatement ps = con.prepareStatement("select r.student_id,r.student_name,r.phone_number,r.email,r.branch,r.current_year,r.gender,c.courses from student r,course c where r.student_id = c.student_id  ");
	rs = ps.executeQuery();}	
else{
PreparedStatement ps = con.prepareStatement("select r.student_id,r.student_name,r.phone_number,r.email,r.branch,r.current_year,r.gender,c.courses from student r,course c where r.student_id = c.student_id and c.courses = ?");
ps.setString(1, course);
 rs = ps.executeQuery();}
%>
<%while(rs.next()){ %>
<tr>
<td><%=rs.getString("student_id")%></td>
<td><%=rs.getString("student_name")%></td>
<td><%=rs.getString("phone_number")%></td>
<td><%=rs.getString("email")%></td>
<td><%=rs.getString("branch")%></td>
<td><%=rs.getString("current_year")%></td>
<td><%=rs.getString("gender")%></td>
<td><%=rs.getString("courses")%></td>
</tr>
<%} %>
<%
}
catch(ClassNotFoundException e){
e.printStackTrace();
}

} 
%>
</table>
</body>
</html>
