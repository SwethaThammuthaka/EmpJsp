<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<style>
 body {
  background-size: 80% 90%;
  background-repeat: no-repeat, repeat;
  background-color: #D8BFD8;
  background-size: cover;
  padding: 30px;
  height: 600px;
  font-family: 'Lato', sans-serif;
  background-color: rgba(255, 0, 0, 0.4);
  font-family: Arial, Helvetica, sans-serif;
 }
 td
 {
 color:black;
 }
 h2
 {
 color:red;
 }
</style>
</head>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>
<div class = "main">
	<marquee class="marq" bgcolor = "#A9A9A9" direction = "left" loop="" scrolldelay="1"> 
	<div class="system1"><h1><b>Employee Details....!!!</b></h1></div> 
	</marquee> 
	</div> 
<center>
<br>
<br>
<form:form modelAttribute="admin" action="adminLogin" method="post">
<table>
			
			<tr>
				<td><label for="eId"><b>Employee Id:</b></label></td>
				
					<td><form:input path="employeeId" id="eId" required="true" placeholder="eId" /></td>
			</tr>	
		
			
			<tr>
				<td><label for="fname"><b>FirstName:</b></label></td>
				
					<td><form:input path="FirstName" id="fName" required="true" placeholder="User Name" /></td></tr>	
			
			
			<tr>
				<td><label for="lname"><b>LastName:</b></label></td>
				
					<td><form:input path="LastName:" id="lName" required="true" placeholder="User Name" /></td></tr>	
			
			
			<tr>
				<td><label for="gender"><b>Gender:</b></label></td>
				
					<td><form:input path="Gender" id="gender" required="true" placeholder="User Name" /></td></tr>	
			
			
			<tr>
				<td><label for="basic"><b>Basic:</b></label></td>
				
					<td><form:input path="Basic" id="basic" required="true" placeholder="User Name" /></td></tr>	
			<tr>
			
			<tr>
				<td><label for="uname"><b>Designation:</b></label></td>
				
					<td><form:input path="Designation" id="fName" required="true" placeholder="User Name" /></td></tr>	
			
			
			<tr>
				<td><label for="uname"><b>MaritalStatus:</b></label></td>
				
					<td><form:input path="MaritalStatus:" id="fName" required="true" placeholder="User Name" /></td></tr>	
			
			
			
			
			</table>
			<br>
				<div>
					<button type="submit">Login</button>
				</div>
<h2>${message}</h2>
</form:form>
</center>
</body>
</html>