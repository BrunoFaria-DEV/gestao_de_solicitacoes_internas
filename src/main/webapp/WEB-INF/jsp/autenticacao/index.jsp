<%@	page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@	page import="java.util.List"%>
<%@ page import="br.edu.ifmt.cba.DTO.UsuarioDto" %> 

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/styles/styles.css">
	<title>Usuarios</title>
</head>
<body>

	<h1>Gestão de Usuários</h1>

	<div class="header-with-button">
		<h2>Lista de Usuários</h2>
			<html:link page="/usuarios.do?parameter=novo" styleClass="button-link">Novo</html:link>
	</div>

	<table>
		<thead>
			<tr>
				<th>Nome</th>
				<th>Email</th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="usuario" items="${usuarios}">
				encontrado
				<tr>
					<td>${usuario.nome}</td>
					<td>${usuario.email}</td>
					<td>
						<html:link page="/usuarios.do?parameter=editar" paramId="usuario_id" paramProperty="id" paramName="usuario" styleClass="button-link">Editar</html:link>
				        <form action="<c:url value='/usuarios.do?parameter=excluir'/>" method="POST" style="display:inline; margin-left: 5px;">
				            <input type="hidden" name="id" value="${usuario.id}">
				            <button type="submit" class="btn btn-danger btn-sm" 
				                    onclick="return confirm('Tem certeza que deseja excluir o usuário \'${usuario.nome}\'?');">
				                Excluir
				            </button>
				        </form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>