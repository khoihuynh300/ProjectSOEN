<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value='/template/admin/assets/css/bootstrap.min.css'/>"  />
<link rel="stylesheet" href="<c:url value='/template/admin/assets/font-awesome/4.2.0/css/font-awesome.min.css'/>"  />
<link rel="stylesheet" href="<c:url value='/template/admin/assets/fonts/fonts.googleapis.com.css'/>"  />
<link rel="stylesheet" href="<c:url value='/template/admin/assets/css/ace.min.css" class="ace-main-stylesheet'/>" id="main-ace-style" /> 
<script src="<c:url value='/template/admin/assets/js/ace-extra.min.js'/>"></script>
</head>
<body>
<body class="no-skin">
	
	<div id="navbar" class="navbar navbar-default">
		<script type="text/javascript">
			try {
				ace.settings.check("navbar", "fixed");
			} catch (e) {
			}
		</script>
		<div class="navbar-container" id="navbar-container">
			<div class="navbar-header pull-left">
				<a href="" class="navbar-brand"> <small> <i
						class="fa fa-leaf"></i> Ace Admin
				</small>
				</a>
			</div>
		</div>
	</div>

	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check("main-container", "fixed");
			} catch (e) {
			}
		</script>
		<div id="sidebar" class="sidebar responsive">
			<script type="text/javascript">
				try {
					ace.settings.check("sidebar", "fixed");
				} catch (e) {
				}
			</script>
			<ul class="nav nav-list">
				<li class="active"><a href="index.html"> <i
						class="menu-icon fa fa-tachometer"></i> <span class="menu-text">
							Dashboard </span>
				</a> <b class="arrow"></b></li>
				<li class=""><a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-list"></i> <span class="menu-text">
							Tables </span> <b class="arrow fa fa-angle-down"></b>
				</a> <b class="arrow"></b>

					<ul class="submenu">
						<li class=""><a href="tables.html"> <i
								class="menu-icon fa fa-caret-right"></i> Simple &amp; Dynamic
						</a> <b class="arrow"></b></li>

						<li class=""><a href="jqgrid.html"> <i
								class="menu-icon fa fa-caret-right"></i> jqGrid plugin
						</a> <b class="arrow"></b></li>
					</ul></li>
			</ul>
		</div>
	</div>
	<dec:body/>
    <script src="<c:url value='/template/admin/assets/js/jquery.2.1.1.min.js'/> "></script>
	<script src="<c:url value='/template/admin/assets/js/bootstrap.min.js'/>"></script>
	<script src="<c:url value='/template/admin/assets/js/ace.min.js'/>"></script>
</body>
</html>