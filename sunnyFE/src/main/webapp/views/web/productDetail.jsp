<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ include file="/common/taglib.jsp" %>  
    
 	
 	
<link href="<c:url value='/views/web/css/product.css'/>" rel="stylesheet" type="text/css" />
  <script src="<c:url value='/views/web/js/product.js'/>"></script> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<%-- 
<link href="<c:url value='/views/web/css/product.css'/>" rel="stylesheet" type="text/css" />
  <script src="<c:url value='/views/web/js/product.js'/>"></script>  --%>
  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.0/js/swiper.min.js"></script>
        <link
          rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.0/css/swiper.min.css"
        />

<link
          rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.0/css/swiper.min.css"
        />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.0/js/swiper.min.js"></script>
        <!-- JS -->
<script src="//code.jquery.com/jquery-3.2.1.slim.min.js" type="text/javascript"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" type="text/javascript"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" type="text/javascript"></script>
   
<section class="jumbotron text-center">
	<div id="carouselExampleIndicators1" class="carousel slide"
		data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleIndicators1" data-slide-to="0"
				class="active"></li>
			<li data-target="#carouselExampleIndicators1" data-slide-to="1"></li>
			<li data-target="#carouselExampleIndicators1" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img class="d-block w-100"
					src="https://fedudesign.vn/wp-content/uploads/2020/07/Web-1920-%E2%80%93-2-1536x864.jpg"
					alt="First slide" />
			</div>
			<div class="carousel-item">
				<img class="d-block w-100" src="img/khai-truong-2409.png"
					alt="Second slide" />
			</div>
			<div class="carousel-item">
				<img class="d-block w-100" src="img/rog-phone-6-home.jpg"
					alt="Third slide" />
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleIndicators1"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span>
			<span class="sr-only"></span>
		</a> <a class="carousel-control-next" href="#carouselExampleIndicators1"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span>
			<span class="sr-only"></span>
		</a>
	</div>
</section>

<div class="container">
	<div class="row">
		<div class="col">
			<nav aria-label="breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="/">Home</a></li>
					<li class="breadcrumb-item"><a href="category.html">Category</a>
					</li>
					<li class="breadcrumb-item active" aria-current="page">
						Product</li>
				</ol>
			</nav>
		</div>
	</div>
</div>


