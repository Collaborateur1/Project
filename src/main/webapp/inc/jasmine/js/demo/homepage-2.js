
// Homepage-2.js
// ====================================================================
// This file should not be included in your project.
// This is just a sample how to initialize plugins or components.
//
// - ThemeOn.net -


$(document).ready(function() {

	// JQUERY COUNT-TO
	// =================================================================
	// Require jQuery countTo
	// -----------------------------------------------------------------
	// https://github.com/mhuggins/jquery-countTo
	// =================================================================

      $('.timer').countTo();


	// RICKSAW CHART REALTIME
	// =================================================================
	// Require Ricksaw Chart
	// -----------------------------------------------------------------
	// https://github.com/shutterstock/rickshaw
	// =================================================================

    var seriesData = [
        [],
        []
    ];
    var random = new Rickshaw.Fixtures.RandomData(50);

    for (var i = 0; i < 50; i++) {
        random.addData(seriesData);
    }

    graph = new Rickshaw.Graph({
        element: document.querySelector("#chart"),
        height: 175,
        renderer: 'area',
        series: [{
            data: seriesData[0],
            color: 'rgb(248, 164, 163)',
            name: 'DB Server'
        }, {
            data: seriesData[1],
            color: '#eceff1',
            name: 'Web Server'
        }]
    });
    var hoverDetail = new Rickshaw.Graph.HoverDetail({
        graph: graph
    });

    setInterval(function() {
        random.removeData(seriesData);
        random.addData(seriesData);
        graph.update();

    }, 1000);


	// RICKSAW CHART REALTIME
	// =================================================================
	// Require Ricksaw Chart
	// -----------------------------------------------------------------
	// https://github.com/shutterstock/rickshaw
	// =================================================================

    var analyticData = [
        [],
        []
    ];
    var random = new Rickshaw.Fixtures.RandomData(50);

    for (var i = 0; i < 50; i++) {
        random.addData(analyticData);
    }

    analyticgraph = new Rickshaw.Graph({
        element: document.querySelector("#map-chart"),
        height: 150,
        renderer: 'area',
        series: [{
            data: analyticData[0],
            color: 'rgba(0,144,217,0.25)',
            name: 'DB Server'
        }, {
            data: analyticData[1],
            color: '#eceff1',
            name: 'Web Server'
        }]
    });
    var hoverDetail = new Rickshaw.Graph.HoverDetail({
        graph: analyticgraph
    });

    setInterval(function() {
        random.removeData(analyticData);
        random.addData(analyticData);
        analyticgraph.update();

    }, 1000);


	// INLINE BOOTSTRAP DATEPICKER
	// =================================================================
	// Require Bootstrap Datepicker
	// http://eternicode.github.io/bootstrap-datepicker/
	// =================================================================


	$('#demo-dp-inline div').datepicker({
	format: "MM dd, yyyy",
	todayBtn: "linked",
	autoclose: true,
	todayHighlight: true
	});



	// DATA TABLES
	// =================================================================
	// Require Data Tables
	// -----------------------------------------------------------------
	// http://www.datatables.net/
	// =================================================================


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
	} );



	// JVECTOR MAP
	// =================================================================
	// Require jVectorMap js
	// -----------------------------------------------------------------
	// http://jvectormap.com/
	// =================================================================


    $('#usa-map-markers').vectorMap({
        map: 'us_aea_en',
        normalizeFunction: 'polynomial',
        scaleColors: ['#C8EEFF', '#0071A4'],
        normalizeFunction: 'polynomial',
        hoverOpacity: 0.7,
        hoverColor: false,
        focusOn:{
		          x: 6,
		          y: 1,
		          scale: 1.85
	    },
	    zoomOnScroll:false,
	    zoomMin: 1.65,
        markerStyle: {
            initial: {
                fill: '#fad733'
            },
            selected: {
                fill: '#ffffff'
            }
        },
        regionStyle: {
            initial: {
                fill: '#23b7e5'
            },
            selected: {
                fill: '#27c24c'
            }
        },
        series: {
            markers: [{
                attribute: 'r',
                scale: [5, 15],
                values: [
                    187.70,
                    255.16,
                    310.69,
                    605.17,
                    248.31,
                    107.35,
                    217.22
                ]
            }]
        },
        backgroundColor: '#ffffff',
     markers :[
        {latLng: [30.22, -81.88], name: 'Cecil,FL'},
        {latLng: [25.8,-80.28], name: 'Miami Intl,FL'},
        {latLng: [32.33, -85.00], name: 'Fort Benning,GA'},
        {latLng: [34.35, -85.17 ], name: 'Rome/Russell,GA'},
        {latLng: [35.90, -82.82], name: 'Hot Springs,NC'},
        {latLng: [35.85, -77.88], name: 'Rocky Mt,NC'},
        {latLng: [32.90, -97.03], name: 'Dallas/FW,TX'},
        {latLng: [39.37, -75.07], name: 'Millville,NJ'},
        {latLng: [39.37, -60.70], name: 'Goodland,KS'}
      ],
    });



	// EXTRA SMALL WEATHER WIDGET
	// =================================================================
	// Require sckycons
	// -----------------------------------------------------------------
	// http://darkskyapp.github.io/skycons/
	// =================================================================


	skycons = new Skycons({
		"color": "#ffffff",
		"resizeClear": true
	});
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

});