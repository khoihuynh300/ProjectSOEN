<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/common/taglib.jsp" %>
	<%@ page session="true" %>
<div class="header">
	<ul>
		<li><a href="">logo</a></li>
	</ul>
	<ul>
		<li><a href="">thông báo</a></li>
		 
			<c:choose>
			    <c:when test="${sessionScope.accountName == null}">
			        <li><a href="">đăng nhập</a></li>
			    </c:when>    
			    <c:otherwise>
			        <li><a href="">${sessionScope.accountName}</a></li>
			    </c:otherwise>
			</c:choose>
		
	</ul>
</div>

