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
	var name = $("#name").val();
$.ajax({
	url : "${pageContext.request.contextPath }/delete",
	type : "post", 
	// data表示发送的数据
	data :JSON.stringify({name:name}),
	// 定义发送请求的数据格式为JSON字符串
	contentType : "application/json;charset=UTF-8",
	//定义回调响应的数据格式为JSON字符串,该属性可以省略
	dataType : "json",
	//成功响应的结果
	success : function(data){
		if(data != null){					
		  alert("您删除的为："+data.name);
		}
	}
});
}
</script>
</head>
<body>
         用户名：<input type="text" name="name" id="name"><br />
          <input type="button" value="删除"  onclick="go()">
</body>
</html>