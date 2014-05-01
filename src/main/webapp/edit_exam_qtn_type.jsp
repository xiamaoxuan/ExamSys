<%@page import="com.cuit.exam.utils.CommonUtil"%>
<%@page import="com.cuit.exam.entity.TExamHasQtns"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="teacher_base_page.jsp"%>
<%
	List<TExamHasQtns> examHasQtns=(List<TExamHasQtns>)request.getAttribute("examHasQtns");
%>
</head>
<body style="background:#eee">
	<!-- 添加题型的Div -->
	<form action="${base_path}teacher/addExamHasQtnsToExam" method="get"
		class="form-horizontal" id="form">
		<div class="alert alert-info fade in hide" id="alert" style="position: relative;top: 15px;">
			<button type="button" class="close" onclick="hide();">&times;</button>
			<div class="control-group" style="border: 3px;">
				<div class="controls">
					<input type="text" style="width:220px;" id="score"
						placeholder="每题分数" /> 
						<input type="hidden" name="TExam.id" value="${examId}"/>
						<input type="hidden" name="fullSocre"/>
						<select id="hard" name="difficulty">
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
						placeholder="题数"  name="qtnCount"/> <select id="qtnType" name="qtnType">
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
					<button style="position: relative;left: 190px;"
						class="btn btn-success btn-large" href="javascript:void(0);"
						onclick="addFullScore()" type="submit">确认添加</button>
				</div>
			</div>
		</div>
	</form>
	<div class="widget-box">
		<div class="widget-title">
			<span class="icon"> <i class="icon-th"></i>
			</span>
			<h5>题型</h5>
			<a class="btn-inverse btn" id="add" href="#myAlert"
				style="position: relative;float: right;top: 3px;"> <i
				class="icon-plus icon-white"></i>添加题型
			</a>
		</div>
		<div class="widget-content nopadding">
			<table class="table table-bordered table-striped">
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
					<%
						if(examHasQtns.size()>0)
					%>
					<%
						for(TExamHasQtns examHasQtns2:examHasQtns){
					%>
					<tr>
						<td><%=CommonUtil.getQtnTypeText(examHasQtns2.getQtnType())%></td>
						<td><%=CommonUtil.getDifficultyText(examHasQtns2.getDifficulty())%></td>
						<td><%=examHasQtns2.getQtnCount()%></td>
						<td><%=Math.floor((examHasQtns2.getFullSocre())/(examHasQtns2.getQtnCount()))%></td>
						<td><%=examHasQtns2.getFullSocre()%></td>
						<td><a class='btn btn-danger btn-mini'
							href='${base_path}teacher/delExamHasQtns?id=<%=examHasQtns2.getId()%>&examId=<%=examHasQtns2.getTExam().getId()%>'>删除</a></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
	</div>
	<script type="text/javascript">
		$("#add").click(function() {
			$("#alert").show();
		});
		function hide() {
			$("#alert").hide();
			clearAddQtnType();
		}
		function clearAddQtnType() {
			$("#score").val("");
			$("#hard").val(0);
			$("#qtnCount").val("");
			$("#qtnType").val(0);
		}
		function addFullScore(){
			var score=$("#score").val();
			var qtnCount=$("#qtnCount").val();
			if(score!=""&&qtnCount!="")
			$("input[name='fullSocre']").val(score*qtnCount);
			else{
				return false;
			}
		}
	</script>
</body>
</html>
