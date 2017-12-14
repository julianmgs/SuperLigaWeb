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
  
    <form:form enctype="multipart/form-data" method="POST" modelAttribute="evento" action="${pageContext.request.contextPath}/eventos/upload" onsubmit="return confirm('Desea guardar el evento?');">
    <div class="row">
    <div class="row">
        <h4 class="header center orange-text">Nuevo evento</h4>
      </div>
    <form class="col s12">
    <div class="row">
	    <div class="file-field input-field">
		    <div class="btn">
		    	<span>File</span>
		    	<input type="file" name="file">
		    </div>
		    <div class="file-path-wrapper">
		    	<input class="file-path validate" type="text" name="name">
		    </div>
	    </div>
	  <button class="btn waves-effect waves-light" type="submit" name="update" value='update' >
        Guardar evento
	    <i class="material-icons right">done</i>
	  </button>
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
