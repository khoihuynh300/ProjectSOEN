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
	<header>
        <div class="container-fluid">
            <div class="logo">
                <a href="#"><img src="<c:url value='/views/login/img/logo.png'/>" width=85px height=85px></a>
                <h4 style="color: #222222; font-weight:normal;">Đăng nhập</h4>
            </div>
        </div>
    </header>
    <main>
    <%@ include file="/common/notify/notify.jsp" %>
        <div class="row">
            <div class="col-6" id="background">
                <img src="<c:url value='/views/login/img/logo1.png'/>" class="d-block">
                <p
                    style="color: white; font-size:xx-large; text-align: center; font-weight: bold; font-family:Arial, Helvetica, sans-serif">
                    Điện thoại, laptop, tablet,<br> phụ kiện chính hãng</p>
            </div>
            <div class="col-6">
                <div class="loginForm">
                    <form id="frmLogin" action="#">
                        <label class="d-block" style="font-size: 1.25rem; margin-bottom: 30px; color: #222222;">Đăng
                            nhập</label>
                        <div>
                        <label>Tên tài khoản:</label>
                        <input type="text" id="account" name="account" placeholder="Tên tài khoản" required pattern="^[a-z][a-z\d]{3,20}$">
                        </div>
                        <label>Mật khẩu:</label>
                        <div class="password-area" id="password-area">
                        
                            <input id="password" name="password" type="password" placeholder="Mật khẩu"
                                pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$" required>
                            <div class="showpw"><a type="button" onclick="showPassword()"><i class="fa-regular fa-eye" id="eye" hidden="true"
                                        style="margin: 0; padding: 0;"></i><i class="fa-regular fa-eye-slash" id="eye1" style="margin:0; padding: 0;"></i></a>
                            </div>
                        </div>

                        <input class="d-block submit-btn" type="submit" value="ĐĂNG NHẬP">
                    </form>
                    <a href="<c:url value='/account/forget'/>" style="text-decoration: none;">Quên mật khẩu</a>
                    <%-- <div class="anotherWay">
                        <div class="border"></div>
                        <span class="or">HOẶC</span>
                        <div class="border"></div>
                    </div>
                    <div style="visibility: hidden;" id="anotherWay-btn" class="d-flex">
                        
                        <button hidden class="google-btn d-flex"><img src="<c:url value='/views/login/img/google-logo-9808.png'/>" width="20%">
                            <div>Google</div>
                        </button>
                    </div> --%>
                    <div class="footerOfForm">
                        <p style="	color: black;">Bạn mới biết đến ThousandSunny? <a href="<c:url value='/account/signup'/>"
                                style="text-decoration: none; color: var(--mainColor)">Đăng ký</a></p>
                    </div>
                </div>
            </div>
        </div>
    </main>
    
    <script src="<c:url value='/views/login/js/login.js'/>"></script>
    <script>
        document.getElementById("password").addEventListener("focusin", focusBorderPasswordArea);
        function focusBorderPasswordArea() {
            document.getElementById("password-area").style.outline = "black solid 1px";
        }

        document.getElementById("password").addEventListener("focusout", blurBorderPasswordArea);
        function blurBorderPasswordArea() {
            document.getElementById("password-area").style.outline = '#b9b9b9 solid 1px';
        }

        function showPassword() {
            let x = document.getElementById("password");
            let eye = document.getElementById("eye");
            let eye1 = document.getElementById("eye1");
            
             
            if (x.type === "password") {
                x.type = "text";
                eye.hidden = false;
                eye1.hidden = true;  
            } else {
                x.type = "password";
                eye.hidden = true;
                eye1.hidden = false;
            }
        }
        
        $( "#frmLogin" ).submit(function( event ) {
        	
        	let username = $("#frmLogin input#account").val();
        	let password = $("#frmLogin input#password").val();
        	
        	
        	login(username, password);
        	event.preventDefault();
        });

    </script>
    
    
</body>
</html>