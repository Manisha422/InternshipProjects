<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Here!!</title>
<link rel="stylesheet" href="CourseReg.css">
</head>
<body>
<br>
<h1><b><center>ONLINE COURSE REGISTRATION FORM</center> </b></h1><br>

<form action="CourseReg" method="post">

<label for="id">Student ID:</label>
		<input type="text" id="id" name="sid" placeholder="Enter student id" required>

		<label for="name">Student Name</label>
		<input type="text" id="name" name="sname" placeholder="Enter your name" required>

		<label for="pnumber">Phone Number</label>
		<input type="tel" id="pnumber" name="phno" placeholder="Enter your phone number" required>

		<label for="email">Email</label>
		<input type="email" id="email" name="email" placeholder="Enter your email" required>

		<label for="branch">Branch</label>
		<input type="text" id="branch" name="branch" placeholder="Enter your branch" required>
		
		<label for="currentYear">Current Year</label>
		<input type="text" id="currentYear" name="currentYear" placeholder="Enter current year" required>

		<label for="gender">Gender:</label>
		<select id="gender" name="gender" required>
			<option value="">Select your gender</option>
			<option value="male">Male</option>
			<option value="female">Female</option>
			<option value="other">Other</option>
		</select>
		
		<label for="course">Select Course</label>
		<input type="checkbox" name="course" value="Devops"> Devops<br>
		 <input type="checkbox" name="course" value="Iot"> IOT<br>
	     <input type="checkbox" name="course" value="Ml"> ML<br>
	     <input type="checkbox" name="course" value="SpringBoot"> Spring Boot
		
		
		<br>
		<center><input type="submit" value="Register"></center><br>
<tr>
   <center><td align='center'><a href="Course.jsp">Click here to view course details</a></td></center>
</tr>




</form>

</body>
</html>