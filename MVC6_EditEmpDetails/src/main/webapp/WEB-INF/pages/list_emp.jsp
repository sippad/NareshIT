<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <title>List Employee</title> -->
</head>
<body>
	<!-- <h2> List of all employees </h2> -->
${delStatus} <br>
${insertStatus} <br>
${updateStatus}<br>

<table><tr><td>Emp NO</td><td>Emp Name</td><td>Emp desg</td><td>Salary</td></tr>
<c:forEach var="emp" items="${listEmp}">
	<tr>
	<td>${emp.eno}</td>
	<td>${emp.ename}</td>
	<td>${emp.desg}</td>
	<td>${emp.sal}</td>
	<td><a href="edit.htm?id=${emp.eno}">Edit</a></td>
	<td><a href="delete.htm?id=${emp.eno}">Delete</a></td>
	<tr>
</c:forEach>
</table>	
<a href="register.htm">Insert new record</a>
</body>
</html>	