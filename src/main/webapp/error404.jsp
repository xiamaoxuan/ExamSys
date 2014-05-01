<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>
      	页面未找到 
    </title>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
    <link class="resources library" rel="stylesheet" type="text/css" href="${base_path}resource/css/error.css"/>
    <script > 
    if (window != top) 
		top.location.href = location.href; 
    </script>
  </head>
  <body>
    <div id="container">
      <img class="png" src="${base_path}resource/images/404.png" />
      <img class="png msg" src="${base_path}resource/images/404_msg.png" />
      <p>
        <a href="${base_path}login/redirect">
          <img class="png" src="${base_path}resource/images/404_to_index.png" />
        </a>
      </p>
    </div>
    <div id="cloud" class="png">
    </div>
    <pre style="DISPLAY: none"></pre>
  </body>
</html>