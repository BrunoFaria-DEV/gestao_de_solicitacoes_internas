<%@ page import="java.util.List" %>
<%@ page import="br.edu.ifmt.cba.Model.Usuario" %> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Editar Usuário</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/styles/styles.css">
</head>
<body>

    <div class="form-container">
        <div class="header-with-button space-between">
       		<h2>Editar Usuário</h2>
			<html:link page="/usuarios.do" styleClass="button-link">Voltar</html:link>
        </div>
        
  		<html:form action="usuariosAtualizar.do" method="POST">
	  		<html:hidden property="id" />

		    <c:if test="${not empty errors}">
		        <div class="alert-danger">${errors}</div>
		    </c:if>
		    
		    <div class="form-group">
		        <label for="nome">Nome:</label>
		        <html:text property="nome" styleId="nome" styleClass="form-control" />
		    </div>
		
		    <div class="form-group">
		        <label for="email">E-mail:</label>
		        <html:text property="email" styleId="email" styleClass="form-control" />
		    </div>
		    
		    <div class="form-group">
		        <label for="cpf">CPF:</label>
		        <html:text property="cpf" styleId="cpf" styleClass="form-control" maxlength="14" />
		    </div>
		    
		    <div class="form-group">
		        <label for="municipio_id">Município:</label>
		        <html:select property="city.id" styleId="municipio_id" styleClass="form-control">
		            <html:option value="">Selecione um município</html:option>
       				<html:optionsCollection name="cities" label="nome" value="id" />
		        </html:select>
		    </div>
		
		    <div class="form-group">
		        <html:submit styleClass="submit-button">Enviar</html:submit>
		    </div>
        </html:form> 
    </div>
    
</body>
</html>