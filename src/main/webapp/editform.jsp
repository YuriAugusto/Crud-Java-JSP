<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Edição do Usuário</title>
	</head>
	<body>
		<%@ page import="com.crudjspjava.bean.Usuario, com.crudjspjava.dao.UsuarioDao"%>

		<%
			String id = request.getParameter("id");
			Usuario usuario = UsuarioDao.getRegistroById(Integer.parseInt(id));
		%>
	</body>
</html>