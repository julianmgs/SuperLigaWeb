<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!-- Dropdown Structure -->
<sec:authorize access="isAuthenticated()">
	<ul id="ddAdmin" class="dropdown-content">
	  <li><a href="<c:url value="/eventos/upload" />">Subir evento</a></li>
	  <li><a href="<c:url value="/eventos/new" />">Crear evento</a></li>
	  <li><a href="<c:url value="/eventos/list" />">Lista de eventos</a></li>
	  <li class="divider"></li>
	  <li><a href="<c:url value="/productos/list" />">Lista de productos</a></li>
	  <sec:authorize  access="hasRole('ROLE_ADMIN')">
	  <li class="divider"></li>
	  <li><a href="<c:url value="/users/new" />">Nuevo usuario</a></li>
	  </sec:authorize>
	</ul>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
	<ul id="ddAdminMob" class="dropdown-content">
	  <li><a href="<c:url value="/eventos/upload" />">Subir evento</a></li>
	  <li><a href="<c:url value="/eventos/new" />">Crear evento</a></li>
	  <li><a href="<c:url value="/eventos/list" />">Lista de eventos</a></li>
	  <li class="divider"></li>
	  <li><a href="<c:url value="/productos/list" />">Lista de productos</a></li>
	  <sec:authorize  access="hasRole('ROLE_ADMIN')">
	  <li class="divider"></li>
	  <li><a href="<c:url value="/users/new" />">Nuevo usuario</a></li>
	  </sec:authorize>
	</ul>
</sec:authorize>
<div class="navbar-fixed">
<nav class="green lighten-1">
  <div class="nav-wrapper container">
    <a href="<c:url value="/" />" class="brand-logo">MTG Rosario</a>
    <a href="#" data-activates="mobile" class="button-collapse"><i class="material-icons">menu</i></a>

    <!-- Para version mobile -->
    <ul class="side-nav" id="mobile" >
      <li>
	  	<a href="<c:url value="/calendario" />" >
	    	Calendario
	  	</a>
	  </li>
      <li>
	  	<a href="<c:url value="/proximos" />" >
	    	Pr&oacute;ximos eventos
	  	</a>
	  </li>
      <li>
	  	<a href="<c:url value="/about" />" >
	    	Sobre nosotros
	  	</a>
	  </li>
      <!-- Dropdown Trigger -->
      <sec:authorize access="isAuthenticated()">
		    <li>
			    <form id="logoutForm" action="<%=request.getContextPath()%>/appLogout" method="POST">
			     <a href="#!" onclick="document.getElementById('logoutForm').submit();" >
			     	<i class="material-icons">power_settings_new</i>
			     </a>	
			    </form>
		    </li>
	        <li>
	        	<a class="dropdown-button" href="#!" data-activates="ddAdminMob" data-constrainwidth="false" data-beloworigin="true" data-alignment="left"><i class="material-icons">more_vert</i></a>
	        </li>
	  </sec:authorize>
	  <sec:authorize access="!isAuthenticated()">
	        <li>
	        	<a href="<c:url value="/login" />" >
	        		<i class="material-icons">settings</i>
	        	</a>
	        </li>
	  </sec:authorize>
    </ul>
    
    <ul class="nav right hide-on-med-and-down">
      <li>
	  	<a href="<c:url value="/eventos/upload" />" >
	    	Subir
	  	</a>
	  </li>
      <li >
	  	<a href="<c:url value="/calendario" />" >
	    	Calendario
	  	</a>
	  </li>
      <li>
	  	<a href="<c:url value="/proximos" />" >
	    	Pr&oacute;ximos eventos
	  	</a>
	  </li>
      <li>
	  	<a href="<c:url value="/about" />" >
	    	Sobre nosotros
	  	</a>
	  </li>
      <!-- Dropdown Trigger -->
      <sec:authorize access="isAuthenticated()">
		    <li>
			    <form id="logoutForm" action="<%=request.getContextPath()%>/appLogout" method="POST">
			     <a href="#!" onclick="document.getElementById('logoutForm').submit();" class="tooltipped" data-position="bottom" data-delay="50" data-tooltip="Cerrar sesión" >
			     	<i class="material-icons">power_settings_new</i>
			     </a>	
			    </form>
		    </li>
	        <li>
	        	<a class="dropdown-button" href="#!" data-activates="ddAdmin" data-constrainwidth="false" data-beloworigin="true" data-alignment="right"><i class="material-icons">more_vert</i></a>
	        </li>
	  </sec:authorize>
	  <sec:authorize access="!isAuthenticated()">
	        <li>
	        	<a href="<c:url value="/login" />" >
	        		<i class="material-icons">settings</i>
	        	</a>
	        </li>
	  </sec:authorize>
    </ul>
    
  </div>
</nav>
</div>