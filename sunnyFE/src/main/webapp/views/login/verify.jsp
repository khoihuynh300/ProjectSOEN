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
                <h4 style="color: #222222; font-weight:normal;">Verify</h4>
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
                    <form id="frmVerify" action="#">
                    	<p>${sessionScope.accountName}</p>
                        <label class="d-block" style="font-size: 1.25rem; margin-bottom: 30px; color: #222222;">Verify</label>
                        <input type="text" id="code" name="code" placeholder="OTP code" required>
                        

                        <input class="d-block submit-btn" type="submit" value="VERIFY">
                    </form>
                 
                </div>
            </div>
        </div>
    </main>
    
    <script src="<c:url value='/views/login/js/login.js'/>"></script>
    <script>
        
        
        $( "#frmVerify" ).submit(function( event ) {
        	var userId = '<%=session.getAttribute("userId")%>';
        	//alert(userId)
        	let code = $("#frmVerify input#code").val();
        	verify(code,userId);
        	event.preventDefault();
        });

    </script>
    
    
</body>
</html>