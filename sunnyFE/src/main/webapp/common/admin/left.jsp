<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/common/taglib.jsp"%>
<div class="navigation">
          <ul>
            <li class="list">
              <b></b>
              <b></b>
              <a href="<c:url value='/admin'/>" class=" item active">
                <span class="icon"><i class="fa-solid fa-house"></i></span>
                <span class="title">Home</span>
                <i class="fa-solid fa-angle-right dropdown"></i>
              </a>
              
            </li>
            <li class="list">
              <b></b>
              <b></b>
              <a class="sub-btn item">
                <span class="icon"><i class="fa-solid fa-user"></i></i></span>
                <span class="title">Account & user</span>
                <i class="fa-solid fa-angle-right dropdown"></i>
              </a>
              
              <div class="sub-menu">
                <a href="<c:url value='/admin/user'/>" class="item sub-item">
                  Account
                </a>
                <a href="<c:url value='/admin/customer'/>" class="item sub-item">
                  Customer
                </a>
                <a href="<c:url value='/admin/employee'/>" class="item sub-item">
                  Employee
                </a>
                <%-- <a href="<c:url value=''/>" class="item sub-item">
                  Shipper
                </a> --%>
              </div>
            </li>
            
            <li class="list">
              <b></b>
              <b></b>
              <a class="sub-btn item">
                <span class="icon"><i class="fa-solid fa-laptop"></i></span>
                <span class="title">Product</span>
                <i class="fa-solid fa-angle-right dropdown"></i>
              </a>
              
              <div class="sub-menu">
                
                <a href="<c:url value='/admin/Product'/>" class="item sub-item">
                  Product
                </a>
                <a href="<c:url value='/admin/order'/>" class="item sub-item">
                  Order
                </a>
                <a href="<c:url value='admin/discount'/>" class="item sub-item">
                  Discount
                </a>
                <a href="<c:url value='/admin/bill'/>" class="item sub-item">
                  Bill
                </a>
              </div>
            </li>
            
          </ul>
        </div>

        <div class="toggle">
          <i class="fa-solid fa-list open"></i>
          <i class="fa-solid fa-list close"></i>
        </div>
    