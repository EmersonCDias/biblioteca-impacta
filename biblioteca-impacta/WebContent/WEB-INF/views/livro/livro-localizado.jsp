<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="/menu.html"%>
<table border="1px">
	<!-- percorre clientes montando as linhas da tabela -->
	
	<tr>
		<th>NOME</th>
		<th>AUTOR</th>
	</tr>
		<tr>
			<td>${livroLocalizado.nome}</td>
			<td>${livroLocalizado.autor}</td>
			<td><a href="mvc?logica=EmprestarLivro&id=${contato.id}">Emprestar</a></td>
		</tr>
</table>
</body>
</html>