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
 color:red;
 }
 h2
 {
 color:yellow;
 }
</style>
</head>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>
<div class = "main">
	<marquee class="marq" bgcolor = "#A9A9A9" direction = "left" loop="" scrolldelay="1"> 
	<div class="system1"><h1><b>Login page....!!!</b></h1></div> 
	</marquee> 
	</div> 
<center>
<br>
<br>
<form:form modelAttribute="admin" action="adminLogin" method="post">
<table>
			
			<tr>
				<td><label for="uId"><b>User Id:</b></label></td>
				
					<td><form:input path="userId" id="uId" required="true" placeholder="uId" /></td></tr>	
			<tr>
			
			<tr>
				<td><label for="uname"><b>UserName:</b></label></td>
				
					<td><form:input path="UserName" id="UserName" required="true" placeholder="User Name" /></td></tr>	
			<tr>
			<tr>
				<td><label for="pass"><b>Password:</b></label></td>
				
					<td><form:password path="password" id="pass" required="true" placeholder="Password" /></td></tr>	
			
			<tr>
				<td><label for="Role"><b>UserRole:</b></label></td>
				
					<td><form:input path="Role" id="Role" required="true" placeholder="Role" /></td></tr>	
			
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