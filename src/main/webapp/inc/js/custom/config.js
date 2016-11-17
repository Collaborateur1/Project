/**
 * 
 */
 require.config({

    		baseUrl: 'puls',
    		 waitSeconds : 30,
    		paths : {
    			'jquery' : '../../inc/js/library/jquery/dist/jquery.min',
    			//'jqueryui' : '../../inc/jasmine/js/jquery-ui.min',
    			'scripts' : '../../inc/jasmine/js/scripts',
    			'bootstrapselect' : '../../../inc/jasmine/plugins/bootstrap-select/bootstrap-select.min',
    			'jasmine' : '../../inc/jasmine/js/demo/jasmine',		
    			'backbone' : '../../inc/js/library/backbonejs/backbone-min',
    			'underscore' : '../../inc/js/library/underscorejs/underscore-min',
    			'bootstrap' : '../../inc/js/library/bootstrap/dist/js/bootstrap.min',
    			'nprogress' : '../../inc/js/library/nprogress/nprogress',
    			'fastclick' : '../../inc/js/library/fastclick/lib/fastclick',
    			'custom' : '../../inc/js/custom/custom',
    			'pnotify' : '../../inc/js/library/pnotify/dist/pnotify',
    			'smartresize' : '../../inc/js/library/smartresize',
    			'main': '../../inc/js/custom/main',
    			'eve' : '../../inc/js/library/raphaelrequiremaster/eve',
    			  'raphael-core' : '../../inc/js/library/raphaelrequiremaster/raphael.core',
    			  'raphael-svg' : '../../inc/js/library/raphaelrequiremaster/raphael.svg',
    			  'raphael-vml' : '../../inc/js/library/raphaelrequiremaster/raphael.vml',
    			  'raphael' : '../../inc/js/library/raphaelrequiremaster/raphael.amd',
    			'bootstrapprogressbar': '../../inc/js/library/bootstrap-progressbar/bootstrap-progressbar.min',
    			'jquerytagsinput': '../../inc/js/library/jquery.tagsinput/src/jquery.tagsinput',
    			'morris': '../../inc/js/library/morris/morris.min',
    			'select2': '../../inc/js/library/select2/dist/js/select2.full.min',		
    			'moment': '../../inc/js/library/moment/min/moment.min',
    			'daterangepicker': '../../inc/js/library/bootstrap-daterangepicker/daterangepicker',
    			'dropzone': '../../inc/js/library/dropzone/dist/min/dropzone.min',
    			'defaultDialogModalView': '../../inc/js/pattern/view/dialogs/DefaultDialogModalView',
    			'updateProfilPicture': '../../inc/js/pattern/view/dialogs/updateProfilPicture',
    			'testDialog': '../../inc/js/view/dialogs/testDialog',
    			'text': '../../inc/js/library/text/text-2.0.12',
    			'user': '../../inc/js/pattern/model/User',
    			'userView': '../../inc/js/pattern/view/user/UserView',
    			'bodyNav': '../../inc/js/pattern/view/menu/BodyNav',
    			'i18n' : '../../inc/js/standard/i18n',
    			'jscookie': '../../inc/js/library/js-cookie/js.cookie.min',
    			'jqueryslimscroll': '../../inc/js/library/jquery-slimscroll/jquery.slimscroll.min',
    			'jqueryblockui': '../../inc/js/library/jqueryblockui/jquery.blockui.min',
    			'bootstrapswitch': '../../inc/js/library/bootstrap-switch/js/bootstrap-switch.min',
    			'base': '../../inc/js/library/app/app.min',
        		'layout': '../../inc/js/library/layout2/scripts/layout.min',
        		'demo': '../../inc/js/library/layout2/scripts/demo.min',
    			'quicksidebar': '../../inc/js/library/global/scripts/quick-sidebar.min',
    			'quicknav': '../../inc/js/library/global/scripts/quick-nav.min',
    			'handlebars': '../../inc/js/library/handlebars/handlebars-v4.0.5'
    		
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
    		/*	jqueryui: {
    				deps : ['jquery'],
    				exports: 'jqueryui'
    			},*/
    			jquery: {
    				deps : ['raphael'],
    				exports: 'jquery'
    			},
    			base: {
    				deps : ['bootstrap'],
    				exports: 'base'
    			},
    			layout: {
    				deps : ['base'],
    				exports: 'layout'
    			},
    			demo: {
    				deps : ['base'],
    				exports: 'demo'
    			},
    			quicksidebar: {
    				deps : ['base'],
    				exports: 'quicksidebar'
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