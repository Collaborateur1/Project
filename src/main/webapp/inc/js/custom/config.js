/**
 * 
 */
 require.config({

    		baseUrl: 'puls',
    		 waitSeconds : 30,
    		paths : {
    			'jquery' : '../../../inc/vendors/jquery/dist/jquery.min',
    			'jqueryui' : '../../../inc/jasmine/js/jquery-ui.min',
    			'scripts' : '../../../inc/jasmine/js/scripts',
    			'bootstrapselect' : '../../../inc/jasmine/plugins/bootstrap-select/bootstrap-select.min',
    			'jasmine' : '../../../inc/jasmine/js/demo/jasmine',		
    			'backbone' : '../../../inc/js/standard/backbone-min',
    			'underscore' : '../../../inc/js/standard/underscore-min',
    			'bootstrap' : '../../../inc/vendors/bootstrap/dist/js/bootstrap.min',
    			'nprogress' : '../../../inc/vendors/nprogress/nprogress',
    			'fastclick' : '../../../inc/vendors/fastclick/lib/fastclick',
    			'custom' : '../../../inc/js/custom/custom',
    			'pnotify' : '../../../inc/vendors/pnotify/dist/pnotify',
    			'smartresize' : '../../../inc/js/custom/smartresize',
    			'main': '../../../inc/js/custom/main',
    			'eve' : '../../../inc/vendors/raphaelrequiremaster/eve',
    			  'raphael-core' : '../../../inc/vendors/raphaelrequiremaster/raphael.core',
    			  'raphael-svg' : '../../../inc/vendors/raphaelrequiremaster/raphael.svg',
    			  'raphael-vml' : '../../../inc/vendors/raphaelrequiremaster/raphael.vml',
    			  'raphael' : '../../../inc/vendors/raphaelrequiremaster/raphael.amd',
    			'bootstrapprogressbar': '../../../inc/vendors/bootstrap-progressbar/bootstrap-progressbar.min',
    			'jquerytagsinput': '../../../inc/vendors/jquery.tagsinput/src/jquery.tagsinput',
    			'morris': '../../../inc/vendors/morris/morris.min',
    			'select2': '../../../inc/vendors/select2/dist/js/select2.full.min',		
    			'moment': '../../../inc/js/standard/moment/moment.min',
    			'daterangepicker': '../../../inc/js/standard/datepicker/daterangepicker',
    			'dropzone': '../../../inc/vendors/dropzone/dist/min/dropzone.min',
    			'defaultDialogModalView': '../../../inc/js/view/dialogs/DefaultDialogModalView',
    			'updateProfilPicture': '../../../inc/js/view/dialogs/updateProfilPicture',
    			'testDialog': '../../../inc/js/view/dialogs/testDialog',
    			'text': '../../../inc/js/standard/text-2.0.12',
    			'user': '../../../inc/js/model/User',
    			'userView': '../../../inc/js/view/user/UserView',
    			'bodyNav': '../../../inc/js/view/menu/BodyNav',
    			'i18n' : '../../../inc/js/standard/i18n',
    			'handlebars': '../../../inc/js/standard/handlebars-v4.0.5'
    		
    		},

    		shim : {
    			
    			'eve': {
    			    exports: "eve"
    			  },
    			  'raphael': {
    			    deps: ["eve"],
    			    exports: "raphael"
    			  },
    			bootstrapprogressbar: {
    				deps : ['bootstrap'],
    				exports: 'bootstrapprogressbar'
    			},
    			jqueryui: {
    				deps : ['jquery'],
    				exports: 'jqueryui'
    			},
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
    			defaultDialogModalView: {
    				deps: ['backbone'],
    				exports: 'defaultDialogModalView'
    			},
    			
    			
    			backbone : {
    				deps : [ 'underscore', 'jquery' ],
    				exports : 'Backbone'
    			},
    			main:{
    				deps : ['backbone'],
    				exports :'main'
    			},
    			morris:{
    				deps : ['raphael'],
    				exports :'Morris'
    			},
    			handlebars: {
    				exports: 'Handlebars'
    			},

    			custom:{
    				deps : ['jquery','bootstrapprogressbar'/*,'switchery'*/],
    				exports :'custom'
    			}


    		}

    	});
 
 require(['main']);