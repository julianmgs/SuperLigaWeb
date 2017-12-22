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
  <div class="row">
    <div class="col s12">
      <ul class="tabs">
        <li class="tab col s3"><a class="active" href="#tab-pendientes">Eventos pendientes</a></li>
        <li class="tab col s3"><a href="#tab-sancionados">Eventos sancionados</a></li>
      </ul>
    </div>
    <div id="tab-pendientes" class="col s12">
     <div class="material-table">
     <div class="table-header">
        <h4 class="header center orange-text table-title">Eventos pendientes</h4>
        <div class="actions">
          <a href="#" class="search-toggle waves-effect btn-flat nopadding"><i class="material-icons">search</i></a>
        </div>
      </div>
      <div id="eventos-pendientes_wrapper" class="dataTables_wrapper no-footer" >
    <table id="eventos-pendientes" class="dataTable no-footer bordered highlight">
    <thead>
		<tr>
			<th data-field="fecha">
				Fecha y Hora
			</th>
			<th data-field="descripcion">
				Descripci&oacute;n
			</th>
			<th data-field="tipoEvento">
				Tipo de evento
			</th>
			<th data-field="formato">
				Formato
			</th>
			<th class="center">
				Opciones
			</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${eventosPendientes}" var="evento">
			<tr>
			<td><fmt:formatDate value="${evento.fecha}" pattern="dd/MM/yyyy" />&nbsp;&nbsp;<fmt:formatDate value="${evento.hora}" pattern="HH:mm" /></td>
			<td>${evento.descripcion}</td>
			<td>${evento.tipoEvento}</td>
			<td>${evento.formato}</td>
			<td class="center">
				<a title="Sancionar" class="btn-floating blue darken-2 tooltipped" href="<c:url value="/eventos/sancionar?id=${evento.id}" />" data-position="top" data-delay="50" data-tooltip="Sancionar" ><i class="material-icons">perm_identity</i></a>
				<a title="Editar" class="btn-floating green darken-2 tooltipped" href="<c:url value="/eventos/edit?id=${evento.id}" />" data-position="top" data-delay="50" data-tooltip="Editar" ><i class="material-icons">mode_edit</i></a>
				<a title="Eliminar" class="btn-floating red darken-2 tooltipped" href="<c:url value="/eventos/cancel?id=${evento.id}" />" data-position="top" data-delay="50" data-tooltip="Eliminar"><i class="material-icons">delete</i></a>
			</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	</div>
    </div>
    </div>
    
    <div id="tab-sancionados" class="col s12">
    <div class="material-table">
     <div class="table-header">
        <h4 class="header center orange-text table-title">Eventos sancionados</h4>
        <div class="actions">
          <a href="#" class="search-toggle waves-effect btn-flat nopadding"><i class="material-icons">search</i></a>
        </div>
      </div>
      <div id="eventos-sancionados_wrapper" class="dataTables_wrapper no-footer" >
    <table id="eventos-sancionados" class="dataTable no-footer bordered highlight">
    <thead>
		<tr>
			<th data-field="fecha">
				Fecha y Hora
			</th>
			<th data-field="descripcion">
				Descripci&oacute;n
			</th>
			<th data-field="tipoEvento">
				Tipo de evento
			</th>
			<th data-field="formato">
				Formato
			</th>
			<th class="center">
				Opciones
			</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${eventosSancionados}" var="evento">
			<tr>
			<td><fmt:formatDate value="${evento.fecha}" pattern="dd/MM/yyyy" />&nbsp;&nbsp;<fmt:formatDate value="${evento.hora}" pattern="HH:mm" /></td>
			<td>${evento.descripcion}</td>
			<td>${evento.tipoEvento}</td>
			<td>${evento.formato}</td>
			<td class="center">
				<a title="Posiciones" class="btn-floating blue darken-2" href="<c:url value="/eventos/posiciones?id=${evento.id}" />" ><i class="material-icons">toc</i></a>
		</c:forEach>
	</tbody>
	</table>
	</div>
    </div>
    
    </div>
  </div>
  
    

  </div>

</div>
</main>
<%@ include file="/WEB-INF/views/elements/footer.jsp" %>
<spring:url value="/resources/js/dataTables/jquery.dataTables.min.js" var="jqueryDataTables" />
<script src="${jqueryDataTables}"></script>
<spring:url value="/resources/js/dataTables/dataTables.materialize.js" var="materializeDataTables" />
<script src="${materializeDataTables}"></script>
<script type="text/javascript">
	$(document).ready(function() {
	  $('#eventos-pendientes').dataTable({
	    "oLanguage": {
	      "sStripClasses": "",
	      "sSearch": "",
	      "sSearchPlaceholder": "Filtrar por palabra clave",
	      "sInfo": "_START_ -_END_ de _TOTAL_",
	      "sLengthMenu": '<span>Filas por p&aacute;gina:</span><select class="browser-default">' +
	        '<option value="10">10</option>' +
	        '<option value="20">20</option>' +
	        '<option value="30">30</option>' +
	        '<option value="40">40</option>' +
	        '<option value="50">50</option>' +
	        '<option value="-1">Todas</option>' +
	        '</select></div>'
	    },
	    bAutoWidth: false
	  });
	  $('#eventos-sancionados').dataTable({
		    "oLanguage": {
		      "sStripClasses": "",
		      "sSearch": "",
		      "sSearchPlaceholder": "Filtrar por palabra clave",
		      "sInfo": "_START_ -_END_ de _TOTAL_",
		      "sLengthMenu": '<span>Filas por p&aacute;gina:</span><select class="browser-default">' +
		        '<option value="10">10</option>' +
		        '<option value="20">20</option>' +
		        '<option value="30">30</option>' +
		        '<option value="40">40</option>' +
		        '<option value="50">50</option>' +
		        '<option value="-1">Todas</option>' +
		        '</select></div>'
		    },
		    bAutoWidth: false
		  });
	  
	});
</script>
</body>
</html>
