<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Highmaps Example</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basePath" value="${pageContext.request.contextPath}" />
<script type="text/javascript"
	src="${basePath}/script/jquery/jquery-1.8.3.min.js"></script>
<style type="text/css">
#container {
    height: 500px; 
    min-width: 310px; 
    max-width: 800px; 
    margin: 0 auto; 
}
.loading {
    margin-top: 10em;
    text-align: center;
    color: gray;
}
</style>
<script type="text/javascript">
$(function () {
    $.getJSON('http://www.hcharts.cn/datas/jsonp.php?filename=world-population-density.json&callback=?', function (data) {
        // Initiate the chart
        $('#container').highcharts('Map', {
            title : {
                text : 'Population density by country (/kmÂ²)'
            },

            mapNavigation: {
                enabled: true,
                buttonOptions: {
                    verticalAlign: 'bottom'
                }
            },

            colorAxis: {
                min: 1,
                max: 1000,
                type: 'logarithmic'
            },

            series : [{
                data : data,
                mapData: Highcharts.maps['custom/world'],
                joinBy: ['iso-a2', 'code'],
                name: 'Population density',
                states: {
                    hover: {
                        color: '#BADA55'
                    }
                },
                tooltip: {
                    valueSuffix: '/kmÂ²'
                }
            }]
        });
    });
});
		</script>
	</head>
	<body>

<script src="${basepath}/script/highcharts/Highmaps-4.2.5/js/highmaps.js"></script>
<script src="${basepath}/script/highcharts/Highmaps-4.2.5/js/modules/data.js"></script>
<script src="${basepath}/script/highcharts/Highmaps-4.2.5/js/modules/exporting.js"></script>
<script src="https://code.highcharts.com/mapdata/custom/world.js"></script>

<div id="container" style="max-width: 1000px"></div>
</body>
</html>
