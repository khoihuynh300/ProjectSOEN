<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/common/taglib.jsp" %>
	
	
<link href="<c:url value='/views/web/css/category.css'/>" rel="stylesheet" type="text/css" />
 <%--  <script src="<c:url value='/views/web/js/category.js'/>"></script>  --%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	
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
              src="<c:url value='/views/login/img/khai-truong-2409.png'/>"
              alt="First slide"
            />
          </div>
          <div class="carousel-item">
            <img
              class="d-block w-100"
              src="<c:url value='/views/login/img/rog-phone-6-home.jpg'/>"
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

    <div class="container" id="cate-container">
      <div class="row">
        <div class="col">
          <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="index.html">Home</a></li>
              <li class="breadcrumb-item">
                <a href="category.html">Category</a>
              </li>
              <li class="breadcrumb-item active catename" aria-current="page">
                Sub-category
              </li>
            </ol>
          </nav>
        </div>
      </div>
    </div>
    <div class="container" id="cate-container">
      <div class="row">
        <div class="col col-sm-3">
          <div class="card bg-light mb-3">
            <div class="card-header bg-primary text-white text-uppercase">
              <i class="fa fa-list"></i> Categories
            </div>
            <ul class="list-group category_block">
              <div class="dropdown">
                

                <!-- <div class="dropdown-content">
                  <a href="#">Link 1</a>
                  <a href="#">Link 2</a>
                  <a href="#">Link 3</a>
                </div> -->
              </div>
            </ul>
          </div>
          
        </div>
        <div class="col">
          <div class="row">
            <div class="container">
              <div id="myCarousel" class="carousel slide" data-ride="carousel">
                <div class="carousel-inner" role="listbox">
                   <div class="item active">
                    <!--<div class="col-12 col-md-6 col-lg-4">
                      <div class="card">
                        <img
                          class="card-img-top"
                          src="img/11-pro-plus-blue.jpg"
                          alt="Card image cap"
                        />
                        <div class="card-body">
                          <h4 class="card-title">
                            <a href="product.html" title="View Product"
                              >Product title1</a
                            >
                          </h4>
                          <p class="card-text">
                            123
                          </p>
                          <div class="row">
                            <div class="col">
                              <p class="btn btn-danger btn-block">99.00 $</p>
                            </div>
                            <div class="col">
                              <a href="#" class="btn btn-success btn-block"
                                >Add to cart</a
                              >
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="col-12 col-md-6 col-lg-4">
                      <div class="card">
                        <img
                          class="card-img-top"
                          src="img/11-pro-plus-blue.jpg"
                          alt="Card image cap"
                        />
                        <div class="card-body">
                          <h4 class="card-title">
                            <a href="product.html" title="View Product"
                              >Product title2</a
                            >
                          </h4>
                          <p class="card-text">
                            Some quick example text to build on the card title and make
                            up the bulk of the card's content.
                          </p>
                          <div class="row">
                            <div class="col">
                              <p class="btn btn-danger btn-block">99.00 $</p>
                            </div>
                            <div class="col">
                              <a href="#" class="btn btn-success btn-block"
                                >Add to cart</a
                              >
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="col-12 col-md-6 col-lg-4">
                      <div class="card">
                        <img
                          class="card-img-top"
                          src="img/11-pro-plus-blue.jpg"
                          alt="Card image cap"
                        />
                        <div class="card-body">
                          <h4 class="card-title">
                            <a href="product.html" title="View Product"
                              >Product title 3</a
                            >
                          </h4>
                          <p class="card-text">
                            Some quick example text to build on the card title and make
                            up the bulk of the card's content.
                          </p>
                          <div class="row">
                            <div class="col">
                              <p class="btn btn-danger btn-block">99.00 $</p>
                            </div>
                            <div class="col">
                              <a href="#" class="btn btn-success btn-block"
                                >Add to cart</a
                              >
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="col-12 col-md-6 col-lg-4">
                      <div class="card">
                        <img
                          class="card-img-top"
                          src="https://dummyimage.com/600x400/55595c/fff"
                          alt="Card image cap"
                        />
                        <div class="card-body">
                          <h4 class="card-title">
                            <a href="product.html" title="View Product"
                              >Product title</a
                            >
                          </h4>
                          <p class="card-text">
                            Some quick example text to build on the card title and make
                            up the bulk of the card's content.
                          </p>
                          <div class="row">
                            <div class="col">
                              <p class="btn btn-danger btn-block">99.00 $</p>
                            </div>
                            <div class="col">
                              <a href="#" class="btn btn-success btn-block"
                                >Add to cart</a
                              >
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="col-12 col-md-6 col-lg-4">
                      <div class="card">
                        <img
                          class="card-img-top"
                          src="https://dummyimage.com/600x400/55595c/fff"
                          alt="Card image cap"
                        />
                        <div class="card-body">
                          <h4 class="card-title">
                            <a href="product.html" title="View Product"
                              >Product title</a
                            >
                          </h4>
                          <p class="card-text">
                            Some quick example text to build on the card title and make
                            up the bulk of the card's content.
                          </p>
                          <div class="row">
                            <div class="col">
                              <p class="btn btn-danger btn-block">99.00 $</p>
                            </div>
                            <div class="col">
                              <a href="#" class="btn btn-success btn-block"
                                >Add to cart</a
                              >
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="col-12 col-md-6 col-lg-4">
                      <div class="card">
                        <img
                          class="card-img-top"
                          src="https://dummyimage.com/600x400/55595c/fff"
                          alt="Card image cap"
                        />
                        <div class="card-body">
                          <h4 class="card-title">
                            <a href="product.html" title="View Product"
                              >Product title</a
                            >
                          </h4>
                          <p class="card-text">
                            Some quick example text to build on the card title and make
                            up the bulk of the card's content.
                          </p>
                          <div class="row">
                            <div class="col">
                              <p class="btn btn-danger btn-block">99.00 $</p>
                            </div>
                            <div class="col">
                              <a href="#" class="btn btn-success btn-block"
                                >Add to cart</a
                              >
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="col-12 col-md-6 col-lg-4">
                      <div class="card">
                        <img
                          class="card-img-top"
                          src="https://dummyimage.com/600x400/55595c/fff"
                          alt="Card image cap"
                        />
                        <div class="card-body">
                          <h4 class="card-title">
                            <a href="product.html" title="View Product"
                              >Product title</a
                            >
                          </h4>
                          <p class="card-text">
                            Some quick example text to build on the card title and make
                            up the bulk of the card's content.
                          </p>
                          <div class="row">
                            <div class="col">
                              <p class="btn btn-danger btn-block">99.00 $</p>
                            </div>
                            <div class="col">
                              <a href="#" class="btn btn-success btn-block"
                                >Add to cart</a
                              >
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                     <div class="col-12 col-md-6 col-lg-4">
                      <div class="card">
                        <img
                          class="card-img-top"
                          src="https://dummyimage.com/600x400/55595c/fff"
                          alt="Card image cap"
                        />
                        <div class="card-body">
                          <h4 class="card-title">
                            <a href="product.html" title="View Product"
                              >Product title</a
                            >
                          </h4>
                          <p class="card-text">
                            Some quick example text to build on the card title and make
                            up the bulk of the card's content.
                          </p>
                          <div class="row">
                            <div class="col">
                              <p class="btn btn-danger btn-block">99.00 $</p>
                            </div>
                            <div class="col">
                              <a href="#" class="btn btn-success btn-block"
                                >Add to cart</a
                              >
                            </div>
                          </div>
                        </div>
                      </div>
                    </div> -->
                  </div>                
                  
                  
                </div>
              </div>
              <div class="pagination">
				  <a href="#" id="first-page"><i class="fa-solid fa-angles-left"></i></a>
				  <a href="#" id="pre-page"><i class="fa-solid fa-angle-left"></i></a>
				  <input id="currentpage" value=1>
				  <a href="#" id="next-page"><i class="fa-solid fa-angle-right"></i></a>
				  <a href="#" id="last-page"><i class="fa-solid fa-angles-right"></i></a>
				</div>
            </div>
          </div>
          </div>
        </div>
      </div>
    
    
  <script type="text/javascript">
  
  var category = {};
  var gcategoryid;
  var lastpage = 1;
  
  fetch("http://localhost:8083/producttype/get")
  .then((response) => response.json())
  .then((data) =>{ 
	  let categoryboard = $('.category_block .dropdown')
	   data.forEach(item => {
		  category[item.ptype] = item
			 //console.log(category)
			 categoryboard.append(`<li data-cateid=\${item.ptype} class="list-group-item"><a>\${item.ptypeName}</a></li>`)
			 
		}); 
	  
	  LoadProductByCate(data[0].ptype)
  })
  
  $(".category_block .dropdown").on('click','.list-group-item', function () {
	let cateid = $(this).data('cateid')
	//console.log(cateid)
	
	$("#currentpage").val(1)
	LoadProductByCate(cateid)	
})
  
  	
	
	function LoadProductByCate(cateid, pagenumber = 1) {
	  gcategoryid = cateid;
	  fetch("http://localhost:8083/product/get-by-ptype?ptype=" + cateid + " &pageNumber=" + pagenumber)
	  .then((response) => response.json())
	  .then((data) =>{ 
		  $('#myCarousel .carousel-inner .item').remove()
		  $('#myCarousel .carousel-inner').append(`<div class="item active"></div>`)
		  let productbox = $('#myCarousel .carousel-inner .item')
		  console.log(productbox.length)
		   data.forEach(item => {
			   console.log(item)
			   getmaxpage();	
			   let originprice = "";
			   let currentprice = item.price;
			   if(item.discountId != null){
				   originprice = item.price;
				   currentprice = parseFloat(item.price) - parseFloat(item.discountId.amount) - parseFloat(item.price)*parseFloat(item.discountId.percent) ;
				   originprice = formatmoney(originprice, ' đ')
			   }
			   currentprice = formatmoney(currentprice, ' đ')
				
			   productbox.append(`<div  class="col-12 col-md-6 col-lg-4">
	                      <div class="card cardproduct " data-pid="\${item.pid}">
	                      <c:url value="/image?fname=\${item.image.picture1}" var="imgUrl"></c:url>
	                        <img
	                          class="card-img-top"
	                          src="${imgUrl}"
	                          alt="${imgUrl}"
	                        />
	                        <div class="card-body">
	                          <h4 class="card-title">
	                            <a href="product.html" title="View Product"
	                              >\${item.pname}</a
	                            >
	                          </h4>
	                          
	                          <div class="row">
	                           
	                            
	                            <div class="col price-site">
	                            	<p class="price-show">\${currentprice} </p>
	                            	<p class="price-through">\${originprice}</p>
	                          	</div>
	                            <div class="col">
	                              <a href="#" class="btn btn-success btn-block btnAddToCart"
	                                >Thêm vào giỏ hàng</a
	                              >
	                            </div>
	                          </div>
	                        </div>
	                      </div>
	                    </div>`)	
				  
		   }); 
	  })
}
  
