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
                      <span  >Tài khoản của tôi</span>

                    </a>
                    <div class="sidebar-submenu">
                      <ul>
                        <li class = "btn-showProfile">
                          <a 
                            >Hồ sơ
                            <span class="badge badge-pill badge-success"
                              ></span
                            >
                          </a>
                        </li>                      
                        <!-- <li class="btn-showAddress">
                          <a href="#">Địa chỉ</a>
                        </li> -->
                        <li class = "btn-showChangePasswd">
                          <a href="#">Đổi mật khẩu</a>
                        </li>
                      </ul>
                    </div>
                  </li>
                  <li class="sidebar-dropdown">
                    <a href="#">
                      <i class="fa fa-shopping-cart"></i>
                      <span>Đơn mua</span>
                      <span class="badge badge-pill badge-danger"></span>
                    </a>
                    <div class="sidebar-submenu">
                      <ul>
                        <li class="btn-showCompletedOrder">
                          <a href="#">Đã nhận</a>
                        </li>
                        <li class="show-UnCompletedOrder">
                          <a href="#">Đang giao</a>
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
                <p style="font-size: 20px;">Hồ sơ của tôi</p>
                <p>Quản lý thông tin hồ sơ để bảo mật tài khoản</p>
              </div>
      
              <div class="menu-content">
                <div class="account-info">
                  <form>
                    <div class="form-row">
                      <div class="form-group col-md-6">
                        <label for="inputName4">Tên đăng nhập</label>
                        <input type="name" class="form-control" id="inputName4" placeholder="" disabled>
                      </div>

                      

                      <div class="form-group col-md-6">
                        <label for="inputEmail4">Email</label>
                        <input type="email" class="form-control" id="inputEmail4" placeholder="">
                      </div>
                      <div class="form-group col-md-6">
                        <label for="inputPassword4">Số điện thoại</label>
                        <input type="phonenumber" class="form-control" id="inputPhonenumber4" placeholder="">
                      </div>
                    </div>
                    
                    <div class="gender">
                      <label for="inputGender4">Giới tính</label>
                      <div class="form-check">
                      
                        <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1" value="option1" checked>
                        <label class="form-check-label" for="exampleRadios1">
                          Nam
                        </label>
                      </div>
                      <div class="form-check">
                        <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios2" value="option2">
                        <label class="form-check-label" for="exampleRadios2">
                          Nữ
                        </label>
                      </div>
                      <!-- <div class="form-check">
                        <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios3" value="option3">
                        <label class="form-check-label" for="exampleRadios3">
                          Khác
                        </label>
                      </div> -->
                    </div>
                    <div class="form-row">
                      <div class="form-group col-md-4">
                        <label for="inputDateOfBirth">Ngày sinh</label>
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
                        <label for="inputMonthOfBirth">Tháng sinh</label>
                        <select id="inputMonthOfBirth" class="form-control">
                          <option selected value="1">Tháng 1</option>
                          <option value="{2}">Tháng 2</option>
                          <option value="{3}">Tháng 3</option>
                          <option value="{4}">Tháng 4</option>
                          <option value="{5}">Tháng 5</option>
                          <option value="{6}">Tháng 6</option>
                          <option value="{7}">Tháng 7</option>
                          <option value="{8}">Tháng 8</option>
                          <option value="{9}">Tháng 9</option>
                          <option value="{10}">Tháng 10</option>
                          <option value="{11}">Tháng 11</option>
                          <option value="{12}">Tháng 12</option>
                          
                        </select>
                      </div>
      
                      <div class="form-group col-md-4">
                        <label for="inputYearOfBirth">Năm sinh</label>
                        <select id="inputYearOfBirth" class="form-control">
                          <option selected value="1950">Năm 1950</option>
      
                          <option value="1951">Năm 1951</option>
                          <option value="1952">Năm 1952</option>
                          <option value="1953">Năm 1953</option>
                          <option value="1954">Năm 1954</option>
                          <option value="1955">Năm 1955</option>
                          <option value="1956">Năm 1956</option>
                          <option value="1957">Năm 1957</option>
                          <option value="1958">Năm 1958</option>
                          <option value="1959">Năm 1959</option>
                          <option value="1960">Năm 1960</option>
                          <option value="1961">Năm 1961</option>
                          <option value="1962">Năm 1962</option>
                          <option value="1963">Năm 1963</option>
                          <option value="1964">Năm 1964</option>
                          <option value="1965">Năm 1965</option>
                          <option value="1966">Năm 1966</option>
                          <option value="1967">Năm 1967</option>
                          <option value="1968">Năm 1968</option>
                          <option value="1969">Năm 1969</option>
                          <option value="1970">Năm 1970</option>
                          <option value="1971">Năm 1971</option>
                          <option value="1972">Năm 1972</option>
                          <option value="1973">Năm 1973</option>
                          <option value="1974">Năm 1974</option>
                          <option value="1975">Năm 1975</option>
                          <option value="1976">Năm 1976</option>
                          <option value="1977">Năm 1977</option>
                          <option value="1978">Năm 1978</option>
                          <option value="1979">Năm 1979</option>
                          <option value="1980">Năm 1980</option>
                          <option value="1981">Năm 1981</option>
                          <option value="1982">Năm 1982</option>
                          <option value="1983">Năm 1983</option>
                          <option value="1984">Năm 1984</option>
                          <option value="1985">Năm 1985</option>
                          <option value="1986">Năm 1986</option>
                          <option value="1987">Năm 1987</option>
                          <option value="1988">Năm 1988</option>
                          <option value="1989">Năm 1989</option>
                          <option value="1990">Năm 1990</option>
                          <option value="1991">Năm 1991</option>
                          <option value="1992">Năm 1992</option>
                          <option value="1993">Năm 1993</option>
                          <option value="1994">Năm 1994</option>
                          <option value="1995">Năm 1995</option>
                          <option value="1996">Năm 1996</option>
                          <option value="1997">Năm 1997</option>
                          <option value="1998">Năm 1998</option>
                          <option value="1999">Năm 1999</option>
                          <option value="2000">Năm 2000</option>
                          <option value="2001">Năm 2001</option>
                          <option value="2002">Năm 2002</option>
                          <option value="2003">Năm 2003</option>
                          <option value="2004">Năm 2004</option>
                          <option value="2005">Năm 2005</option>
                          <option value="2006">Năm 2006</option>
                          <option value="2007">Năm 2007</option>
                          <option value="2008">Năm 2008</option>
                          <option value="2009">Năm 2009</option>
                          <option value="2010">Năm 2010</option>
                          <option value="2011">Năm 2011</option>
                          <option value="2012">Năm 2012</option>
                          <option value="2013">Năm 2013</option>
                          <option value="2014">Năm 2014</option>
                          <option value="2015">Năm 2015</option>
                          <option value="2016">Năm 2016</option>
                          <option value="2017">Năm 2017</option>
                          <option value="2018">Năm 2018</option>
                          <option value="2019">Năm 2019</option>
                          <option value="2020">Năm 2020</option>
                          <option value="2021">Năm 2021</option>
                          <option value="2022">Năm 2022</option>
                          
                          
                        </select>
                      </div>
                    </div>
                    
                  </form>
                  <div class="form-group" >                  
                  <button type="submit" class="btn btn-primary">Lưu</button>
                </div>
              </div>
              </div>
      
              
              <!-- <div class="menu-content-nav">
                <p style ="font-size: 20px;"> Đổi Mật Khẩu</p>
                <p>Để bảo mật tài khoản, vui lòng không chia sẻ mật khẩu cho người khác</p>
              </div>
              
              <div class="menu-content">
                <div class="account-passwd">
                  <form>
                    <div class="form-row">
                      <div class="form-group col-md-6">
                        <label for="inputCurrentPasswd">Mật khẩu hiện tại</label>
                        <input type="currenPasswd" class="form-control" id="inputName4" placeholder="">
                      </div>
                      <div class="form-group col-md-6">
                        <label for="inputNewPasswd">Mật khẩu mới</label>
                        <input type="newPasswd" class="form-control" id="inputEmail4" placeholder="">
                      </div>
                      <div class="form-group col-md-6">
                        <label for="inputConfNewPasswd">Xác nhận mật khẩu</label>
                        <input type="confNewPasswd" class="form-control" id="inputPhonenumber4" placeholder="">
                      </div>
                    </div>

                    <div class="ConfirmPasswd"><button id="confirmChangePasswd"> Xác nhận</button></div>
                  </form>
                </div>
              </div> -->

              <!-- <div class="menu-content-nav">
                <p style ="font-size: 20px;"> Đơn hàng chưa nhận</p>
              </div>
              <div class="menu-content">
                <div class="col-12">
                  <div class="table-responsive"> 

                    <table class="table table-striped">
                      <thead>
                        <tr>
                          <th></th>
                          <th scope="col">Tên</th>
                          <th scope="col">Đơn giá</th>
                          <th scope="col" class="text-center" >Số lượng</th>
                          <th scope="col" class="text-center">Thành tiền</th>
                          <th scope="col" class="text-center">Trạng thái</th>
                          
                          
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
                          <td id="product-totalmoney" class="text-center">124,90 €</td>
                          <td id="product-status" class="text-center" style="color: rgb(197, 31, 31); font-weight: 600;"> Chưa giao</td>
                          
                        </tr>
        
                        <br />  
                        
                        <tr>
                          
                          <td id="product-img"><img src="https://dummyimage.com/50x50/55595c/fff" /></td>
                          <td id="product-name">Iphone 12 promax 1TB mauf dne xanh nham nhieu ma </td>
                          <td id="product-price">464247</td>
                          <td id="form-product-quantity">
                            
                            <input class="form-control" type="text" value="1" disabled/>
                            
                          </td>
                          <td id="product-totalmoney" class="text-center">124,90 €</td>
                          <td id="product-status" class="text-center" style="color: rgb(197, 31, 31); font-weight: 600;"> Chưa giao</td>
                          
                        </tr>
                      </br>
    
                      <tr>
                          
                        <td id="product-img"><img src="https://dummyimage.com/50x50/55595c/fff" /></td>
                        <td id="product-name">Iphone 12 promax 1TB mauf dne xanh nham nhieu ma </td>
                        <td id="product-price">464247</td>
                        <td id="form-product-quantity">
                          
                          <input class="form-control" type="text" value="1" disabled/>
                          
                        </td>
                        <td id="product-totalmoney" class="text-center">124,90 €</td>
                        <td id="product-status" class="text-center" style="color: rgb(197, 31, 31); font-weight: 600;"> Chưa giao</td>
                        
                      </tr>
    
                      </tbody>
                    </table>
                  </div>
                </div>
              </div> -->

              <!-- <div class="menu-content-nav">
                <p style ="font-size: 20px;">Địa Chỉ</p>
               
              </div>
              
              <div class="menu-content">
                <div class="account-address">
                  <form>
                    <div class="form-row">
                      <div class="form-group col-md-6" >
                        <label for="">Tên người nhận</label>
                        <input type="" class="form-control" id="" placeholder="">
                      </div>
                      
                      <div class="form-group col-md-6">
                        <label for="">Tỉnh/Thành phố</label>
                        <input type="" class="form-control" id="" placeholder="">
                      </div>
                      <div class="form-group col-md-6">
                        <label for="">Quận/Huyện</label>
                        <input type="" class="form-control" id="" placeholder="">
                      </div>

                      <div class="form-group col-md-6">
                        <label for="">Phường/Xã</label>
                        <input type="" class="form-control" id="" placeholder="">
                      </div>
                    </div>                      

                  </div>

                    <div class="ConfirmAddress"><button id="confirmAddress"> Xác nhận</button></div>
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
							"0":"đang chờ xác nhận",
							"1":"đã xác nhận",
							"2":"đang giao hàng",
							"3":"đã giao hàng",
							"4":"đã nhận hàng",
							"5":"đã hủy"
								
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
										fmDonGiaGiam = formatmoney(fmDonGiaGiam, 'đ') 
									}
									
									fmDonGia = formatmoney(fmDonGia, 'đ') 
									fmTongTien =  formatmoney(fmTongTien, 'đ') 
									
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
  							"0":"đang chờ xác nhận",
  							"1":"đã xác nhận",
  							"2":"đang giao hàng",
  							"3":"đã giao hàng",
  							"4":"đã nhận hàng",
  							"5":"đã hủy"
  								
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
										fmDonGiaGiam = formatmoney(fmDonGiaGiam, 'đ') 
									}
									
									fmDonGia = formatmoney(fmDonGia, 'đ') 
									fmTongTien =  formatmoney(fmTongTien, 'đ') 
  									
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
    	
    	