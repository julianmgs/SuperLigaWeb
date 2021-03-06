<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Super Liga Rosario</title>
  <%@ include file="/WEB-INF/views/elements/head.jsp" %>
  
  <style type="text/css">
	
	/* Animacion del loader */
	.loader {
	    border: 16px solid #f3f3f3; /* Light grey */
	    border-top: 16px solid #3498db; /* Blue */
	    border-radius: 50%;
	    width: 100px;
	    height: 100px;
	    animation: spin 2s linear infinite;
	    position: absolute;
		left: 0;
		top: 0;
		right: 0;
		bottom: 0;
		margin: auto; /* presto! */
	}
	
	.tiny-loader {
	    border: 4px solid #f3f3f3; /* Light grey */
	    border-top: 4px solid #3498db; /* Blue */
	    border-radius: 50%;
	    width: 20px;
	    height: 20px;
	    animation: spin 2s linear infinite;
	    position: absolute;
		left: 0;
		top: 0;
		right: 0;
		bottom: 0;
		margin: auto; /* presto! */
	}
	
	@keyframes spin {
	    0% { transform: rotate(0deg); }
	    100% { transform: rotate(360deg); }
	}
	/* FIN Animacion del loader */
	
	</style>
  
</head>
<body>
<%@ include file="/WEB-INF/views/elements/nav.jsp" %>
<main>
<div class="white">
  <div class="section container">
    <div class="section">

<div class="row">

    <div class="col s12">
      <ul class="tabs">
        <li class="tab col s3"><a class="active" href="#test1">Ranking mensual</a></li>
        <li class="tab col s3"><a href="#test2">Ranking semestral</a></li>
      </ul>
    </div>
  <form:form method="POST" modelAttribute="rankingMes" action="${pageContext.request.contextPath}/">
    <div id="test1" class="col s12">
    <h4 class="header center orange-text">
    Ranking de 
    <a class='dropdown-button' href='#' data-activates='dropdown1' data-constrainwidth="false"><c:out value="${meses[rankingMes.mes - 1].nomMes}" /> </a>
    <c:out value="${rankingMes.anio}" />
    
    <ul id='dropdown1' class='dropdown-content'>
    <c:forEach items="${meses}" var="mes" >
    	<li><a href="#!" onclick="loadJsonMes(${mes.nroMes}, 2017);">${mes.nomMes}</a></li>
    </c:forEach>
  	</ul>
  	</h4>
  	<input id="hiddenMes" name="mes" value="${meses[rankingMes.mes - 1].nroMes}" type="hidden" />
  	<input id="hiddenAnio" name="anio" value="2017" type="hidden" />
    <br>
   <%-- 
   <div class="input-field col s2">
    <form:select id="meses" path="mes" onchange="this.form.submit()">
		<form:options items="${meses}" itemValue="nroMes" itemLabel="nomMes"/>
	</form:select>
	<label for="mes">Mes</label>
  </div>
  --%>
  <%--
  <div class="input-field col s1">
    <form:select id="anios" path="anio" onchange="this.form.submit()">
		<form:options items="${anios}" />
	</form:select>
    <label>A&ntilde;o</label>
  </div>
  --%>
    <table id="table-rankMes" class="bordered highlight">
    <thead>
		<tr>
			<th data-field="pos">
				Pos
			</th>
			<th data-field="nombre">
				Nombre
			</th>
			<th data-field="apellido">
				Apellido
			</th>
			<th class="center" data-field="jugados">
				Eventos jugados
			</th>
			<th class="center" data-field="puntos">
				Puntos
			</th>
		</tr>
	</thead>
	<tbody id="tbody-rankMes">
	<div class="loader" id="loader" style="display:none"></div>
	<%--
		<c:set var="i" value="1" />
		<c:forEach items="${pjSeason}" var="puntosJugador">
			<tr>
			<td>${i}</td>
			<td>${puntosJugador.jugador.nombre}</td>
			<td>${puntosJugador.jugador.apellido}</td>
			<td class="center">${puntosJugador.eventosJugados}</td>
			<td class="center">${puntosJugador.puntos}</td>
			</tr>
			<c:set var="i" value="${i+1}" />
		</c:forEach>
	--%>
	</tbody>
	</table>
    
    </div>
    </form:form>
    
    <div id="test2" class="col s12">
    <div class="container">
      <br><br>
    	<div class="row center"> <%-- 375 523 --%>
    		<img alt="Sitio en construcción" src="<c:url value="resources/img/under-construction.png"/>" width="281" height="392" />
      	</div>
    </div>
    </div>
    <%-- 
    <form:form method="POST" modelAttribute="rankingSemestre" action="${pageContext.request.contextPath}/">
    <div id="test2" class="col s12">
    <h4 class="header center orange-text">Ranking de Julio - Diciembre 2016</h4>
      <br>
   <div class="input-field col s2">
    <form:select id="meses" path="semestre" onchange="this.form.submit()">
		<form:option value="1" label="Enero - Junio" />
		<form:option value="2" label="Julio - Diciembre" />
	</form:select>
	<label for="mes">Mes</label>
  </div>
  <div class="input-field col s1">
    <form:select id="anios" path="anio">
		<form:options items="${anios}" />
	</form:select>
    <label>A&ntilde;o</label>
  </div>
    <table class="bordered highlight">
    <thead>
		<tr>
			<th data-field="pos">
				Pos
			</th>
			<th data-field="nombre">
				Nombre
			</th>
			<th data-field="apellido">
				Apellido
			</th>
			<th class="center" data-field="jugados">
				Eventos jugados
			</th>
			<th class="center" data-field="puntos">
				Puntos
			</th>
		</tr>
	</thead>
	<tbody>
		<c:set var="i" value="1" />
		<c:forEach items="${pjSemestre}" var="puntosJugador">
			<tr>
			<td>${i}</td>
			<td>${puntosJugador.jugador.nombre}</td>
			<td>${puntosJugador.jugador.apellido}</td>
			<td class="center">${puntosJugador.eventosJugados}</td>
			<td class="center">${puntosJugador.puntos}</td>
			</tr>
			<c:set var="i" value="${i+1}" />
		</c:forEach>
	</tbody>
	</table>
    
    </div>
    </form:form>
    --%>
  </div>   

    </div>

  </div>
  </div>
