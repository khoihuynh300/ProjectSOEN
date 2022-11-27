<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/common/taglib.jsp" %>
	<%@ page session="true" %>
<div class="header">
	<ul>
		<li style="background-color: #4285F4;font-size: 20px; " ><a style="color: white; font-weight: 800" href="">Thousand Sunny</a></li>
	</ul>
	<ul>
		
		 
			<c:choose>
			    <c:when test="${sessionScope.accountName == null}">
			        
			    </c:when>    
			    <c:otherwise>
			    	<img style="height: 60px;" src="<c:url value='/views/image/avatardefault_92824.jpg'/>" alt="defautlavt">
			        <%-- <li style="border-radius: 10px" ><a href="">${sessionScope.accountName}</a></li> --%>
			        <div class="accountoption">
			        	<div>Đổi mật khẩu</div>
			        	<div>Đăng xuất</div>
			        </div>
			    </c:otherwise>
			</c:choose>
		
	</ul>
</div>

