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
		<p hidden="true" id="geturl" data-value="/invoice/get"></p>
		<p hidden="true" id="addurl" data-value="/discount/get"></p>
	    <p hidden="true" id="editurl" data-value="/discount/get"></p>
	    <p hidden="true" id="deleteurl" data-value="/discount/get"></p>
	    
		<div class="main_content__body-title">
			<p>Danh sách tài khoản</p>
		</div>
		
		<table class="table maintable">
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
	    	<label>empId:</label><input disabled name="empId"></br>
	    	<label>userId:</label><input class="obj" data-objkey="key" data-objvalue="val" name="userId"><button data-url="/user/get" class="chooseobj">chọn</button> </br>
	    	<label>name:</label><input name="name"></br>
	    	<label>gender:</label><select name="gender">
								  <option value="F">Female</option>
								  <option value="M">Male</option>
								</select></br>
	    	<label>dateofBirth:</label><input name="dateofBirth"></br>
	    	<label>address:</label><input name="address"></br>
	    	<label>job:</label><input name="job"></br>
	    	<label>luongThang:</label><input name="luongThang"></br>
	    	
	    </div>
	    <div class="modal-footer">
	    	
	    	
	      <button id="oke">oke</button>
	      <button class="close">cancel</button>
	    </div>
	  </div>
	
	</div>
	
	
	
	<script src="<c:url value='/views/admin/js/table.js'/>"></script>
	<script type="text/javascript">
	
		let url = $(".main_content__body #geturl").data("value")
		
		LoadTable(url);
	</script>
</body>
</html>