/**
 * 
 */
define([
        
        'defaultDialogModalView',
        'text!../../html/template/modal/updateProfilPicture.html'
        ], function (
        		
        		DefaultDialogModalView,
        		mymodal
        ) {
	'use strict';
	var activeDropzone=function(){
		window.Dropzone.instances=[];
		   window.Dropzone._autoDiscoverFunction();
		   window.Dropzone.options.dropzone = {
				   addRemoveLinks:true
				 };
	};
	return DefaultDialogModalView.extend({
		template:   mymodal,
		callback: activeDropzone
	});

	
});