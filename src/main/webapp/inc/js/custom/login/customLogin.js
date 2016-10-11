
   
   var signForm = Backbone.View.extend({

		  //tagName:  'div',
		  el: '#signForm',
		  // Cache the template function for a single item.
		 

		  events: {
			  'change #signEmailInput': 'checkLoginPassword',
			  'change  #signPasswordInput': 'checkLoginPassword',
			  'keyup  #signChekEqualPasswordInput': 'checkPasswordEqual',
			  'click .Register' : 'signup'	  
		  },

		  initialize: function (options) {
		    // In Backbone 1.1.0, if you want to access passed options in
		    // your view, you will need to save them as follows:
		 //   this.options = options || {};
		  //this.listenTo(this.model, 'change', this.render);
		   // this.listenTo(this.model, 'change', this.render);
		    
		    //console.log(this.model);
		    
		  },

		  // Re-render the title of the todo item.
		  render: function() {
			  
			  var target =  this.$el;
			  target.html="lol";
			  
			  
			 
		  },
		  checkPasswordEqual: function() {
			  var password1=this.$("#signPasswordInput");
			  var password2=this.$("#signChekEqualPasswordInput");
			  if(password1.val()==password2.val()&&password2.val()!="")
				 {
				  var divPassword2=$("#signEqualPassword");
				  divPassword2.removeClass("has-success");
			    	divPassword2.removeClass("has-error");
			    	divPassword2.addClass("has-success");
				 }else
				 {
					  var divPassword2=$("#signEqualPassword");
					  divPassword2.removeClass("has-success");
				    	divPassword2.removeClass("has-error");
				    	divPassword2.addClass("has-error");
					 
				 }
			  
		  },
		  checkLoginPassword: function() {
			  var email=this.$("#signEmailInput");
			  var password=this.$("#signPasswordInput");
			  //var donnees = $(this).$el.serialize();
			 
				 //vraiment à améliorer    
				    $.ajax({
				       url : 'login/checkSignup', // La ressource ciblée
				       type : 'GET', // Le type de la requête HTTP.
				        data : 'email=' + email.val() +"&"+ 'password=' + password.val(), 
				        dataType: "json",
				      // data: donnees,
				   contentType: "application/x-www-form-urlencoded",
				      success : function(code_html, statut){ // code_html contient le HTML renvoyé
				    	
				    	
				    
				        },
				    error : function(resultat, statut, erreur){
                       alert("error ajax requete"+erreur+" "+statut+" "+resultat);
				       },
				        complete : function(resultat, statut){
				        	
				        	var divEmail=$("#signEmail");
					        var divPassword=$("#signPassword");
					    
					    if(resultat.responseJSON.signPasswordInput=="true")
					    	{
					    	divPassword.removeClass("has-success");
					    	divPassword.removeClass("has-error");
					    	
					    	divPassword.addClass("has-success");
					    	
					    	}else
					    	{
					    		divPassword.removeClass("has-success");
						    	divPassword.removeClass("has-error");
					    		
						    	divPassword.addClass("has-error");	
					    		
					    	}
					    
					    if(resultat.responseJSON.signEmailInput=="true")
					    {
					    	divEmail.removeClass("has-success");
					    	divEmail.removeClass("has-error");
					    	
					    	divEmail.addClass("has-success");
					    	
					    }else
				    	{
					    	divEmail.removeClass("has-success");
					    	divEmail.removeClass("has-error");
					    	
					    	divEmail.addClass("has-error");
				    		
				    	}
					    	
				        }
				    });
				   
				

			  
		  },
		  signup:function() {
			  var email=this.$("#signEmailInput");
			  var password=this.$("#signPasswordInput");
			  var passwordRetype=this.$("#signChekEqualPasswordInput");
			  var firstName=this.$(".firstName");
			  var lastName=this.$(".lastName");
			  
			  if(password.val()!=passwordRetype.val()){
				  
				    	new PNotify({
		                    title: 'Password re type',
		                    text: 'The two passwords are nor equals, please retape',
		                    type: 'error',
		                    styling: 'bootstrap3'
		                });
				    	password.val("");
				    	passwordRetype.val("");
				    	
			  }else{
			 
				     
				    $.ajax({
				       url : 'login/signup', // La ressource ciblée
				       type : 'GET', // Le type de la requête HTTP.
				        data : 'email=' + email.val() +"&"+ 'password=' + password.val()+"&"+'firstName='+firstName.val()+"&"+'lastName='+lastName.val(), 
				        dataType: "html",
				      // data: donnees,
				   contentType: "application/x-www-form-urlencoded",
				      success : function(resultat, statut, erreur){ 
				    	  
				    	  new PNotify({
			                    title: 'Signup succed',
			                    text: 'Welcom '+firstName.val()+" you can now conect",
			                    type: 'success',
			                    styling: 'bootstrap3',
			                    delay:2000
			                });
				    
				        },
				    error : function(resultat, statut, erreur){
				    	new PNotify({
		                    title: 'Signup failed',
		                    text: 'sorry '+firstName.val()+" please verify your informations :"+resultat.responseText,
		                    type: 'error',
		                    styling: 'bootstrap3',
		                    delay:1500
		                });
		    		  }
				       ,
				        complete : function(resultat, statut){
				        	
				        	
					    	
				        }
				    });
			  }
		  },
		  close: function() {
		    // executed when todo loses focus
			  this.$el.html("jai changé");
		  },

		
		});
 
   var  signform= new signForm(); 