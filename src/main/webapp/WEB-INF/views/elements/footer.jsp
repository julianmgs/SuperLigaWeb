 <footer class="page-footer green">
    <div class="container">
      <div class="row">
        <div class="col l6 s12">
          <h5 class="white-text">MTG Rosario</h5>
          <p class="grey-text text-lighten-4">Zeballos 1107.</p>
        </div>
      </div>
    </div>
    <div class="footer-copyright">
      <div class="container">
      Made with <a class="orange-text text-lighten-3" href="http://materializecss.com">Materialize</a>
      </div>
    </div>
  </footer>
  
<!--  Scripts-->
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="http://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<spring:url value="/resources/js/jquery.dataTables.min.js" var="jqueryDataTables" />
<spring:url value="/resources/js/materialize.js" var="materializeJs" />
<spring:url value="/resources/js/init.js" var="initJs" />

<script src="${jqueryDataTables}"></script>
<script src="${materializeJs}"></script>

<script src="${initJs}"></script>