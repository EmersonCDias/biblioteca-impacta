<!DOCTYPE html>
<html>
  <body>
  <%@include file="menu.html"%>
    <h1>Cadastrar Livro</h1>
    <hr />
    <form action="cadastrarLivro" method="get">
      Nome: <input type="text" name="nome" /><br />
      Autor: <input type="text" name="autor" /><br />      
      <input type="submit" value="Gravar" />
    </form>
  </body>
</html>