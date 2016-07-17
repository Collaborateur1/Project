
// Dashboard.js
// ====================================================================
// This file should not be included in your project.
// This is just a sample how to initialize plugins or components.
//
// - squaredesigns.net -


$(window).on('load', function() {


	// FLOT BAR CHART
	// =================================================================
	// Require flot orderBars Charts
	// -----------------------------------------------------------------
	// http://www.flotcharts.org/
	// =================================================================

        var a1 = [[0,10],[1,8],[2,15],[3,5],[4,11],[5,3],[6,19],[7,15]];
        var a2 = [[0,7],[1,5],[2,12],[3,10],[4,1],[5,8],[6,6],[7,12]];
        var a3 = [[0,12],[1,12],[2,11],[3,2],[4,13],[5,3],[6,12],[7,11]];

        var data = [
            {
                label: "France",
                data: a1
            },
            {
                label: "Germany",
                data: a2
            },
            {
                label: "Italy",
                data: a3
            }
        ];

        $.plot($("#placeholder1"), data, {
            series: {
                bars: {
                    show: true,
                    barWidth: 0.20,
                    order: 1,
                    fillColor: {
                        colors: [{
                            opacity: 0.8
                        }, {
                            opacity: 1
                        }]
                    }
                }
            },
		    legend: {
		        show: false
		    },
		    grid: {
			    borderWidth: 0,
			    hoverable: true,
			    clickable: true
		    },
		   yaxis: {
			    show: true
		    },
		   xaxis: {
			    show: false
		    },
			colors: ['#F6BB42', '#967ADC', '#2C967C'],
        });

	// REALTIME FLOT CHART
	// =================================================================
	// Require Flot Charts
	// -----------------------------------------------------------------
	// http://www.flotcharts.org/
	// =================================================================
	// We use an inline data source in the example, usually data would
	// be fetched from a server


	var data = [],  totalPoints = 300;

	function getRandomData() {
		if (data.length > 0)
			data = data.slice(1);

		// Do a random walk

		while (data.length < totalPoints) {
			var prev = data.length > 0 ? data[data.length - 1] : 50,
				y = prev + Math.random() * 10 - 5;

			if (y < 0) {
				y = 0;
			} else if (y > 100) {
				y = 100;
			}

			data.push(y);
		}

		// Zip the generated y values with the x values
		var res = [];
		for (var i = 0; i < data.length; ++i) {
			res.push([i, data[i]])
		}
		return res;
	}

	// Set up the control widget
	var updateInterval = 300;
	var flotOptions = {
		series: {
			lines: {
				lineWidth:0,
				show: true,
				fill: true,
				fillColor : "#5BC0DE"
			},
			shadowSize: 0	// Drawing is faster without shadows
		},
		yaxis: {
			min: 0,
			max: 110,
			ticks: 30,
			show: false
		},
		xaxis: {
			show: false
		},
		grid: {
			hoverable: true,
			clickable: true,
			borderWidth: 0
		},
		tooltip: true,
		tooltipOpts: {
			defaultTheme: false
		}
	}


	var plot = $.plot("#demo-realtime-chart", [ getRandomData() ], flotOptions);
	function update() {
		plot.setData([getRandomData()]);

		// Since the axes don't change, we don't need to call plot.setupGrid()

		plot.draw();
		setTimeout(update, updateInterval);
	}

	update();


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

	$('#demo-pie-5').easyPieChart({
		barColor :'#F3565D',
		scaleColor: true,
		trackColor:'#eee',
		lineCap : 'round',
		   size : '85',
		lineWidth :7,
		onStep: function(from, to, percent) {
			$(this.el).find('.pie-value-lg').text(Math.round(percent) + '%');
		}
	});

	$('#demo-pie-6').easyPieChart({
		barColor :'#F3565D',
		scaleColor: true,
		trackColor:'#eee',
		lineCap : 'round',
		   size : '85',
		lineWidth :7,
		onStep: function(from, to, percent) {
			$(this.el).find('.pie-value-lg').text(Math.round(percent) + '%');
		}
	});

	// DATA TABLES
	// =================================================================
	// Require Data Tables
	// -----------------------------------------------------------------
	// http://www.datatables.net/
	// =================================================================

	$.fn.DataTable.ext.pager.numbers_length = 5;


	// Row selection and deletion (multiple rows)
	// -----------------------------------------------------------------
	var rowDeletion = $('#demo-dt-delete').DataTable({
		"responsive": true,
		"language": {
			"paginate": {
			  "previous": '<i class="fa fa-angle-left"></i>',
			  "next": '<i class="fa fa-angle-right"></i>'
			}
		},
		"dom": '<"toolbar">frtip'
	});
	$('#demo-custom-toolbar').appendTo($("div.toolbar"));

	$('#demo-dt-delete tbody').on( 'click', 'tr', function () {
		$(this).toggleClass('selected');
	} );

	$('#demo-dt-delete-btn').click( function () {
		rowDeletion.row('.selected').remove().draw( false );
	});


});
