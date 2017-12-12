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
  
    <div class="row">
    <div id="test1" class="col s12">
    <div class="row">
    <h4 class="header center orange-text">Próximos eventos</h4>
    </div>
    <div class="row">
    <c:forEach items="${eventos}" var="e">

    	<div class="col s12 m6">
	    <div class="card horizontal">
	      <div class="card-image">
	        <img src="<c:url value="resources/img/eventos/${e.img}"/>">
	      </div>
	      <div class="card-stacked">
	        <div class="card-content">
	          <p>${e.evento.descripcion}</p>
	          <p>${e.evento.formato.nombre}</p>
	          <p>
	          	<fmt:formatDate pattern="EEEE, d" value="${e.evento.fecha}" /> de <fmt:formatDate pattern="MMMM" value="${e.evento.fecha}" />
	          </p>
	          <p><fmt:formatDate pattern="HH:mm" value="${e.evento.hora}" /> Hrs</p>
	        </div>
	        <div class="card-action">
	          <a href="${e.evento.fbUrl}" target="_blank">Evento en Facebook</a>
	        </div>
	      </div>
	    </div>
	    </div>
    
    </c:forEach>
    </div>
    </div>
    </div>
    
<%-- 
<div class="row">
   <div class="col s12 m6">
    <div class="card horizontal">
      <div class="card-image">
        <img src="http://lorempixel.com/100/190/nature/6">
      </div>
      <div class="card-stacked">
        <div class="card-content">
          <p>I am a very simple card. I am good at containing small bits of information.</p>
        </div>
        <div class="card-action">
          <a href="#">This is a link</a>
        </div>
      </div>
    </div>
    </div>
    <div class="col s12 m6">
    <div class="card horizontal">
      <div class="card-image">
        <img src="http://lorempixel.com/100/190/nature/6">
      </div>
      <div class="card-stacked">
        <div class="card-content">
          <p>I am a very simple card. I am good at containing small bits of information.</p>
        </div>
        <div class="card-action">
          <a href="#">This is a link</a>
        </div>
      </div>
    </div>
  </div>
</div>
    <br><br>
--%>




  </div>
  </div>
</main>
 <%@ include file="/WEB-INF/views/elements/footer.jsp" %>

  </body>
</html>
