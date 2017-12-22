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
     <div class="material-table">
     <div class="table-header">
        <h4 class="header center orange-text table-title">Productos</h4>
        <div class="actions">
          <a href="#" class="search-toggle waves-effect btn-flat nopadding"><i class="material-icons">search</i></a>
        </div>
      </div>
      <div id="productos_wrapper" class="dataTables_wrapper no-footer" >
    <table id="productos" class="dataTable no-footer bordered highlight">
    <thead>
		<tr>
			<th data-field="nombre">
				Nombre
			</th>
			<th data-field="precio">
				Precio
			</th>
			<th data-field="hayStock">
				Hay Stock
			</th>
			<th data-field="enabled">
				Habilitado
			</th>
			<th data-field="opciones">
				Opciones
			</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${productos}" var="prod">
			<tr>
			<td>${prod.nombre}</td>
			<td>${prod.precio}</td>
			<td>${prod.hayStock}</td>
			<td>${prod.enabled}</td>
			<td>
			</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
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
	  $('#productos').dataTable({
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