</script>

<!-- paging -->
<script type="text/javascript">

$(document).on('change','#currentpage' , function(e){
	
	let curpage = parseInt($(this).val())
	if(curpage < 1 || curpage>lastpage){
		alert("hông có trang này")
		return false;
	}
	LoadProductByCate(gcategoryid, curpage)
}); 


$(document).on('click','#first-page' , function(e){
	
	$("#currentpage").val(1)
	
	//let url = $(".main_content__body #geturl").data("value")
	let curpage = $(this).val()
	LoadProductByCate(gcategoryid, curpage)
	e.preventDefault();
}); 

$(document).on('click','#pre-page' , function(e){
	let prepage = parseInt($("#currentpage").val()) -1 
	if(prepage < 1){
		alert("hông có trang này")
		return false;
	}
	
	$("#currentpage").val(prepage)
	
	LoadProductByCate(gcategoryid, prepage)
	e.preventDefault();
}); 

$(document).on('click','#next-page' , function(e){
	let nextpage = parseInt($("#currentpage").val()) +1 
	
	if(nextpage >lastpage){
		alert("hông có trang này")
		return false;
	}
	
	$("#currentpage").val(nextpage)	
	LoadProductByCate(gcategoryid, nextpage)
	e.preventDefault();
}); 

$(document).on('click','#last-page' ,async function(e){
	
	$("#currentpage").val(lastpage)
	LoadProductByCate(gcategoryid, lastpage)
	e.preventDefault();
}); 

function getmaxpage(){
	
	fetch("http://localhost:8083/product/count?cateid=" + gcategoryid)
		  .then((response) => response.json())
		  .then((data) =>{
			lastpage =  parseInt( (parseInt(data)-1) / 8 )+1 
			//console.log(lastpage)
	}) 
}


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
	
$(document).on("click",".cardproduct",function(e) {
	   //alert(1)
	   e.preventDefault();
		e.stopPropagation();
		window.location='/sunnyFE/web/product-detail?pid=' + $(this).data("pid")
})
</script>