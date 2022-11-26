<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.2.1/css/bootstrap.min.css"
        integrity="sha512-siwe/oXMhSjGCwLn+scraPOWrJxHlUgMBMZXdPe2Tnk3I0x3ESCoLz7WZ5NTH6SZrywMY+PB1cjyqJ5jAluCOg=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
        
    <link rel="stylesheet" href="<c:url value='/views/login/css/loginLayout.css'/>">
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
        integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
 <%@ include file="/common/notify/notify.jsp" %>
<style>
@charset "UTF-8";

:root { 
	--mainColor: #d70018e6; 
	--shadowColor: #d7001880;
}

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

html {
	overflow-x: hidden;
	height: 100%;
}

header>div>h4 {
	font-weight: 400;
}

.row {
	background: linear-gradient(320deg, #f27121, #e94057, #cb42c7);

}

.col-6 {
	/* margin-bottom: 50px; */
	/* background-color: var(--mainColor); */
	height: 650px;
}

.logo {
	display: flex;
	align-items: center;
	justify-content: flex-start;
	margin: 0 150px;
}

.logo>h4 {
	margin-left: 20px;
	margin-top: 10px;
	color: #222222;
}

header>div {
	margin-bottom: 50px;
}

.container-fluid {
	margin-bottom: 0px;
}

.loginForm {
	/* float: right; */
	width: 400px;
	height: 80%;
	padding: 40px 30px;
	margin-right: 240px;
	margin-top: 55px;
	/*  border-radius: 10px;
    box-shadow: 6px 6px 12px #5a5a5a00, -6px -6px 12px #ffffff00;
    border: 1px solid var(--shadowColor);
    background-color: white; */
	/* From https://css.glass */
	/* From https://css.glass */
	background: rgba(255, 255, 255, 0.35);
	border-radius: 16px;
	box-shadow: 0 4px 30px rgba(0, 0, 0, 0.1);
	backdrop-filter: blur(15.7px);
	-webkit-backdrop-filter: blur(15.7px);
}

.loginForm>a {
	font-size: small;
	margin: 10px 0;
}

#account,
#code,
#resetPw,
#Pw2 {
	width: 100%;
	height: 40px;
	margin-bottom: 15px;
	align-items: center;
	padding: 5px;
	border: 1px solid gray;
}

input[type=email] {
	border-radius: 1px;
	border: none;
	outline: 1px solid #b9b9b9;
	margin-bottom: 15px;
	padding: 5px;
	width: 100%;
	height: 40px;
}

input[type=email]:focus {
	border: none;
	outline: black solid 1px;
}

.password-area {
	display: flex;
	align-items: center;
	margin-bottom: 15px;
	outline: #b9b9b9 solid 1px;
	border-radius: 1px;
}

#password, #password-repeat {
	border-radius: 1px 0 0 1px;
	border: none;
	width: 100%;
	height: 40px;
	padding: 5px;
}

.showpw {
	display: flex;
	align-items: center;
	background-color: white;
	border-radius: 0 1px 1px 0;
	padding-right: 10px;
	height: 40px;
}

#password:focus, #password-repeat:focus {
	outline: none;
}

#phone {
	width: 100%;
	height: 40px;
	margin-bottom: 15px;
}

.submit-btn {
	width: 100%;
	height: 40px;
	padding: 5px;
	margin: 10px 0;
	border: none;
	border-radius: 2px;
	color: white;
	background: var(--mainColor);
}

#background {
	display: flex;
	justify-content: center;
	align-items: center;
	flex-direction: column;
}

#background>img {
	border-radius: 50%;
	width: 50%;
	margin-top: -50px;
	width: 40%;
}

.anotherWay {
	display: flex;
	align-items: center;
	justify-content: space-between;
	margin-bottom: 10px;
}

.border {
	width: 50%;
	height: 1px;
	background-color: #b9b9b9;
}

.or {
	color: #b9b9b9;
	font-size: small;
	margin: 0 10px;
}

#anotherWay-btn {
	align-items: center;
	justify-content: space-evenly;
	margin: 20px 0;
}

.facebook-btn, .google-btn {
	border: 1px solid #b9b9b9;
	width: 48%;
	background-color: white;
	border-radius: 2px;
	align-items: center;
	justify-content: center;
	padding: 5px 5px;
}

.facebook-btn>img, .google-btn>img {
	margin-right: 10px;
}

.footerOfForm {
	margin-top: 40px;
	text-align: center;
	color: #b9b9b9;
}

footer {
	background: #343a40;
	padding: 40px;
	bottom: 0;
}

footer a {
	color: #f8f9fa !important;
}


#frmVerify{
	height: 50%;
	margin: 25% 0;
}

