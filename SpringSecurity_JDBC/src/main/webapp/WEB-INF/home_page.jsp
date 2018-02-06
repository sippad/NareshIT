<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<a href="admin"> Admin</a>		<br>
	AuthType: ${pageContext.request.authType} <br>
	Username : ${pageContext.request.userPrincipal.name}
	<br>
	<a href="cust"> Customer </a>
</body>
</html>