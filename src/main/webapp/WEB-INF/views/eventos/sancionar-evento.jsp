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

<div class="container">
  <div class="section">
  
    <div class="row">
    <div class="row">
        <h4 class="header center orange-text">Sancionar evento</h4>
    </div>
      <div class="row">
        <div class="input-field col s10 offset-s1">
          <input disabled value="${eventoVo.evento.fecha} ${eventoVo.evento.hora} - ${eventoVo.evento.descripcion} - ${eventoVo.evento.tipoEvento} (${eventoVo.evento.formato})" id="evento" type="text" class="validate">
          <label for="evento">Evento</label>
        </div>
      </div>
      <c:if test="${not empty error}">
      <div class="input-field col s10 offset-s1">
          	<div class="alert alert-dismissable card-panel red lighten-1" id="card-alert" >
	          <span class="white-text">${error}</span>
	          <button type="button" class="close white-text" data-dismiss="alert" aria-label="Close">
              	<span aria-hidden="true">×</span>
              </button>
	        </div>
      </div>
      </c:if>
    </div>
    <div class="section">
    <div class="row">
	<div class="row col s10 offset-s1">
     <div class="material-table">
     <div class="table-header">
        <h4 class="header center orange-text table-title">Ingresar jugadores</h4>
        <div class="actions">
          <a href="#modalAddJugador" title="Nuevo jugador" class="modal-trigger waves-effect btn-flat nopadding"><i class="material-icons">person_add</i></a>
          <a title="Filtrar jugadores" class="search-toggle waves-effect btn-flat nopadding"><i class="material-icons">search</i></a>
        </div>
      </div>
      <div id="jugadores_wrapper" class="dataTables_wrapper no-footer" >
    <table id="jugadores" class="dataTable no-footer bordered highlight">
    <thead>
		<tr>
			<th data-field="fecha">
				#DCI
			</th>
			<th data-field="descripcion">
				Apellido
			</th>
			<th data-field="tipoEvento">
				Nombre
			</th>
			<%-- 
			<th data-field="formato" style="text-align: center;">
				Puntos
			</th>
			--%>
			<th style="text-align: right;"> 
				Ingresar
			</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${eventoVo.jugadoresPuntos}" var="jugadorP" varStatus="i">
		<tr>
			<td> <input type="hidden" id="dci_${jugadorP.jugador.id}" value="${jugadorP.jugador.dci}" /> ${jugadorP.jugador.dci}</td>
			<td> <input type="hidden" id="apellido_${jugadorP.jugador.id}" value="${jugadorP.jugador.apellido}" /> ${jugadorP.jugador.apellido}</td>
			<td> <input type="hidden" id="nombre_${jugadorP.jugador.id}" value="${jugadorP.jugador.nombre}" /> ${jugadorP.jugador.nombre}</td>
			<%-- 
			<td style="text-align: center;"> <form:input path="jugadoresPuntos[${i.index}].puntos" type="number" style="width: 35px;" class="validate puntos-jugador" /></td>
			--%>
			<td style="text-align: right;">
				<%-- 
				<input id="jugadoresPuntos${i.index}.checked1" name="jugadoresPuntos[${i.index}].checked" class="filled-in check-jugador" type="checkbox" value="true" >
				<label for="jugadoresPuntos${i.index}.checked1"></label>
				<input type="hidden" name="_jugadoresPuntos[${i.index}].checked" value="on" >
				--%>
				<a title="Agregar" onclick="addPlayer(${jugadorP.jugador.id}, ${i.index});" id="addPlayer_${jugadorP.jugador.id}" class="btn-floating green darken-2 btn-add-player"><i class="material-icons">add</i></a>
				<%-- 
				<form:hidden path="jugadoresPuntos[${i.index}].jugador.id" />
				--%>
			</td>
		
		</tr>
	</c:forEach>
	</tbody>
	</table>
	</div>
    </div>
    </div>
	</div>
	
	<div class="section">
	<div class="row col s10 offset-s1">
	<form:form method="POST" modelAttribute="eventoVo" action="/SuperLigaWeb/eventos/confirmar" >
    <div class="row">
      <div align="right" class="input-field col s11">
	   <button class="btn waves-effect waves-light" type="submit" >
        Ingresar resultados
	    <i class="material-icons right">play_arrow</i>
	  </button>
	  </div>
    </div>
    <form:hidden path="evento.id"/>
    <form:hidden path="evento.fechaTimestamp"/>
	<div id="ingresados" class="col s10 offset-s1">
    <h5 class="header center orange-text">Jugadores a ingresar</h5>
      <br>
  	<table id="addedTable" class="bordered highlight">
    <thead>
		<tr>
			<th data-field="dci">
				DCI #
			</th>
			<th data-field="apellido">
				Apellido
			</th>
			<th data-field="nombre">
				Nombre
			</th>
			<th data-field="puntos">
				Puntos
			</th>
			<th >
			</th>
		</tr>
	</thead>
	<tbody>
		<%-- Filas a generar --%>
		<%-- 
		<c:if test="${not empty eventoVo.jugadoresPuntos}" >
			<c:forEach items="${eventoVo.jugadoresPuntos}" var="jp" varStatus="i" >
				<c:if test="${jp.checked}" >
				<tr id="row_${jp.jugador.id}">
	   				<td>
	    				<form:hidden path="jugadoresPuntos[${i.index}].jugador.id" />
	    				<form:hidden path="jugadoresPuntos[${i.index}].checked" />
	    				${jp.jugador.dci}
	   				</td>
	   				<td>
	   					${jp.jugador.apellido}
	   				</td>
	   				<td>
	   					${jp.jugador.nombre}
	   				</td>
	   				<td>
	   					<form:input type="number" class="validate puntos-jugador" style="width: 35px;" path="jugadoresPuntos[${i.index}].puntos" />
	   				</td>
	   				<td>
	   					<a onClick="removePlayer(${jp.jugador.id})" id="removePlayer_${jp.jugador.id}" class="btn-floating red darken-2 btn-remove-player" ><i class="material-icons">remove</i></a>
	   				</td>
	   			</tr>
				 </c:if>
			</c:forEach>
		</c:if>
		--%>							                			
	</tbody>
	</table>
    
    </div>
    </form:form>
    </div>
    </div>
    </div>
  </div>
  
  <div id="hiddens">
  
  </div>
  
