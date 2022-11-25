



      $(document).ready(function () {
          $(".btn-showProfile").click(function () {
            $("#account-profile .page-content .container-fluid").empty();
            $("#account-profile .page-content .container-fluid").append(`              <div class="menu-content-nav">
                <p style="font-size: 20px;">Hồ sơ của tôi</p>
                <p>Quản lý thông tin hồ sơ để bảo mật tài khoản</p>
              </div>
      
              <div class="menu-content">
                <div class="account-info">
                  <form>
                    <div class="form-row">
                      <div class="form-group col-md-6">
                        <label for="inputName4">Tên đăng nhập</label>
                        <input type="name" class="form-control" id="inputName4" placeholder="Name">
                      </div>
                      
                     

                      <div class="form-group col-md-6">
                        <label for="inputEmail4">Email</label>
                        <input type="email" class="form-control" id="inputEmail4" placeholder="Email">
                      </div>
                      <div class="form-group col-md-6">
                        <label for="inputPassword4">Số điện thoại</label>
                        <input type="phonenumber" class="form-control" id="inputPhonenumber4" placeholder="PhoneNumber">
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
                      <div class="form-check">
                        <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios3" value="option3">
                        <label class="form-check-label" for="exampleRadios3">
                          Khác
                        </label>
                      </div>
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
                        <label for="inputYearOfBirth">Tháng sinh</label>
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
              </div>`);


          });

          $(".btn-showChangePasswd").click(function () {
	
            $("#account-profile .page-content .container-fluid").empty();
            $("#account-profile .page-content .container-fluid").append(`<div class="menu-content-nav">
                <p style ="font-size: 20px;"> Đổi Mật Khẩu</p>
                <p>Để bảo mật tài khoản, vui lòng không chia sẻ mật khẩu cho người khác</p>
              </div>
              
              <div class="menu-content">
                <div class="account-passwd">
                  <form>
                    <div class="form-row">
                      <div class="form-group col-md-6">
                        <label for="inputCurrentPasswd">Mật khẩu hiện tại</label>
                        <input type="password" class="form-control" id="currentPasswd" placeholder="">
                      </div>
                      <div class="form-group col-md-6">
                        <label for="inputNewPasswd">Mật khẩu mới</label>
                        <input type="password" class="form-control" id="newPasswd" placeholder="">
                      </div>
                      <div class="form-group col-md-6">
                        <label for="inputConfNewPasswd">Xác nhận mật khẩu</label>
                        <input type="password" class="form-control" id="confNewPasswd" placeholder="">
                      </div>
                    </div>

                    <div class="ConfirmPasswd"><button id="confirmChangePasswd"> Xác nhận</button></div>
                  </form>
                </div>
              </div>`)
              
              
          });
          
          $(document).on('click', '#confirmChangePasswd', function(){
			let curpass = $('#currentPasswd').val().trim()
			let newpass = $('#newPasswd').val().trim()
			let cfmnewpass = $('#confNewPasswd').val().trim()
			if(curpass == "" || newpass == ""  ||  cfmnewpass ==""){
				alert("chưa nhập đầy đủ thông tin")
			}
			else if(newpass != cfmnewpass){
				alert("xác nhận mật khẩu không đúng!")
			}
			else if(newpass == curpass){
				alert("mật khẩu mới phải khác mật khẩu cũ")
			}
			
			else{
				var formdata = new FormData();
				
			    formdata.append('id','9')
			     formdata.append('oldPassword',curpass)
			    formdata.append('newPassword',newpass)
			    fetch('http://localhost:8083/user/changepassword', {
				  method: 'PUT',
				  body: formdata
				})
				.then(r =>{
					if(!r.ok){
						if(r.status == 406){
							alert("mật khẩu không chính xác!")
						}
					}else{
						
						alert("đổi thành công")
					}
					})
				
			}
		})
          
          $(".btn-showAddress").click(function () {
            $("#account-profile .page-content .container-fluid").empty();
            $("#account-profile .page-content .container-fluid").append(`
            <div class="menu-content-nav">
                <p style ="font-size: 20px;">Địa chỉ của tôi</p>             
              </div>
              
              <div class="menu-content">
                <div class="account-address">
                  <form>
                    <div class="form-row">
                      <div class="form-group col-md-6" >
                        <label for="">Tên người nhận</label>
                        <input type="" class="form-control" id="ten-nguoi-nhan" placeholder="">
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
                </div>`)
      });
      
      
                $(".btn-showCompletedOrder").click(function () {
            $("#account-profile .page-content .container-fluid").empty();
            $("#account-profile .page-content .container-fluid").append(` <div class="menu-content-nav">
                  <p style ="font-size: 20px;"> Đơn hàng đã giao</p>
                </div>
                <div class="menu-content">
                  <div class="col-12">
                    <div class="table-responsive">
                      <table class="table table-striped">
                        <thead>
                          <tr>
                            
                            <tr>
	                          <th></th>
	                          <th scope="col">Tên</th>
	                          <th scope="col">Đơn giá</th>
	                          <th scope="col" class="text-center" >Số lượng</th>
	                          <th scope="col" class="text-center">Thành tiền</th>
	                          <th scope="col" class="text-center">Trạng thái</th>
	                          
	                          
	                        </tr>
                            <!-- <th></th> -->
                            
                            
                          </tr>
                        </thead>
                        <tbody>
                          
                          

      
                        </tbody>
                      </table>
                    </div>
                  </div>
                </div>`)
                loadorder();

              
          });
          
          
            $(".show-UnCompletedOrder").click(function () {
            $("#account-profile .page-content .container-fluid").empty();
            $("#account-profile .page-content .container-fluid").append(`<div class="menu-content-nav">
                  <p style ="font-size: 20px;"> Đơn hàng đang giao</p>
                </div>
                <div class="menu-content">
                  <div class="col-12">
                    <div class="table-responsive">
                      <table class="table table-striped">
                        <thead>
                          <tr>
                            
                            <tr>
                          <th></th>
                          <th scope="col">Tên</th
                          <th scope="col">Đơn giá</th>
                          <th scope="col" class="text-center" >Số lượng</th>
                          <th scope="col" class="text-center">Thành tiền</th>
                          <th scope="col" class="text-center">Trạng thái</th>
                          
                          
                        </tr>
                            
                            <!-- <th></th> -->
                            
                            
                          </tr>
                        </thead>
                        <tbody>
                          
                          

      
                        </tbody>
                      </table>
                    </div>
                  </div>
                </div>`)
                 loadorder2();	
      });
          
      });



