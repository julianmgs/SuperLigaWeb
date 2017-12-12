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
  
  <div class="row">
  <c:if test="${'fail' eq param.auth}">
       <div class="input-field col s4 offset-s4">
         	<div class="alert alert-dismissable card-panel red lighten-1" id="card-alert" >
          <span class="white-text">Nombre de usuario y password inválidos.</span>
          <button type="button" class="close white-text" data-dismiss="alert" aria-label="Close">
             	<span aria-hidden="true">×</span>
             </button>
        </div>
      </div>
    </c:if>
    <br>
	<form action="<%=request.getContextPath()%>/login" method="POST" class="col s12">
		<div class="row">
			<div class="input-field col s4 offset-s4">
			  <i class="material-icons prefix">account_circle</i>
	          <input autofocus="autofocus" id="app_username" name="app_username" type="text" >
	          <label for="app_username">Nombre de usuario</label>
	        </div>
	        </div>
        <div class="row">
	        <div class="input-field col s4 offset-s4">
	          <i class="material-icons prefix">lock</i>
	          <input id="app_password" name="app_password" type="password" >
	          <label for="app_password">Contrase&ntilde;a</label>
	        </div>	
	        </div>
        <div class="row">
        <div class="input-field col s4 offset-s4">
			<button class="btn waves-effect waves-light col s12" type="submit" name="update" value='Login' >
	        Ingresar
		  	</button>
		</div>
	  	</div>	
	</form>
  </div>
  </div>

  </div>
</main>
 <%@ include file="/WEB-INF/views/elements/footer.jsp" %>

  </body>
</html>
