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
    $.getJSON('http://www.hcharts.cn/datas/jsonp.php?filename=aapl-c.json&callback=?', function (data) {
        // Create the chart
        $('#container').highcharts('StockChart', {
            rangeSelector : {
                selected : 1
            },

            title : {
                text : 'AAPL Stock Price'
            },

            series : [{
                name : 'AAPL',
                data : data,
                tooltip: {
                    valueDecimals: 2
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
