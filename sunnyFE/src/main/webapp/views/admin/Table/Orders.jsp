<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<style>.maintable tr > *:nth-child(13) {display: none;}</style>
<style>.maintable tr > *:nth-child(12) {display: none;}</style>
	<div class="main_content__body">
		<p hidden="true" id="geturl" data-value="/orders/get"></p>
		<p hidden="true" id="addurl" data-value="/customer/create"></p>
	    <p hidden="true" id="editurl" data-value="/customer/update"></p>
	    <p hidden="true" id="deleteurl" data-value="/customer/delete"></p>
	    
		<div class="main_content__body-title">
			<p>Danh sách tài khoản</p>
		</div>
		<table  class="table maintable">
        <thead>
            
        </thead>
        <tbody>
        
        </tbody>
    </table>
	</div>
	<div class="main_content__footer">
		<i class="fa-solid fa-circle-plus addbtn"></i>
		<i onclick="abcd()" class="fa-solid fa-magnifying-glass findbtn" ></i>
		<i class="fa-solid fa-arrows-rotate refreshbtn"></i>
		<i class="fa-solid fa-forward next-status"></i>
		<i class="fa-sharp fa-solid fa-truck-fast deliver"></i>
	</div>
	
	 <div id="AddAndEdit" class="modal">
	
	  
	  <div class="modal-content">
	    <div class="modal-header">
	      <span class="close closex">&times;</span>
	      <h2>Modal Header</h2>
	    </div>
	    <div class="modal-body">
	    	
	    	
	    	<label>userId:</label><input disabled name="userId"></br>
	    	<label>accountName:</label><input name="accountName"></br>
	    	<label>password:</label><input name="password"></br>
	    	<label>email:</label><input name="email"></br>
	    	<label>phone:</label><input name="phone"></br>
	    	<label>role:</label><select name="role">
								  <option value="0">Customer</option>
								  <option value="1">ADMIN</option>
								  <option value="2">Management</option>
								  <option value="3">Shipper</option>
								  <option value="4">Other</option>
								</select></br>
	    	<label>enable:</label><select class="toggledisable" disabled name="enable">
								  <option value="true">true</option>
								  <option value="false">false</option>
								</select></br>
	    	<label>deleted:</label><select class="toggledisable" disabled name="deleted">
								  <option value="false">false</option>
								  <option value="true">true</option>
								</select></br>
	    	
	    </div>
	    <div class="modal-footer">
	    	
	    	
	      <button id="oke">oke</button>
	      <button class="close">cancel</button>
	    </div>
	  </div>
	
	</div> 
	<!-- function  -->
	<script type="text/javascript">
	function decoratetable(){
		let status = {
				"0":"đang kiểm tra kho",
				"1":"đang chờ lấy hàng",
				"2":"đang giao",
				"3":"đã giao",
				"4":"đã đánh giá",
				"5":"đã hủy"
		}
		let tr = $('.maintable tbody tr')
    	tr.each(function () {
    		let colstt = $(this).children().eq(5)
    		colstt.data('originstatus', colstt.html())
			//console.log(colstt.data('originstatus') )
    		colstt.html(status[colstt.html()])
		})
	}
	</script>
	
	<script src="<c:url value='/views/admin/js/table.js'/>"></script>
	<script type="text/javascript">
		let url = $(".main_content__body #geturl").data("value")
		
		LoadTable(url);
		//setTimeout(() => {  LoadOrderStatus(); }, 100);
				
	
	</script>
	
	<script>
	function LoadOrderStatus(){
		let status = $('.maintable thead tr th').filter(function(){return $(this).html()=='status'})
		let index = $('.maintable thead tr th').index(status)
		let tr = $('.maintable tbody tr')
		for(let i = 0; i< tr.length; i++){
			console.log(tr.eq(i).find('td').eq(index).append(`<i class="fa-solid fa-forward"></i>`))
		}
		
	}
	
	//on append table trigger
	/* (function($) {

        var origAppend = $.fn.append;

        $.fn.append = function () {
            return origAppend.apply(this, arguments).trigger("append");
        };
    })(jQuery);

    $(".maintable").bind("append", function() {
    	await
    	let tr = $('.maintable tr')
    	tr.each(function () {
			console.log( $(this).children().length )
		})
    }); */

    //$("div").append("<span>");
	
	
	</script>
</body>
</html>