/**
 * 
 */



$(document).on("click", ".viewdetail", function(){
	let selectrow = $('tbody tr input:checkbox')
	selectrow.each( function(){
		if(this.checked){
			
			let inputId = 0;
			let orderid = $(this).closest('tr').find('td').eq(2).html()
			$.ajax({
				url : "http://localhost:8083/orderdetail/get-all-order-detail?orderid=" + orderid,
				type : "GET",
				dataType: "json",				
				success : function(result) {
					var keys = Object.keys(result[0])
					var keyslength = keys.length
					
					$('.subtable thead tr').remove()
					$('.subtable tbody tr').remove()
					$('.subtable p').remove()
					$('.subtable').append(`<p hidden id="inputId">${inputId}</p>`)
					$('.subtable thead').append(`<tr></tr>`)
					//$('.subtable thead tr').append(`<th></th>`)
					
					for (var i = 0; i<keyslength; i++){
						$('.subtable thead tr').append(`<th>${keys[i]}</th>`)
					}
		
					for (var i = 0; i <result.length ; i++) { 
						$('.subtable tbody').append(`<tr></tr>`)
						//$('.subtable tbody tr').last().append(`<td style="width:70px;" ><button class="btnsubmit" >chọn</button></td>`)
						for (var j = 0; j<keyslength; j++){
							if(typeof result[i][keys[j]] === 'object' && result[i][keys[j]] !== null ){
								let objdata = result[i][keys[j]]
								$('.subtable tbody tr').last().append(`<td name="${keys[j]}" >${objdata[Object.keys(objdata)[0]]}</td>`)					
							}
							else{
								
								$('.subtable tbody tr').last().append(`<td name="${keys[j]}" >${result[i][keys[j]]}</td>`)
							}
						}	
					}
					$('#TblChooseObj').css("display", "block");
				},
				error : function(error) {
					alert('an error occur!')
				}
			});
			
			
			return false;
		}
	})
})

$(document).on("click", ".getorder", function(){
	let selectrow = $('tbody tr input:checkbox')
	//console.log(selectrow.length)
	selectrow.each( function(){
		if(this.checked){
			let shipperid;
			let orderid = $(this).closest('tr').find('td').eq(1).html()
			
			$.get('/sunnyFE/account/getsession', function(ketqua) {
				console.log(ketqua)
				shipperid = ketqua.shipper
				shipperid = shipperid.empId
				console.log(shipperid)
				console.log(orderid)
				fetch("http://localhost:8083/employee/shipper/get-order?shipperid=" +shipperid + "&orderid=" +orderid)
				  .then((response) =>{
					console.log("success")
					toast({
			          title: "SUCCESS",
			          message: "Nhận đơn hàng thành công!",
			          type: "success", //or success
			        });
					myDisplay()
					if(response.status == 406){
						//alert("đơn hàng " + orderid + " đã có người nhận!")
						toast({
			          title: "Thất bại",
			          message: "đơn hàng " + orderid + " đã có người nhận!",
			          type: "error", 
			        });
					}
				})
				   
				
			})
		}
	})
})
 
 
 
$(".main_content").on("click", ".sendtocustomer", function (e) {
	$('.maintable .cbx-row input[type=checkbox]').each(function (index) {
		if(this.checked){
			let obj = {};
			obj['status'] = (parseInt($(this).closest('tr').find('td').eq(5).data('originstatus')) + 1)
			obj['orderId'] = $(this).closest('tr').find('td').eq(1).html()
			if(obj['status']!=3 ){
				alert("Bạn không thể làm điều này")
				return false;
			}
			
			fetch(rootURL + '/orders/update', {
			  method: 'PUT', // or 'PUT'
			  headers: {
			    'Content-Type': 'application/json',
			  },
			  body: JSON.stringify(obj),
			})
			  .then((response) => response.json())
			  .then((data) => {
				toast({
			          title: "SUCCESS",
			          message: "Giao đơn hàng thành công",
			          type: "success", //or success
			        });
			    console.log('Success:', data);
			    myDisplay()
			  })
			  .catch((error) => {
			    console.error('Error:', error);
			  });
			
			//EditTable("/orders/update","PUT", obj)
			
			return false;
		}
    });
})
 
 
 
 // test
 function SelectRow(col, value){
	var index;
	let th = $('.maintable th')
	
	th.each(function(i){
		
		if($(this).html() == col){
			index = i;
			console.log(index)
		}
	} )
	
	
	let tr =  $('.maintable tbody tr')
	tr.each(function(){
		if($(this).find('td').eq(index).html() != value){
			$(this).remove()
			
		}
	})
	
}

var olast = 1;
var ocurp = 1;

//on change page number 
$(document).on('change','#ocurrentpage' , function(e){
	
	ocurp = parseInt($(this).val())
	alert(ocurp)
	myDisplay()
}); 


$(document).on('click','#ofirst-page' , function(e){
	
	$("#currentpage").val(1)	
	ocurp = $(this).val()
	myDisplay()
}); 

$(document).on('click','#opre-page' , function(e){
	
	
	if(ocurp < 2){
		alert("hông có trang này")
		return false;
	}
	ocurp = parseInt($("#currentpage").val()) -1 
	$("#currentpage").val(ocurp)
	
	myDisplay()
}); 

$(document).on('click','#onext-page' , function(e){
	
	
	if(ocurp > olast){
		alert("hông có trang này")
		return false;
	}
	ocurp = parseInt($("#currentpage").val()) +1 
	
	$("#currentpage").val(ocurp)	
	myDisplay()
}); 

$(document).on('click','#olast-page' ,function(e){
	
	$("#currentpage").val(lastpage)
	myDisplay()
}); 
