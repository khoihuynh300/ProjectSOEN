var rootURL = "http://localhost:8083";
var execUrl;
var execType;
// get data
function LoadTable(url="",type="GET",data={}) {
			$.ajax({
				url : rootURL+url,
				type : type,
				data:data,
				dataType: "json",
				
				success : function(result) {
					var keys = Object.keys(result[0])
					var keyslength = keys.length
					//xóa hết trươc khi thêm vào
					$('.maintable thead tr').remove()
					$('.maintable tbody tr').remove()
					
					$('.maintable thead').append(`<tr></tr>`)
					$('.maintable thead tr').append(`<th class="cbx-all" style="width:10px;"><input  type="checkbox" id="" name="" value=""></th>`)
					$('.maintable thead tr').append(`<th></th>`)
					
					for (var i = 0; i<keyslength; i++){
						// nếu là 1 object {} thì đổi tên thành trường thứ 2(index = 1) của object 
						if(typeof result[0][keys[i]] === 'object' && result[0][keys[i]] !== null){
							
							$('.maintable thead tr').append(`<th>${Object.keys(result[0][keys[i]])[1]}</th>`)
						}
						else {
							$('.maintable thead tr').append(`<th>${keys[i]}</th>`)
						}
						
						//$('#AddAndEdit .modal-body').append(`<label >${keys[i]}</label><input name="${keys[i]}"></br>`)
					}
		
					for (var i = 0; i <result.length ; i++) { 
						$('.maintable tbody').append(`<tr></tr>`)
						$('.maintable tbody tr').last().append(`<td class="cbx-row" style="width:10px;"><input  type="checkbox" id="" name="" value=""></td>`)
						$('.maintable tbody tr').last().append(`<td style="width:70px;" ><i class="fa-solid fa-pen-to-square edit-row"></i><i class="fa-solid fa-trash delete-row"></i></td>`)
						for (var j = 0; j<keyslength; j++){
							//nếu là object thì sẽ hiện thị name thay vì là id, thêm nút khi hover  sẽ hiện đầy đủ thông tin
							if(typeof result[i][keys[j]] === 'object' && result[i][keys[j]] !== null ){
								var p = ``
								
								for(var z = 0; z < Object.keys(result[i][keys[j]]).length; z++ ){
									p = p + `<a class="key">${Object.keys(result[i][keys[j]])[z]}</a>: <a class="data">${result[i][keys[j]][Object.keys(result[i][keys[j]])[z]]}</a> </br></br>`
									
								}
								$('.maintable tbody tr').last().append(`<td name="${keys[j]}" >
								<div class="viewobj"><i class="fa-solid fa-eye viewobj"></i>
								      <div class="showobj">
								        ${p}
								      </div>
								    </div>
								${result[i][keys[j]][Object.keys(result[i][keys[j]])[1]]}
								</td>`)
							}
							else //không phải là object
							{
								$('.maintable tbody tr').last().append(`<td name="${keys[j]}" >${result[i][keys[j]]}</td>`)
								
							}
						}	
					}

				},
				error : function(error) {
					alert('an error occur!')
				}
			});
		}
//create, update, delete data
function EditTable(url="",type="POST",data={}) {
	
	fetch(rootURL+url, {
	  method: type, // or 'PUT'
	  headers: {
	    'Content-Type': 'application/json',
	  },
	  body: JSON.stringify(data),
	})
	.then((response) =>{ 
		if(response.status == 200){
			alert("success")
			//$('thead').remove("tr")
			let url = $(".main_content__body #geturl").data("value")
			
			LoadTable(url);
			
		}
		else{
			alert("fail")
		}
		response.json().then((data) => {
			console.log('Success:', data);
		
	  })
	})
	  .catch((error) => {
	    alert("error:", error)
	  });   
	 /* .then((response) => 
	  {
		if(response.status == 200){
			alert("success")
		}
		else{
			alert("fail")
		}
	})
	.catch((error) => {
	    alert("error:", error)
	   
	  });*/
	  
	  
};

//array to object
/*function ToObject(Name,Data){
			//
			if(Name.length == Data.length && Name.length > 0){
				var o = {}
				for(var i in Name){
					o[Name[i]] = Data[i];
				}
				return o;
			}
			return false
		}	*/
		
$("table").on("click", ".edit-row", function (e) {
	execUrl = $(".main_content__body #editurl").data("value")
	execType = "PUT"
	$(".modal-body .toggledisable").prop('disabled', false);
    
    let row = $(this).closest('tr');
   // var keys = $('thead tr').find("th");
    //let test = $(row).find("td[name='user']");
    //let td = $(row).find("td");
    
	let inp = $('#AddAndEdit .modal-body input');
	let sel = $('#AddAndEdit .modal-body select');
	let inpobj = $('#AddAndEdit .modal-body input.obj');
    for(let i = 0;i< inp.length ; i++){
		let name = $(inp).eq(i).attr("name")
		$(inp).eq(i).val($(row).find("td[name=" + name+"]").eq(0).html())
	}
	for(let i = 0;i< sel.length ; i++){
		let name = $(sel).eq(i).attr("name")
		
		$(sel).eq(i).val($(row).find("td[name=" + name+"]").eq(0).html())
	}
	for(let i = 0;i< inpobj.length ; i++){
		let name = $(inpobj).eq(i).attr("name")
		$(inpobj).eq(i).val($(row).find("td[name=" + name+"]").eq(0).html())
	}
	$('#AddAndEdit').css("display", "block");
	
	$('#AddAndEdit #type').attr('data-value','PUT');
  
});

$(".main_content").on("click", ".addbtn", function (e) {
	execUrl = $(".main_content__body #addurl").data("value")
	execType = "POST"
	$('#AddAndEdit').css("display", "block");	
})

$(".main_content").on("click", ".delete-row", function (e) {
	let row = $(this).closest('tr');
	let td = row.find('td')
	let obj = {}
	
	for(let i = 2; i < td.length; i++){
		obj[td.eq(i).attr("name")] = td.eq(i).html() 
		
		
	}
	
	EditTable($(".main_content__body #deleteurl").data("value"),"DELETE",obj)
})

$("#AddAndEdit").on("click", "#oke", function (e) {
	
	
	let inp = $('#AddAndEdit .modal-body input');
	let sel = $('#AddAndEdit .modal-body select');
	let inpobj = $('#AddAndEdit .modal-body input.obj');
	//console.log(inp.length)
	//console.log(sel.length)
	let obj = {}
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
	//console.log(obj)
	EditTable(execUrl,execType,obj) 
		
	
});  

$("#AddAndEdit").on("click", ".close", function (e) {
	resetInput();
	$('#AddAndEdit').css("display", "none");
	$(".modal-body .toggledisable").prop('disabled', true);
	console.log($('.maintable thead tr').length)
});

$("#ChooseObj").on("click", ".close", function (e) {
	$('#ChooseObj').css("display", "none");
});

function resetInput(){
	let inp = $('#AddAndEdit .modal-body input');
	let sel = $('#AddAndEdit .modal-body select');
	for(let i = 0;i< inp.length ; i++){
		$(inp).eq(i).val("")
	}
	for(let i = 0;i< sel.length ; i++){
		sel[i].selectedIndex = 0;
	}
}


