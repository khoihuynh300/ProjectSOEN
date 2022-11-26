<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.2.1/css/bootstrap.min.css"
	integrity="sha512-siwe/oXMhSjGCwLn+scraPOWrJxHlUgMBMZXdPe2Tnk3I0x3ESCoLz7WZ5NTH6SZrywMY+PB1cjyqJ5jAluCOg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet"
	href="<c:url value='/views/login/css/signup.css'/>">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
	integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/@emailjs/browser@3/dist/email.min.js"></script>
<script href="/sendSMS/sendSMS.js"></script>
<script type="text/javascript">
	(function() {
		// https://dashboard.emailjs.com/admin/account
		emailjs.init('-PIK4yH15mdv040TA');
	})();
</script>
</head>
<body>

 <%@ include file="/common/notify/notify.jsp" %>

	<header>
		<div class="container-fluid">
			<div class="logo">
				<a href="#"><img
					src="<c:url value='/views/login/img/logo.png'/>" width=85px
					height=85px></a>
				<h4 style="color: #222222; font-weight: normal;">Đăng kí</h4>
			</div>
		</div>
	</header>
	<main>
		<div class="row">
			<div class="col-6" id="background">
				<img src="<c:url value='/views/login/img/logo1.png'/>"
					class="d-block">
				<p
					style="color: white; font-size: xx-large; text-align: center; font-weight: bold; font-family: Arial, Helvetica, sans-serif">
					Điện thoại, laptop, tablet,<br> phụ kiện chính hãng
				</p>
			</div>
			<div class="col-6">
				<div class="loginForm">
					<form id="frmsignup" action="#">
						<label class="d-block"
							style="font-size: 1.25rem; margin-bottom: 20px; color: #222222;">Đăng
							ký</label> <input type="email" placeholder="Email" name="email"
							id="email" required>
						<div class="account-area" id="account-area">
							<input type="text" id="account" name="account"
								placeholder="Account" required pattern="^[a-z][a-z\d]{3,20}$"
								onkeyup="check_account();">
							<div style="margin-right: 5px;">
								<i class="fa-solid fa-check" id="correct2" style="color: green;"
									hidden="true"></i> <i class="fa-solid fa-xmark" id="wrong2"
									style="color: red" hidden="true"></i>
							</div>
						</div>
						<p style="font-size: 0.7rem;">*Gồm khoảng [8-32] ký tự và bắt
							đầu ký tự thường, không được chứa ký tự ngoài ký tự thường và số</p>
						<input type="text" id="phone" name="phone"
							placeholder="Phone Number" required>
						<div class="password-area" id="password-area">
							<input id="password" type="password" placeholder="Mật khẩu"
								pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$"
								onkeyup="check(); checkValidation()" required>
							<div style="margin-right: 5px;">
								<i class="fa-solid fa-check" id="correct1" style="color: green;"
									hidden="true"></i> <i class="fa-solid fa-xmark" id="wrong1"
									style="color: red" hidden="true"></i>
							</div>
							<div class="showpw">
								<a type="button" onclick="showPassword()"><i
									class="fa-regular fa-eye" id="eye" hidden="true"
									style="margin: 0; padding: 0;"></i><i
									class="fa-regular fa-eye-slash" id="eye1"
									style="margin: 0; padding: 0;"></i></a>
							</div>
						</div>
						<p style="font-size: 0.7rem;">*Ít nhất 8 kí tự, bao gồm ít
							nhất 1 kí tự thường, 1 kí tự hoa, 1 chữ số, 1 ký tự đặc biệt</p>
						<div class="password-area" id="password-area1">
							<input class="password" id="password-repeat" type="password"
								placeholder="Nhập lại mật khẩu"
								pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$"
								onkeyup="check();" required>
							<div style="margin-right: 5px;">
								<i class="fa-solid fa-check" id="correct" style="color: green;"
									hidden="true"></i> <i class="fa-solid fa-xmark" id="wrong"
									style="color: red" hidden="true"></i>
							</div>
							<div class="showpw">
								<a type="button" onclick="showPasswordRepeat()"><i
									class="fa-regular fa-eye eye" hidden="true" id="eye2"
									style="margin: 0; padding: 0;"></i><i
									class="fa-regular fa-eye-slash eye1" id="eye3"
									style="margin: 0; padding: 0;"></i></a>
							</div>
						</div>
						<input class="d-block submit-btn" type="submit" value="ĐĂNG KÝ">
					</form>
					<%--                     <div class="anotherWay">
                        <div class="border"></div>
                        <span class="or">HOẶC</span>
                        <div class="border"></div>
                    </div>
                    <div style="visibility: hidden;" id="anotherWay-btn" class="d-flex">
                       
                        <button  class="google-btn d-flex"><img src="<c:url value='/views/login/img/google-logo-9808.png'/>" width="20%">
                            <div>Google</div>
                        </button>
                    </div> --%>
					<div class="footerOfForm">
						<p style="color: black;">
							Bạn đã có tài khoản <a href="<c:url value='/account/login'/>"
								style="text-decoration: none; color: var(- -mainColor)">Đăng
								nhập</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</main>
	<script src="<c:url value='/views/login/js/login.js'/>"></script>
	<script>
		document.getElementById("account").addEventListener("focusin",
				focusBorderPasswordArea);
		function focusBorderPasswordArea() {
			document.getElementById("account-area").style.outline = "black solid 1px";
		}

		document.getElementById("account").addEventListener("focusout",
				blurBorderPasswordArea);
		function blurBorderPasswordArea() {
			document.getElementById("account-area").style.outline = '#b9b9b9 solid 1px';
		}

		document.getElementById("password").addEventListener("focusin",
				focusBorderPasswordArea);
		function focusBorderPasswordArea() {
			document.getElementById("password-area").style.outline = "black solid 1px";
		}

		document.getElementById("password").addEventListener("focusout",
				blurBorderPasswordArea);
		function blurBorderPasswordArea() {
			document.getElementById("password-area").style.outline = '#b9b9b9 solid 1px';
		}

		document.getElementById("password-repeat").addEventListener("focusin",
				focusBorderPasswordArea1);
		function focusBorderPasswordArea1() {
			document.getElementById("password-area1").style.outline = "black solid 1px";
		}

		document.getElementById("password-repeat").addEventListener("focusout",
				blurBorderPasswordArea1);
		function blurBorderPasswordArea1() {
			document.getElementById("password-area1").style.outline = '#b9b9b9 solid 1px';
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
		function showPasswordRepeat() {
			let x = document.getElementById("password-repeat");
			let eye = document.getElementById("eye2");
			let eye1 = document.getElementById("eye3");

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

		function check() {
			let pattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
			if ((document.getElementById("password").value == document
					.getElementById("password-repeat").value)
					&& pattern.test(document.getElementById("password").value)) {
				document.getElementById("correct").hidden = false;
				document.getElementById("wrong").hidden = true;
			} else {
				document.getElementById("correct").hidden = true;
				document.getElementById("wrong").hidden = false;
			}
		}
		function checkValidation() {
			let pattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
			if (pattern.test(document.getElementById("password").value)) {
				document.getElementById("correct1").hidden = false;
				document.getElementById("wrong1").hidden = true;
			} else {
				document.getElementById("correct1").hidden = true;
				document.getElementById("wrong1").hidden = false;
			}
		}

		function check_account() {
			let pattern = /^[a-z][a-z\d]{3,20}$/;
			if (pattern.test(document.getElementById("account").value)) {
				document.getElementById("correct2").hidden = false;
				document.getElementById("wrong2").hidden = true;
			} else {
				document.getElementById("correct2").hidden = true;
				document.getElementById("wrong2").hidden = false;
			}
		}

		$("#frmsignup").submit(function(event) {
			let username = $("#frmsignup input#account").val();
			let password = $("#frmsignup input#password").val();
			let email = $("#frmsignup input#email").val();
			let phone = $("#frmsignup input#phone").val();

			signup(email, username, password, phone);
			event.preventDefault();
		});
	</script>
</body>
</html>