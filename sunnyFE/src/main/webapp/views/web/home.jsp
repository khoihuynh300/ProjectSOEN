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
<link href="<c:url value='/views/web/css/home.css'/>" rel="stylesheet" type="text/css" />
	<section class="jumbotron text-center">
      <div
        id="carouselExampleIndicators1"
        class="carousel slide"
        data-ride="carousel"
      >
        <ol class="carousel-indicators">
          <li
            data-target="#carouselExampleIndicators1"
            data-slide-to="0"
            class="active"
          ></li>
          <li data-target="#carouselExampleIndicators1" data-slide-to="1"></li>
          <li data-target="#carouselExampleIndicators1" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img
              class="d-block w-100"
              src="<c:url value='/views/login/img/rog-phone-6-home.jpg'/>"
              alt="First slide"
            />
          </div>
          <div class="carousel-item">
            <img
              class="d-block w-100"
              src="<c:url value='/views/login/img/khai-truong-2409.png'/>"
              alt="Second slide"
            />
          </div>
          <div class="carousel-item">
            <img
              class="d-block w-100"
              src="<c:url value='/views/login/img/apple watch.png'/>"
              alt="Third slide"
            />
          </div>
        </div>
        <a
          class="carousel-control-prev"
          href="#carouselExampleIndicators1"
          role="button"
          data-slide="prev"
        >
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only"></span>
        </a>
        <a
          class="carousel-control-next"
          href="#carouselExampleIndicators1"
          role="button"
          data-slide="next"
        >
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only"></span>
        </a>
      </div>
    </section>

    <!--Banner 2-->
    <!-- 
    <div class="container" id="slider-banner">
      <div class="row">
        <div class="col">
          <div
            id="carouselExampleIndicators"
            class="carousel slide"
            data-ride="carousel"
          >
            <ol class="carousel-indicators">
              <li
                data-target="#carouselExampleIndicators"
                data-slide-to="0"
                class="active"
              ></li>
              <li
                data-target="#carouselExampleIndicators"
                data-slide-to="1"
              ></li>
              <li
                data-target="#carouselExampleIndicators"
                data-slide-to="2"
              ></li>
            </ol>
            <div class="carousel-inner">
              <div class="carousel-item active">
                <img
                  class="d-block w-100"
                  src="<c:url value='/views/login/img/khai-truong-2409.png'/>"
                  alt="First slide"
                />
              </div>
              <div class="carousel-item">
                <img
                  class="d-block w-100"
                  src="<c:url value='/views/login/img/apple watch.png'/>"
                  alt="Second slide"
                />
              </div>
              <div class="carousel-item">
                <img
                  class="d-block w-100"
                  src="<c:url value='/views/login/img/apple watch.png'/>"
                  alt="Third slide"
                />
              </div>
            </div>
            <a
              class="carousel-control-prev"
              href="#carouselExampleIndicators"
              role="button"
              data-slide="prev"
            >
              <span
                class="carousel-control-prev-icon"
                aria-hidden="true"
              ></span>
              <span class="sr-only"></span>
            </a>
            <a
              class="carousel-control-next"
              href="#carouselExampleIndicators"
              role="button"
              data-slide="next"
            >
              <span
                class="carousel-control-next-icon"
                aria-hidden="true"
              ></span>
              <span class="sr-only"></span>
            </a>
          </div>
        </div>
        <div class="col-12 col-md-3">
          <div class="card">
            <div class="card-header bg-success text-white text-uppercase">
              <i class="fa fa-heart"></i> Top product
            </div>
            <img
              class="img-fluid border-0"
              src="img/ip14prm.png"
              alt="Card image cap"
            />
            <div class="card-body">
              <h4 class="card-title text-center">
                <a href="product.html" title="View Product">Product title</a>
              </h4>
              <p class="card-text">Some quick</p>
            </div>
          </div>
        </div>
      </div>
    </div>
    -->

    <!--Slider list cate2 product-->
    <div class="container mt-10 test" data-ptypeid="1">
      <section class="mb-5">
        <div id="carousel-2" class="carousel slide" data-ride="carousel">
          <ol class="carousel-indicators">
            <li data-target="#carousel-2" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-2" data-slide-to="1"></li>
            <li data-target="#carousel-2" data-slide-to="2"></li>
            <li data-target="#carousel-2" data-slide-to="3"></li>
          </ol>
          <div class="card-header bg-primary text-white text-uppercase">
            <i class="fa fa-star"></i> Điện thoại
          </div>
          <div class="carousel-inner" role="listbox">
            
          </div>
          <!-- e carousel-inner -->

          <a
            class="carousel-control-prev"
            href="#carousel-2"
            role="button"
            data-slide="prev"
          >
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">prev</span>
          </a>

          <a
            class="carousel-control-next"
            href="#carousel-2"
            role="button"
            data-slide="next"
          >
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">next</span>
          </a>
        </div>
        <!-- e carousel -->
      </section>
      <!-- e section -->
    </div>
    
    
    
    <!--Slider list cate2 product-->
    <div class="container mt-10 test" data-ptypeid="2">
      <section class="mb-5">
        <div id="carousel-3" class="carousel slide" data-ride="carousel">
          <ol class="carousel-indicators">
            <li data-target="#carousel-3" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-3" data-slide-to="1"></li>
            <li data-target="#carousel-3" data-slide-to="2"></li>
            <li data-target="#carousel-3" data-slide-to="3"></li>
          </ol>
          <div class="card-header bg-primary text-white text-uppercase">
            <i class="fa fa-star"></i> Laptop 
          </div>
          <div class="carousel-inner" role="listbox">
            
            
          </div>
          <!-- e carousel-inner -->

          <a
            class="carousel-control-prev"
            href="#carousel-3"
            role="button"
            data-slide="prev"
          >
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">prev</span>
          </a>

          <a
            class="carousel-control-next"
            href="#carousel-3"
            role="button"
            data-slide="next"
          >
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">next</span>
          </a>
        </div>
        <!-- e carousel -->
      </section>
      <!-- e section -->
    </div>
    
    <script type="text/javascript">
    /* 
    var formdata = new FormData();
    formdata.append('address','address')
    formdata.append('paymentMethod','paymentMethod')
    formdata.append('listCartItem','listCartItem')
    fetch('http://localhost:8083/test/create', {
	  method: 'POST',
	  body: formdata
	})
	.then(r => r.json())
	.then(data => {
	  console.log(data)
	}) */
    
    
    
   	//$(".container.mt-10.test .carousel-item.test").eq(0).addClass('active');
   	let containers =  $(".container.mt-10.test")
   	containers.each(function () {
		
		let ptypeId = $(this).data("ptypeid")
		//console.log(ptypeId)
		
		fetch('http://localhost:8083/product/recommended?size=16&ptype=' + ptypeId)
	    .then((response) => response.json())
	    .then((data) =>{ 
	    	while(data.length > 0){
	    		$(this).find('.carousel-inner').first().append(`<div class="carousel-item"><div class="row"><div class="col-sm"><div class="card"><div class="card-body"></div></div></div></div></div>`)
				let cardbody = $(this).find('.carousel-inner .carousel-item .card-body').last()  		 
	    		for(let row = 0; row<2; row ++){
	    			//console.log(carouselitem.length)
	    			cardbody.append(`<div class="row"></div>`)
	    			
	    			let row = cardbody.find(".row").last()
	    			for(let product = 0; product < 4;product++ ){
	    				//console.log(cardbody.length)
	    				let product = data.pop()
	    				
	    				//console.log(product.image.picture1)
	    				let currentprice = product.price
	    				let originprice = ""
	    				 if(product.discountId!= null){
	                        	currentprice = parseFloat(product.price) - parseFloat(product.discountId.amount) - parseFloat(product.price)*parseFloat(product.discountId.percent)
	                        	originprice = product.price
	                        	originprice = formatmoney(originprice, ' đ')
	    				 }
						currentprice = formatmoney(currentprice, ' đ')
						//
	    				
	    				row.append(`<div class="col-sm"  >
	                            <div class="card" data-pid="\${product.pid}">
	                            <div class="card_product_img">
	                            <c:url value="/image?fname=\${product.image.picture1}" var="imgUrl"></c:url>
	                              <img
	                                class="card-img-top"
	                                src="${imgUrl}"
	                                alt="${imgUrl}"
	                              />
	                            </div>
	                            
	                            <div class="card-body">
	                              <h4 class="card-title">
	                                <a href="product.html" title="View Product"
	                                  >\${product.pname}</a
	                                >
	                              </h4>
	                              
	                              <div class="row">
	                              
	                                
	                                <div class="col price-site">
	                                <p class="price-show">\${currentprice}</p>
	                                <p class="price-through">\${originprice}</p>
	                              </div>
	                              
	                                <div class="col">
	                                  <a
	                                    
	                                    class="btn btn-success btn-block btnAddToCart"
	                                    >Thêm vào giỏ hàng</a
	                                  >
	                                </div>
	                              </div>
	                            </div>
	                          </div>
	                        </div>`)
	                        
	                       
	    				
	    				if(data.length <=0) {
	    					$(this).find(".carousel-item").first().addClass("active")
	    					return 0
	    				}
	    			}
	    		} 
	    	
	    		
	    		
	    		//$(this).find(".carousel-item .card-body").last().append(``)
	    		
	    	}
	    })
   	})
    
    //let cardbody = 
    
	   $(document).on("click",".btnAddToCart",function(e) {
		   <%-- let user =  <%= session.getAttribute("cus") %> --%>
		   e.preventDefault();
		  e.stopPropagation();
			
			let cartid;
			let pid = $(this).closest('.card').data('pid')
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
   	

	   $(document).on("click",".card",function(e) {
		   //alert(1)
		   e.preventDefault();
			e.stopPropagation();
			window.location='/sunnyFE/web/product-detail?pid=' + $(this).data("pid")
	   })
	    
    </script>

</body>
</html>


	
	       