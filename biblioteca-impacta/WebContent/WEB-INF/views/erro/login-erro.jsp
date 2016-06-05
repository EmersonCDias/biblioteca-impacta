<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
</head>
<body>
	<%-- <%@include file="/menu.html"%> --%>
	<h1>Login ou senha não foi digitado corretamente!</h1><br/>
	<h2>Digite o Login e Senha</h2>
	<hr />
	<form action="efetuaLogin" method="post">
		Login: <input type="text" name="login" /><br />
		Senha: <input type="password" name="senha" /><br />
		<input type="submit" value="Entrar">
	</form>

</body>
</html>