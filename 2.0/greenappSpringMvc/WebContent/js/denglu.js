/**
 * 
 */

/**--如果路径提示文件错误，请在文件路径前加入${pageContext.request.contextPath }/  如“href="${pageContext.request.contextPath }/Signin" --**/

function testJson(){
	var shohin_gonghao=$("#entry_name").val();
	var mima = $("#entry_password").val();
	$.ajax({
		url : "hello",
		type : "post", 
		// data表示发送的数据
		data :JSON.stringify({mima:mima,shohin_gonghao:shohin_gonghao}),
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
//					window.self.location = "index.jsp";
				}
				
			}
		}
	});
}