/**
 * 
 */
 require.config({

    		baseUrl: 'puls',
    		 waitSeconds : 30,
    		paths : {
    			'jquery' : '../../../inc/vendors/jquery/dist/jquery.min',
    			'bootstrap' : '../../../inc/vendors/bootstrap/dist/js/bootstrap.min',
    			'nprogress' : '../../../inc/vendors/nprogress/nprogress',
    			'dropzone': '../../../inc/vendors/dropzone/dist/min/dropzone.min',
    			'handlebars': '../../../inc/js/standard/handlebars-v4.0.5'
    		
    		},

    		shim : {
    			
    			
    			jquery: {
    				deps : ['raphael'],
    				exports: 'jquery'
    			},
    			
    			smartresize: {
    				deps : ['jquery'],
    				exports: 'smartresize'
    			},
    			
    			bootstrap: {
    				deps: ['jquery'],
    				exports: 'bootstrap'
    			},
    			
    			handlebars: {
    				exports: 'Handlebars'
    			}


    		}

    	});
 
 require(['main']);