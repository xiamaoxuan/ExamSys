<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<link rel="stylesheet" type="text/css"
	href="${base_path}resource/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${base_path}resource/css/login.css" />
<script src="${base_path}resource/js/jquery-1.11.0.js" type="text/javascript"></script>
<script src="${base_path}resource/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${base_path}js/login.js" type="text/javascript"></script>
<script type="text/javascript">
var base_path="${base_path}";
</script>
</head>
<body>
	<div class="container">
		<section class="loginBox row-fluid">
			<section class="span7 left">
				<form action="${base_path}j_spring_security_check" method="post">
					<h2>用户登录</h2>
					<p>
						<input type="text" name="j_username" placeholder="学号" />
					</p>
					<p>
						<input type="password" name="j_password" placeholder="密码" />
					</p>
					<p>
						<a href="javascript:void(0);" onclick="change();"
							title="看不清楚？点击换一张"><img style="float: right;cursor: hand;"
							class="span5 img-rounded" id="code" src="${base_path}login/imageCode" /></a> 
						<div class="control-group" id="j_code">
						<input type="text" class="span5" name="j_code" placeholder="验证码" />
						</div>
					</p>
					<section class="row-fluid">
						<section class="span8 lh30">
							<label><input type="checkbox" name="_spring_security_remember_me" />下次自动登录</label>
						</section>
						<section class="span1">
							<input type="submit" value="登录 " class="btn btn-primary">
						</section>
					</section>
				</form>
			</section>
			<section class="span5 right">
				<h2>没有注册登记</h2>
				<section>
					<p>如果你现在没有注册登记考试系统，点击下面的按钮，立即注册</p>
					<p>
						<input type="button" class="btn btn-success" value=" 注册 " class="btn">
					</p>
				</section>
			</section>
		</section>
	</div>
</body>
</html>
