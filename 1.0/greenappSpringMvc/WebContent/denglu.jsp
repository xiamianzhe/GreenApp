<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>登录</title>

<link rel="stylesheet" type="text/css" href="css/style.css">
<!--如果路径提示文件错误，请在文件路径前加入${pageContext.request.contextPath }/  如"href="${pageContext.request.contextPath }/css/login.css"-->
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/vector.js"></script>

</head>
<body>

<div id="container">
	<div id="output">
		<div class="containerT">
			<h1>用户登录</h1>
			<form class="form" id="entry_form">
				<input type="text" placeholder="admin" id="entry_name" name="username">
				<input type="password" placeholder="密码" id="entry_password" name="mima">
				<button type="button" id="entry_btn" onclick="testJson()">登录</button>
				<div id="prompt" class="prompt"></div>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript" 
      src="js/jquery-1.11.3.min.js">
</script>
<script type="text/javascript" >
$(function(){
        Victor("container", "output");   //登陆背景函数
        $("#entry_name").focus();
        $(document).keydown(function(event){
            if(event.keyCode==13){
                $("#entry_btn").click();
            }
        });
        
    });
 function testJson(){
	var username=$("#entry_name").val();
	var mima = $("#entry_password").val();
	$.ajax({
		url : "${pageContext.request.contextPath }/Signinweb",
		type : "post", 
		// data表示发送的数据
		data :JSON.stringify({mima:mima,shohin_gonghao:username}),
		// 定义发送请求的数据格式为JSON字符串
		contentType : "application/json;charset=UTF-8",
		//定义回调响应的数据格式为JSON字符串,该属性可以省略
		dataType : "json",
		//成功响应的结果
		success : function(data){
			if(data.shohin_gonghao=="false"){
				alert("不存在此工号");
			}else{
				if(data.jieguo==false){
					alert("密码错误");
				}else{
					alert("登录成功");
				window.self.location = "index.jsp";
				}
				
			}
		} 
	});
} 
</script>
</body>
</html>
