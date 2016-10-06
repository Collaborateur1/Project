/**
 * 
 */

define( [       
         
         
        
         ],
         function(
        		
               
        		 
         ) {
	'use strict';

	var user = Backbone.Model.extend({
		  // Default todo attribute values
		urlRoot:'/puls/user',
		  defaults : {
				id : null
			},
		  events: {
		  
		  },
		   initialize: function(){
		    console.log('This model has been initialized.');
		    this.on('change', function(){
		        console.log('- Values for this model have changed.');
		    });
		  }
		  
		});

	return user;
} );