<div class="container">
	<div class="row" id="product-site">
		<!-- Image -->
		<div class="col-12 col-lg-6 ">
			<!-- Swiper -->
			
			<%-- <c:url value="/image?fname=\${product.image.picture1}" var="imgUrl2"></c:url>
			<c:url value="/image?fname=\${product.image.picture1}" var="imgUrl3"></c:url>
			<c:url value="/image?fname=\${product.image.picture1}" var="imgUrl4"></c:url> --%>
			<div class="swiper-container gallery-top">
			
				<div class="swiper-wrapper imgproduct1">
					<%-- <c:url value="/image?fname=dt1.png" var="imgUrl1"></c:url>
					<div class="swiper-slide"
						style="background-image: url(${imgUrl1})"></div>
						<c:url value="/image?fname=dt1.png" var="imgUrl1"></c:url>
					<div class="swiper-slide"
						style="background-image: url(${imgUrl1})"></div>
						<c:url value="/image?fname=dt1.png" var="imgUrl1"></c:url>
					<div class="swiper-slide"
						style="background-image: url(${imgUrl1})"></div>
						<c:url value="/image?fname=dt1.png" var="imgUrl1"></c:url>
					<div class="swiper-slide"
						style="background-image: url(${imgUrl1})"></div> --%>
					<!-- <div class="swiper-slide"
						style="background-image: url(https://source.unsplash.com/random)"></div>
					<div class="swiper-slide"
						style="background-image: url(https://source.unsplash.com/random)"></div>
					<div class="swiper-slide"
						style="background-image: url(https://source.unsplash.com/random)"></div> -->
				</div>
				<!-- Add Arrows -->
				<div class="swiper-button-next swiper-button-white"></div>
				<div class="swiper-button-prev swiper-button-white"></div>
			</div>

			<!--Thumbnails-->
			<div class="swiper-container gallery-thumbs">
				<div class="swiper-wrapper imgproduct2">
					
					<%-- <div class="swiper-slide"
						style="background-image: url(${imgUrl1})"></div>
						<div class="swiper-slide"
						style="background-image: url(${imgUrl1})"></div>
						<div class="swiper-slide"
						style="background-image: url(${imgUrl1})"></div>
						<div class="swiper-slide"
						style="background-image: url(${imgUrl1})"></div> --%>
					<!-- <div class="swiper-slide"
						style="background-image: url(https://source.unsplash.com/random)"></div>
					<div class="swiper-slide"
						style="background-image: url(https://source.unsplash.com/random)"></div>
					<div class="swiper-slide"
						style="background-image: url(https://source.unsplash.com/random)"></div> -->
				</div>
			</div>

		</div>


		<!-- Add to cart -->
		<div class="col-12 col-lg-6 add_to_cart_block">
			<div class="card bg-light mb-3">
				<div class="card-body">
					<p class="name">Product name</p>
					<p class="price">99.00 $</p>
					<p style="visibility: hidden;" class="price_discounted">149.90 $</p>
					<form method="get" action="cart.html">

						<div class="form-group">
							<label>Quantity :</label>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<button type="button"
										class="quantity-left-minus btn btn-danger btn-number minusquantity"
										data-type="minus" data-field="">
										<i class="fa fa-minus"></i>
									</button>
								</div>
								<input type="text" class="form-control" id="quantity"
									name="quantity" min="1" max="100" value="1">
								<div class="input-group-append">
									<button type="button"
										class="quantity-right-plus btn btn-success btn-number plusquantity"
										data-type="plus" data-field="">
										<i class="fa fa-plus"></i>
									</button>
								</div>
							</div>
						</div>
						<div class="payment-block btnAddToCart">
							<a 
								class="btn btn-success btn-lg btn-block text-uppercase"> <i
								class="fa fa-shopping-cart btnAddToCart"></i> Add To Cart
							</a> <!-- <a href="cart.html"
								class="btn btn-success btn-lg btn-block text-uppercase"> <i
								class="fa fa-shopping-cart"></i> Mua ngay
							</a> -->
						</div>
					</form>
					<!-- <div class="product_rassurance">
                              <ul class="list-inline">
                                  <li class="list-inline-item"><i class="fa fa-truck fa-2x"></i><br/>Fast delivery</li>
                                  <li class="list-inline-item"><i class="fa fa-credit-card fa-2x"></i><br/>Secure payment</li>
                                  <li class="list-inline-item"><i class="fa fa-phone fa-2x"></i><br/>+33 1 22 54 65 60</li>
                              </ul>
                          </div> -->
					<!-- <div class="reviews_product p-3 mb-2 ">
						3 reviews <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
							class="fa fa-star"></i> <i class="fa fa-star"></i> <i
							class="fa fa-star"></i> (4/5) <a class="pull-right"
							href="#reviews">View all reviews</a>
					</div> -->

				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<!-- Description -->
		<div class="col-12">
			<div class="card border-light mb-3">
				<div class="card-header bg-primary text-white text-uppercase">
					<i class="fa fa-align-justify"></i> Description
				</div>
				<div class="card-body description-product">
					<!-- <p class="card-text"></p>
					<p class="card-text"> </p> -->
				</div>
			</div>
		</div>

		<!-- Reviews -->
		<!-- <div class="col-12" id="reviews">
			<div class="card border-light mb-3">
				<div class="card-header bg-primary text-white text-uppercase">
					<i class="fa fa-comment"></i> Reviews
				</div>
				<div class="card-body">
					<div class="review">
						<span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
						<meta itemprop="datePublished" content="01-01-2016">
						January 01, 2018 <span class="fa fa-star"></span> <span
							class="fa fa-star"></span> <span class="fa fa-star"></span> <span
							class="fa fa-star"></span> <span class="fa fa-star"></span> by
						Paul Smith
						<p class="blockquote">
						<p class="mb-0">Lorem ipsum dolor sit amet, consectetur
							adipiscing elit. Integer posuere erat a ante.</p>
						<hr>
					</div>
					<div class="review">
						<span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
						<meta itemprop="datePublished" content="01-01-2016">
						January 01, 2018 <span class="fa fa-star" aria-hidden="true"></span>
						<span class="fa fa-star" aria-hidden="true"></span> <span
							class="fa fa-star" aria-hidden="true"></span> <span
							class="fa fa-star" aria-hidden="true"></span> <span
							class="fa fa-star" aria-hidden="true"></span> by Paul Smith
						<p class="blockquote">
						<p class="mb-0">Lorem ipsum dolor sit amet, consectetur
							adipiscing elit. Integer posuere erat a ante.</p>
						<hr>
					</div>
				</div>
			</div>
		</div> -->
	</div>
</div>


        <script>
          var galleryThumbs = new Swiper(".gallery-thumbs", {
            spaceBetween: 10,
            slidesPerView: 4,
            freeMode: true,
            watchSlidesVisibility: true,
            watchSlidesProgress: true,
          });
          var galleryTop = new Swiper(".gallery-top", {
            spaceBetween: 10,
            navigation: {
              nextEl: ".swiper-button-next",
              prevEl: ".swiper-button-prev",
            },
            thumbs: {
              swiper: galleryThumbs,
            },
          });
        </script>


      


