
function login(username ="", password = ""){
	var data = {
    "accountName" : username,
    "password" : password
}
	
	fetch('http://localhost:8083/login', {
	  method: 'POST', // or 'PUT'
	  headers: {
	    'Content-Type': 'application/json',
	  },
	  body: JSON.stringify(data),
	})
	  .then((response) => response.json())
	  .then((data) => {
		if(data.status){
			
		}
	    console.log('Success1:', {jsonData:JSON.stringify(data)});
	    /*$.ajax({
            type:"POST",
            url:"http://localhost:1032/sunnyFE/account/login",
            data:{jsonData:JSON.stringify(data)},
            dataType:"json"
        });*/
	    $.post("http://localhost:1032/sunnyFE/account/login",
		  {userId:JSON.stringify(data)},
		  function(data, status){
		    console.log('Success2:',status);
		  });
	  })
	  .catch((error) => {
	    console.error('Error:', error);
	  });
}