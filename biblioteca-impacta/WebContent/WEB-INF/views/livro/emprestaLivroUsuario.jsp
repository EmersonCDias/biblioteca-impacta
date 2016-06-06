<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/menu.html"%>
	<form action="localizaUsuario">
	<input type="hidden" name="id" value="${registroEmprestimo.id}" />
    <input type="text" name="valor"/> <input type="submit" value="Procurar"/><br/>
    <input type="radio" name="tipo" value="cpf" checked /> CPF<br/>
	<input type="radio" name="tipo" value="nome" /> NOME<br/>
	<input type="radio" name="tipo" value="login" /> login<br/>
</form>
<!--	
	<form action="concluirEmprestimo" method="post">
 	<input type="hidden" name="idLivro" value="${registroEmprestimo.id}" />  
      Nome: <input type="text" name="nome" /><br />
      Ra: <input type="text" name="ra" /><br /> 
      Data Retirada: <input type="text" name="dataRetirada" /><br /> 
      Data Entrega: <input type="text" name="dataEntrega" /><br />      
      <input type="submit" value="Gravar" />
    </form>	-->
</body>
</html>