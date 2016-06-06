<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
		<head>
			<title>Emprestar livro</title>
	        <meta charset="utf-8">
	        <link rel="stylesheet" type="text/css" href="/biblioteca-impacta/css/styleBiblioteca.css" />
		</head>
		<body>
			<!--<%@include file="menu.html"%>
			<%String teste = request.getParameter("id");
			LivroDao dao = new LivroDao();
			Livro livro = dao.CarregaLivro(Long.parseLong(teste));%>RETIRAR COMENTARIO!!!!!!!!!!!!!!!!!!!-->
			
				<header>
		              <div id="nomeCabecalho">
		                <h1>BIBLIOTECA BOOK'S</h1>
		              </div>
		              <div class="nomeTela">
		                <h2>Emprestar livro</h2>
		              </div>
	         	 </header>
				<section>
						<div id="voltarMenu">
		                  <a href="menu.html">Retornar ao MENU</a>
		              	</div>						
						<div class="estiloGeral" id="emprestarLivro">
							<form action="registroEmprestimo">
							      <label>NOME:</label><br/>
							      	<input type="text" name="nome"/></br>
							      <label>RA: </label> <br/>
							      	<input type="text" name="ra"/></br>
							      <label>ID_LIVRO </label> <br/>
							      	<input type="text" name="idLivro" value="<%=livro.getId()%>"/></br>
							      <label>RETIRADA: </label> <br/>
							      	<input type="text" name="retirada"/></br>
							      <label>DEVOLUÇÃO: </label><br/>
							      	<input type="text" name="devolucao"/></br>
							</form>
						</div>
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
						<input id="submitEmprestarLivro" type="submit" value="GRAVAR" />
				</section>
				<footer>
              		Copyright 2015 - Todos os direitos reservados.
            	</footer>
		</body>
</html>