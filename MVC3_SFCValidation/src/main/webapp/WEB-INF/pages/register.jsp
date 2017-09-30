<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<style>
	font {
		color : red; 
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Registration Form</title>
</head>
<body align="center">
	<form:form method="POST" commandName="stCmd">
		Student number : <form:input path="sno" /><font><form:errors path="sno"/></font><br><br>
		Student name : <form:input path="sname"/><font><form:errors path="sname"/></font><br><br>
		Student mobile : <form:input path="smob"/><font><form:errors path="smob"/></font><br><br>
		Student email : <form:input path="email"/><font><form:errors path="email"/></font><br><br>
		<input type="submit" value="REGISTER"/>
	</form:form>
</body>
</html>