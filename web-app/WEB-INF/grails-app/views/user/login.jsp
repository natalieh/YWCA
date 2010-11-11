<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<div class="body">
<g:form action="doLogin" method="post">
<div class="dialog">
<p>Enter your login details below:</p>
<table class="userForm">
<tr class='prop'>
<td valign='top' style='text-align:left;' width='20%'>
<label for='email'>Email:</label>
</td>
<td valign='top' style='text-align:left;' width='80%'>
<input id='email' type='text' name='email' value='${user?.email}' />
</td>
</tr>
<tr class='prop'>
<td valign='top' style='text-align:left;' width='20%'>
<label for='password'>Password:</label>
</td>
<td valign='top' style='text-align:left;' width='80%'>
<input id="password" type='password' name='password'
value='${user?.password}' />
</td>
</tr>
</table>
</div>
<div class="buttons">
<span class="formButton">
<input type="submit" value="Login"></input>
</span>
</div>
</g:form>
</div>
</body>
</html>