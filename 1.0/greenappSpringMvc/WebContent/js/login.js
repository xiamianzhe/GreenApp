function testJson(){
	var shohin_gonghao=$("#shohin_gonghao").val();
	var mima = $("#mima").val();
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
			  window.self.location = "NewFile.jsp";
			  alert("登录成功");
			}
		}
	});
}