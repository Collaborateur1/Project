 require([
          'backbone',
          'pnotify'
          ],function(
             backbone,
             PNotify
          ) {

	 'use strict';


	
    var bodyNav = Backbone.View.extend({
    id:'001BodyNav'
    ,
    	  //tagName:  'div',
    	  el: '.page-sidebar-menu', 
    	  // Cache the template function for a single item.

    	  events: {
    	   
    	   
    	    'click #url': 'change_menu'
    	  },

    	  initialize: function (options) {
    		  var that=this;
    		  $(window).bind("popstate", function(e) {
    			 
    			var url=window.location.pathname.split('/');
    			  
    			 that.loadPage(url[url.length-1]);
    			  
    			});
    	    // In Backbone 1.1.0, if you want to access passed options in
    	    // your view, you will need to save them as follows:
    	    this.loadPage($('#currentPage').val());
    	    this.options = options || {};
    	   // this.listenTo(app.Todos, 'reset', this.render);
    	    //this.listenTo(this.model, 'change', this.render);
    	    debugger;
    	    console.log(this.model);
    	    
    	  },
 
    	  // Re-render the title of the todo item.
    	  render: function() {
    		  this.$el.html("jai changé");
    	    return this;
    	  },

    	  edit: function() {
    		  this.$el.html("jai changé");
    		  
    	  },
    	  change_menu:function(e) {
    		  
    		  var target =  $(e.currentTarget);
    		   debugger;
    		  var myUrl=target.children().attr("href") 
    		  e.stopImmediatePropagation();
    		  if($('#MenuOn').length>0)
    			  {
    			  $('#MenuOn').removeClass('active open');
    			  $('#MenuOn').removeAttr('id');
    			  target.parent().parent().children().first().children().last().removeClass('selected');
    			  }
    		  if($('#underMenuOn').length>0){
    			  $('#underMenuOn').removeClass('active open');
    			  $('#underMenuOn').attr('id','url');
    		  }
  
    		  target.parent().parent().addClass('active open');
    		  target.parent().parent().attr('id','MenuOn');
    		  target.addClass('active open');
    		  target.attr('id','underMenuOn');
    		  target.parent().parent().children().first().children().last().addClass('selected');
    		  this.loadPage(myUrl, true);
    	  },
    	  close: function() {
    	    // executed when todo loses focus
    		  this.$el.html("jai changé");
    	  },
    	  
    	 
    	  
    	  loadPage:function(myUrl,history)
    	  {
    		  if(history&&history===true){
    		  try{
    			  var stateObj = { foo: myUrl };
    		  window.history.pushState( stateObj , myUrl, myUrl );
    		  }catch(e)
    		  {
    			 console.error("error"); 
    		  }
    		  }
    		  //delete view from the current page
    		  if(app.ListModel){
    		  app.ListModel._reset();
    		  app.ListView._reset();
    		  }
    		  var that=this;
    		  $('.dynamic-content').fadeOut(250);
    	  	$.ajax({
    	  	       url : myUrl, // La ressource ciblée
    	  	       type : 'GET', // Le type de la requête HTTP. 
    	  	        dataType: "html",
    	  	        async: true,
    	  	      data: 'currentPage=' + myUrl,
    	  	   contentType: "application/x-www-form-urlencoded",
    	  	      success : function(code_html, statut){ // code_html contient le HTML renvoyé
    	  	    	  
    	  	    	 
    	  	    	
    	  	    	 $('.dynamic-content').css("display", "none").html(code_html).fadeIn(500);
    	  	    	/* debugger;
    	  	    	 $($('div[role="main"]').children()[0]).code_html;
    	  	    	  $('div[role="main"]').html(code_html);
    	  	    	//$($('div[role="main"]').children()[0]).fadeIn();*/
    	  	    	
    	  	        },
    	  	    error : function(resultat, statut, erreur){
    	  	    	new PNotify({
    	           title: 'Wrong menu!',
    	           text: 'the menu '+ myUrl +' don\'t exist',
    	           type: 'error',
    	           styling: 'bootstrap3'
    	       });
    	  	       },
    	  	        complete : function(resultat, statut){
    	  	        	
    	  	        	
    	  		    	
    	  	        }
    	  	    });
    	    
    	  }
    	
    	});
    	
    	debugger;


    var tmp= new bodyNav;
    app.menu=tmp;
return tmp;
  
    });