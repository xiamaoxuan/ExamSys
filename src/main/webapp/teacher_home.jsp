<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="teacher_base_page.jsp"%>
</head>
<body >
	<div id="header">
		<h1></h1>
	</div>
	<div id="user-nav" class="navbar navbar-inverse">
		<ul class="nav btn-group">

			<li class="btn btn-inverse"><a title="" href="${base_path}login/loginOut"><i
					class="icon icon-share-alt"></i> <span class="text">Logout</span></a></li>
		</ul>
	</div>
	<div id="sidebar">
		<a href="#" class="visible-phone"><i class="icon icon-home"></i>
			管理系统</a>
		<ul>
			<li class="active"><a href="javascript:void(0);"><i
					class="icon icon-home"></i> <span>欢迎使用</span></a></li>
			<li class="submenu" id="exam"><a href="#"><i class="icon icon-th-list"></i>
					<span>考试管理</span></a>
				<ul>
					<li><a href="${base_path}teacher/addExam" target="iframe">添加考试</a></li>
					<li><a href="${base_path}teacher/editQtnHome" target="iframe">编辑考试</a></li>
					<li><a href="${base_path}teacher/addQtnPage" target="iframe">添加考题</a></li>
				</ul></li>
			<li class="submenu" id="student"><a href="#"><i class="icon icon-th-list"></i>
					<span>学生管理</span></a>
				<ul>
					<li><a href="invoice.html">Invoice</a></li>
					<li><a href="${base_path}teacher/addExam" target="iframe">Support chat</a></li>
					<li><a href="calendar.html">Calendar</a></li>
					<li><a href="gallery.html">Gallery</a></li>
				</ul></li>
		</ul>

	</div>
	<div id="content">
		<div id="content-header">
			<h1></h1>
		</div>
		<div id="breadcrumb">
			<a href="#" title="Go to Home" class="tip-bottom"><i
				class="icon-home"></i>Home</a>
		</div>
		<div class="container-fluid">
	<iframe width="1050" align="center"  height="200" id="win" name="iframe" onload="AutoIframe()" frameborder="0" scrolling="no"></iframe>  
		</div>
	</div>
	<script type="text/javascript" src="${base_path}js/teacher_home.js"></script>
</body>
</html>
