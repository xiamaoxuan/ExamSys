<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="teacher_base_page.jsp"%>
</head>
  <body style="background:#eee">
	<div class="widget-box">
		<div class="widget-title">
			<span class="icon"> <i class="icon-align-justify"></i>
			</span>
			<h5>添加名词解释题</h5>
		</div>
		<div class="widget-content nopadding">
			<form action="${base_path}exam/addQtnInterpretation" method="get" class="form-horizontal">

				<div class="control-group">
					<label class="control-label">题干</label>
					<div class="controls">
					<input name="TExam.id" type="hidden" value="${examId}"/>
						<input type="text" name="questionDescription"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">答案</label>
					<div class="controls">
					<textarea name="answer"></textarea>
					</div>
				</div>

				<div class="control-group">
					<label class="control-label">难度</label>
					<div class="controls">
						<select id="hard" style="width:692px;" name="difficulty">
							<option value="0">容易</option>
							<option value="1">中等</option>
							<option value="2">难</option>
							<option value="3">压轴</option>
						</select>
					</div>
				</div>
				<div class="form-actions">
					<button type="submit" class="btn btn-primary" style="position: relative;left: 260px;">添加</button>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a  class="btn btn-danger" href="${base_path}teacher/addQtnPage" style="position: relative;left: 260px;" >返回</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
