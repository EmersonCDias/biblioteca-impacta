<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Livros Cadastrados</title>
</head>
<body>
<%@include file="/menu.html"%>
<table border="1px">
	<!-- percorre clientes montando as linhas da tabela -->
	
	<tr>
		<th>ID</th>
		<th>NOME</th>
		<th>AUTOR</th>
		<th>STATUS</th>
		<th>ACAO</th>
	</tr>
	<c:forEach items="${livro}" var="livro">
		<tr>
			<td>${livro.id}</td>
			<td>${livro.nome}</td>
			<td>${livro.autor}</td>
			<td>${livro.status}</td>
		<td><a href="emprestaLivro?id=${livro.id}">Emprestar</a></td> 
<!--  	<td><a href="emprestar-livro.jsp?id=${livro.id}">Emprestar</a></td> 	-->   
<!-- 		<td><a href="mvc?logica=EmprestarLivro&id=${livro.id}">Emprestar</a></td>   -->
		</tr>
	</c:forEach>
</table>
</body>
</html>