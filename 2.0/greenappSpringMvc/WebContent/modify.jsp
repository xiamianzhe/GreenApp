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
<script type="text/javascript">
function testJson(){

    // 获取输入的用户名和密码
	var name = $("#name").val();
	var mima = $("#mima").val();
	var shohin_shoujihao = $("#shohin_shoujihao").val();
	var shohin_gonghao=$("#shohin_gonghao").val();
	var ruzhishijian=$("#ruzhishijian").val();
	var zhiwu=$("#zhiwu").val();
	var zhanghu=$("#zhanghu").val();
	$.ajax({
		url : "${pageContext.request.contextPath }/modify",
		type : "post", 
		// data表示发送的数据
		data :JSON.stringify({name:name,mima:mima,shohin_shoujihao:shohin_shoujihao,ruzhishijian:ruzhishijian,zhiwu:zhiwu,zhanghu:zhanghu,shohin_gonghao:shohin_gonghao}),
		// 定义发送请求的数据格式为JSON字符串
		contentType : "application/json;charset=UTF-8",
		//定义回调响应的数据格式为JSON字符串,该属性可以省略
		dataType : "json",
		//成功响应的结果
		success : function(data){
			if(data != null){					
			  alert("您输入的用户名为："+data.name+
                                 "密码为："+data.mima);
			}
		}
	});
}
</script>
</head>
<body>
    <form>
         用户名：<input type="text" name="name" id="name"><br />
        密&nbsp;&nbsp;&nbsp;码：
          <input type="password" name="mima" id="mima"><br />
         手&nbsp;&nbsp;&nbsp;机： <input type="text" name="shohin_shoujihao" id="shohin_shoujihao"><br />
         工号 <input type="text" name="shohin_gonghao" id="shohin_gonghao"><br />
         入职时间 <input type="text" name="ruzhishijian" id="ruzhishijian"><br />
         职务 <input type="text" name="zhiwu" id="zhiwu"><br />
         账户 <input type="text" name="zhanghu" id="zhanghu"><br />
	     <input type="button" value="修改" onclick="testJson()"/>
    </form> 
</body>
</html>