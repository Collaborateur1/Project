/**
 * 
 */

define( [       
         
         
        
         ],
         function(
        		
               
        		 
         ) {
	'use strict';
debugger;
	var user = Backbone.Model.extend({
		  // Default todo attribute values
		urlRoot:'../user',
		  defaults : {
				id : null
			},
		  events: {
		  
		  },
		   initialize: function(){
			   debugger;
		    console.log('This model has been initialized.');
		    this.on('change', function(){
		        console.log('- Values for this model have changed.');
		    });
		  }
		  
		});

	return user;
} );


