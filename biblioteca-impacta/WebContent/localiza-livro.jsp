<%@page import="br.com.biblioteca.dao.LivroDao"%>
<%@page import="br.com.biblioteca.modelo.Livro"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="menu.html"%>
<jsp:useBean id="dao" class="br.com.biblioteca.dao.LivroDao"/>
<form action="localiza-livro.jsp">
      ID LIVRO: <input type="text" name="id"/> <input type="submit"/>
</form>
<table border="1px">
	<!-- percorre clientes montando as linhas da tabela -->
	
	<tr>
		<th>NOME</th>
		<th>AUTOR</th>
	</tr>
		<tr>
		<%
		String teste = request.getParameter("id");
		LivroDao dao2 = new LivroDao();
		Livro livro = dao2.CarregaLivro(Long.parseLong(teste));
		%>
			<td><%=livro.getNome()%></td>
			<td><%=livro.getAutor()%></td>
			<td><a href="mvc?logica=EmprestarLivro&id=${contato.id}">Emprestar</a></td>
		</tr>
</table>

</body>
</html>