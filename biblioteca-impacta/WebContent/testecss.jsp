<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
      <head>
		<link rel="stylesheet" type="text/css" href="/biblioteca-impacta/css/styleBiblioteca.css" />
          <title>Cadastro de livro</title>
          <meta charset="utf-8">
<!-- 		<link type="text/css" rel="stylesheet" href="<c:url value="/styleBiblioteca.css" />" />  -->          
<!--        <link rel="stylesheet" type="text/css" href="<%request.getContextPath();%>/resources/theme1/css/styleBiblioteca.css" /> -->

          
      </head>
      <body>
          <header>
              <div id="nomeCabecalho">
                <h1>BIBLIOTECA BOOK'S</h1>
              </div>
              <div class="nomeTela">
                <h2>Cadastrar livro</h2>
              </div>
         </header>   
          <!--%@include file="/menu.html"%> RETIRAR COMENTARIO!!!!!!!!!!!!!!!!!!!!!!!!--> 
            <section>
              <div id="voltarMenu">
                  <a href="menu.html">Retornar ao MENU</a>
              </div>
              <div class="estiloGeral" id="cadastroLivro" >
                  <form action="cadastrarLivro" method="post">
                      <label>Título: </label><br/>
                        <input type="text" name="nome" /><br />
                      <label>Autor: </label><br/>
                        <input type="text" name="autor" /><br />      
                      
                  </form>
              </div>
                      <input class="submit" type="submit" value="GRAVAR" />
            </section>
            <footer>
              Copyright 2015 - Todos os direitos reservados.
            </footer>
      </body>
</html>