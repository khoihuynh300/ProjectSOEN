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
	<div class="main_content__body">
		<p hidden="true" id="geturl" data-value="/product/get"></p>
		<p hidden="true" id="addurl" data-value=""></p>
	    <p hidden="true" id="editurl" data-value=""></p>
	    <p hidden="true" id="deleteurl" data-value=""></p>
	    
		<div class="main_content__body-title">
			<p>Danh sách tài khoản</p>
		</div>
		<div class="CateList">
			<!-- <div class="cateItem active">abcd</div> -->
			<div data-ptype ="" class="cateItem">Tất cả</div>
		</div>
		
		<table class="maintable">
        <thead>
            
        </thead>
        <tbody>
        
        </tbody>
    </table>
	</div>
	<div class="main_content__footer">
		<i class="fa-solid fa-circle-plus addbtn"></i>
		<i class="fa-solid fa-eye viewbtn"></i>
		<i class="fa-solid fa-magnifying-glass findbtn" ></i>
		<i class="fa-solid fa-arrows-rotate refreshbtn"></i>
		
	</div>
	
	 <div id="AddAndEdit" class="modal">
	
	  
	  <div class="modal-content">
	    <div class="modal-header">
	      <span class="close closex">&times;</span>
	      <h2>Modal Header</h2>
	    </div>
	    <div class="modal-body">
	    	
	    	
	    	<label>userId:</label><input disabled name="userId"></br>
	    	<label>accountName:</label><input name="accountName"></br>
	    	<label>password:</label><input name="password"></br>
	    	<label>email:</label><input name="email"></br>
	    	<label>phone:</label><input name="phone"></br>
	    	<label>role:</label><select name="role">
								  <option value="0">Customer</option>
								  <option value="1">ADMIN</option>
								  <option value="2">Management</option>
								  <option value="3">Shipper</option>
								  <option value="4">Other</option>
								</select></br>
	    	<label>enable:</label><select class="toggledisable" disabled name="enable">
								  <option value="true">true</option>
								  <option value="false">false</option>
								</select></br>
	    	<label>deleted:</label><select class="toggledisable" disabled name="deleted">
								  <option value="false">false</option>
								  <option value="true">true</option>
								</select></br>
	    	
	    </div>
	    <div class="modal-footer">
	    	
	    	
	      <button id="oke">oke</button>
	      <button class="close">cancel</button>
	    </div>
	  </div>
	
	</div> 
	
	
	<script src="<c:url value='/views/admin/js/table.js'/>"></script>
	
	<!-- function -->
	<script type="text/javascript">
		function LoadCategory(){
			
			fetch('http://localhost:8083/producttype/get-all-producttype')
			  .then((response) => response.json())
			  .then((data) => {
				  data.forEach(item => {$(".CateList").append(`<div data-ptype = \${item.ptype} class="cateItem">\${item.ptypeName}</div>`)});
			  });
		}
		
		function LoadProductByPtype(ptype) {
			LoadTable('/product/get?ptype=' + ptype);
			fetch('http://localhost:8083/product/get?ptype=' + ptype)
			  .then((response) => response.json())
			  .then((data) => {
				  console.log(data)
			  });
		}
	</script>
	
	
	
	<!-- action  -->
	<script type="text/javascript">
		let url = $(".main_content__body #geturl").data("value")
		LoadTable(url);
		LoadCategory();
	</script>
	
	<!-- action -->
	<script type="text/javascript">
	$(".CateList").on("click", ".cateItem", function (e) {
		
		let cateitem = $(".CateList .cateItem");
		[...cateitem].forEach(item => {
			 item.className = "cateItem";
		});
		
		this.className = "cateItem active";
		
		
		LoadProductByPtype($(this).data("ptype"))
	})
		
	</script>
</body>
</html>