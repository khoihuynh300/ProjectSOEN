<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<%@ include file="/common/taglib.jsp" %>
	<%@ page session="true" %>
	

	
<link href="<c:url value='/views/web/css/profile.css'/>" rel="stylesheet" type="text/css" />
  <script src="<c:url value='/views/web/js/profile.js'/>"></script> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	
	
	<!-- JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/esm/popper.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.1/js/bootstrap.js"></script>
	
 <div class="container" id="profile-container">
      <div class="row">
        <div id = "account-sidebar" class="col-12 col-lg-6">
          <div class="page-wrapper chiller-theme toggled"><nav id="sidebar" class="sidebar-wrapper">
            <div class="sidebar-content">
              <div class="sidebar-header">
                <!-- <div class="user-pic">
                  <img
                    class="img-responsive img-rounded"
                    src="https://raw.githubusercontent.com/azouaoui-med/pro-sidebar-template/gh-pages/src/img/user.jpg"
                    alt="User picture"
                  />
                </div> -->
                <!-- <div class="user-info">
                  <span class="user-name"
                    >Jhon
                    <strong>Smith</strong>
                  </span>
                  <span class="user-role">Administrator</span>
                  <span class="user-status">
                    <i class="fa fa-circle"></i>
                    <span>Online</span>
                  </span>
                </div> -->
              </div>
              <!-- sidebar-header  -->
              
              <!-- sidebar-search  -->
              <div class="sidebar-menu">
                <ul>
                  <li class="header-menu">
                    <span></span>
                  </li>
                  <li class="sidebar-dropdown">
                    <a href="#" class = "btn-showProfile">
                      <i class="fa fa-tachometer-alt"></i>
                      <span  >T??i kho???n c???a t??i</span>

                    </a>
                    <div class="sidebar-submenu">
                      <ul>
                        <li class = "btn-showProfile">
                          <a 
                            >H??? s??
                            <span class="badge badge-pill badge-success"
                              ></span
                            >
                          </a>
                        </li>                      
                        <!-- <li class="btn-showAddress">
                          <a href="#">?????a ch???</a>
                        </li> -->
                        <li class = "btn-showChangePasswd">
                          <a href="#">?????i m???t kh???u</a>
                        </li>
                      </ul>
                    </div>
                  </li>
                  <li class="sidebar-dropdown">
                    <a href="#">
                      <i class="fa fa-shopping-cart"></i>
                      <span>????n mua</span>
                      <span class="badge badge-pill badge-danger"></span>
                    </a>
                    <div class="sidebar-submenu">
                      <ul>
                        <li class="btn-showCompletedOrder">
                          <a href="#">???? nh???n</a>
                        </li>
                        <li class="show-UnCompletedOrder">
                          <a href="#">??ang giao</a>
                        </li>
                      </ul>
                    </div>
                  </li>
                 
                  
                  
              </div>
              <!-- sidebar-menu  -->
            </div>
            <!-- sidebar-content  -->
            <!-- <div class="sidebar-footer">
              <a href="#">
                <i class="fa fa-bell"></i>
                <span class="badge badge-pill badge-warning notification">3</span>
              </a>
              <a href="#">
                <i class="fa fa-envelope"></i>
                <span class="badge badge-pill badge-success notification">7</span>
              </a>
              <a href="#">
                <i class="fa fa-cog"></i>
                <span class="badge-sonar"></span>
              </a>
              <a href="#">
                <i class="fa fa-power-off"></i>
              </a>
            </div> -->
          </nav>
        </div>
        </div>
        <div id="account-profile" class="col-12 col-lg-6">
          <main class="page-content">
            <div class="container-fluid">
              <div class="menu-content-nav">
                <p style="font-size: 20px;">H??? s?? c???a t??i</p>
                <p>Qu???n l?? th??ng tin h??? s?? ????? b???o m???t t??i kho???n</p>
              </div>
      
              <div class="menu-content">
                <div class="account-info">
                  <form>
                    <div class="form-row">
                      <div class="form-group col-md-6">
                        <label for="inputName4">T??n ????ng nh???p</label>
                        <input type="name" class="form-control" id="inputName4" placeholder="" disabled>
                      </div>

                      

                      <div class="form-group col-md-6">
                        <label for="inputEmail4">Email</label>
                        <input type="email" class="form-control" id="inputEmail4" placeholder="">
                      </div>
                      <div class="form-group col-md-6">
                        <label for="inputPassword4">S??? ??i???n tho???i</label>
                        <input type="phonenumber" class="form-control" id="inputPhonenumber4" placeholder="">
                      </div>
                    </div>
                    
                    <div class="gender">
                      <label for="inputGender4">Gi???i t??nh</label>
                      <div class="form-check">
                      
                        <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1" value="option1" checked>
                        <label class="form-check-label" for="exampleRadios1">
                          Nam
                        </label>
                      </div>
                      <div class="form-check">
                        <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios2" value="option2">
                        <label class="form-check-label" for="exampleRadios2">
                          N???
                        </label>
                      </div>
                      <!-- <div class="form-check">
                        <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios3" value="option3">
                        <label class="form-check-label" for="exampleRadios3">
                          Kh??c
                        </label>
                      </div> -->
                    </div>
                    <div class="form-row">
                      <div class="form-group col-md-4">
                        <label for="inputDateOfBirth">Ng??y sinh</label>
                        <select id="inputDateOfBirth" class="form-control">
                          <option selected>1</option>
                          <option value="2">2</option>
                          <option value="3">3</option>
                          <option value="4">4</option>
                          <option value="5">5</option>
                          <option value="6">6</option>
                          <option value="7">7</option>
                          <option value="8">8</option>
                          <option value="9">9</option>
                          <option value="10">10</option>
                          <option value="11">11</option>
                          <option value="12">12</option>
                          <option value="13">13</option>
                          <option value="14">14</option>
                          <option value="15">15</option>
                          <option value="16">16</option>
                          <option value="17">17</option>
                          <option value="18">18</option>
                          <option value="19">19</option>
                          <option value="20">20</option>
                          <option value="21">21</option>
                          <option value="22">22</option>
                          <option value="23">23</option>
                          <option value="24">24</option>
                          <option value="25">25</option>
                          <option value="26">26</option>
                          <option value="27">27</option>
                          <option value="28">28</option>
                          <option value="29">29</option>
                          <option value="29">30</option>
                          <option value="29">31</option>
                          </option>
                        </select>
                      </div>
      
                      <div class="form-group col-md-4">
                        <label for="inputMonthOfBirth">Th??ng sinh</label>
                        <select id="inputMonthOfBirth" class="form-control">
                          <option selected value="1">Th??ng 1</option>
                          <option value="{2}">Th??ng 2</option>
                          <option value="{3}">Th??ng 3</option>
                          <option value="{4}">Th??ng 4</option>
                          <option value="{5}">Th??ng 5</option>
                          <option value="{6}">Th??ng 6</option>
                          <option value="{7}">Th??ng 7</option>
                          <option value="{8}">Th??ng 8</option>
                          <option value="{9}">Th??ng 9</option>
                          <option value="{10}">Th??ng 10</option>
                          <option value="{11}">Th??ng 11</option>
                          <option value="{12}">Th??ng 12</option>
                          
                        </select>
                      </div>
      
                      <div class="form-group col-md-4">
                        <label for="inputYearOfBirth">N??m sinh</label>
                        <select id="inputYearOfBirth" class="form-control">
                          <option selected value="1950">N??m 1950</option>
      
                          <option value="1951">N??m 1951</option>
                          <option value="1952">N??m 1952</option>
                          <option value="1953">N??m 1953</option>
                          <option value="1954">N??m 1954</option>
                          <option value="1955">N??m 1955</option>
                          <option value="1956">N??m 1956</option>
                          <option value="1957">N??m 1957</option>
                          <option value="1958">N??m 1958</option>
                          <option value="1959">N??m 1959</option>
                          <option value="1960">N??m 1960</option>
                          <option value="1961">N??m 1961</option>
                          <option value="1962">N??m 1962</option>
                          <option value="1963">N??m 1963</option>
                          <option value="1964">N??m 1964</option>
                          <option value="1965">N??m 1965</option>
                          <option value="1966">N??m 1966</option>
                          <option value="1967">N??m 1967</option>
                          <option value="1968">N??m 1968</option>
                          <option value="1969">N??m 1969</option>
                          <option value="1970">N??m 1970</option>
                          <option value="1971">N??m 1971</option>
                          <option value="1972">N??m 1972</option>
                          <option value="1973">N??m 1973</option>
                          <option value="1974">N??m 1974</option>
                          <option value="1975">N??m 1975</option>
                          <option value="1976">N??m 1976</option>
                          <option value="1977">N??m 1977</option>
                          <option value="1978">N??m 1978</option>
                          <option value="1979">N??m 1979</option>
                          <option value="1980">N??m 1980</option>
                          <option value="1981">N??m 1981</option>
                          <option value="1982">N??m 1982</option>
                          <option value="1983">N??m 1983</option>
                          <option value="1984">N??m 1984</option>
                          <option value="1985">N??m 1985</option>
                          <option value="1986">N??m 1986</option>
                          <option value="1987">N??m 1987</option>
                          <option value="1988">N??m 1988</option>
                          <option value="1989">N??m 1989</option>
                          <option value="1990">N??m 1990</option>
                          <option value="1991">N??m 1991</option>
                          <option value="1992">N??m 1992</option>
                          <option value="1993">N??m 1993</option>
                          <option value="1994">N??m 1994</option>
                          <option value="1995">N??m 1995</option>
                          <option value="1996">N??m 1996</option>
                          <option value="1997">N??m 1997</option>
                          <option value="1998">N??m 1998</option>
                          <option value="1999">N??m 1999</option>
                          <option value="2000">N??m 2000</option>
                          <option value="2001">N??m 2001</option>
                          <option value="2002">N??m 2002</option>
                          <option value="2003">N??m 2003</option>
                          <option value="2004">N??m 2004</option>
                          <option value="2005">N??m 2005</option>
                          <option value="2006">N??m 2006</option>
                          <option value="2007">N??m 2007</option>
                          <option value="2008">N??m 2008</option>
                          <option value="2009">N??m 2009</option>
                          <option value="2010">N??m 2010</option>
                          <option value="2011">N??m 2011</option>
                          <option value="2012">N??m 2012</option>
                          <option value="2013">N??m 2013</option>
                          <option value="2014">N??m 2014</option>
                          <option value="2015">N??m 2015</option>
                          <option value="2016">N??m 2016</option>
                          <option value="2017">N??m 2017</option>
                          <option value="2018">N??m 2018</option>
                          <option value="2019">N??m 2019</option>
                          <option value="2020">N??m 2020</option>
                          <option value="2021">N??m 2021</option>
                          <option value="2022">N??m 2022</option>
                          
                          
                        </select>
                      </div>
                    </div>
                    
                  </form>
                  <div class="form-group" >                  
                  <button type="submit" class="btn btn-primary">L??u</button>
                </div>
              </div>
              </div>
      
              
              <!-- <div class="menu-content-nav">
                <p style ="font-size: 20px;"> ?????i M???t Kh???u</p>
                <p>????? b???o m???t t??i kho???n, vui l??ng kh??ng chia s??? m???t kh???u cho ng?????i kh??c</p>
              </div>
              
              <div class="menu-content">
                <div class="account-passwd">
                  <form>
                    <div class="form-row">
                      <div class="form-group col-md-6">
                        <label for="inputCurrentPasswd">M???t kh???u hi???n t???i</label>
                        <input type="currenPasswd" class="form-control" id="inputName4" placeholder="">
                      </div>
                      <div class="form-group col-md-6">
                        <label for="inputNewPasswd">M???t kh???u m???i</label>
                        <input type="newPasswd" class="form-control" id="inputEmail4" placeholder="">
                      </div>
                      <div class="form-group col-md-6">
                        <label for="inputConfNewPasswd">X??c nh???n m???t kh???u</label>
                        <input type="confNewPasswd" class="form-control" id="inputPhonenumber4" placeholder="">
                      </div>
                    </div>

                    <div class="ConfirmPasswd"><button id="confirmChangePasswd"> X??c nh???n</button></div>
                  </form>
                </div>
              </div> -->

              <!-- <div class="menu-content-nav">
                <p style ="font-size: 20px;"> ????n h??ng ch??a nh???n</p>
              </div>
              <div class="menu-content">
                <div class="col-12">
                  <div class="table-responsive"> 

                    <table class="table table-striped">
                      <thead>
                        <tr>
                          <th></th>
                          <th scope="col">T??n</th>
                          <th scope="col">????n gi??</th>
                          <th scope="col" class="text-center" >S??? l?????ng</th>
                          <th scope="col" class="text-center">Th??nh ti???n</th>
                          <th scope="col" class="text-center">Tr???ng th??i</th>
                          
                          
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          
                          <td id="product-img"><img src="https://dummyimage.com/50x50/55595c/fff" /></td>
                          <td id="product-name">Iphone 12 promax 1TB mauf dne xanh nham nhieu ma </td>
                          <td id="product-price">464247</td>
                          <td id="form-product-quantity">
                            
                            <input class="form-control" type="text" value="1" disabled/>
                            
                          </td>
                          <td id="product-totalmoney" class="text-center">124,90 ???</td>
                          <td id="product-status" class="text-center" style="color: rgb(197, 31, 31); font-weight: 600;"> Ch??a giao</td>
                          
                        </tr>
        
                        <br />  
                        
                        <tr>
                          
                          <td id="product-img"><img src="https://dummyimage.com/50x50/55595c/fff" /></td>
                          <td id="product-name">Iphone 12 promax 1TB mauf dne xanh nham nhieu ma </td>
                          <td id="product-price">464247</td>
                          <td id="form-product-quantity">
                            
                            <input class="form-control" type="text" value="1" disabled/>
                            
                          </td>
                          <td id="product-totalmoney" class="text-center">124,90 ???</td>
                          <td id="product-status" class="text-center" style="color: rgb(197, 31, 31); font-weight: 600;"> Ch??a giao</td>
                          
                        </tr>
                      </br>
    
                      <tr>
                          
                        <td id="product-img"><img src="https://dummyimage.com/50x50/55595c/fff" /></td>
                        <td id="product-name">Iphone 12 promax 1TB mauf dne xanh nham nhieu ma </td>
                        <td id="product-price">464247</td>
                        <td id="form-product-quantity">
                          
                          <input class="form-control" type="text" value="1" disabled/>
                          
                        </td>
                        <td id="product-totalmoney" class="text-center">124,90 ???</td>
                        <td id="product-status" class="text-center" style="color: rgb(197, 31, 31); font-weight: 600;"> Ch??a giao</td>
                        
                      </tr>
    
                      </tbody>
                    </table>
                  </div>
                </div>
              </div> -->

              <!-- <div class="menu-content-nav">
                <p style ="font-size: 20px;">?????a Ch???</p>
               
              </div>
              
              <div class="menu-content">
                <div class="account-address">
                  <form>
                    <div class="form-row">
                      <div class="form-group col-md-6" >
                        <label for="">T??n ng?????i nh???n</label>
                        <input type="" class="form-control" id="" placeholder="">
                      </div>
                      
                      <div class="form-group col-md-6">
                        <label for="">T???nh/Th??nh ph???</label>
                        <input type="" class="form-control" id="" placeholder="">
                      </div>
                      <div class="form-group col-md-6">
                        <label for="">Qu???n/Huy???n</label>
                        <input type="" class="form-control" id="" placeholder="">
                      </div>

                      <div class="form-group col-md-6">
                        <label for="">Ph?????ng/X??</label>
                        <input type="" class="form-control" id="" placeholder="">
                      </div>
                    </div>                      

                  </div>

                    <div class="ConfirmAddress"><button id="confirmAddress"> X??c nh???n</button></div>
                  </form>
                </div> -->
              
              
              </div>
            </div>
          </main>
        </div>
      </div>
      
      
      
      <script>
      $(".sidebar-dropdown > a").click(function () {
    	  $(".sidebar-submenu").slideUp(200);
    	  if ($(this).parent().hasClass("active")) {
    	    $(".sidebar-dropdown").removeClass("active");
    	    $(this).parent().removeClass("active");
    	  } else {
    	    $(".sidebar-dropdown").removeClass("active");
    	    $(this).next(".sidebar-submenu").slideDown(200);
    	    $(this).parent().addClass("active");
    	  }
    	});

    	$("#close-sidebar").click(function () {
    	  $(".page-wrapper").removeClass("toggled");
    	});
    	$("#show-sidebar").click(function () {
    	  $(".page-wrapper").addClass("toggled");
    	});
    	
    	let u = <%= session.getAttribute("user") %>
    	let c = <%= session.getAttribute("cus") %>
    	$('#inputName4').val(u.accountName)
    	$('#inputEmail4').val(u.email)
    	$('#inputPhonenumber4').val(u.phone)
    	if(c.gender == 'F'){
    		$('#exampleRadios2').prop('checked','true')
    	}
    	
    	let day = c.DateofBirth.slice(0, 2) 
		let month = c.DateofBirth.slice(3, 5) 
		let year =c.DateofBirth.slice(6, 10) 
		let d = parseInt(day)
		let m = parseInt(month)
		
		$('#inputDateOfBirth').val(d)
		$('#inputMonthOfBirth').val("{"+ m +"}")
		$('#inputYearOfBirth').val(2002)
    	console.log(c)
    	var tongtienorder = 0;
    	function tinhtongtien(id) {
    		return new Promise(resolve => {
    		   
    			let tt = 0;
        		fetch('http://localhost:8083/orderdetail/get-all-order-detail?orderid=' + id)
    	  		  .then((response) => response.json())
    	  		  .then((data) =>{ 
    	  			  console.log(data)
    	  			  data.forEach(function (item) {
    	  				
    	  				tt = tt + item.price*item.quantity - item.discount
    	  				 //console.log('tt:' tt)
    				})
    	  		  })
    	  		  setTimeout(() => { console.log( tt); resolve(tt); }, 100);
    	  		  console.log(tt)
    	  		
    		  });
    		
	  		  //cosole.log('tt:')
  		  
	  		 // console.log( tt)
			
		}
		
    	
    	async function  loadorder2() {
    		let cus = <%= session.getAttribute("cus") %>
    		fetch('http://localhost:8083/orders/get?cusid=' + cus.cusId)
    		  .then((response) => response.json())
    		  .then((data) =>{ 
    			  //console.log(data)
    			  
    			  data.forEach(async function (item) {
					
					if(item.status < 3){
						console.log(item)
						let tt = await tinhtongtien(item.orderId);
						console.log(tt)
						let statusnumber = {
							"0":"??ang ch??? x??c nh???n",
							"1":"???? x??c nh???n",
							"2":"??ang giao h??ng",
							"3":"???? giao h??ng",
							"4":"???? nh???n h??ng",
							"5":"???? h???y"
								
						}
						
						
						let statusmes =statusnumber[item.status]
						//alert(statusmes)
						$.ajax({
							url : "http://localhost:8083/orderdetail/get-all-order-detail?orderid=" + item.orderId,
							type : "GET",
							dataType: "json",				
							success : function(result) {
								console.log(result)
								for(let i = 0; i < result.length; i++){
									let fmDonGia = result[i].productId.price
									let fmTongTien = parseInt(result[i].productId.price)*parseInt(result[i].quantity)
									let fmDonGiaGiam = "";
									
									if(result[i].productId.discountId != null){
										fmDonGiaGiam = fmDonGia
										fmDonGia = parseInt(fmDonGia) -  parseFloat(result[i].productId.discountId.percent)*parseInt(fmDonGia) -  parseInt(result[i].productId.discountId.amount)
										fmTongTien = parseInt(fmTongTien) -parseInt( result[i].discount)
										fmDonGiaGiam = formatmoney(fmDonGiaGiam, '??') 
									}
									
									fmDonGia = formatmoney(fmDonGia, '??') 
									fmTongTien =  formatmoney(fmTongTien, '??') 
									
									$("#account-profile .page-content .container-fluid tbody").append(` <tr>
											<c:url value="/image?fname=\${result[i].productId.image.picture1}" var="imgUrl"></c:url>
					                          <td  id="product-img"><img style="height: 60px;width: 60px;" src="${imgUrl}" /></td>
					                          <td id="product-name">\${result[i].productId.pname} </td>
					                          <td id="product-price"><p style=" text-decoration: line-through;">\${fmDonGiaGiam}</p> \${fmDonGia} </td>
					                          <td id="form-product-quantity">
					                            
					                            <input class="form-control" type="text" value="\${result[i].quantity}" disabled/>
					                            
					                          </td>
					                          <td id="product-totalmoney" class="text-center">\${fmTongTien}</td>
					                          <td id="product-status" class="text-center" style="color: green; font-weight: 600;"> \${statusmes}</td>
					                          
					                        </tr>`)
								}
				                        
				                        
								
							},
							error : function(error) {
								alert('an error occur!')
							}
						});
						
						
						 
					}
				})
    		  });
		}
    	
    	async function  loadorder() {
    		let cus = <%= session.getAttribute("cus") %>
    		fetch('http://localhost:8083/orders/get?cusid=' + cus.cusId)
    		  .then((response) => response.json())
    		  .then((data) =>{ 
    			  //console.log(data)
    			  
    			  data.forEach(async function (item) {
    				  if(item.status == 3){
  						console.log(item)
  						let tt = await tinhtongtien(item.orderId);
  						console.log(tt)
  						let statusnumber = {
  							"0":"??ang ch??? x??c nh???n",
  							"1":"???? x??c nh???n",
  							"2":"??ang giao h??ng",
  							"3":"???? giao h??ng",
  							"4":"???? nh???n h??ng",
  							"5":"???? h???y"
  								
  						}
  						
  						
  						let statusmes =statusnumber[item.status]
  						//alert(statusmes)
  						$.ajax({
  							url : "http://localhost:8083/orderdetail/get-all-order-detail?orderid=" + item.orderId,
  							type : "GET",
  							dataType: "json",				
  							success : function(result) {
  								console.log(result)
  								for(let i = 0; i < result.length; i++){
  									
  									let fmDonGia = result[i].productId.price
									let fmTongTien = parseInt(result[i].productId.price)*parseInt(result[i].quantity)
									let fmDonGiaGiam = "";
									
									if(result[i].productId.discountId != null){
										fmDonGiaGiam = fmDonGia
										fmDonGia = parseInt(fmDonGia) -  parseFloat(result[i].productId.discountId.percent)*parseInt(fmDonGia) -  parseInt(result[i].productId.discountId.amount)
										fmTongTien = parseInt(fmTongTien) -parseInt( result[i].discount)
										fmDonGiaGiam = formatmoney(fmDonGiaGiam, '??') 
									}
									
									fmDonGia = formatmoney(fmDonGia, '??') 
									fmTongTien =  formatmoney(fmTongTien, '??') 
  									
  									$("#account-profile .page-content .container-fluid tbody").append(` <tr>
  											<c:url value="/image?fname=\${result[i].productId.image.picture1}" var="imgUrl"></c:url>
  					                          <td  id="product-img"><img style="height: 60px;width: 60px;" src="${imgUrl}" /></td>
  					                          <td id="product-name">\${result[i].productId.pname} </td>
  					                          <td id="product-price"><p style=" text-decoration: line-through;">\${fmDonGiaGiam}</p> \${fmDonGia}</td>
  					                          <td id="form-product-quantity">
  					                            
  					                            <input class="form-control" type="text" value="\${result[i].quantity}" disabled/>
  					                            
  					                          </td>
  					                          <td id="product-totalmoney" class="text-center">\${fmTongTien}</td>
  					                          <td id="product-status" class="text-center" style="color: green; font-weight: 600;"> \${statusmes}</td>
  					                          
  					                        </tr>`)
  								}
  				                        
  				                        
  								
  							},
  							error : function(error) {
  								alert('an error occur!')
  							}
  						});
  						
  						
  						 
  					}
					
				})
    		  });
		}
    	
    	$(document).on('click', '.confirmOrder', function () {
			let id = $(this).find('p').html()
			let obj = {};
			obj['status'] = 5
			obj['orderId'] = id
			fetch('http://localhost:8083/orders/update', {
				  method: 'PUT',
				  headers: {
				    'Content-Type': 'application/json',
				  },
				  body: JSON.stringify(obj),
				})
				  .then((response) => response.json())
				  .then((data) => {
				    console.log('Success:', data);
				    $('#account-profile .page-content .container-fluid tbody tr').remove()
				    loadorder()
				  })
				  .catch((error) => {
				    console.error('Error:', error);
				  });
		})
    	</script>
    	
    	