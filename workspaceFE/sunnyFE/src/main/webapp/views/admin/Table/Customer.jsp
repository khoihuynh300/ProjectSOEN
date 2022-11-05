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
		<p hidden="true" id="geturl" data-value="/customer/get"></p>
		<p hidden="true" id="addurl" data-value="/customer/create"></p>
	    <p hidden="true" id="editurl" data-value="/customer/update"></p>
	    <p hidden="true" id="deleteurl" data-value="/customer/delete"></p>
	    
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
	    	<label>cusId:</label><input disabled name="cusId"></br>
	    	<label>userId:</label><input class="obj" data-objkey="key" data-objvalue="val" name="userId"><button data-url="/user/get" class="btnchooseobj">chọn</button> </br>
	    	<label>name:</label><input name="name"></br>
	    	<label>gender:</label><select name="gender">
								  <option value="F">Female</option>
								  <option value="M">Male</option>
								</select></br>
	    	<label>dateofBirth:</label><input name="dateofBirth"></br>
	    	<label>address:</label><input name="address"></br>
	    	
	    	
	    </div>
	    <div class="modal-footer">
	    	
	    	
	      <button id="oke">oke</button>
	      <button class="close">cancel</button>
	    </div>
	  </div>
	
	</div>
	
	<div id="ChooseObj" class="modal">
	  <div class="modal-content">
	    <div class="modal-header">
	      <span class="close closex">&times;</span>
	      <h2>Modal Header</h2>
	    </div>
	    <div class="modal-body">
	    	<table class="table subtable">
		        <thead>
		            
		        </thead>
		        <tbody>
		        
		        </tbody>
		    </table>
	    	
	    </div>
	    <div class="modal-footer">
	    	
	    	
	      
	    </div>
	  </div>
	
	</div> 
	
	<script src="<c:url value='/views/admin/js/table.js'/>"></script>
	<script type="text/javascript">
	$("#AddAndEdit").on("click", ".btnchooseobj", function (e) {
		//console.log($(this).data("url"))
		$('#ChooseObj').css("display", "block");	
		
		$.ajax({
			url : "http://localhost:8083"+$(this).data("url"),
			type : "GET",
			dataType: "json",
			
			success : function(result) {
				
				var keys = Object.keys(result[0])
				
				var keyslength = keys.length
				$('.subtable thead tr').remove()
				$('.subtable tbody tr').remove()
				
				$('.subtable thead').append(`<tr></tr>`)
				
				$('.subtable thead tr').append(`<th></th>`)
				
				for (var i = 0; i<keyslength; i++){
					$('.subtable thead tr').append(`<th>\${keys[i]}</th>`)
				}
	
				for (var i = 0; i <result.length ; i++) { 
					$('.subtable tbody').append(`<tr></tr>`)
					$('.subtable tbody tr').last().append(`<td style="width:70px;" ><button class="btnsubmit" >chọn</button></td>`)
					for (var j = 0; j<keyslength; j++){
						
						$('.subtable tbody tr').last().append(`<td name="${keys[j]}" >\${result[i][keys[j]]}</td>`)
				
					}	
				}

			},
			error : function(error) {
				alert('an error occur!')
			}
		});
	});
	
	$("#ChooseObj").on("click", "button.btnsubmit", function (e) {
		
		$("input.obj").data("objkey",$(".subtable thead tr th").eq(1).html())
		$("input.obj").data("objvalue", $(this).closest('tr').find('td').eq(1).html())
		$("input.obj").val($(this).closest('tr').find('td').eq(1).html())
		
		$('#ChooseObj').css("display", "none");
		
	});
	
	
		let url = $(".main_content__body #geturl").data("value")
		
		LoadTable(url);
		
		
	</script>
</body>
</html>