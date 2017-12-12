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
  
    <form:form id="formUsuario" method="POST" modelAttribute="user" action="${pageContext.request.contextPath}/users/save"  >
    <div class="row">
    <div class="row">
        <h4 class="header center orange-text">Nuevo usuario</h4>
      </div>
    <form class="col s12">
      <div class="row">
        <div class="input-field col s5 offset-s1">
          <form:input path="username" id="username" type="text" required="required" aria-required="true" />
          <label for="username">Nombre de usuario</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s5 offset-s1">
          <form:input path="password" id="password" type="password" required="required" aria-required="true" />
          <label for="password">Contrase&ntilde;a</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s5 offset-s1">
          <input id="password_again" type="password" required="required" aria-required="true" >
          <label for="password_again">Contrase&ntilde;a</label>
        </div>
      </div>
      <div class="row">
      <div class="input-field col s10 offset-s1">
        <button class="btn waves-effect waves-light" type="submit" name="create" value='create' >
        Crear usuario
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

<%--
<script type="text/javascript">

$.validator.setDefaults({
    errorClass: 'invalid',
    validClass: "valid",
    errorPlacement: function (error, element) {
        $(element)
            .closest("form")
            .find("label[for='" + element.attr("id") + "']")
            .attr('data-error', error.text());
    }
});

$("#formUsuario").validate({
    rules: {
    	username: {
    		minlength: 5
        }, 
        password: {
    		minlength: 5
        }, 
        password_again: {
        	minlength: 5
        }
    }
});
</script>
--%>

</body>
</html>
