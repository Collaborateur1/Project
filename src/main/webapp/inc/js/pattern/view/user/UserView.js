/**
 * 
 */

define( [       

'text!../../html/template/user/user.html',
'handlebars',
'updateProfilPicture',
'moment'
         
        
         ],
         function(
        		 
                 user,
                 handlebars,
                 UpdateProfilPicture,
                 moment
               
        		 
         ) {
	'use strict';

	var ViewUser = Backbone.View.extend({
		  
		 
		  el:'#profil',
		  template: handlebars.compile(user),
		  initialize: function() {
		    
		    this.load();
		    this.model.bind('change', _.bind(this.render, this));
		    debugger;
		  },
		   events: {
			 'click .img-responsive':'updtaPictDialog',  
		  },
		  render: function(){
			  
			 this.$el.html(this.template(this.model.attributes)); 
			 this.load();
			 console.log('- render view user');
		  },
		  updtaPictDialog : function(){
			  debugger;
			 var dialog= new UpdateProfilPicture();
			 dialog.show();
		  },
		  
		  load: function(){
			 // tesi=new updateProfilPicture();
				 debugger;
			   window.Raphael = require('raphael');
			   if ($(".progress .progress-bar")[0]) {
				    $('.progress .progress-bar').progressbar();
				}
			   setTimeout(function() {
				   Morris.Bar({
				          element: 'graph_bar',
				          data: [
				            { "period": "Jan", "Hours worked": 80 }, 
				            { "period": "Feb", "Hours worked": 125 }, 
				            { "period": "Mar", "Hours worked": 176 }, 
				            { "period": "Apr", "Hours worked": 224 }, 
				            { "period": "May", "Hours worked": 265 }, 
				            { "period": "Jun", "Hours worked": 314 }, 
				            { "period": "Jul", "Hours worked": 347 }, 
				            { "period": "Aug", "Hours worked": 287 }, 
				            { "period": "Sep", "Hours worked": 240 }, 
				            { "period": "Oct", "Hours worked": 211 }
				          ],
				          xkey: 'period',
				          hideHover: 'auto',
				          barColors: ['#26B99A', '#34495E', '#ACADAC', '#3498DB'],
				          ykeys: ['Hours worked', 'sorned'],
				          labels: ['Hours worked', 'SORN'],
				          xLabelAngle: 60,
				          resize: true
				        });  // Your code here
				}, 500);
				  
				
			  
			 
		  
		        $MENU_TOGGLE.on('click', function() {
		          $(window).resize();
		        });
		        
		     // for input tabg
		  	  $('#tags_1').tagsInput({
		  	          width: 'auto'
		  	        });
		  	//End input Tags
		    	
		  	$(".select2_single").select2({
		          placeholder: "Select a state",
		          allowClear: true
		        });
		        $(".select2_group").select2({});
		        $(".select2_multiple").select2({
		          maximumSelectionLength: 4,
		          placeholder: "With Max Selection limit 4",
		          allowClear: true
		        });
		 
		        var cb = function(start, end, label) {
			          console.log(start.toISOString(), end.toISOString(), label);
			          $('#reportrange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
			          //alert("Callback has fired: [" + start.format('MMMM D, YYYY') + " to " + end.format('MMMM D, YYYY') + ", label = " + label + "]");
			        }

			        var optionSet1 = {
			          startDate: moment().subtract(29, 'days'),
			          endDate: moment(),
			          minDate: '01/01/2012',
			          maxDate: '12/31/2015',
			          dateLimit: {
			            days: 60
			          },
			          showDropdowns: true,
			          showWeekNumbers: true,
			          timePicker: false,
			          timePickerIncrement: 1,
			          timePicker12Hour: true,
			          ranges: {
			            'Today': [moment(), moment()],
			            'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
			            'Last 7 Days': [moment().subtract(6, 'days'), moment()],
			            'Last 30 Days': [moment().subtract(29, 'days'), moment()],
			            'This Month': [moment().startOf('month'), moment().endOf('month')],
			            'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
			          },
			          opens: 'left',
			          buttonClasses: ['btn btn-default'],
			          applyClass: 'btn-small btn-primary',
			          cancelClass: 'btn-small',
			          format: 'MM/DD/YYYY',
			          separator: ' to ',
			          locale: {
			            applyLabel: 'Submit',
			            cancelLabel: 'Clear',
			            fromLabel: 'From',
			            toLabel: 'To',
			            customRangeLabel: 'Custom',
			            daysOfWeek: ['Su', 'Mo', 'Tu', 'We', 'Th', 'Fr', 'Sa'],
			            monthNames: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
			            firstDay: 1
			          }
			        };
			        $('#reportrange span').html(moment().subtract(29, 'days').format('MMMM D, YYYY') + ' - ' + moment().format('MMMM D, YYYY'));
			        $('#reportrange').daterangepicker(optionSet1, cb);
			        $('#reportrange').on('show.daterangepicker', function() {
			          console.log("show event fired");
			        });
			        $('#reportrange').on('hide.daterangepicker', function() {
			          console.log("hide event fired");
			        });
			        $('#reportrange').on('apply.daterangepicker', function(ev, picker) {
			          console.log("apply event fired, start/end dates are " + picker.startDate.format('MMMM D, YYYY') + " to " + picker.endDate.format('MMMM D, YYYY'));
			        });
			        $('#reportrange').on('cancel.daterangepicker', function(ev, picker) {
			          console.log("cancel event fired");
			        });
			        $('#options1').click(function() {
			          $('#reportrange').data('daterangepicker').setOptions(optionSet1, cb);
			        });
			        $('#options2').click(function() {
			          $('#reportrange').data('daterangepicker').setOptions(optionSet2, cb);
			        });
			        $('#destroy').click(function() {
			          $('#reportrange').data('daterangepicker').remove();
			        });
		  }
		  
		  
		});
	

	return ViewUser;
	

	 
	 
	   
	   
	
	
	   

	
	


		  
	        
	    	
	  
		  

	 
	        
			
	        
} );


