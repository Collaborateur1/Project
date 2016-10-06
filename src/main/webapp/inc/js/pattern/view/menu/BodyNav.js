 require([
          'backbone' 
          ],function(
             backbone	
          ) {

	 'use strict';



    var bodyNav = Backbone.View.extend({
    id:'001BodyNav'
    ,
    	  //tagName:  'div',
    	  el: '#sidebar-menu', 
    	  // Cache the template function for a single item.

    	  events: {
    	   
    	   
    	    'click #url': 'change_menu',
    	    'mouseover #menu': 'activeMenu'
    	  },

    	  initialize: function (options) {
    		  
    		  
    	    // In Backbone 1.1.0, if you want to access passed options in
    	    // your view, you will need to save them as follows:
    	    this.loadPage($('#currentPage').val());
    	    this.options = options || {};
    	   // this.listenTo(app.Todos, 'reset', this.render);
    	    //this.listenTo(this.model, 'change', this.render);
    	    
    	    console.log(this.model);
    	    
    	  },
       activeMenu: function(e){
    	   
    	   	e.stopImmediatePropagation();
        	var $li=$(e.currentTarget);
        	debugger;
        	if($('#sidebar-menu').find('li[id="menuActif"]').size()!=0){
        		$('#sidebar-menu').find('li[id="menuActif"]').attr('id','menu');
            }
        	$li.attr('id','menuActif');
        	
        	
    
            if ($li.is('.active')) {
                $li.removeClass('active active-sm');
                $('ul:first', $li).slideUp(function() {
                	$TEST();
                });
            } else {
                // prevent closing menu if we are on child menu
                if (!$li.parent().is('.child_menu')) {
                    $SIDEBAR_MENU.find('li').removeClass('active active-sm');
                    $SIDEBAR_MENU.find('li ul').slideUp();
                }
                
                $li.addClass('active');

                $('ul:first', $li).slideDown(function() {
                	$TEST();
                });
            }
        
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
    		   
    		  var myUrl=target.children().attr("href") 
    		  e.stopImmediatePropagation();
    		  if($('li[id="urlOn"]'))
    			  {
    			  $('li[id="urlOn"]').attr('class','');
    			  }
    		 
    		  if($('li[class="current-page"]'))
    			  {
    			  $('li[class="current-page"]').attr('class','');
    			  }
    		  $('li[id="urlOn"]').attr('id', 'url');
    		  target.attr('id', 'urlOn');
    		  this.loadPage(myUrl);
    	  },
    	  close: function() {
    	    // executed when todo loses focus
    		  this.$el.html("jai changé");
    	  },
    	  
    	 
    	  
    	  loadPage:function(myUrl)
    	  {
    		  try{
    		  window.history.replaceState( {} , myUrl, myUrl );
    		  }catch(e)
    		  {
    			  
    		  }
    		  //delete view from the current page
    		  if(app.ListModel){
    		  app.ListModel._reset();
    		  app.ListView._reset();
    		  }
    		  var that=this;
    	  	$.ajax({
    	  	       url : myUrl, // La ressource ciblée
    	  	       type : 'GET', // Le type de la requête HTTP. 
    	  	        dataType: "html",
    	  	        async: true,
    	  	      data: 'currentPage=' + myUrl,
    	  	   contentType: "application/x-www-form-urlencoded",
    	  	      success : function(code_html, statut){ // code_html contient le HTML renvoyé
    	  	    	  
    	  	    	
    	  	    	  $('div[role="main"]').html(code_html);
    	  	    	if($(document).width() <992 )
    	  	    	{
    	  	    		that.$('ul[style="display: block;"]').attr('style','display: none;');
                        that.$('li[class="active"]').attr('class','active-sm');
    	  	    	  //Do Something
    	  	    	}
    	  	    	
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