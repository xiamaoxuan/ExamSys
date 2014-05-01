<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="teacher_base_page.jsp"%>
</head>
<body style="background:#eee">
	<div class="widget-box">
		<div class="widget-title">
			<span class="icon"> <i class="icon-align-justify"></i>
			</span>
			<h5>添加单选题</h5>
		</div>
		<div class="widget-content nopadding">
			<form action="${base_path}exam/addQtnOverChoiceComplete" method="get" id="form" class="form-horizontal">
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
				<div class="control-group">
					<label class="control-label">题干</label>
					<div class="controls">
						<textarea name="questionDescription"></textarea>
					</div>
				</div>

				<div class="control-group">
					<div class="controls">
						<a class="btn btn-inverse"
							style=" left: 260px;position: relative;" id="add"
							href="javascript:void(0)"> <i class="icon-plus icon-white"></i>添加选项
						</a>
					</div>
				</div>
				<div class="alert alert-info fade in hide" id="alert"
					style="position: relative;">
					<button type="button" class="close" onclick="hide();">&times;</button>
					<div class="control-group" style="border: 3px;">
						<label class="control-label">描述</label>
						<div class="controls">
							<textarea id="description"></textarea>
							<input name="TExam.id" type="hidden" value="${examId}"/>
						</div>
					</div>
					<div class="control-group" style="border: 3px;">
						<label class="control-label">是否正确</label>
						<div class="controls">
							<select id="flag" style="width:652px;">
								<option value="0">否</option>
								<option value="1">是</option>
							</select>
						</div>
					</div>

					<div class="control-group" style="border: 3px;">
						<div class="controls">
							<a style="position: relative;left: 265px;"
								href="javascript:void(0);" onclick="addRow()"
								class="btn btn-success">添加</a>
						</div>
					</div>
				</div>

				<div class="widget-box">
					<div class="widget-title">
						<span class="icon"> <i class="icon-th"></i>
						</span>
						<h5>题型</h5>
					</div>
					<div class="widget-content nopadding">
						<table class="table table-bordered table-striped" id="table">
							<thead>
								<tr>
									<th>序号</th>
									<th>选项描述</th>
									<th>真假</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
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
	<script type="text/javascript">
		var count = 1;
		$("#add").click(function() {
			$("#alert").show();
		});
		function hide() {
			$("#alert").hide();
			clearSelector();
		}
		function addRow() {
			var description = $("#description").val();
			var flag = $("#flag").val();
			if (description != "" && flag != "") {
				var text = "";
				if (flag == 1 || flag == "1") {
					text = "是";
				} else {
					text = "否";
				}
				var row = "<tr id='tr"+count+"'><td>"
						+ count
						+ "</td><td>"
						+ description
						+ "</td><td>"
						+ text
						+ "</td><td><a class='btn btn-danger btn-mini' href='javascript:void(0);'  onclick='delRow(\""
						+ count + "\");' >删除</a></td></tr>";
						addInput("optionDescription",description);
						addInput("isCorrect",flag);
				$("#table").append(row);
				count++;
				hide();
				clearSelector();
			}
		}
		function clearSelector(){
			$("#description").val("");
			$("#flag").val(0);
		}
		function delRow(id){
			$("#tr"+id).remove();
			$(".input" + id).remove();
		}
		function addInput(name, value) {
			$("<input />").attr('type', 'hidden')
					.attr("class", "input" + count).attr('name', name).attr(
							'value', value).appendTo('#form');
		}
	</script>
</body>
</html>
