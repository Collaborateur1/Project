
// Flot Chart.js
// ====================================================================
// This file should not be included in your project.
// This is just a sample how to initialize plugins or components.
//
// - ThemeOn.net -



 $(document).ready(function() {


	// FLOT CHART
	// =================================================================
	// Require Flot Charts
	// -----------------------------------------------------------------
	// http://www.flotcharts.org/
	// =================================================================
	var pageviews = [[1, 5], [2, 9], [3, 17], [4, 22], [5, 19], [6, 11.5], [7, 5.2], [8, 9.5], [9, 11.3], [10, 15.3], [11, 19.9], [12, 24.6]],
	unique_visitor = [[1, 2.9], [2, 3.2], [3, 4.7], [4, 5.5], [5, 8.9], [6, 12.2], [7, 17.8], [8, 16.6], [9, 14.2], [10, 18.3], [11, 6.6], [12, 4.8]],
	visitor = [[1, 15], [2, 19], [3, 22.7], [4, 29.3], [5, 22], [6, 17], [7, 23.8], [8, 19.1], [9, 22.1], [10, 14.1], [11, 11.6], [12, 7.5]];
	
	var plot = $.plot("#demo-flot-line", [
			{
				label: 'Pageviews',
				data: pageviews,
				lines: {
					show: true,
					lineWidth:2,
					fill: false,
					fillColor: {
						colors: [{opacity: 0.5}, {opacity: 0.5}]
					}
				},
				points: {
					show: true,
					radius: 4
				}
			},
			{
				label: 'Unique Visitor',
				data: unique_visitor,
				lines: {
					show: true,
					lineWidth:2,
					fill: false,
					fillColor: {
						colors: [{opacity: 0.5}, {opacity: 0.5}]
					}
				},
				points: {
					show: true,
					radius: 4
				}
			},
			{
				label: 'Visitor',
				data: visitor,
				lines: {
					show: true,
					lineWidth:2,
					fill: false,
					fillColor: {
						colors: [{opacity: 0.5}, {opacity: 0.5}]
					}
				},
				points: {
					show: true,
					radius: 4
				}
			}
		],{
		series: {
			lines: {
				show: true
			},
			points: {
				show: true
			},
			shadowSize: 0	// Drawing is faster without shadows
		},
		colors: ['#37BC9B;', '#F6BB42'],
		legend: {
			show: true,
			position: 'nw',
			margin: [15]
			
		},
		grid: {
			borderWidth: 0,
			hoverable: true,
			clickable: true
		},
		yaxis: {
			ticks: 4, tickColor: '#eeeeee'
		},
		xaxis: {
			ticks: 12,
			tickColor: '#ffffff'
		}
	});


	// Flot tooltip
	// =================================================================
	$("<div id='demo-flot-tooltip'></div>").css({
		position: "absolute",
		display: "none",
		padding: "10px",
		color: "#fff",
		"text-align":"right",
		"background-color": "#1c1e21"
	}).appendTo("body");


	$("#demo-flot-line").bind("plothover", function (event, pos, item) {

		if (item) {
			var x = item.datapoint[0].toFixed(2),  y = item.datapoint[1];
			$("#demo-flot-tooltip").html("<p class='h4'>" + item.series.label + "</p>" + y)
				.css({top: item.pageY+5, left: item.pageX+5})
				.fadeIn(200);
		} else {
			$("#demo-flot-tooltip").hide();
		}

	});




	// FLOT PIE CHART
	// =================================================================
	// Require Flot Charts
	// -----------------------------------------------------------------
	// http://www.flotcharts.org/
	// =================================================================
	var dataSet = [
		{ label: "Comedy", data: 4119630000, color: "#177bbb" },
		{ label: "Action", data: 1012960000, color: "#a6c600" },
		{ label: "Adventure", data: 727080000, color: "#8669CC" },
		{ label: "Drama", data: 344120000, color: "#f84f9a" }
	];

	$.plot('#demo-flot-pie', dataSet, {
		series: {
			pie: {
				show: true,
				combine: {
				color: '#999',
				threshold: 0.1
				}
			}
		},
		legend: {
		show: true
		}
	});

	// FLOT DONUT CHART
	// =================================================================
	// Require Donut Charts
	// -----------------------------------------------------------------
	// http://www.flotcharts.org/
	// =================================================================
	var dataSet = [
		{ label: "Comedy", data: 4119630000, color: "#177bbb" },
		{ label: "Action", data: 1012960000, color: "#a6c600" },
		{ label: "Adventure", data: 727080000, color: "#8669CC" },
		{ label: "Drama", data: 344120000, color: "#f84f9a" }
	];

	$.plot('#demo-flot-donut', dataSet, {
		series: {
			pie: {
				show: true,
				innerRadius: 0.5
			}
		},
		legend: {
		show: true
		}
	});


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
			    borderWidth: 1,
			    hoverable: true,
			    clickable: true
		    },
			colors: ['#F6BB42', '#967ADC', '#2C967C'],
        });

	// FLOT SPLINE CHART
	// =================================================================
	// Require flot Spine Charts
	// -----------------------------------------------------------------
	// http://www.flotcharts.org/
	// =================================================================

var origData = {
	daterange: ["7-1-13", "7-7-13"],
	count: [1,5,9,3,17,22,19,11.5,9.5,11.3,15.3,19.9,24.6]
},
	ticks = [],
  max = 0;

