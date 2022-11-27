<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<style>
.BieuDoDoanhThu div span svg g:nth-child(4) {
    display: none;
}
.BieuDoDoanhThu{
	width: 60%;
	
}
.BieuDoTron{
	width: 40%;
}
.wrap-bieudo{
	display: flex;
}

</style>
	<div class="wrap-bieudo">
	
		<div class="BieuDoDoanhThu">
				<div id="chart-container"></div>
		</div>
		<div class="BieuDoTron">
			<canvas id="myChart" style="width:40%;max-width:500px"></canvas>
		</div>
	</div>
	<script type="text/javascript" src="https://cdn.fusioncharts.com/fusioncharts/latest/fusioncharts.js"></script>
	<script type="text/javascript" src="https://cdn.fusioncharts.com/fusioncharts/latest/themes/fusioncharts.theme.fusion.js"></script>
	<script type="text/javascript">
	var chartObj = new FusionCharts({
	    type: 'scrollColumn2d',
	    renderAt: 'chart-container',
	    width: '680',
	    height: '390',
	    dataFormat: 'json',
	    dataSource: {
	        "chart": {
	            "theme": "fusion",
	            "caption": "Tổng doanh thu",
	            "subcaption": "",
	            "xaxisname": "Tháng",
	            "yaxisname": "",
	            "showvalues": "0",
	            "numberprefix": "",
	            "numVisiblePlot": "12",
	            "scrollheight": "16",
	            "flatScrollBars": "1",
	            "scrollShowButtons": "0",
	            "scrollColor": "#cccccc",
	            "showHoverEffect": "1"
	        },
	        "categories": [{
	            "category": [{
	                "label": "1 Jan 2016"
	            }, {
	                "label": "Feb 2016"
	            }, {
	                "label": "Mar 2016"
	            }, {
	                "label": "Apr 2016"
	            }, {
	                "label": "May 2016"
	            }, {
	                "label": "Jun 2016"
	            }, {
	                "label": "Jul 2016"
	            }, {
	                "label": "Aug 2016"
	            }, {
	                "label": "Sep 2016"
	            }, {
	                "label": "Oct 2016"
	            }, {
	                "label": "Nov 2016"
	            }, {
	                "label": "Dec 2016"
	            }, {
	                "label": "Jan 2017"
	            }, {
	                "label": "Feb 2017"
	            }, {
	                "label": "Mar 2017"
	            }, {
	                "label": "Apr 2017"
	            }, {
	                "label": "May 2017"
	            }, {
	                "label": "Jun 2017"
	            }, {
	                "label": "Jul 2017"
	            }, {
	                "label": "Aug 2017"
	            }, {
	                "label": "Sep 2017"
	            }, {
	                "label": "Oct 2017"
	            }, {
	                "label": "Nov 2017"
	            }, {
	                "label": "Dec 2017"
	            }]
	        }],
	        "dataset": [{
	            "data": [{
	                "value": "67000"
	            }, {
	                "value": "29800"
	            }, {
	                "value": "25800"
	            }, {
	                "value": "26800"
	            }, {
	                "value": "29600"
	            }, {
	                "value": "32600"
	            }, {
	                "value": "31800"
	            }, {
	                "value": "36700"
	            }, {
	                "value": "29700"
	            }, {
	                "value": "31900"
	            }, {
	                "value": "34800"
	            }, {
	                "value": "24800"
	            }, {
	                "value": "26300"
	            }, {
	                "value": "31800"
	            }, {
	                "value": "30900"
	            }, {
	                "value": "33000"
	            }, {
	                "value": "36200"
	            }, {
	                "value": "32100"
	            }, {
	                "value": "37500"
	            }, {
	                "value": "38500"
	            }, {
	                "value": "35400"
	            }, {
	                "value": "38200"
	            }, {
	                "value": "33300"
	            }, {
	                "value": "68300"
	            }]
	        }]
	    }
	});
		chartObj.render();
	</script>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
	<script type="text/javascript">
	var xValues = ["Italy", "France", "Spain", "USA", "Argentina"];
	var yValues = [55, 49, 44, 24, 15];
	var barColors = [
	  "#b91d47",
	  "#00aba9",
	  "#2b5797",
	  "#e8c3b9",
	  "#1e7145"
	];

	new Chart("myChart", {
	  type: "pie",
	  data: {
	    labels: xValues,
	    datasets: [{
	      backgroundColor: barColors,
	      data: yValues
	    }]
	  },
	  options: {
	    title: {
	      display: true,
	      text: "World Wide Wine Production 2018"
	    }
	  }
	});
	</script>

</body>
</html>