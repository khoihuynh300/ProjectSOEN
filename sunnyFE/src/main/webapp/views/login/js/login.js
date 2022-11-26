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
			
			window.location.href = "http://"+location.host+"/sunnyFE/account/login";
		}
	    else{
			toast({
	          title: "ERROR",
	          message: "An error occur!",
	          type: "error", //or success
	        });
			
		}
	   
	  })
	  .catch((error) => {
		toast({
	          title: "ERROR",
	          message: "An error occur!",
	          type: "error", //or success
	        });
	    console.error('Error:', error);
	  });
}


function verify(code,userId){
	var status;	
	let url = "http://localhost:8083/user/register/verifyer?code=" + code + "&userId=" + userId;
	
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
	    
	    
	    if(status==200){
			window.location.href = "http://"+location.host+"/sunnyFE/account/signup/userinfo";
			
		}
		else {
			
			toast({
	          title: "Xác thực không thành công",
	          message: "Mã xác thực không chính xác",
	          type: "error", //or success
	        });
		}
	   	
	  })
	  .catch((error) => {
	    console.error('Error:', error);
	    
	    toast({
	          title: "ERROR",
	          message: "An error occur!",
	          type: "error", //or success
	        });
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
		
		if(response.status != 200){
			response.text().then(function (text) {
			  toast({
		          title: "Đăng ký thất bại",
		          message: text,
		          type: "error", //or success
		        });
		        
			});
		}
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
			window.location.href = "http://"+location.host+"/sunnyFE/account/signup/verify";	
		}
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
			
			toast({
	          title: "Đăng nhập thất bại",
	          message: "Tài khoản hoặc mật khẩu không đúng",
	          type: "error", //or success
	        });
	        
		}
	    //console.log('Success1:', {jsonData:JSON.stringify(data)});
	    
	    
	  })
	  .catch((error) => {
		
		toast({
	          title: "ERROR",
	          message: "An error occur!",
	          type: "error", //or success
	        });
	    console.error('Error:', error);
	  });
	  
	  
	 
		
		if(account.roleId.roleId == 2){
			
			await fetch('http://localhost:8083/customer/get-by-user-id?userId=' + account.userId)
			  .then((response) => response.json())
			  .then((data) => user=data);
			
			$.post("http://"+location.host+"/sunnyFE/account/login",
		  	{userId:JSON.stringify(account),cus:JSON.stringify(user)},
			function(){
				
				window.location.href = "http://"+location.host+"/sunnyFE/web";
			}).fail(function(){
				toast({
		          title: "ERROR",
		          message: "An error occur!",
		          type: "error", //or success
		        });
				
			})
			
		}
		else if(account.roleId.roleId == 4){
			
			await fetch('http://localhost:8083/usermanagement/shipper/get-by-user-id?userId=' + account.userId)
			  .then((response) => response.json())
			  .then((data) => user=data);
			
			$.post("http://"+location.host+"/sunnyFE/account/login",
		  	{userId:JSON.stringify(account),shipper:JSON.stringify(user)},
			function(){
				
				window.location.href = "http://"+location.host+"/sunnyFE/shipper";
			}).fail(function(){
				toast({
		          title: "ERROR",
		          message: "An error occur!",
		          type: "error", //or success
		        });
				
			})
		}
		else if(account.roleId.roleId == 1){
			
			
			
			$.post("http://"+location.host+"/sunnyFE/account/login",
		  	{userId:JSON.stringify(account)},
			function(){
				
				window.location.href = "http://"+location.host+"/sunnyFE/admin";
			}).fail(function(){
				toast({
		          title: "ERROR",
		          message: "An error occur!",
		          type: "error", //or success
		        });
				
			})
		}
		else if(account.roleId.roleId == 3){
			
			await fetch('http://localhost:8083/usermanagement/shipper/get-by-user-id?userId=' + account.userId)
			  .then((response) => response.json())
			  .then((data) => user=data);
			
			$.post("http://"+location.host+"/sunnyFE/account/login",
		  	{userId:JSON.stringify(account),Employee:JSON.stringify(user)},
			function(){
				
				window.location.href = "http://"+location.host+"/sunnyFE/admin";
			}).fail(function(){
				toast({
		          title: "ERROR",
		          message: "An error occur!",
		          type: "error", //or success
		        });
				
			})
		}
}

//
function getCusId(UserId){
	
}