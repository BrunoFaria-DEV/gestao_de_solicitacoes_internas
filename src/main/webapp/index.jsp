<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Página Inicial</title>
   	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/styles/styles.css">
</head>
<body>
    <h1 class="h1-center">Sistema de gestão de solicitações internas</h1>
    reservado para usuáruio autenticado
    <h2 class="h2-center">seja bem vindo:  </h2>
	fim reservado
	
    <div class="center-container">
        <%-- <a class="button-link" href="${pageContext.request.contextPath}/usuarios.do">Usuários</a> --%>
    </div>
</body>
</html>