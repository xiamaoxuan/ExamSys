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
						<td><div class="btn-group">
								<%-- <a class="btn btn-info" href="${base_path}teacher/addQtnForExam?id=<%=exam.getId()%>">添加试题</a> --%>
									  <button class="btn btn-info">添加试题</button>
									  <button data-toggle="dropdown" class="btn btn-info dropdown-toggle"><span class="caret"></span></button>
									  <ul class="dropdown-menu">
										<li><a href="${base_path}/exam/addQtn?id=<%=exam.getId()%>&qtnType=0">单选</a></li>
										<li><a href="${base_path}/exam/addQtn?id=<%=exam.getId()%>&qtnType=1">填空</a></li>
										<li><a href="${base_path}/exam/addQtn?id=<%=exam.getId()%>&qtnType=2">简答</a></li>
										<li ><a href="${base_path}/exam/addQtn?id=<%=exam.getId()%>&qtnType=3">解释</a></li>
										<li><a href="${base_path}/exam/addQtn?id=<%=exam.getId()%>&qtnType=4">判断</a></li>
										<li><a href="${base_path}/exam/addQtn?id=<%=exam.getId()%>&qtnType=5">多选</a></li>
									  </ul>
									</div>
						</td>
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