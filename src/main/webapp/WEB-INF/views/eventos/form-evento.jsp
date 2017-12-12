<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Super Liga Rosario</title>
<%@ include file="/WEB-INF/views/elements/head.jsp" %>
</head>
<body>
<%@ include file="/WEB-INF/views/elements/nav.jsp" %>
<main>
<div class="container">
  <div class="section">
  
    <form:form method="POST" modelAttribute="evento" action="/SuperLigaWeb/eventos/save" onsubmit="return confirm('Desea guardar el evento?');">
    <form:hidden path="id"/>
    <form:hidden path="fechaTimestamp"/>
    <div class="row">
    <div class="row">
        <h4 class="header center orange-text">Nuevo evento</h4>
      </div>
    <form class="col s12">
      <div class="row">
        <div class="input-field col s5 offset-s1">
          <form:input path="descripcion" id="descripcion" type="text" class="validate" required="required" maxlength="50" />
          <label for="descripcion">Descripci&oacute;n del evento</label>
        </div>
        <div class="input-field col s3">
        <form:input value="${evento.fecha}" path="fecha" id="fecha-evento" type="date" class="validate" required="required" />
        </div>
        <div class="input-field col s2">
        <form:input path="hora" id="hora-evento" type="time" class="validate" required="required" />
        </div>
      </div>
      <div class="row">
        <div class="input-field col s5 offset-s1">
            <form:select id="tipo-evento" path="tipoEvento.id" required="required" >
            	<form:option value="">-- Elija un tipo de evento --</form:option>
		    	<form:options items="${tiposEvento}" itemValue="id" itemLabel="descripcion"/>
		    </form:select>
		    <label for="evento">Tipo de evento</label>
        </div>
        <div class="input-field col s5">
            <form:select id="formato" path="formato.id" required="required" >
            	<form:option value="">-- Elija un formato --</form:option>
		    	<form:options items="${formatos}" itemValue="id" itemLabel="nombre" />
		    </form:select>
		    <label for="formato">Formato del evento</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s10 offset-s1">
          <form:input path="fbUrl" id="fb_url" type="text" class="validate" />
          <label for="fb_url">Link del evento de Facebook</label>
        </div>
      </div>
      <div class="row">
      <div class="input-field col s10 offset-s1">
      <c:if test="${evento.id == null}">
        <button class="btn waves-effect waves-light" type="submit" name="create" value='create' >
        Crear evento
	    <i class="material-icons right">done</i>
	  </button>
	  </c:if>
	  <c:if test="${evento.id != null}">
	   <button class="btn waves-effect waves-light" type="submit" name="update" value='update' >
        Guardar evento
	    <i class="material-icons right">done</i>
	  </button>
	  </c:if>
	  </div>
      </div>
    </form>
  </div>
  </form:form>

  </div>

</div>
</main>
<%@ include file="/WEB-INF/views/elements/footer.jsp" %>
<script type="text/javascript">
$(document).ready(function() {
    $('select').material_select();
  });
</script>

</body>
</html>