<%@ include file="/WEB-INF/views/jugadores/modal-add-jugador.jsp" %>

</div>

<%@ include file="/WEB-INF/views/elements/footer.jsp" %>
<spring:url value="/resources/js/jquery.dataTables.min.js" var="jqueryDataTables" />
<script src="${jqueryDataTables}"></script>
<spring:url value="/resources/js/dataTables.materialize.js" var="materializeDataTables" />
<script src="${materializeDataTables}"></script>
<script type="text/javascript">

	$(document).ready(function() {
	  $('#jugadores').dataTable({
			"scrollY": "50vh",
	        "paging": false,
		    "oLanguage": {
		      "sStripClasses": "",
		      "sSearch": "",
		      "sSearchPlaceholder": "Filtrar por palabra clave",
		      "Id": "filter-query",
		      "sInfo": "_START_ -_END_ de _TOTAL_",
		      "sLengthMenu": '<span>Filas por p&aacute;gina:</span><select id="filas-for-pagina" class="browser-default">' +
		        '<option value="10">10</option>' +
		        '<option value="20">20</option>' +
		        '<option value="30">30</option>' +
		        '<option value="40">40</option>' +
		        '<option value="50">50</option>' +
		        '<option value="-1" selected="selected">Todas</option>' +
		        '</select></div>'
		    },
		    bAutoWidth: false
		  });
	  
	  // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
	  $('.modal-trigger').leanModal();
	  
	  $(".puntos-jugador").on("click", function () {
		   $(this).select();
		});

	});
	
	function addPlayer(playerId, index) {

		crearFilaJugador(playerId, index);
		
		$(".input-sm").select();
		
	}
	
	function crearFilaJugador(playerId, index) {
		
		$("#addedTable").find('tbody')
			.append($('<tr id="row_'+playerId+'">')
				.append($('<td>')
					.text($("#dci_"+playerId).attr("value")
						)
					.append($('<input>')
							.attr('id', 'jugadoresPuntos'+index+'.jugador.id')
							.attr('name', 'jugadoresPuntos['+index+'].jugador.id')
							.attr('value', playerId)
							.attr('type', 'hidden')
							.attr('style', 'width: 35px;')
							.attr('class', 'validate puntos-jugador')
								)
						.append($('<input>')
							.attr('id', 'jugadoresPuntos'+index+'.checked1')
							.attr('name', 'jugadoresPuntos['+index+'].checked')
							.attr('value', 'true')
							.attr('type', 'hidden')
							.attr('style', 'width: 35px;')
							.attr('class', 'validate puntos-jugador')
								)
					)
				.append($('<td>')
					.text($("#apellido_"+playerId).attr("value")
							)
						)
				.append($('<td>')
					.text($("#nombre_"+playerId).attr("value")
							)
						)
			.append($('<td>')
					.append($('<input>')
						.attr('id', 'jugadoresPuntos'+index+'.puntos')
						.attr('name', 'jugadoresPuntos['+index+'].puntos')
						.attr('type', 'number')
						.attr('style', 'width: 35px; height: 15px;')
						.attr('class', 'validate puntos-jugador')
							)
						)
				.append($('<td>')
					.append($('<a>')
						.attr('id', 'removePlayer_'+playerId)
						.attr('class', 'btn-floating red darken-2 btn-remove-player')
						.attr('onclick', 'removePlayer('+playerId+')')
						.append($('<i>')
							.attr('class', 'material-icons')
							.text('remove')
							))
						)
					);
		
	}
	
	function removePlayer(playerId) {
		 $("#row_"+playerId).remove();
	}
	 
</script>
</body>
</html>