<script type="text/javascript">
	let pid = <%= request.getAttribute("pid") %>
	
	//alert(pid)
	let status;
	fetch("http://localhost:8083/product/get-product-by-id?id=" + pid)
	.then((resp)=>{
		status = resp.status
		//alert(status)
		return resp.json();
	})
	.then((data)=>{
		//alert(status)
		if(status == 200){
			$('.imgproduct1').append(`<c:url value="/image?fname=\${data.image.picture1}" var="imgUrl1"></c:url>
					<div class="swiper-slide"
					style="background-image: url(${imgUrl1})"></div>
					<c:url value="/image?fname=\${data.image.picture2}" var="imgUrl2"></c:url>
				<div class="swiper-slide"
					style="background-image: url(${imgUrl2})"></div>
					<c:url value="/image?fname=\${data.image.picture3}" var="imgUrl3"></c:url>
				<div class="swiper-slide"
					style="background-image: url(${imgUrl3})"></div>
					<c:url value="/image?fname=\${data.image.picture4}" var="imgUrl4"></c:url>
				<div class="swiper-slide"
					style="background-image: url(${imgUrl4})"></div>`)
				
			$('.imgproduct2').append(`<div class="swiper-slide"
					style="background-image: url(${imgUrl1})"></div>
					<div class="swiper-slide"
					style="background-image: url(${imgUrl2})"></div>
					<div class="swiper-slide"
					style="background-image: url(${imgUrl3})"></div>
					<div class="swiper-slide"
					style="background-image: url(${imgUrl4})"></div>`)
			console.log(data)
			
			
			 fetch("http://localhost:8083/productToAttribute/get-by-pid?pid=" + pid)
			.then((resp)=>{
				status = resp.status
				return resp.json();
			})
			.then((data)=>{
					//console.log(data)
				//alert(data.length)
				$('.description-product p').remove()
				 data.forEach((item)=>{
					console.log(item)
					//alert(pid)
					$('.description-product').append(`<p class="card-text">\${item.atrId.atrName}: \${item.val} \${item.atrId.unit} </p>`)
					
				}) 
			})
			
			
			$('p.name').html(data.pname)
			$('p.price').html(formatmoney(data.price, ' vnd'))
			//$('p.price').html(data.price.toLocaleString('it-IT', {style : 'currency', currency : 'đ'}))
			if(data.discountId != null){
				let originprice = parseFloat(data.price) - parseFloat(data.discountId.amount) - parseFloat(data.discountId.percent)*parseFloat(data.price)
				$('p.price').html(originprice.toLocaleString('it-IT', {style : 'currency', currency : 'đ'}))
				$('p.price_discounted').html(data.price.toLocaleString('it-IT', {style : 'currency', currency : 'đ'}) )
				$('p.price_discounted').css("visibility","visible")
			}
			
			 
		}
		
	})
	
	$('.plusquantity').click(function () {
		//alert(1)
		let v = parseInt($('input#quantity').val()) +1
		$('input#quantity').val(v)
	})
	$('.minusquantity').click(function () {
		let v = parseInt($('input#quantity').val()) - 1
		if(v < 1){
			v = 1
		}
		$('input#quantity').val(v)
	})
	
	/* var x = 10000000000.145633;
	x = x.toLocaleString('it-IT', {style : 'currency', currency : 'VND'});
	alert(x);
	//alert(moneyFormat("10000000000.123"))
	function moneyFormat(money) {
		
		let fm = "";
		
		
		console.log(money)
		
		return fm
	} */
	$('.gallery-top').append(``)
	
	
	 $(document).on("click",".btnAddToCart",function(e) {
		 let pidr = <%= request.getAttribute("pid") %>
		   <%-- let user =  <%= session.getAttribute("cus") %> --%>
		   e.preventDefault();
		  e.stopPropagation();
			
			let cartid;
			let pid = pidr
			//alert(pid )
			let cartitem = {};
			cartitem["productId"] = { "pid" :pid}
			//console.log(cartitem)
			$.get('/sunnyFE/account/getsession',async function(ketqua) {
				if('cus' in ketqua){
					
					var status;	
					let url = "http://localhost:8083/cart/get-by-customer-id?id=" + ketqua.cus.cusId;
					//alert(2)
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
					
						alert('Thêm thành công')
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
				else{
					window.location.href = "/sunnyFE/account/login";
				}
			});
			// e.preventDefault();
			 // 	e.stopPropagation();
		});
</script>
      