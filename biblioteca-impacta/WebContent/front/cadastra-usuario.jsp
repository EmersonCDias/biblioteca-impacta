<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
		<head>
			<title>Cadastro de usuários</title>
	        <meta charset="utf-8">
	        <link rel="stylesheet" type="text/css" href="/biblioteca-impacta/css/styleBiblioteca.css" />
		</head>
		<body>
			<!--<%@include file="/menu.html"%> RETIRAR COMENTARIO!!!!!!!!!!!!!!!!!!!-->
			 <header>
	              <div id="nomeCabecalho">
	                <h1>BIBLIOTECA BOOK'S</h1>
	              </div>
	              <div class="nomeTela">
	                <h2>Cadastrar usuário</h2>
	              </div>
         	 </header>
			<section>
				<div id="voltarMenu">
                  	<a href="menu.html">Retornar ao MENU</a>
              	</div>
				<div class="estiloGeral" id="cadastroUsuario">
					<form action="cadastrarUsuario" method="post">
						<label>Nome: </label><br/>
							<input type="text" name="nome" /><br />
						<label>Login: </label><br/>
							<input type="text" name="login" /><br /> 
						<label>Senha: </label><br/>
							<input type="password" name="senha" /><br /> 
						<label>Tipo de Usuario:</label> <br/>
						<!-- <input type="text" name="tipo" /> -->
							<input class="radioEdition" type="radio" name="tipo" value="bibliotecario" /> 
								<label class="labelRadio">Bibliotecario</label><br/>
							<input class="radioEdition" type="radio" name="tipo" value="professor" /> 
								<label class="labelRadio">Professor</label><br/>
							<input class="radioEdition" type="radio" name="tipo" value="aluno" /> 
								<label class="labelRadio">Aluno</label>	
					</form>
				</div>
						<input class="submit" type="submit" value="GRAVAR" />
			</section>
			<footer>
              Copyright 2015 - Todos os direitos reservados.
            </footer>
		</body>
</html>