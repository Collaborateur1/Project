define([
        'backbone',
        
        ], function (
        		backbone
        		
        ) {
	'use strict';

	return Backbone.View.extend({
		el: '#dialog',
		draggable: true,

		draggableData : {
			isMouseDown: false,
			mouseOffset: {}
		},

		events: {
			'click .close': 'close'
		},

		close: function(){
			this.stopListening();
			this.trigger('dialog:close');
			this.$el.html("")
			
		},

		getModalHeader: function () {
			return this.$el.find('.modal-header');
		},
		
		getModalDialog: function(){
			return this.$el.find('.modal-dialog');
		},

		getModal: function () {
			return this.$el;
		},

		makeModalDraggable: function () {
			if (this.draggable) {
				this.getModalHeader().addClass('modal-draggable').on('mousedown', {dialog: this}, function (event) {
					var dialog = event.data.dialog;
					dialog.draggableData.isMouseDown = true;
					var dialogOffset = dialog.getModalDialog().offset();
					dialog.draggableData.mouseOffset = {
							top: event.clientY - dialogOffset.top,
							left: event.clientX - dialogOffset.left
					};
				});
				this.getModal().on('mouseup mouseleave', {dialog: this}, function (event) {
					event.data.dialog.draggableData.isMouseDown = false;
				});
				$('body').on('mousemove', {dialog: this}, function (event) {
					var dialog = event.data.dialog;
					if (!dialog.draggableData.isMouseDown) {
						return;
					}
					dialog.getModalDialog().offset({
						top: event.clientY - dialog.draggableData.mouseOffset.top,
						left: event.clientX - dialog.draggableData.mouseOffset.left
					});
				});
			}

			return this;
		},

		show: function(){
			// Do it when view is rendered
			this.$el.html("")			
			this.stopListening();
			this.$el.append(this.template);
			this.makeModalDraggable();
			this.$el.modal({
				backdrop: true,
				keyboard: true,
				show: true
			});
			
			if(this.callback){
				this.callback();
			}
		}
		
		
	});
});