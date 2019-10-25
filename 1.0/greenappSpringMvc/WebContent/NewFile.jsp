<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" 
      src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js">
</script>
<script>
function go(){
var mima = $("#mima").val();
var shohin_gonghao= $("#shohin_gonghao").val();
if(mima!=''&&shohin_gonghao!=''){
	$.ajax({
		url : "${pageContext.request.contextPath }/Signin",
		type : "post", 
		// data表示发送的数据
		data :JSON.stringify({mima:mima,shohin_gonghao:shohin_gonghao}),
		// 定义发送请求的数据格式为JSON字符串
		contentType : "application/json;charset=UTF-8",
		//定义回调响应的数据格式为JSON字符串,该属性可以省略
		dataType : "json",
		//成功响应的结果
		success : function(data){
			if(data != null){					
			  alert("您输入的工号为："+data.shohin_gonghao+
	                             "密码为："+data.mima+"name"+data.name);
			}
		}
	}); 
}else{
	alert("账号或密码为空");
}

}
</script>
</head>
<body>
         工&nbsp;&nbsp;&nbsp;号： <input type="text" name="shohin_gonghao" id="shohin_gonghao"><br />
          密&nbsp;&nbsp;&nbsp;码：<input type="password" name="mima" id="mima"><br />
          <input type="button" value="登录"  onclick="go()">
</body>
</html>