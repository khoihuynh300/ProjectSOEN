<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/common/taglib.jsp"%>
<div class="navigation">
          <ul>
            <li class="list">
              <b></b>
              <b></b>
              <a href="<c:url value='/shipper'/>" class=" item active">
                <span class="icon"><i class="fa-solid fa-house"></i></span>
                <span class="title">Home</span>
                <i class="fa-solid fa-angle-right dropdown"></i>
              </a>
              
            </li>
            
            <li class="list">
              <b></b>
              <b></b>
              <a href="<c:url value='/shipper/nhan-don'/>" class=" item ">
                <span class="icon"><i class="fa-solid fa-rectangle-list"></i></span>
                <span class="title">Nhận Đơn</span>
                <i class="fa-solid fa-angle-right dropdown"></i>
              </a>
              
            </li>
            
            <li class="list">
              <b></b>
              <b></b>
              <a href="<c:url value='/shipper/chua-giao'/>" class=" item ">
                <span class="icon"><i class="fa-solid fa-truck-arrow-right"></i></span>
                <span class="title">Chưa Giao</span>
                <i class="fa-solid fa-angle-right dropdown"></i>
              </a>
              
            </li>
            
            <li class="list">
              <b></b>
              <b></b>
              <a href="<c:url value='/shipper/da-giao'/>" class=" item ">
                <span class="icon"><i class="fa-solid fa-circle-check"></i></span>
                <span class="title">Đã Giao</span>
                <i class="fa-solid fa-angle-right dropdown"></i>
              </a>
              
            </li>
            
            
            
            
          </ul>
        </div>

        <div class="toggle">
          <i class="fa-solid fa-list open"></i>
          <i class="fa-solid fa-list close"></i>
        </div>
    