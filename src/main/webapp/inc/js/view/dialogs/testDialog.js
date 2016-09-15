/**
 * 
 */
define([
        
        'defaultDialogModalView',
        'text!../../../template/modal/testModal.html'
        ], function (
        		
        		DefaultDialogModalView,
        		mymodal
        ) {
	'use strict';

	return DefaultDialogModalView.extend({
		template:   mymodal
	});

	
});