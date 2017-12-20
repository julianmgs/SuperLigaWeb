<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Super Liga Rosario</title>
<%@ include file="/WEB-INF/views/elements/head.jsp" %>

</head>
<body>
<%@ include file="/WEB-INF/views/elements/nav.jsp" %>
<main>
<div class="section container">
  <div class="section">
  
    <form:form id="formContacto" method="POST" modelAttribute="mensaje" action="${pageContext.request.contextPath}/contacto"  >
    <div class="row">
    <div class="row">
        <h4 class="header center orange-text">Nuevo usuario</h4>
      </div>
    <form class="col s12">
      <div class="row">
        <div class="input-field col s5 offset-s1">
          <form:input path="nombre" id="nombre" type="text" required="required" aria-required="true" />
          <label for="nombre">Nombre</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s5 offset-s1">
          <form:input path="email" id="email" type="text" required="required" aria-required="true" />
          <label for="email">Email</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s5 offset-s1">
          <form:input path="asunto" id="asunto" type="text" required="required" aria-required="true" />
          <label for="asunto">Asunto</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s5 offset-s1">
          <form:textarea path="mensaje" id="mensaje" type="text" required="required" aria-required="true" class="materialize-textarea" />
          <label for="mensaje">Mensaje</label>
        </div>
      </div>
      <div class="row">
      <div class="input-field col s10 offset-s1">
        <button class="btn waves-effect waves-light" type="submit" name="create" value='create' >
        Enviar
	    <i class="material-icons right">done</i>
	    </button>
	  </div>
      </div>
    </form>
  </div>
  </form:form>

  </div>

</div>
</main>
<%@ include file="/WEB-INF/views/elements/footer.jsp" %>

</body>
</html>
