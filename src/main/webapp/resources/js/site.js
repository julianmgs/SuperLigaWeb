(function($){
  $(function(){

    $('.button-collapse').sideNav();
    $('.dropdown-button').dropdown();
    $('.tooltipped').tooltip({delay: 50});
    
  }); // end of document ready
})(jQuery); // end of jQuery name space

/*
$(document).ready(function () {
    var url = window.location;
    $('ul.nav a[href="' + url + '"]').parent().addClass('active');
    $('ul.nav a').filter(function () {
        return this.href == url;
    }).parent().addClass('active');
});
*/

/*
$(function() {
    var pgurl = window.location.href.substr(window.location.href
.lastIndexOf("/")+1);
    $("#nav ul li a").each(function(){
         if($(this).attr("href") == pgurl || $(this).attr("href") == '' )
         $(this).addClass("active");
    })
});
*/