(function($){
  $(function(){

    $('.button-collapse').sideNav();
    $('.dropdown-button').dropdown();
    $('.tooltipped').tooltip({delay: 50});
    
    var pgurl = window.location.pathname;
    $(".nav li a").each(function(){
    	if($(this).attr("href") == pgurl || $(this).attr("href") == '' ) {
    		$(this).parent().addClass("active");
        }
    })
    
  }); // end of document ready
})(jQuery); // end of jQuery name space
