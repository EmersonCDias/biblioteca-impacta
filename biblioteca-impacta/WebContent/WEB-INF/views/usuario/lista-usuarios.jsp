<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usuarios Cadastrados</title>
</head>
<body>
<%@include file="/menu.html"%>
<table border="1px">
	<!-- percorre usuarios montando as linhas da tabela -->
	
	<tr>
		<th>ID</th>
		<th>NOME</th>
		<!-- <th>LOGIN</th>-->
		<th>TIPO</th>
	</tr>
	<c:forEach items="${usuario}" var="usuario">
		<tr>
			<td>${usuario.id}</td>
			<td>${usuario.nome}</td>
<%-- 			<td>${usuario.login}</td> --%>
  			<td>${usuario.tipo}</td> 
			<!-- <td><a href="emprestaLivro">Emprestar</a></td> -->
<!-- 		<td><a href="emprestar-livro.jsp?id=${livro.id}">Emprestar</a></td>   -->
<!-- 		<td><a href="mvc?logica=EmprestarLivro&id=${livro.id}">Emprestar</a></td>   -->
		</tr>
	</c:forEach>
</table>
</body>
</html>