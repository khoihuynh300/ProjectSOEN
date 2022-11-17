<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<%@ include file="/common/taglib.jsp" %>
	<%@ page session="true" %>
	
<link href="<c:url value='/views/web/css/cart.css'/>" rel="stylesheet" type="text/css" />
  <script src="<c:url value='/views/web/js/cart.js'/>"></script> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<div class="container mb-4">
	<div class="row">
		<div class="col-12">
			<div class="table-responsive">
				<table class="table table-striped">
					<thead>
						<tr>
							<th id="checkcol" scope="col"><input class="checkAll"
								type="checkbox" id="vehicle1" name="vehicle1" value="Bike" />
							</th>
							<th scope="col" class="text-center">Chọn tất cả</th>
							<th scope="col" class="text-center">Tên sản phẩm</th>
							<!-- Gía 1 sp -->
							<th scope="col" class="text-center">Đơn giá</th>
							<th scope="col" class="text-center">Số lượng</th>
							<th scope="col" class="text-center">Số tiền</th>
							<th scope="col" class="text-center">Thao tác</th>
						</tr>
					</thead>
					<tbody>
						

						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>Tiền</td>
							<td class="text-right">255,90 €</td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>Phí vận chuyển</td>
							<td class="text-right">6,90 €</td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td><strong>Tổng tiền</strong></td>
							<td class="text-right"><strong>346,90 €</strong></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="col mb-2">
			<div class="row">
				<div class="col-sm-12 col-md-6">
					<button class="btn btn-block btn-light">Xoá</button>
				</div>
				<div class="col-sm-12 col-md-6 text-right">
					<button class="btn btn-lg btn-block btn-success text-uppercase btnDatHang">
						Thanh toán</button>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	var listCartItem;
	LoadCartItem()
	
	function LoadCartItem() {
		var cartId;
    	
    	$.get('/sunnyFE/account/getsession', async function(ketqua) {
			if('cus' in ketqua){
				
				var status;	
				let url = "http://localhost:8083/cart/get-by-customer-id?id=" + ketqua.cus.cusId;
				
				
				await fetch(url, {
				  method: 'GET', 
				  headers: {
				    'Content-Type': 'application/json',
				  },
				})
				  .then((response) =>{ 
					status = response.status
					return response.json()
					})
				  .then((data) => {
				    
				    if(status==200){
				    	cartId = data.cartId
				    	//alert(cartId)
					}
				   	
				  })
				  .catch((error) => {
				    console.error('Error:', error);
				    alert(error)
				  });
				
				url = "http://localhost:8083/cartitem/get-all-cartitem?id=" + cartId
				await fetch(url, {
					  method: 'GET', 
					  headers: {
					    'Content-Type': 'application/json',
					  },
					})
					  .then((response) =>{ 
						status = response.status
						return response.json()
						})
					  .then((data) => {
						  listCartItem = data
					    if(status==200){
					    	$('tbody tr.cartitem').remove()
					    	data.forEach(function (item) {

					    	let SL = parseFloat(item.quantity);
					    	
					    	let DonGia = parseFloat(item.productId.price);
					    	let GiamGia = "";
					    	if(item.productId.discountId != null){
					    		console.log(item.productId.discountId)
					    		GiamGia = "<p style=' text-decoration: line-through;' >" +DonGia +"</p>"
					    		DonGia = DonGia - DonGia* parseFloat(item.productId.discountId.percent) - parseFloat(item.productId.discountId.amount)
					    	}
					    	let SoTien = DonGia*SL

						    	//console.log(item)
						    	$('tbody').prepend(`<tr class="cartitem" data-pid="\${item.productId.pid}">
									<td class="btn-select-product"><input type="checkbox"
									id="vehicle1" name="vehicle1" value="Bike" />
								</td>
								<td id="product-img" class="text-center"><img
									src="D:\\upload\\imageFile\\abcd.png" /></td>
								<td id="product-name" class="text-center">\${item.productId.pname}</td>
								<td id="product-price" class="text-center">\${GiamGia} \${DonGia}</td>
								<td id="form-product-quantity" class="text-center">
									<div class="qtySelector text-center">
										<i class="fa fa-minus decreaseQty"></i> <input type="text"
											class="qtyValue" value="\${item.quantity}" /> <i
											class="fa fa-plus increaseQty"></i>
									</div>
								</td>
								<td id="product-totalmoney" class="text-center">\${SoTien}</td>
								<td id="product-delete" class="text-center">
									<button class="btn btn-sm btn-danger">
										<i class="fa fa-trash"></i>
									</button>
								</td>
							</tr>`)
							})
							
						}
					   	
					  })
					  .catch((error) => {
					    console.error('Error:', error);
					    alert(error)
					  });
				
				
			}
		});
	}
	
	$( "tbody" ).on( "click", ".increaseQty", function() {
		let cartid;
		let pid = $(this).closest('tr').data('pid')
		let cartitem = {};
		cartitem["productId"] = { "pid" :pid}
		//console.log(cartitem)
		$.get('/sunnyFE/account/getsession',async function(ketqua) {
			if('cus' in ketqua){
				
				var status;	
				let url = "http://localhost:8083/cart/get-by-customer-id?id=" + ketqua.cus.cusId;
				
				await fetch(url, {
				  method: 'GET', 
				  headers: {
				    'Content-Type': 'application/json',
				  },
				})
				  .then((response) =>{ 
					status = response.status
					return response.json()
					})
				  .then((data) => {
				    
				    if(status==200){
				    	cartid = data.cartId
				    	//alert(cartid)
				    	cartitem["cartId"] = {"cartId":cartid}
				    	
				    	//console.log(cartitem)
					}
				   	
				  })
				  .catch((error) => {
				    console.error('Error:', error);
				    alert(error)
				  });
				
		
			fetch('http://localhost:8083/cartitem/add-to-cart', {
			  method: 'POST',
			  headers: {
			    'Content-Type': 'application/json',
			  },
			  body: JSON.stringify(cartitem),
			})
			  .then((response) =>{
				status = response.status
				return response.json()
			})
			  .then((data) => {
					
				if(status == 200){
				
					LoadCartItem()
					
				}
				else {
					console.log(data.message)
				}
			    
			    
			    
			  })
			  .catch((error) => {
			    console.error('Error:', error);
			  });
				
				
			}
		});
				
	});
	
	$( "tbody" ).on( "click", ".decreaseQty", function() {
		let cartid;
		let pid = $(this).closest('tr').data('pid')
		let cartitem = {};
		cartitem["productId"] = { "pid" :pid}
		//console.log(cartitem)
		$.get('/sunnyFE/account/getsession',async function(ketqua) {
			if('cus' in ketqua){
				
				var status;	
				let url = "http://localhost:8083/cart/get-by-customer-id?id=" + ketqua.cus.cusId;
				
				await fetch(url, {
				  method: 'GET', 
				  headers: {
				    'Content-Type': 'application/json',
				  },
				})
				  .then((response) =>{ 
					status = response.status
					return response.json()
					})
				  .then((data) => {
				    
				    if(status==200){
				    	cartid = data.cartId
				    	//alert(cartid)
				    	cartitem["cartId"] = {"cartId":cartid}
				    	
				    	//console.log(cartitem)
					}
				   	
				  })
				  .catch((error) => {
				    console.error('Error:', error);
				    alert(error)
				  });
				
		
			fetch('http://localhost:8083/cartitem/remove-item', {
			  method: 'POST',
			  headers: {
			    'Content-Type': 'application/json',
			  },
			  body: JSON.stringify(cartitem),
			})
			  .then((response) =>{
				status = response.status
				return response.json()
			})
			  .then((data) => {
					
				if(status == 200){
				
					LoadCartItem()
					LoadNumberItemOfCart();
				}
				else {
					console.log(data.message)
				}
			  })
			  .catch((error) => {
			    console.error('Error:', error);
			  });
				
				
			}
		});	  
		
	});
	
	$('table').on('change', 'thead :checkbox', function() {
	    if (this.checked) {
	    	
	    	$('table tbody input[type=checkbox]').each(function () {
	    	    $(this).prop('checked', true);
	    	    
	    	});
	    } else {
	    	$('table tbody input[type=checkbox]').each(function () {
	    	    $(this).prop('checked', false);
	    	});
	    }
	});
	$('table').on('change', 'tbody :checkbox', function() {
	    if (!this.checked) {
	    	$('table thead input[type=checkbox]').prop('checked', false);
	    }
	})

	$(document).on('click','.btnDatHang', function() {
		let PaymentMethod = { "id": 1  }
		let address = "thu duc"
		console.log(listCartItem)
		let listchoose = "";
		
		let chooseRows = $('table tbody input[type=checkbox]:checked')
		chooseRows.each(function () {
			let pid = $(this).closest('tr').data('pid')
			var found = listCartItem.filter(function(item) { return item.productId.pid === pid; });
			console.log(found)
			listchoose = listchoose + (JSON.stringify(found))
		})
		
		console.log(listchoose)
		
		var formdata = new FormData();
		/* formdata.append('address', new Blob([JSON.stringify(address)], {
		    type: "application/json"
		}));
		formdata.append('paymentMethod', new Blob([JSON.stringify(PaymentMethod)], {
		    type: "application/json"
		}));
		formdata.append('listCartItem', new Blob([JSON.stringify(listchoose)], {
		    type: "application/json"
		})); */
		
	     formdata.append('address',address)
	    formdata.append('paymentMethod',JSON.stringify(PaymentMethod))
	    formdata.append('listCartItem',listchoose)
	    fetch('http://localhost:8083/orders/create', {
		  method: 'POST',
		  body: formdata
		})
		.then(r => r.json())
		.then(data => {
		  console.log(data)
		})
	})
</script>