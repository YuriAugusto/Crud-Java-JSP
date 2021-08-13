
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Visualização de Usuários</title>
</head>
<body>
	<%@ page
		import="com.crudjspjava.dao.UsuarioDao, com.crudjspjava.bean.*, java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%-- c é a var de acesso a uri --%>

	<h1>Listagem de Usuários</h1>
	<% 
			List<Usuario> list = UsuarioDao.getAllUsuarios();
			request.setAttribute("list", list);//1º arg atributo 2ºarg lista acessada por list
		%>

	<table border="1">
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Password</th>
			<th>Email</th>
			<th>Sexo</th>
			<th>País</th>
			<th>Editar</th>
			<th>Excluir</th>
		</tr>
		<c:forEach items="${list}" var="usuario">
			<%-- iteração da lista --%>
			<tr>
				<td>${usuario.getId()}</td>
				<td>${usuario.getNome()}</td>
				<td>${usuario.getPassword()}</td>
				<td>${usuario.getEmail()}</td>
				<td>${usuario.getSexo()}</td>
				<td>${usuario.getPais()}</td>
				<td><a href="editform.jsp?id=${usuario.getId()}">Editar</a></td>
				<%-- Aqui eu envio o id do usuário --%>
				<td><a href="#">Excluir</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="addusuarioform.jsp">Adicionar novo Usuário</a>
</body>
</html>