<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
</head>
<body>
<form method="post" action="/SpringSecurity_Standalone/j_spring_security_check">
<table border="0" align="center">
<tr><td align="center"  colspan="2">Login page</td></tr>
<tr><td>Username </td> <td><input type="text" name="j_username"></td></tr>
<tr><td>Password </td> <td><input type="text" name="j_password"></td></tr>
<tr><td colspan="2"><input type="checkbox" name="_spring_security_remember_me">Remember Me</td></tr>
<tr><td  align="right" colspan="2"><input  type="submit" value="Login"/></td><tr>
</table>
</form>
</body>
</html>