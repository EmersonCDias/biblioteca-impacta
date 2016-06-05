<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <body>
  <%@include file="/menu.html"%>
    <h1>Cadastrar Livro</h1>
    <hr />
    <form action="cadastrarLivro" method="post">
      Nome: <input type="text" name="nome" /><br />
      Autor: <input type="text" name="autor" /><br />      
      <input type="submit" value="Gravar" />
    </form>
  </body>
</html>