<%@ page import="java.lang.String" %> 
<%@	page import="java.util.List"%>
<%@ page import="br.edu.ifmt.cba.DTO.LoginDto" %> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/styles/styles.css">
	<title>Login</title>
</head>
<body>

    <div class="form-container">
        <div class="header-with-button space-between">
            <h2>Login</h2>
			<html:link page="/usuarios.do?parameter=inicio" styleClass="button-link">Home</html:link>
        </div>

  		<html:form action="login.do" method="POST">
		    <div class="form-group">
		        <label for="email">E-mail:</label>
		        <html:text property="email" styleId="email" styleClass="form-control" />
		    </div>
		    
			<div class="form-group">
		        <label for="senha">Senha:</label>
		        <html:text property="senha" styleId="senha" styleClass="form-control" />
		    </div>

		    <div class="form-group">
		        <html:submit styleClass="submit-button">Enviar</html:submit>
		    </div>
        </html:form> 
    </div>
    
</body>
</html>