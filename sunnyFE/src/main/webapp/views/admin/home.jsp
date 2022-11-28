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
			<div class="optionBieuDo">
				<a>Loại:</a><select class="type" name="type">
								  <option value="year">Năm</option>
								 <!--  <option value="season">Quý</option> -->
								  <option value="month">Tháng</option>
								  <option value="day">Ngày</option>
								</select>
				
			</div>
				<div id="chart-container"></div>
		</div>
		<div class="BieuDoTron">
			<canvas id="myChart" style="width:40%;max-width:500px"></canvas>
		</div>
	</div>
	<script type="text/javascript" src="https://cdn.fusioncharts.com/fusioncharts/latest/fusioncharts.js"></script>
	<script type="text/javascript" src="https://cdn.fusioncharts.com/fusioncharts/latest/themes/fusioncharts.theme.fusion.js"></script>
	
	<script type="text/javascript">
	var strSDate = "";
	$(document).ready(async function(){
		
		await new Promise((resolve, reject) => {
			fetch('http://localhost:8083/orders/get')
			.then((response) => response.json())
			.then((data) =>{
				console.log(data)
				strSDate = data[data.length - 1 ].OrderDate
				resolve()
			});
		});
		showchart() 
		showchart2()
		
		
	});
	function datetostring(d) {
		//console.log(d)
		let date = d.toJSON().slice(0, 10);
        let nDate = date.slice(8, 10) + '/'
                + date.slice(5, 7) + '/'
                + date.slice(0, 4);
        //console.log(nDate)
        return nDate;
	}
	function datetostring2(d) {
		d.setDate(d.getDate() + 1);
		//console.log(d)
		let date = d.toJSON().slice(0, 10);
        let nDate = date.slice(8, 10) + '/'
                + date.slice(5, 7) + '/'
                + date.slice(0, 4);
        //console.log(nDate)
        return nDate;
	}
	function getfirstdateofnextyear(d) {
		let dateParts = d.split("/");
		let dateObject = new Date(+dateParts[2], dateParts[1] - 1, +dateParts[0]);
		let year = dateObject.getFullYear()
		let fdate =  new Date(year+1, 0, 2)
		return datetostring(fdate)
	}
	function getfirstdateofyear(d) {
		let dateParts = d.split("/");
		let dateObject = new Date(+dateParts[2], dateParts[1] - 1, +dateParts[0]);
		let year = dateObject.getFullYear()
		let fdate =  new Date(year, 0, 2)
		return datetostring(fdate)
	}
	function getlastdateofyear(d) {
		let dateParts = d.split("/");
		let dateObject = new Date(+dateParts[2], dateParts[1] - 1, +dateParts[0]);
		let year = dateObject.getFullYear()
		let fdate =  new Date(year+1, 0, 1)
		return datetostring(fdate)
	}
	function getfirstdayofmonth(d, optiond = 1, optionm = 0 ) { //1 0 firstofyear, 0 1 lastofyear
		let dateParts = d.split("/");
		let dateObject = new Date(+dateParts[2], dateParts[1], +dateParts[0]);
		let year = dateObject.getFullYear()
		let fdate =  new Date(year, dateObject.getMonth() + optionm, 1 + optiond)
		return datetostring(fdate)
	}
	function getnexday(d) {
		let dateParts = d.split("/");
		let strday = parseInt(dateParts[0]) + 1
		let dateObject = new Date(+dateParts[2], dateParts[1] - 1, + dateParts[0]);
		let year = dateObject.getFullYear()
		//console.log(dateObject)
		let fdate =  new Date(year, dateObject.getMonth(), strday)
		return fdate
	}
	
	async function showchart() {
		let type = $('.optionBieuDo .type').val()
		console.log(type)
		console.log(strSDate)
		
		var newcate = []
		var newdata = []
		if(type=="year"){
			//console.log("getyear")
			let tempdate = strSDate
			while(true){
				let sdate = tempdate
				let edate = getlastdateofyear(tempdate)
				tempdate = getfirstdateofnextyear(tempdate)
				//console.log(sdate)
				//console.log(edate)
				
				await new Promise((resolve, reject) => {
					fetch('http://localhost:8083/producttype/total-income-in-interval?startDate='+sdate+'&endDate=' + edate)
					.then((response) => response.json())
					.then((data) =>{
						newcate.push({"label": sdate.split("/")[2]})
						newdata.push({"value": data})
						//console.log(data)
						resolve()
					});
				});
									
				if( parseInt(tempdate.split("/")[2]) > parseInt( (datetostring(new Date)).split("/")[2])){
					break
				}
			}
			
		}else if(type=="month"){
			let tempdate = strSDate
			while(true){
				let sdate = tempdate
				let edate = getfirstdayofmonth(tempdate,0,0)
				tempdate = getfirstdayofmonth(tempdate, 1,0)
				let nowdate = new Date
				let str = tempdate.split("/")[2]
				let tdate = new Date(tempdate.split("/")[2] + "-" + tempdate.split("/")[1] )
				console.log("s:" + sdate)
				console.log("e:"+ edate)
				console.log("t:"+ tempdate)
				//console.log(tdate>=nowdate)
				
				
				await new Promise((resolve, reject) => {
					fetch('http://localhost:8083/producttype/total-income-in-interval?startDate='+sdate+'&endDate=' + edate)
					.then((response) => response.json())
					.then((data) =>{
						newcate.push({"label": sdate.split("/")[1] + "/ " + sdate.split("/")[2]})
						newdata.push({"value": data})
						console.log(data)
						resolve()
					});
				});
				
				if(tdate >= nowdate){
					break
				}
				
			}
		}
		else if(type=="day"){
			let tempdate = strSDate
			while(true){
				let sdate = tempdate
				tempdate = getnexday(tempdate)
				tempdate = datetostring2(tempdate)
				let edate = tempdate
				//console.log("s:"+sdate)
			//	console.log("e:"+edate)
				//console.log("t:"+tempdate)
				
				await new Promise((resolve, reject) => {
					fetch('http://localhost:8083/producttype/total-income-in-interval?startDate='+sdate+'&endDate=' + edate)
					.then((response) => response.json())
					.then((data) =>{
						newcate.push({"label": sdate})
						newdata.push({"value": data})
						console.log(data)
						resolve()
					});
				});
				
				if(getnexday(sdate) >= new Date){
					break
				}
				
				
			}
		}
		
		
		
		
		/* var category =[
			{"label": "Jan 2020"}, 
			{"label": "Feb 2020"}, 
			{"label": "Mar 2020"},  
			{"label": "Dec 2020"}
			]
		
		let objc = {"label": "Dec 2021"}
		category.push(objc)
		var data = [
			{"value": "97000000"},
			{"value": "29800000"},
			{"value": "25800000"}, 
			{"value": "68300000"}
			]
		
		let objd = {"value": "68300000"}
		data.push(objd) */
		
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
					"category": newcate
				}],
				"dataset": [{
					"data": newdata
				}]
			}
		});
		chartObj.render();
	}
	
	
	
	async function showchart2() {
		var xValues = [];
		var yValues = [];
		var barColors = [
		  "#b91d47",
		  "#00aba9",
		  "#2b5797",
		  "#e8c3b9",
		  "#1e7145"
		];
		
		await new Promise((resolve, reject) => {
			fetch('http://localhost:8083/product/n-product-best-income?n=5')
			.then((response) => response.json())
			.then((data) =>{
				data.forEach(function(item) {
					xValues.push(item[0])
					yValues.push(item[1])
					
				})
				
				resolve()
			});
		});
		
		await new Promise((resolve, reject) => {
			fetch('http://localhost:8083/producttype/total-income')
			.then((response) => response.json())
			.then((data) =>{
				let left = data
				yValues.forEach(function(item) {
					left = left - item
				})
				console.log(left)
				xValues.push("khác")
				yValues.push(left)
				resolve()
			});
		});
		
		

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
		      text: "Top 5 sản phẩm bán chạy nhất"
		    }
		  }
		});
	}
		
	$('.optionBieuDo select.type').on('change', function () {
		
		
		showchart()
		
	})
	
	
	</script>
	
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
	<script type="text/javascript">
	
	</script>

</body>
</html>