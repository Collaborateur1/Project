
// Charts.js
// ====================================================================
// This file should not be included in your project.
// This is just a sample how to initialize plugins or components.
//
// - ThemeOn.net -



 $(document).ready(function() {

	// MORRIS AREA CHART
	// =================================================================
	// Require MorrisJS Chart
	// -----------------------------------------------------------------
	// http://morrisjs.github.io/morris.js/
	// =================================================================

	Morris.Area({
		element: 'demo-morris-area',
		data: [{
			period: 'Monday',
			dl: 77,
			up: 25
			}, {
			period: 'Tuesday',
			dl: 120,
			up: 58
			}, {
			period: 'Wednesday',
			dl: 85,
			up: 46
			}, {
			period: 'Thursday',
			dl: 180,
			up: 57
			}, {
			period: 'Friday',
			dl: 85,
			up: 75
			}, {
			period: 'Saturday',
			dl: 97,
			up: 57
			}, {
			period: 'Sunday',
			dl: 105,
			up: 70
			}],
		gridEnabled: false,
		gridLineColor: 'transparent',
		behaveLikeLine: true,
		xkey: 'period',
		ykeys: ['dl', 'up'],
		labels: ['Visitor', 'Pageview'],
		lineColors: ['#37BC9B'],
		pointSize: 0,
		pointStrokeColors : ['#FFFFFF'],
		lineWidth: 0,
		resize:true,
		hideHover: 'auto',
		fillOpacity: 0.7,
		parseTime:false
	});


	// MORRIS LINE CHART
	// =================================================================
	// Require MorrisJS Chart
	// -----------------------------------------------------------------
	// http://morrisjs.github.io/morris.js/
	// =================================================================
	var day_data = [
		{"elapsed": "Monday", "value": 10},
		{"elapsed": "Tuesday", "value": 8},
		{"elapsed": "Wednesday", "value": 6},
		{"elapsed": "Thursday", "value": 12},
		{"elapsed": "Friday", "value": 5},
		{"elapsed": "Saturday", "value": 15},
		{"elapsed": "Sunday", "value": 18},
	];
	Morris.Line({
		element: 'demo-morris-line',
		data: day_data,
		xkey: 'elapsed',
		ykeys: ['value'],
		labels: ['value'],
		gridEnabled: false,
		gridLineColor: 'transparent',
		lineColors: ['#37BC9B'],
		lineWidth: 2,
		parseTime: false,
		resize:true,
		hideHover: 'auto'
	});


	// MORRIS BAR CHART
	// =================================================================
	// Require MorrisJS Chart
	// -----------------------------------------------------------------
	// http://morrisjs.github.io/morris.js/
	// =================================================================
	Morris.Bar({
		element: 'demo-morris-bar',
		data: [
			{ y: '1', a: 100, b: 90 },
			{ y: '2', a: 75,  b: 65 },
			{ y: '3', a: 20,  b: 15 },
			{ y: '5', a: 50,  b: 40 },
			{ y: '6', a: 75,  b: 95 },
			{ y: '7', a: 15,  b: 65 },
			{ y: '8', a: 70,  b: 100 },
			{ y: '9', a: 100, b: 70 },
			{ y: '10', a: 50, b: 70 },
			{ y: '11', a: 20, b: 10 },
			{ y: '12', a: 40, b: 90 },
			{ y: '13', a: 70, b: 30 },
			{ y: '14', a: 50, b: 50 },
			{ y: '15', a: 100, b: 90 }
		],
		xkey: 'y',
		ykeys: ['a', 'b'],
		labels: ['Series A', 'Series B'],
		gridEnabled: false,
		gridLineColor: 'transparent',
		barColors: ['#37BC9B', '#7cd9c2'],
		resize:true,
		hideHover: 'auto'
	});



	// MORRIS DONUT CHART
	// =================================================================
	// Require MorrisJS Chart
	// -----------------------------------------------------------------
	// http://morrisjs.github.io/morris.js/
	// =================================================================
	Morris.Donut({
		element: 'demo-morris-donut',
		data: [
			{label: "Download Sales", value: 12},
			{label: "In-Store Sales", value: 30},
			{label: "COD Sales", value: 40},
			{label: "Mail-Order Sales", value: 20}
		],
		colors: [
			'#37BC9B',
			'#7cd9c2',
			'#41c8a6',
            '#6cd4ba'
		],
		resize:true
	});

});