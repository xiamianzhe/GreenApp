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
var shohin_shoujihao= $("#shohin_shoujihao").val();
if(shohin_shoujihao!=''){
	$.ajax({
		url : "${pageContext.request.contextPath }/mius",
		type : "post", 
		// data表示发送的数据
		data :JSON.stringify({shohin_shoujihao:shohin_shoujihao}),
		// 定义发送请求的数据格式为JSON字符串
		contentType : "application/json;charset=UTF-8",
		//定义回调响应的数据格式为JSON字符串,该属性可以省略
		dataType : "json",
		//成功响应的结果
		success : function(data){
			if(data != null){					
			  alert("您输入的手机号为："+data.shohin_shoujihao);
			}
		}
	}); 
}else{
	 alert("手机号为空"); 
}

}
</script>
</head>
<body>
手&nbsp;&nbsp;&nbsp;机： <input type="text" name="shohin_shoujihao" id="shohin_shoujihao"><br />
<input type="button" onclick="go()" value="发送">
</body>
</html>