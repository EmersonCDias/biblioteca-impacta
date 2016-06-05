<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Cadastro de Usuario</title>
</head>
<body>
	<%@include file="/menu.html"%>
	<h1>Cadastrar Usuario</h1>
	<hr />
	<form action="cadastrarUsuario" method="post">

		Nome: <input type="text" name="nome" /><br /> 
		Login: <input type="text" name="login" /><br /> 
		Senha: <input type="password" name="senha" /><br /> 
		
		Tipo de Usuario: <br/>
		<!-- <input type="text" name="tipo" /> -->
		<input type="radio" name="tipo" value="bibliotecario" /> Bibliotecario<br />
		<input type="radio" name="tipo" value="professor" /> Professor<br />
		<input type="radio" name="tipo" value="aluno" /> Aluno<br /> 
		<input type="submit" value="Gravar" /> 
	</form>
</body>
</html>