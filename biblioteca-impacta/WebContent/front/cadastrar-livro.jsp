<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
      <head>
          <title>Cadastro de livro</title>
          <meta charset="utf-8">
          <link rel="stylesheet" type="text/css" href="/biblioteca-impacta/css/styleBiblioteca.css" />
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
                      
                       <input class="submit" type="submit" value="GRAVAR" />
                  </form>
              </div>
                     
            </section>
            <footer>
              Copyright 2015 - Todos os direitos reservados.
            </footer>
      </body>
</html>