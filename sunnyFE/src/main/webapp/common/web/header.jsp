<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ include file="/common/taglib.jsp" %>
	<%@ page session="true" %>
	
	<nav
      class="navbar navbar-expand-md navbar-dark color-ligth"
      id="home-navbar"
    >
      <div id="slider-banner" class="container">
        <a class="navbar-brand" href="<c:url value='/web'/>">Thousand Sunny</a>
        <button
          class="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbarsExampleDefault"
          aria-controls="navbarsExampleDefault"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>

        <div
          class="collapse navbar-collapse justify-content-end"
          id="navbarsExampleDefault"
        >
          <ul class="navbar-nav m-auto">
            <li class="nav-item active">
              <a class="nav-link" href="<c:url value='/web'/>">
                <i class="bx bxs-home"></i>
                Trang chủ <span class="sr-only">(current)</span></a
              >
            </li>
            <li class="nav-item">
              <a class="nav-link" href="<c:url value='/web/category'/>">
                <i class="bx bx-category-alt"></i>
                Danh mục
              </a>
            </li>

            <form class="form-inline my-2 my-lg-0" id="searchForm">
              <div class="input-group input-group-sm">
                <input
                  type="text"
                  class="form-control"
                  placeholder="Tìm kiếm..."
                  id="searchText"
                />
                <div class="input-group-append">
                  <button
                    type="button"
                    class="btn btn-secondary btn-number"
                    onclick="getSearchText()"
                  >
                    <i class="fa fa-search"></i>
                  </button>
                </div>
              </div>
              <a class="btn btn-success btn-sm ml-3" href="<c:url value='/web/cart'/>">
                <i class="fa fa-shopping-cart"></i> Cart
                <span class="badge badge-light">0</span>
              </a>
            </form>

            <li class="nav-item dropdown">
              <a class="nav-link" >
                <i class="bx bxs-face"></i>
                Tài khoản</a
              >
              <c:choose>
			    <c:when test="${sessionScope.cus == null}">
			        <ul class="dropdown-menu">
                <li>
                  <a href="<c:url value='/account/login'/>"><i class="fa-regular fa-face-smile"></i>Đăng nhập</a>
                </li>
              </ul>
			    </c:when>    
			    <c:otherwise>
			        <ul class="dropdown-menu">
                <li >
                  
                  <a href="<c:url value='/web/profile'/>"><i class="fa-regular fa-face-smile"></i>${sessionScope.CusName}</a>
                </li>
                <li>
                  <a href="<c:url value='/web/cart'/>"><i class="fa-solid fa-cart-plus"></i>Giỏ hàng</a>
                </li>
                <li>
                  <!-- <i class="fa-solid fa-key"></i><a href="#">Đổi mật khẩu</a> -->
                </li>
                <li>
                 <a href="#"> <i class="fa-solid fa-right-from-bracket"></i
                  >Đăng xuất</a>
                </li>
              </ul>
			    </c:otherwise>
			</c:choose>
              
            </li>
          </ul>
        </div>
      </div>
    </nav>
 
	