</main>
 <%@ include file="/WEB-INF/views/elements/footer.jsp" %>


<script type="text/javascript">
/*
$(document).ready(function() {
    $('select').material_select();
    
    $('#meses').on('change', function (e) {
        var optionSelected = $("option:selected", this);
        var valueSelected = this.value;
    });
    
  });
*/
</script>

<script type="text/javascript">


$(function(){
	loadJsonMes($('#hiddenMes').val(), $('#hiddenAnio').val());
});

$(document)
	/* Esconder el loader animado al completar la consulta Ajax */
	.on({
	    ajaxStop: function() {
	    	$('#loader').hide();
	    }
	});

function loadJsonMes(mes, anio) {
	
	$("#table-rankMes").find('tbody').empty();
	$('#loader').show();
		
	//search = {mes: mes, anio: anio};
	search = {mes: 12, anio: 2017};
	
	var request = $.ajax({
		type : "POST",
		contentType : "application/json",
		url : "${home}rankingMesAjax",
		data : JSON.stringify(search),
		dataType : 'json',
		success : function(data) {
			console.log("SUCCESS: ", data);
			
			$.each(data.ranking, function(index, value) {
				$("#table-rankMes").find('tbody')
					.append($('<tr>')
						.append($('<td>')
							.text(index + 1)
						)
						.append($('<td>')
							.text(value.nombre)
						)
						.append($('<td>')
							.text(value.apellido)
						)
						.append($('<td>')
							.attr('class', 'center')
							.attr('data-field', 'jugados')
							.text(value.eventosJugados)
						)
						.append($('<td>')
							.attr('class', 'center')
							.attr('data-field', 'puntos')
							.text(value.puntos)
						)
					)
			});
		},
		error : function(e) {
			console.log("ERROR: ", e);
		},
		done : function(e) {
			console.log("DONE");
		}
	});
}

</script>

<script type="text/javascript">
function cambiarMes(nroMes) {
	$('#hiddenMes').val(nroMes);
	$('#rankingMes').submit();
}
</script>

  </body>
</html>
