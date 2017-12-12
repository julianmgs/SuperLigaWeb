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
    <div class="row">
        <h4 class="header center orange-text">Detalle del evento</h4>
    </div>
    
      <div class="row">
        <div class="input-field col s10 offset-s1">
          <input disabled value="${eventoVo.evento.fecha} ${eventoVo.evento.hora} - ${eventoVo.evento.descripcion} - ${eventoVo.evento.tipoEvento} (${eventoVo.evento.formato})" id="evento" type="text" class="validate">
          <label for="evento">Evento</label>
        </div>
      </div>
	<div class="section">
	<div class="row col s10 offset-s1">
     <h5 class="header center orange-text">Posiciones finales del evento</h5>
      <br>
    <table class="bordered highlight">
    <thead>
		<tr>
			<th data-field="pos">
				Pos
			</th>
			<th data-field="dci">
				#DCI
			</th>
			<th data-field="nombre">
				Nombre
			</th>
			<th data-field="apellido">
				Apellido
			</th>
			<th class="center" data-field="puntos">
				Puntos
			</th>
		</tr>
	</thead>
	<tbody>
		<c:set var="pos" value="1" />
		<c:forEach items="${eventoVo.rankingFinal}" var="puntosJugador" varStatus="i">
			<tr>
			<td>${pos}</td>
			<td>${puntosJugador.jugador.dci}</td>
			<td>${puntosJugador.jugador.nombre}</td>
			<td>${puntosJugador.jugador.apellido}</td>
			<td class="center">${puntosJugador.puntos}</td>
			</tr>
			<c:set var="pos" value="${pos+1}" />
		</c:forEach>
	</tbody>
	</table>
    </div>
      </div>
  </div>

</div>
</main>
<%@ include file="/WEB-INF/views/elements/footer.jsp" %>

</body>
</html>
