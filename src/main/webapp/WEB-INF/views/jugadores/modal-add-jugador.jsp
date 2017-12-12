<!-- Modal Structure -->
<div id="modalAddJugador" class="modal">
<form:form method="POST" modelAttribute="newJugador" action="/SuperLigaWeb/jugadores/new">
  <div class="modal-content">
    <h4>Agregar nuevo jugador</h4>
    <br>
    <div class="row col s12">
   
        <div class="input-field col s3">
          <form:input path="dci" id="dci" type="text" class="validate" maxlength="10" />
          <label for="dci">#DCI</label>
        </div>
       	<div class="input-field col s4">
          <form:input path="apellido" id="apellido" type="text" class="validate" maxlength="30" />
          <label for="apellido">Apellido</label>
        </div>
         <div class="input-field col s5">
          <form:input path="nombre" id="nombre" type="text" class="validate" maxlength="30" />
          <label for="nombre">Nombre</label>
        </div>
   
  </div>
  </div>
  <div class="modal-footer">
    <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat">Cancelar</a>
    <button class="btn waves-effect waves-light" type="submit" >
        Agregar
	</button>
  </div>
  </form:form>  
</div>