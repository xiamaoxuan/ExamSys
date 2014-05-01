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
				<h5>编辑考试</h5>
			</div>
			<div class="widget-content nopadding">
				<form action="${base_path}teacher/addOrUpdateExamComplete"
					method="get" class="form-horizontal">

					<div class="control-group">
						<label class="control-label">考试标题</label>
						<div class="controls">
							<input type="hidden" name="id" value="${exam.id}" /> <input
								type="text" name="title" value="${exam.title}" />
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
							id="subjectId" value="${exam.TSubject.id}">
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

					<div class="form-actions">
						<div class="btn-group" style="position: relative;left: 200px;">
							<button type="submit" class="btn btn-primary">确认编辑</button>
							<a class="btn btn-inverse " href="${base_path}teacher/getExamQtnType?id=${exam.id}" >编辑题型</a>
							<button type="cancle" class="btn btn-danger">取消</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<%@ include file="teacher_base_page.jsp"%>
	<script type="text/javascript">
		$("#starTime").datetimepicker();
		$("#endTime").datetimepicker();
		$("select[name='TSubject.id']").val($("#subjectId").val());
	</script>
</body>
</html>
