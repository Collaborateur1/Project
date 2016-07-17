
// Widgets.js
// ====================================================================
// This file should not be included in your project.
// This is just a sample how to initialize plugins or components.
//
// - squaredesigns.net -


$(document).ready(function() {


	// EASY PIE CHART
	// =================================================================
	// Require easyPieChart
	// -----------------------------------------------------------------
	// http://rendro.github.io/easy-pie-chart/
	// =================================================================

	$('#demo-pie-2').easyPieChart({
		barColor :'#F3565D',
		scaleColor:false,
		trackColor:'#eee',
		lineCap : 'round',
		   size : '70',
		lineWidth :8,
		onStep: function(from, to, percent) {
			$(this.el).find('.pie-value').text(Math.round(percent) + '%');
		}
	});

	$('#demo-pie-3').easyPieChart({
		barColor :'#F3565D',
		scaleColor:false,
		trackColor:'#eee',
		lineCap : 'round',
		   size : '70',
		lineWidth :8,
		onStep: function(from, to, percent) {
			$(this.el).find('.pie-value').text(Math.round(percent) + '%');
		}
	});

	$('#demo-pie-4').easyPieChart({
		barColor :'#F3565D',
		scaleColor:false,
		trackColor:'#eee',
		lineCap : 'round',
		   size : '70',
		lineWidth :8,
		onStep: function(from, to, percent) {
			$(this.el).find('.pie-value').text(Math.round(percent) + '%');
		}
	});






	// GMAPS
	// =================================================================
	// Require gmaps
	// -----------------------------------------------------------------
	// http://hpneo.github.io/gmaps/
	// =================================================================

	var overlayMap = new GMaps({
		div: '#demo-overlays-map',
		lat: 37.336095,
		lng: -121.8885431
	});
	overlayMap.drawOverlay({
		lat: overlayMap.getCenter().lat(),
		lng: overlayMap.getCenter().lng(),
		content: '<div class="popover top" style="display:block; width:200px"><div class="arrow"></div><div class="popover-content"><strong>You are here</strong><p>86 Washington Sq, San Jose, CA 95192, United States</p></div></div>',
		verticalAlign: 'top',
		horizontalAlign: 'center'
	});





	// MEDIUM WEATHER WIDGET
	// =================================================================
	// Require sckycons
	// -----------------------------------------------------------------
	// http://darkskyapp.github.io/skycons/
	// =================================================================

	// on Android, a nasty hack is needed: {"resizeClear": true}


	skyconsOptions = {
		"color": "#fff",
		"resizeClear": true
	}





	// LARGE WEATHER WIDGET
	// =================================================================
	// Require sckycons
	// -----------------------------------------------------------------
	// http://darkskyapp.github.io/skycons/
	// =================================================================

	/* Main Icon */

	var skycons = new Skycons(skyconsOptions);
	skycons.add("demo-weather-lg-icon-1", Skycons.RAIN);
	skycons.play();

	var skycons2 = new Skycons(skyconsOptions);
	skycons.add("demo-weather-lg-icon-2", Skycons.PARTLY_CLOUDY_DAY);
	skycons.play();





	// SMALL WEATHER WIDGET
	// =================================================================
	// Require sckycons
	// -----------------------------------------------------------------
	// http://darkskyapp.github.io/skycons/
	// =================================================================

	var skycons = new Skycons(skyconsOptions);
	skycons.add("demo-weather-sm-icon", Skycons.RAIN);
	skycons.play();





	// EXTRA SMALL WEATHER WIDGET
	// =================================================================
	// Require sckycons
	// -----------------------------------------------------------------
	// http://darkskyapp.github.io/skycons/
	// =================================================================

	skycons = new Skycons(skyconsOptions);
	skycons.add("demo-weather-xs-icon-1", Skycons.CLEAR_DAY);
	skycons.play();
    



	// EXTRA SMALL WEATHER WIDGET
	// =================================================================
	// Require sckycons
	// -----------------------------------------------------------------
	// http://darkskyapp.github.io/skycons/
	// =================================================================

	skycons = new Skycons({
		"color": "#00b19d",
		"resizeClear": true
	});

	skycons.add("demo-weather-xs-icon-2", Skycons.PARTLY_CLOUDY_DAY);
	skycons.play();




	// JQUERY TAG IT
	// =================================================================
	// Require jQuery Tag It
	// http://harvesthq.github.io/chosen/
	// =================================================================

    $("#jquery-tagIt-white").tagit({
        
    });


	// SUMMERNOTE
	// =================================================================
	// Require Summernote
	// http://hackerwins.github.io/summernote/
	// =================================================================
    $('#demo-summernote').summernote({
        toolbar: [
            ['style', ['bold', 'italic', 'underline', 'clear']],
            ['fontsize', ['fontsize']],
            ['color', ['color']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['height', ['height']],
        ],
        height: 143   //set editable area's height
    });


});
