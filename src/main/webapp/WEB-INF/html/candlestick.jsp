<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Highstock Example</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basePath" value="${pageContext.request.contextPath}" />
<script type="text/javascript"
	src="${basePath}/script/jquery/jquery-1.8.3.min.js"></script>
<style type="text/css">
	${demo.css}
</style>
<script type="text/javascript">
	$(function () {
    $.getJSON('${basePath}/dashboard/get-future-data', function (data) {
    //$.getJSON('http://www.hcharts.cn/datas/jsonp.php?filename=aapl-ohlcv.json&callback=?', function (data) {
        // split the data set into ohlc and volume
        var ohlc = [],
            volume = [],
            dataLength = data.length,
            // set the allowed units for data grouping
            groupingUnits = [[
                '周',                         	// unit name
                [1]                             // allowed multiples
            ], [
                '月',
                [1, 2, 3, 4, 6]
            ]],

            i = 0;
 	       for (i; i < dataLength; i += 1) {
            ohlc.push([
                data[i][0], // the date
                data[i][1], // open
                data[i][2], // high
                data[i][3], // low
                data[i][4] // close
            ]);

            volume.push([
                data[i][0], // the date
                data[i][5] // the volume
            ]);
        }   

/*            for (i; i < dataLength; i += 1) {
            ohlc.push([
                data[i][13], // the date
                data[i][7], // open
                data[i][8], // high
                data[i][15], // low
                data[i][16] // close
            ]);

            volume.push([
                data[i][13], // the date
                data[i][1] // the volume
            ]);
        }
  */
        // create the chart
        $('#container').highcharts('StockChart', {

            rangeSelector: {
                selected: 1
            },

            title: {
                text: 'RB1701'
            },

            yAxis: [{
                labels: {
                    align: 'right',
                    x: -3
                },
                title: {
                    text: 'OHLC'
                },
                height: '60%',
                lineWidth: 2
            }, {
                labels: {
                    align: 'right',
                    x: -3
                },
                title: {
                    text: 'Volume'
                },
                top: '65%',
                height: '35%',
                offset: 0,
                lineWidth: 2
            }],

            series: [{
                type: 'candlestick',
                name: 'AAPL',
                data: ohlc,
                dataGrouping: {
                    units: groupingUnits
                }
            }, {
                type: 'column',
                name: 'Volume',
                data: volume,
                yAxis: 1,
                dataGrouping: {
                    units: groupingUnits
                }
            }]
        });
    });
});
		</script>
</head>
<body>
	<script src="${basePath}/script/highcharts/Highstock-4.2.5/js/highstock.js"></script>
	<script src="${basePath}/script/highcharts/Highstock-4.2.5/js/modules/exporting.js"></script>
	<div id="container" style="height: 400px; min-width: 310px"></div>
</body>
</html>
