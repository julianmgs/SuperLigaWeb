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
<div class="section container">
  <div class="section">
  
    <form:form method="POST" modelAttribute="producto" action="${pageContext.request.contextPath}/productos/save" onsubmit="return confirm('Desea guardar el evento?');">
    <form:hidden path="id"/>
    <div class="row">
    <div class="row">
        <h4 class="header center orange-text">Nuevo Producto</h4>
      </div>
    <form class="col s12">
      <div class="row">
        <div class="input-field col s4 offset-s1">
          <form:input path="nombre" id="nombre" type="text" class="validate" required="required" maxlength="50" />
          <label for="nombre">Nombre</label>
        </div>
        <div class="input-field col s2">
          <form:input path="precio" id="precio" type="number" min="1" step="any" />
          <label for="precio">Precio</label>
        </div>
        <div class="input-field col s2">
	      <form:checkbox class="filled-in" path="hayStock" id="hayStock" />
	      <label for="hayStock">Hay Stock</label>
        </div>
        <div class="input-field col s2">
	      <form:checkbox class="filled-in" path="enabled" id="enabled" />
	      <label for="enabled">Habilitar</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s10 offset-s1">
          <div class="btn">
	        <span>File</span>
	        <input type="file">
	      </div>
	      <div class="file-path-wrapper">
	        <input class="file-path validate" type="text" name="">
	      </div>
        </div>
      </div>
      <div class="row">
      <div class="input-field col s10 offset-s1">
        <button class="btn waves-effect waves-light" type="submit" name="create" >
        Crear producto
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
<script type="text/javascript">
$(document).ready(function() {
    $('select').material_select();
  });
</script>

</body>
</html>
