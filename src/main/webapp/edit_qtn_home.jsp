<%@page import="com.cuit.exam.entity.TExam"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	List<TExam> exams = (List<TExam>) request.getAttribute("exams");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${base_path}resource/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${base_path}resource/bootstrap/css/bootstrap-responsive.min.css" />
<link rel="stylesheet"
	href="${base_path}resource/bootstrap/css/uniform.css" />
<link rel="stylesheet"
	href="${base_path}resource/bootstrap/css/select2.css" />
<link rel="stylesheet"
	href="${base_path}resource/bootstrap/css/unicorn.main.css" />
<link rel="stylesheet"
	href="${base_path}resource/bootstrap/css/unicorn.grey.css"
	class="skin-color" />
<title></title>
</head>
<body style="background:#eee">
	<div class="widget-box">
		<div class="widget-title">
							<span class="icon"> <i class="icon-th"></i>
							</span>
							<h5>添加题型</h5>
						</div>
		<div class="widget-content nopadding">
			<table class="table table-bordered data-table">
				<thead>
					<tr><th>ID</th>
						<th>考试标题</th>
						<th>考试科目</th>
						<th>开始时间</th>
						<th>结束时间</th>
						<th>总分</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (TExam exam : exams) {
					%>
					<tr class="gradeX">
						<td><%=exam.getId() %></td>
						<td><%=exam.getTitle()%></td>
						<td><%=exam.getTSubject().getSubjectName()%></td>
						<td><%=exam.getStartTime()%></td>
						<td class="center"><%=exam.getEndTime()%></td>
						<td><%=exam.getFullScore()%></td>
						<td style="text-align: center;"><div class="btn-group">
								<a class="btn" href="${base_path}teacher/editExam?id=<%=exam.getId()%>">编辑</a>
								<a class="btn btn-danger"
									href="${base_path}teacher/removeExam?id=<%=exam.getId()%>" onclick="if(!confirm('确定删除？')){return false;}">删除</a>
							</div></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
	</div>
	<script src="${base_path}resource/bootstrap/js/jquery.min.js"></script>
	<script src="${base_path}resource/bootstrap/js/jquery.ui.custom.js"></script>
	<script src="${base_path}resource/bootstrap/js/bootstrap.js"></script>
	<script src="${base_path}resource/bootstrap/js/jquery.uniform.js"></script>
	<script src="${base_path}resource/bootstrap/js/select2.min.js"></script>
	<script src="${base_path}resource/bootstrap/js/jquery.dataTables.min.js"></script>
	<script src="${base_path}resource/bootstrap/js/unicorn.js"></script>
	<script src="${base_path}resource/bootstrap/js/unicorn.tables.js"></script>
</body>
</html>