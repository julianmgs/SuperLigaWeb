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
<div class="container">
    <div class="section">

      <!--   Icon Section   -->
      <div class="row">
        <br><br>
    	<div class="row center"> <%-- 375 523 --%>
    	<h4 class="header center orange-text" >500</h4>
    		<img alt="Acceso denegado" src="<c:url value="/resources/img/404-lost.jpg"/>" width="281" height="392" />
      	</div>
        
      </div>

    </div>
    <br><br>
    
  </div>
</main>
 <%@ include file="/WEB-INF/views/elements/footer.jsp" %>

  </body>
</html>