function formatData(data) {
	dataTemp = {
		date: [],
		count: data.count
	};
	dataOut = [];

	var range = moment().range(moment(data.daterange[0], "M-D-YY"), moment(data.daterange[1], "M-D-YY"));

	range.by(moment().range(moment(data.daterange[0], "M-D-YY"), moment(data.daterange[0], "M-D-YY").add("days", 1)), function(m) {
		dataTemp.date.push(m.valueOf());
	ticks.push([m.valueOf(), m.format("MMM D")]);
	});

  num = dataTemp.count.length;
  
  for (var i = 0; i < num; i++) {
		dataOut.push([dataTemp.date[i], dataTemp.count[i]]);
	}
  
  var units = Math.pow(10, Math.floor(Math.log(Math.max.apply(Math, dataTemp.count)) / Math.log(10)));
		max = Math.ceil(Math.max.apply(Math, dataTemp.count) / units) * units;

	return dataOut;
}

function yticks(axis) {
	var units = Math.pow(10, Math.floor(Math.log(axis.datamax) / Math.log(10))),
		maxScale = Math.ceil(axis.datamax / units) * units,
		values = [];

	while (maxScale / 4 !== Math.round(maxScale / 4)) maxScale++;

	values.push([maxScale, (maxScale).toLocaleString()]);
	values.push([(maxScale * 3) / 4, ((maxScale * 3) / 4).toLocaleString()]);
	values.push([(maxScale * 2) / 4, ((maxScale * 2) / 4).toLocaleString()]);
	values.push([(maxScale) / 4, (maxScale / 4).toLocaleString()]);
	values.push([0, "0"]);

	return values;
}

var plot = $.plot("#flot-spline", [
	{
		label: "Clicks",
		data: formatData(origData)
	}
], {
	series: {
		points: {
			show: true,
			fillColor: "#e74c3c",
			radius: 4,
			lineWidth: 1,
			strokeColor: "#FFF"
		},
    splines: {
      show: true,
      tension: 0.3,
      lineWidth: 3
    }
	},
	xaxis: {
		tickLength: 0,
		ticks: ticks,
		font: {
			size: 11,
			lineHeight: 13,
			family: "Arial, sans-serif",
			color: "#888"
		}
	},
	yaxis: {
		font: {
			size: 11,
			lineHeight: 13,
			family: "Arial, sans-serif",
			color: "#888"
		},
		tickFormatter: function(y) { return y.toLocaleString(); },
		min: 0,
    max: max,
		ticks: yticks
	},
	colors: ["#e74c3c"],
	shadowSize: 0,
	tooltip: true,
	tooltipOpts: {
		content: function(label, x, y) {
			return '<div class="hover-title">' + moment(x).format("dddd, MMMM Do YYYY") + '</div><b style="color:#e74c3c">' + y.toLocaleString() + " </b><span>" + label.toLowerCase() + "</span>";
		}
	},
	grid: {
		hoverable: true,
		borderWidth: 0,
		margin: 1,
		mouseActiveRadius: 2000
	},
	legend: {
		labelFormatter: function(){ return ""; }
	}
  });

});


	// FLOT AREA CHART
	// =================================================================
	// Require Flot Area Chart
	// -----------------------------------------------------------------
	// http://www.flotcharts.org/
	// =================================================================
	
	var visitor = [[1, 15], [2, 19], [3, 22.7], [4, 29.3], [5, 22], [6, 17], [7, 23.8], [8, 19.1], [9, 22.1], [10, 14.1], [11, 11.6], [12, 7.5]],
	    pageviews = [[1, 5], [2, 9], [3, 17], [4, 22], [5, 19], [6, 11.5], [7, 5.2], [8, 9.5], [9, 11.3], [10, 15.3], [11, 19.9], [12, 24.6]];
	
	var plot = $.plot("#demo-flot-area", [
			{
				label: 'Visitor',
				data: visitor,
				lines: {
					show: true,
					lineWidth:2,
					fill: true,
					fillColor: {
						colors: [{opacity: 0.5}, {opacity: 0.5}]
					}
				},
				points: {
					show: true,
					radius: 4
				}
			},
			{
				label: 'Pageviews',
				data: pageviews,
				lines: {
					show: true,
					lineWidth:2,
					fill: true,
					fillColor: {
						colors: [{opacity: 0.5}, {opacity: 0.5}]
					}
				},
				points: {
					show: true,
					radius: 4
				}
			}
		],{
		series: {
			lines: {
				show: true
			},
			points: {
				show: true
			},
			shadowSize: 0	// Drawing is faster without shadows
		},
		colors: ['#37BC9B;', '#F6BB42'],
		legend: {
			show: true,
			position: 'nw',
			margin: [15]
			
		},
		grid: {
			borderWidth: 0,
			hoverable: true,
			clickable: true
		},
		yaxis: {
			ticks: 4, tickColor: '#eeeeee'
		},
		xaxis: {
			ticks: 12,
			tickColor: '#ffffff'
		}
	});


	// Flot tooltip
	// =================================================================
	$("<div id='demo-flot-tooltip'></div>").css({
		position: "absolute",
		padding: "8px",
		"font-size":"12px",
		color: "#000",
		"text-align":"right",
		"background-color": "#ffffff"
	}).appendTo("body");


	$("#demo-flot-area").bind("plothover", function (event, pos, item) {

		if (item) {
			var x = item.datapoint[0].toFixed(2),  y = item.datapoint[1];
			$("#demo-flot-tooltip").html("<p class='h4'>" + item.series.label + "</p>" + y)
				.css({top: item.pageY+5, left: item.pageX+5})
				.fadeIn(200);
		} else {
			$("#demo-flot-tooltip").hide();
		}

	});