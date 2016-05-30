<%@page import="br.com.biblioteca.dao.LivroDao"%>
<%@page import="br.com.biblioteca.modelo.Livro"%>
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
	<%
	String teste = request.getParameter("id");
	LivroDao dao = new LivroDao();
	Livro livro = dao.CarregaLivro(Long.parseLong(teste));
	%>
	<table>
		<tr>
			<th>ID</th>
			<th>NOME</th>
			<th>AUTOR</th>
		</tr>
		<tr>
			<td><%=livro.getId()%></td>
			<td><%=livro.getNome()%></td>
			<td><%=livro.getAutor()%></td>
		</tr>
	</table>	
	
<form action="registroEmprestimo">
      NOME: <input type="text" name="nome"/></br>
      RA: <input type="text" name="ra"/></br>
      ID_LIVRO <input type="text" name="idLivro" value="<%=livro.getId()%>"/></br>
      RETIRADA: <input type="text" name="retirada"/></br>
      DEVOLUCAO: <input type="text" name="devolucao"/></br>
      <input type="submit" value="Gravar" />
</form>

</body>
</html>