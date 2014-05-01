<%@page import="com.cuit.exam.entity.TSubject"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	List<TSubject> subjects=(List<TSubject>)request.getAttribute("subjects");
%>
</head>
<body style="background:#eee">
	<div>${Message}</div>
	<div id="cform" class="span12">
		<div class="widget-box">
			<div class="widget-title">
				<span class="icon"> <i class="icon-align-justify"></i>
				</span>
				<h5>添加考试</h5>
			</div>
			<div class="widget-content nopadding">
				<form action="${base_path}teacher/addOrUpdateExamComplete"
					method="get" class="form-horizontal" id="form">
					<div class="control-group">
						<label class="control-label">考试标题</label>
						<div class="controls">
							<input type="text" name="title" value="${exam.title}" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">开始时间</label>
						<div class="controls">
							<input type="text" id="starTime" name="startTime"
								data-date-format="yyyy-mm-dd hh:ii" value="${exam.startTime}" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">结束时间</label>
						<div class="controls">
							<input type="text" id="endTime" name="endTime"
								data-date-format="yyyy-mm-dd hh:ii" value="${exam.endTime}" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">考试总分</label>
						<div class="controls">
							<input type="text" name="fullScore" value="${exam.fullScore}" />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label">考试科目</label> <input type="hidden"
							value="${exam.TSubject.id}">
						<div class="controls">
							<select name="TSubject.id" style="width:604px;">
								<%
									for(TSubject subject:subjects){
								%>
								<option value="<%=subject.getId()%>"><%=subject.getSubjectName()%></option>
								<%
									}
								%>
							</select>
						</div>
					</div>
					<!-- 题型表格 -->
					<div class="alert alert-info fade in hide" id="alert"
						style="position: relative;">
						<button type="button" class="close" onclick="hide();">&times;</button>
						<div class="control-group" style="border: 3px;">
							<div class="controls">
								<input type="text" style="width:220px;" id="score"
									placeholder="每题分数" /> <select id="hard">
									<option value="0">容易</option>
									<option value="1">中等</option>
									<option value="2">难</option>
									<option value="3">压轴</option>
								</select>
							</div>
						</div>
						<div class="control-group" style="border: 3px;">
							<div class="controls">
								<input type="text" style="width:220px;" id="qtnCount"
									placeholder="题数" /> <select id="qtnType">
									<option value="0">单选</option>
									<option value="1">填空</option>
									<option value="2">简答</option>
									<option value="3">解释</option>
									<option value="4">判断</option>
									<option value="5">多选</option>
								</select>
							</div>
						</div>
						<div class="control-group" style="border: 3px;">
							<div class="controls">
								<a style="position: relative;left: 190px;"
									class="btn btn-success btn-large" href="javascript:void(0);"
									onclick="addRow()">确认添加</a>
							</div>
						</div>
					</div>
					<div class="widget-box">
						<div class="widget-title">
							<span class="icon"> <i class="icon-th"></i>
							</span>
							<h5>题型</h5>
							<a class="btn-inverse btn" id="add"
								style="position: relative;float: right;top: 3px;"> <i
								class="icon-plus icon-white"></i>添加题型
							</a>
						</div>
						<div class="widget-content nopadding">
							<table class="table table-bordered table-striped" id="table">
								<thead>
									<tr>
										<th>题型</th>
										<th>难度</th>
										<th>题数</th>
										<th>每题分数</th>
										<th>总分数</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
					</div>
					<div class="form-actions" >
						<button type="submit" class="btn btn-primary" style="position: relative;left: 220px">添加</button>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="cancle" class="btn btn-danger"  style="position: relative;left: 220px">取消</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<%@ include file="teacher_base_page.jsp"%>
	<script type="text/javascript">
		var count = 0;
		$("#add").click(function() {
			$("#alert").show();
		});
		function hide() {
			$("#alert").hide();
			clearAddQtnType();
		}
		$("#starTime").datetimepicker();
		$("#endTime").datetimepicker();
		function addRow() {
			var score = $("#score").val();
			var hard = $("#hard").val();
			var hardText = $("#hard").find("option:selected").text();
			var qtnCount = $("#qtnCount").val();
			var qtnType = $("#qtnType").val();
			var qtnTypeText = $("#qtnType").find("option:selected").text();
			//清除添加的表单
			clearAddQtnType();
			var row = "<tr id='tr"+count+"'><td >"
					+ qtnTypeText
					+ "</td><td >"
					+ hardText
					+ "</td><td >"
					+ qtnCount
					+ "</td><td >"
					+ score
					+ "</td><td >"
					+ qtnCount
					* score
					+ "</td><td ><a class='btn btn-danger btn-mini' href='javascript:void(0);' onclick='delRow(\""
					+ count + "\");'>删除</a></td></tr>";
			$("#table").append(row);
			//添加Input
			addInput("qtnTypeFullScores", qtnCount * score);
			addInput("qtnTypeIds", qtnType);
			addInput("qtnTypeHards", hard);
			addInput("qtnCounts", qtnCount);
			count++;
			hide();
		}
		function clearAddQtnType() {
			$("#score").val("");
			$("#hard").val(0);
			$("#qtnCount").val("");
			$("#qtnType").val(0);
		}
		function addInput(name, value) {
			$("<input />").attr('type', 'hidden')
					.attr("class", "input" + count).attr('name', name).attr(
							'value', value).appendTo('#form');
		}

		function delRow(id) {
			$("#tr" + id).remove();
			$(".input" + id).remove();
		}
	</script>
</body>
</html>