#frmVerify #code{
	width: 100%;
	padding: 10px;
	margin-bottom: 10px;
	border-radius: 10px;
}

#frmVerify .d-block.submit-btn{
	border-radius: 10px;
}


/* Reponsive */
@media screen and (max-width: 768px) {
	
/* 	body {
		height: 100% !important;
		
	}
	header {
		height: 15%;
	}

	main {
		height: 100%;
	}
	
	.row{
		height: 100%;
	} */
	.loginForm {
		width: 90%;
		height: 90%;
	}
	#background {
		width: 40%;
	}
	#background>img {
		width: 60%;
	}
	.col-6 {
		width: 60%;
	}
	.google-btn {
		width: 80%;
	}
	
	#frmVerify{
	height: 50%;
	margin: 25% 0;
	}

	#frmVerify #code{
		width: 100%;
		padding: 10px;
		margin-bottom: 10px;
		border-radius: 10px;
	}
	
	#frmVerify .d-block.submit-btn{
		border-radius: 10px;
	}
}





</style>
	<header>
        <div class="container-fluid">
            <div class="logo">
                <a href="#"><img src="<c:url value='/views/login/img/logo.png'/>" width=85px height=85px></a>
                <h4 style="color: #222222; font-weight:normal;">Quên mật khẩu </h4>
            </div>
        </div>
    </header>
    <main>
        <div class="row">
            <div class="col-6" id="background">
                <img src="<c:url value='/views/login/img/logo1.png'/>" class="d-block">
                <p
                    style="color: white; font-size:xx-large; text-align: center; font-weight: bold; font-family:Arial, Helvetica, sans-serif">
                    Điện thoại, laptop, tablet,<br> phụ kiện chính hãng</p>
            </div>
            <div class="col-6">
                <div class="loginForm">
                    <form id="frmResetPw" action="#">
                    	
                        <label class="d-block" style="font-size: 1.25rem; margin-bottom: 30px; color: #222222;">Đặt lại mật khẩu</label>
                        <div>
                        <input type="text" id="account" name="account" placeholder="Tên tài khoản" required>
                        </div>
                        <div>
                        <input type="text" id="code" name="code" placeholder="OTP code" required>
                        </div>
                        <div>
                        <input type="password" id="resetPw" name="resetPw" placeholder="Nhập mật khẩu mới" required>
                        </div>
                        <div>
                        <input type="password" id="Pw2" name="Pw2" placeholder="Nhập lại mật khẩu" required>
                        </div>

                        <input class="d-block submit-btn" type="submit" value="Xác nhận ">
                    </form>
                 
                </div>
            </div>
        </div>
    </main>
    <%@ include file="/common/notify/notify.jsp" %>
    <script src="<c:url value='/views/login/js/login.js'/>"></script>
    <script>
        
        
    $( "#frmResetPw" ).submit(function( event ) {
    	let account = $("#frmResetPw input#account").val().trim();
    	let code = $("#frmResetPw input#code").val().trim();
    	let resetpw = $("#frmResetPw input#resetPw").val();
    	let pw2 = $("#frmResetPw input#Pw2").val();
    	
    	if(resetpw.indexOf(' ') >= 0 || pw2.indexOf(' ') >= 0){
    		toast({
		          title: "Cảnh báo",
		          message: "Mật khẩu nhập vào không được có khoảng trắng",
		          type: "error",
		        });
    	}
    	else if(pw2 == "" || resetpw == "" || code == "" || account == ""){
    		toast({
		          title: "Cảnh báo",
		          message: "Thông tin không được để trống",
		          type: "error",
		        });
    	}
    	else if(pw2 != resetpw){
    		toast({
		          title: "Cảnh báo",
		          message: "Nhập lại mật khẩu không chính xác",
		          type: "error",
		        });
    	}
    	else{
    		let data = {
    			    "accountName": account,
    			    "password": resetpw
    			}
    		fetch('http://localhost:8083/user/reset-password?code=' + code, {
         		  method: 'POST', 
         		  headers: {
         		    'Content-Type': 'application/json',
         		  },
         		  body: JSON.stringify(data),
         		})
         		  .then((response) =>{ 
         			  if(response.status == 200){
         				 response.text().then(function (text) {
            				  toast({
            			          title: "thành công",
            			          message: text,
            			          type: "success",
            			        });
            			        
            				});
         			  }
         			  else{
         				response.text().then(function (text) {
         				  toast({
         			          title: "Lỗi",
         			          message: text,
         			          type: "error",
         			        });
         			        
         				});
         			  }
         		  })
         		  .catch((error) => {
         		    console.error('Error:', error);
         		  });
    	}
    	
    	event.preventDefault();
    });

    </script>
    
    
</body>
</html>