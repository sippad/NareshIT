<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Registration Form</title>
</head>
<body align="center">
<h1>REGISTRATION FORM</h1>
<form:errors path="*"/>
<form:form>
	<form:input path="sname"/><br>
	<form:input path="age"/><br>
	<form:input path="mobile"/><br><br>
	<input type="submit" value="Register"/>
</form:form>
</body>
</html>