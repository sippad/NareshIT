<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register New Employee</title>
</head>
<body>
<h2>Employee Registration</h2>
<form:form method="POST" commandName="empCmd">
	Emp No : <form:input path="eno"/><font><form:errors path="eno"/></font><br>
	Emp Name : <form:input path="ename"/><font><form:errors path="ename"/></font><br>
	Designation : <form:input path="desg"/><font><form:errors path="desg"/></font><br>
	Salary : <form:input path="sal"/><font><form:errors path="sal"/></font><br>
	 <input type="submit" value="Register"/>
</form:form>
</body>
</html>