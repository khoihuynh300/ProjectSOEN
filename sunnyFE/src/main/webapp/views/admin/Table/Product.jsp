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
<style>.maintable tr > *:nth-child(12) {display: none;}</style>

	<div class="main_content__body">
		<p hidden="true" id="geturl" data-value="/product/get"></p>
		<p hidden="true" id="addurl" data-value="/product/create"></p>
	    <p hidden="true" id="editurl" data-value=""></p>
	    <p hidden="true" id="deleteurl" data-value=""></p>
	    
		<div class="main_content__body-title">
			<p>Danh sách tài khoản</p>
		</div>
		<div class="CateList">
			<!-- <div class="cateItem active">abcd</div> -->
			<div onclick="LoadTable(url)" class="cateItem">Tất cả</div>
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
	
	  
	  <div class="modal-content product">
	    <div class="modal-header">
	      <span class="close closex">&times;</span>
	      <h2>PRODUCT DETAIL</h2>
	    </div>
	    <div class="modal-body">
	    	<label>Product ID:</label><input disabled name="pid"></br></br>
	    	<div class="input-image">
		    	<div>
			    	<input type="file" id="imageFile" name="images " accept=".jpg, .jpeg, .png" /></br>
			    	<img class="card-img" src="" alt="Card image cap" /></br>
			    </div>
			    
			    <div>
			    	<input type="file" id="imageFile" name="images " accept=".jpg, .jpeg, .png" /></br>
			    	<img class="card-img" src="" alt="Card image cap" /></br>
			    </div>
			    <div>
			    	<input type="file" id="imageFile" name="images " accept=".jpg, .jpeg, .png" /></br>
			    	<img class="card-img" src="" alt="Card image cap" /></br>
			    </div>
			    <div>
			    	<input type="file" id="imageFile" name="images " accept=".jpg, .jpeg, .png" /></br>
			    	<img class="card-img" src="" alt="Card image cap" /></br>
			    </div>
			</div>
	    	
		    <div class="input-product">
		    	<div class="input-info">
		        	
			    	<label>ptype:</label><input onkeydown="return false" class="obj" data-objkey="" data-objvalue="" id="ptype" name="ptype"><button data-inputid="ptype" data-url="/producttype/get" class="btnchooseobj">chọn</button> </br>
			    	<label>pname:</label><input name="pname"></br>
			    	<label>price:</label><input name="price"></br>
			    	<label>description:</label><input name="description"></br>
			    	<label>quantity:</label><input name="quantity"></br>
			    	<label>discountId:</label><input onkeydown="return false" class="obj" data-objkey="" data-objvalue="" id="discountId" name="discountId"><button data-inputid="discountId" data-url="/discount/get" class="btnchooseobj">chọn</button> </br>
			    	<label>deleted:</label><select class="toggledisable" disabled name="deleted">
								  <option value="false">false</option>
								  <option value="true">true</option>
								</select></br>
			    	<label>waranty(tháng):</label><input name="waranty"></br>	    	
		    	</div>
		    	<div class= "floatbtn">
		    	<div class="pattr" data-url="/productAttribute/get" id="add-ptoattr">
		    			<i class="fa-solid fa-circle-plus" ></i>
		    		</div>
		    		<div class="pattr" data-url="/productAttribute/add" id="new-pattr">
		    			<button onclick="newpattr" >new</button>
		    		</div>
		    	</div>	
		    	
		    	<div class="input-attribute">
		    		
		    	 <table>
		    	 	<thead>
		    	 		<tr>
		    	 			<th>atrName</th>
		    	 			<th>val</th>
		    	 			<th>unit</th>
		    	 		</tr>
		    	 	</thead>
		    	 	<tbody>
		    	 		
		    	 	</tbody>
		    	 </table>
		    		
		    	</div>
		    	
	    	</div>
	    	
	    </div>
	    <div class="modal-footer">
	    	
	    	
	      <button id="oke-product">oke</button>
	      <button class="close">cancel</button>
	    </div>
	  </div>
	  
	</div> 
	  
	  <div id="TblChooseObj" class="modal">
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
	
	<div id="TblChooseAttr" class="modal">
	  <div class="modal-content">
	    <div class="modal-header">
	      <span class="close-a closex">&times;</span>
	      <h2>Modal Header</h2>
	    </div>
	    <div class="modal-body">
	    	<table class="table tblchooseattr">
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
	
	<!-- override -->
	<script type="text/javascript">
		//load cate
		function LoadCategory(){
			
			fetch('http://localhost:8083/producttype/get')
			  .then((response) => response.json())
			  .then((data) => {
				  data.forEach(item => {$(".CateList").append(`<div data-ptype = \${item.ptype} class="cateItem">\${item.ptypeName}</div>`)});
			  });
		}
		//load product by cate
		function LoadProductByPtype(ptype) {
			LoadTable('/product/get-by-ptype?ptype=' + ptype);
		}
		//click oke --> fetch api to add or edit
		$("#AddAndEdit").on("click", "#oke-product", function (e) {
			let inp = $('#AddAndEdit .modal-body .input-info input');
			let sel = $('#AddAndEdit .modal-body .input-info select');
			let inpobj = $('#AddAndEdit .modal-body .input-info input.obj');
			
			let inputimg = $('#AddAndEdit .modal-body .input-image input');
			const fileField = document.querySelector('#AddAndEdit .modal-body .input-image input');
			
			console.log( inputimg.eq(0).prop('files')[0] )
			//console.log(fileField.files[0])
			
			let obj = {}
			let ptoattrs = []
			let images = []
			for(let i = 0;i< inp.length ; i++){
				if($(inp).eq(i).hasClass("obj")){
					let newobj = {}
					newobj[$(inp).eq(i).data("key")] = $(inp).eq(i).val();
					obj[$(inp).eq(i).attr("name")] = newobj;
				}
				else{
					obj[$(inp).eq(i).attr("name")] = $(inp).eq(i).val()
				}
			}
			for(let i = 0;i< sel.length ; i++){
				
				obj[$(sel).eq(i).attr("name")] = $(sel).eq(i).val()
			}
			for(let i = 0;i< inpobj.length ; i++){
				//console.log($(inpobj).eq(i).attr("name"))
				
				let subobj = {}
				subobj[$(inpobj).eq(i).data("objkey")] = $(inpobj).eq(i).data("objvalue")
				obj[$(inpobj).eq(i).attr("name")] = subobj
			}
			if(obj.discountId == "" || obj.discountId =="null"){
				obj.discountId = null
			}
			//console.log(obj)
			//alert(execType)
			var formdata = new FormData();
			
		    formdata.append('imageFile',inputimg.eq(0).prop('files')[0])
		    formdata.append('imageFile',inputimg.eq(1).prop('files')[0])
		    formdata.append('imageFile',inputimg.eq(2).prop('files')[0])
		    formdata.append('imageFile',inputimg.eq(3).prop('files')[0])
		    
		    formdata.append('product',JSON.stringify(obj))
		    formdata.append('ptoattrs','1234')
		    fetch('http://localhost:8083/product/create', {
			  method: 'POST',
			  body: formdata
			})
			.then(r => {
				console.log(r.status)
			})
			.then(data => {
			  console.log(data)
			})
		})
		
		//choose attr of p
		
		
		//click delete attr of p
		
	</script>
	
	
	
	<!-- action  -->
	<script type="text/javascript">
		let url = $(".main_content__body #geturl").data("value")
		LoadTable(url);
		LoadCategory();
	</script>
	
	<!-- action -->
	<script type="text/javascript">
	//show to sub table
	$("#AddAndEdit").on("click", "#add-ptoattr", function (e) {
		$.ajax({
			url : "http://localhost:8083"+$(this).data("url"),
			type : "GET",
			dataType: "json",				
			success : function(result) {
				var keys = Object.keys(result[0])
				
				var keyslength = keys.length
				$('.tblchooseattr thead tr').remove()
				$('.tblchooseattr tbody tr').remove()
				$('.tblchooseattr thead').append(`<tr></tr>`)
				$('.tblchooseattr thead tr').append(`<th></th>`)
				
				for (var i = 0; i<keyslength; i++){
					console.log(keys[i])
					$('.tblchooseattr thead tr').append(`<th>\${keys[i]}</th>`)
				}

				for (var i = 0; i <result.length ; i++) { 
					$('.tblchooseattr tbody').append(`<tr></tr>`)
					$('.tblchooseattr tbody tr').last().append(`<td style="width:70px;" ><button class="btnsubmit" >chọn</button></td>`)
					for (var j = 0; j<keyslength; j++){
						$('.tblchooseattr tbody tr').last().append(`<td name="${keys[j]}" >\${result[i][keys[j]]}</td>`)
					}	
				}
				console.log(result)
				$('#TblChooseAttr').css("display", "block");
			},
			error : function(error) {
				alert('an error occur!')
			}
		});
	})
	
	//onclick on catename
	$(".CateList").on("click", ".cateItem", function (e) {
		
		let cateitem = $(".CateList .cateItem");
		[...cateitem].forEach(item => {
			 item.className = "cateItem";
		});
		
		this.className = "cateItem active";
		
		if($(this).data("ptype")){
			
		LoadProductByPtype($(this).data("ptype"))
		}
	})
	//show image
	 $(document).on('change','#imageFile' , function(e){
		  //alert('change')
		  const currFiles = e.target.files
		  if(currFiles.length > 0){
			  let src = URL.createObjectURL(currFiles[0])
			  let imagePreview = $(this).parent().find('img')
		      imagePreview.attr('src', src);
		      //console.log(imagePreview.attr('class'))
		  }
	  }); 
	
	var old_diplay = $('#AddAndEdit').css("display")
	setInterval(function () {
		var new_diplay = $('#AddAndEdit').css("display")
		if(old_diplay != new_diplay){
			old_diplay = new_diplay
			if(old_diplay == "block"){
				$('#AddAndEdit img').attr('src','null')
				if(execType == "PUT"){
				LoadAttribute()
					
				}

			}
		}
		
	}, 300);
	
	 function LoadAttribute() {
		 
		 fetch('http://localhost:8083/productToAttribute/get-by-pid?pid=' + "1")
		  .then((response) => response.json())
		  .then((data) => {
			  $('.input-attribute tbody tr').remove()
			  data.forEach(item => {$('.input-attribute tbody').append(`<tr><td>\${item.atrId.atrName}</td><td>\${item.val}</td><td>\${item.atrId.unit}</td></tr>`)});
		  });
	}
		
	</script>
	
	
</body>
</html>