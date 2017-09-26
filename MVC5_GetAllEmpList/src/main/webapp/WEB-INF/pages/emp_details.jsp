<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EMP DETAILS</title>
</head>
<body>
<table border="1">
<thead>Emp No</thead><thead>Emp Name</thead> <thead>Job</thead><thead>Salary</thead>
<c:forEach var="listemp" items="${listEmp}">		
	<tr>
		<td>${listemp.eno}</td>
		<td>${listemp.ename}</td>
		<td>${listemp.job}</td>
		<td>${listemp.sal}</td>
	</tr>	
</c:forEach>
</table>
</body>
</html>