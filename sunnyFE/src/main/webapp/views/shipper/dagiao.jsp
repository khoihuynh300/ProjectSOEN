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

<style>.maintable tr > *:nth-child(2) {display: none;}</style>
	<div class="main_content__body">
		<p hidden="true" id="geturl" data-value="/orders/get"></p>
		<p hidden="true" id="addurl" data-value="/customer/create"></p>
	    <p hidden="true" id="editurl" data-value="/customer/update"></p>
	    <p hidden="true" id="deleteurl" data-value="/customer/delete"></p>
	    
		<div class="main_content__body-title">
			<p>Lịch sử giao hàng</p>
		</div>
		<table  class="table maintable">
        <thead>
            <tr>
            <th class="cbx-all" style="width:10px;"><input  type="checkbox" id="" name="" value=""></th>
            
            <th>Mã đơn hàng</th>
            <th>Tên khách hàng</th>
            <th>Ngày đặt</th>
            <th>Thanh toán</th>
            <th>Trạng thái</th>
            <th>Địa chỉ</th>
            <th>Người giao hàng</th>
            <th>Chi tiết đơn hàng</th>
            </tr>
        </thead>
        <tbody>
        
        </tbody>
    	</table>
	</div>
	<div class="main_content__footer">
		<i class="fa-solid fa-arrows-rotate refreshbtn grow-btn-when-hover" ></i>
		<i class="fa-solid fa-eye viewdetail grow-btn-when-hover"></i>
		
		
	</div>
	
	
	<div id="TblChooseObj" class="modal">
	  <div class="modal-content">
	    <div class="modal-header">
	      <span class="close closex">&times;</span>
	      <h2>Order detail</h2>
	    </div>
	    <div class="modal-body">
	    	<table class="table subtable">
		        <thead>
		            
		        </thead>
		        <tbody>
		        
		        </tbody>
		    </table>
	    	
	    </div>
	    <div class="modal-footer">
	    	
	    	
	      
	    </div>
	  </div>
	
	</div> 
	 
	<!-- function  -->
	<script type="text/javascript">
	function decoratetable(){
		let status = {
				"0":"đang chờ xác nhận",
				"1":"đã xác nhận",
				"2":"đang giao hàng",
				"3":"đã giao hàng",
				"4":"đã nhận hàng",
				"5":"đã hủy",
		}
		let tr = $('.maintable tbody tr')
    	tr.each(function () {
    		let colstt = $(this).children().eq(5)
    		colstt.data('originstatus', colstt.html())
			//console.log(colstt.data('originstatus') )
    		if(colstt.html() == 0  ){
    			colstt.css('color','red')
    		} else if(colstt.html() == 2 || colstt.html() == 1 ){
    			colstt.css('color','blue')
    		} else {
    			colstt.css('color','green')
    		}
    		colstt.html(status[colstt.html()])
		})
	}
	</script>
	
	<script src="<c:url value='/views/admin/js/table.js'/>"></script>
	<script src="<c:url value='/views/shipper/js/order.js'/>"></script>
	<script type="text/javascript">
		let url = $(".main_content__body #geturl").data("value")
		async function myDisplay() {
			$.get('/sunnyFE/account/getsession', function(ketqua) {
				 gshipperid = ketqua.shipper
				 gshipperid = gshipperid.empId
				 console.log(gshipperid)
				 LoadTable2(url + "?shipid=" + gshipperid);
			 })
			 
			await setTimeout(() => {
				let tr = $('.maintable tbody tr')
		    	tr.each(function () {
		    		let colstt = $(this).children().eq(5)
		    		//let shid = $(this).children().eq(11)
		    		//alert(colstt.data('originstatus'))
		    		if(colstt.data('originstatus') <3 ){
		    			//console.log(shid.data('objectvalue'))
		    			$(this).remove()
		    		}
		    		
					
				})
				
				
			}, 200);
			
		}
		myDisplay()
		
		
		//
				
	
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
    //setTimeout(() => {  ; }, 100);
	function checkfilter(ob) {
		
		if(ob.status < 4 ||ob.status == 6 ){
			return true;
		} 
		return false;
	}
	</script>
</body>
</html>