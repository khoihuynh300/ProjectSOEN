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
            <i class="fa fa-star"></i> T???t c??? s???n ph???m2
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
            <i class="fa fa-star"></i> T???t c??? s???n ph???m2
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
	    				
	    				
	    				row.append(`<div class="col-sm">
	                            <div class="card">
	                            <div class="card_product_img">
	                            <c:url value="/image?fname=\${product.image.picture1}" var="imgUrl"></c:url>
	                              <img
	                                class="card-img-top"
	                                src="${imgUrl}"
	                                alt="Card image cap"
	                              />
	                            </div>
	                            
	                            <div class="card-body">
	                              <h4 class="card-title">
	                                <a href="product.html" title="View Product"
	                                  >\${product.pname}</a
	                                >
	                              </h4>
	                              <p class="card-text">
	                              \${product.description}
	                              </p>
	                              <div class="row">
	                                <div class="col">
	                                  <p class="btn btn-danger btn-block">
	                                  \${product.price} $
	                                  </p>
	                                </div>
	                                <div class="col">
	                                  <a
	                                    href="cart.html"
	                                    class="btn btn-success btn-block"
	                                    >Add to cart</a
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
    
    
    </script>

</body>
</html>


	
	       