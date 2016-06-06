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
<form action="localizaLivro">
    Entrega:<input type="text" name="dataEntrega"/><br/>
	Devolucao:<input type="text" name="dataDevolucao"/><br/>
	 <input type="submit" value="Concluir"/>
</form>
</body>
</html>