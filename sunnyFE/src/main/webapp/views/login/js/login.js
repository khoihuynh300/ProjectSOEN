function AddCustomer(user, name,gender,address ){
	var status;
	var data = {
	    "userId" : user,
	    "name" : name,
	    "gender":gender,
	    "address":address
	}
	console.log(data)
	fetch('http://localhost:8083/customer/create', {
	  method: 'POST',
	  headers: {
	    'Content-Type': 'application/json',
	  },
	  body: JSON.stringify(data),
	})
	  .then((response) =>{ 
		status = response.status
		return response.json()
		})
	  .then((data) => {
		if(status == 200){
			console.log('Success:', data)
			//alert(data.message)
			window.location.href = "http://"+location.host+"/sunnyFE/account/login";
		}
	    else{
			alert('fail! some error occur')
		}
	   
	  })
	  .catch((error) => {
	    console.error('Error:', error);
	  });
}


function verify(code,userId){
	var status;	
	let url = "http://localhost:8083/user/register/verifyer?code=" + code + "&userId=" + userId;
	//alert(url)
	fetch(url, {
	  method: 'PUT', 
	  headers: {
	    'Content-Type': 'application/json',
	  },
	 // body: JSON.stringify(data),
	})
	  .then((response) =>{ 
		status = response.status
		return response.json()
		})
	  .then((data) => {
	    //console.log('Success1:', {jsonData:JSON.stringify(data)});
	    
	    if(status==200){
			window.location.href = "http://"+location.host+"/sunnyFE/account/signup/userinfo";
			//alert('xác thực thành công. vui lòng nhập thông tin người dùng')
		}
		else {
			alert('mã xác thực không chính xác')
		}
	   	
	  })
	  .catch((error) => {
	    console.error('Error:', error);
	    alert(error)
	  });
}


function signup(email,username, password, phone){
	var status;
	var data = {
	    "accountName" : username,
	    "password" : password,
	    "email":email,
	    "phone":phone
	}
	
	
	fetch('http://localhost:8083/user/register', {
	  method: 'POST', // or 'PUT'
	  headers: {
	    'Content-Type': 'application/json',
	  },
	  body: JSON.stringify(data),
	})
	  .then((response) =>{ 
		status = response.status
		return response.json()
		})
	  .then((data) => {
		if(status == 200){
			console.log(data)
			$.post("http://"+location.host+"/sunnyFE/account/login",
			  	{userId:JSON.stringify(data)},
				function(){
					console.log('success login')
				}).fail(function(){
					console.log('không thể đăng nhập')
			})
			//alert("vui lòng xác nhận tài khoản qua email")		
			window.location.href = "http://"+location.host+"/sunnyFE/account/signup/verify";
			//window.location.href = location.host + "/sunnyFE/account/login/verify";
			
		}
	    console.log('Success1:', {jsonData:JSON.stringify(data)});
	   
	  })
	  .catch((error) => {
	    console.error('Error:', error);
	  });
}


async function login(username ="", password = ""){
	var status;
	var data = {
    "accountName" : username,
    "password" : password
}

	var account;
	var user;
	
	await fetch('http://localhost:8083/login', {
	  method: 'POST', // or 'PUT'
	  headers: {
	    'Content-Type': 'application/json',
	  },
	  body: JSON.stringify(data),
	})
	  .then((response) =>{
		status = response.status
		//let x = JSON.stringify(response)
		//console.log(x)
		return response.json()
	})
	  .then((data) => {
			//console.log(status == 200)
		if(status == 200){
			//console.log(data.userId)
			account = data;
			
		}
		else {
			//alert("tài khoản hoặc mật khẩu không đúng")
			toast({
	          title: "title",
	          message: "tài khoản hoặc mật khẩu không đúng",
	          type: "error", //or success
	        });
	        
		}
	    console.log('Success1:', {jsonData:JSON.stringify(data)});
	    
	    
	  })
	  .catch((error) => {
		alert("tài khoản hoặc mật khẩu không đúng")
	    console.error('Error:', error);
	  });
	  
	  
	  //alert(123)
		//alert(account.roleId.roleId)
		if(account.roleId.roleId == 2){
			
			await fetch('http://localhost:8083/customer/get-by-user-id?userId=' + account.userId)
			  .then((response) => response.json())
			  .then((data) => user=data);
			
			$.post("http://"+location.host+"/sunnyFE/account/login",
		  	{userId:JSON.stringify(account),cus:JSON.stringify(user)},
			function(){
				//alert("Đăng nhập thành công")
				window.location.href = "http://"+location.host+"/sunnyFE/web";
			}).fail(function(){
				alert('không thể đăng nhập')
			})
			
		}
		else if(account.roleId.roleId == 4){
			alert(account.userId)
			await fetch('http://localhost:8083/usermanagement/shipper/get-by-user-id?userId=' + account.userId)
			  .then((response) => response.json())
			  .then((data) => user=data);
			//alert("login")
			$.post("http://"+location.host+"/sunnyFE/account/login",
		  	{userId:JSON.stringify(account),shipper:JSON.stringify(user)},
			function(){
				//alert("Đăng nhập thành công ")
				window.location.href = "http://"+location.host+"/sunnyFE/shipper";
			}).fail(function(){
				alert('không thể đăng nhập')
			})
		}
		else if(account.roleId.roleId == 1){
			//alert(account.userId)
			
			//alert("login")
			$.post("http://"+location.host+"/sunnyFE/account/login",
		  	{userId:JSON.stringify(account)},
			function(){
				//alert("Đăng nhập thành công ")
				window.location.href = "http://"+location.host+"/sunnyFE/admin";
			}).fail(function(){
				alert('không thể đăng nhập')
			})
		}
		else if(account.roleId.roleId == 3){
			//alert(account.userId)
			await fetch('http://localhost:8083/usermanagement/shipper/get-by-user-id?userId=' + account.userId)
			  .then((response) => response.json())
			  .then((data) => user=data);
			//alert("login")
			$.post("http://"+location.host+"/sunnyFE/account/login",
		  	{userId:JSON.stringify(account),Employee:JSON.stringify(user)},
			function(){
				//alert("Đăng nhập thành công ")
				window.location.href = "http://"+location.host+"/sunnyFE/admin";
			}).fail(function(){
				alert('không thể đăng nhập')
			})
		}
}

function getCusId(UserId){
	return 0;
}