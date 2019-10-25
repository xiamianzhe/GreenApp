
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="description" content="人力资源管理平台" />

<title>绿色车间后台管理</title>
<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link type="text/css" rel="stylesheet" href="css/css.css" />


<!--<script src="js/jquery.js"></script>
<script src="js/calendar.js"></script>-->	
</head>
<body>
<div class="header">
	
  <div class="top"> 
    <ul class="nav">
      <li class="seleli"><a href="inme.html" target="iframe_a">首页</a></li>
      <li><a href="house_list.html" target="iframe_a">人员管理</a></li>
      <li><a href="house_list1.html" target="iframe_a">设备管理</a></li>
      <!--<li><a href="house_list2.html" target="iframe_a">系统管理</a></li>-->
     
		<li ><a href="introduce.html" target="iframe_a" >系统介绍</a></li>
    </ul>
	  
	  <iframe src="inme.html"  frameborder="no"  name="iframe_a" width="79.5%" height="900" id="b" >
    	<!--<iframe src="introduce.html"  frameborder="no"  name="iframe_a" width="79.5%" height="900" id="c" >
		</iframe>-->
  </div>
	
</div>
<div class="container">
  <div class="leftbar">
    <div class="lm01"> <img class="peptx" src="images/a1.jpg" />
      <div class="pepdet">
        <p class="pepname">${message}</p>
        <p>管理员</p>
        <p>生产车间第一组</p>
      </div>
      <div class="clear"></div>
    </div>
    <div class="lm02">
      <div class="title"><img class="icon" src="images/dataicon.jpg" />
        <h2>日历</h2>
      </div>
      <div class="detail"> <img class="" src="images/kj_01.jpg" />
		
		<!--<div id="demo">
    <div id="ca"></div>
		</div>-->
		
		</div>
    </div>
    <div class="lm03">
      <div class="title"><img style="padding-right:5px;" class="icon" src="images/weaicon.jpg" />
        <h2>天气</h2>
      </div>
      <div class="detail"><!-- <img class="" src="images/kj_02.jpg" /> -->
		

  <div class="background">
  <div class="big-1"></div>
  <div class="big-2"></div>
  <div class="big-3"></div>
  <div class="big-4"></div>
  <div class="big-5"></div>
  <div class="big-6"></div>
  <div class="big-7"></div>
  <div class="big-8"></div>
  <div class="big-9"></div>
  <div class="big-10"></div>
  <div class="medium-1"></div>
  <div class="medium-2"></div>
  <div class="medium-3"></div>
  <div class="medium-4"></div>
  <div class="medium-5"></div>
  <div class="medium-6"></div>
  <div class="medium-7"></div>
  <div class="medium-8"></div>
  <div class="medium-9"></div>
  <div class="medium-10"></div>
  <div class="small-1"></div>
  <div class="small-2"></div>
  <div class="small-3"></div>
  <div class="small-4"></div>
  <div class="small-5"></div>
  <div class="small-6"></div>
  <div class="small-7"></div>
  <div class="small-8"></div>
  <div class="small-9"></div>
  <div class="small-10"></div>
  <div class="moon">
    <div class="crater crater-1"></div>
    <div class="crater crater-2"></div>
    <div class="crater crater-3"></div>
    <div class="crater crater-4"></div>
    <div class="crater crater-5"></div>
    <div class="crater crater-6"></div>
    <div class="crater crater-7"></div>
    <div class="crater crater-8"></div>
    <div class="crater crater-9"></div>
    <div class="crater crater-10"></div>
    <div class="crater crater-11"></div>
  </div>
  <div class="hillWrapper">
    <div class="hill hill-1"></div>
    <div class="hill hill-2"></div>
    <div class="hill hill-3"></div>
    <div class="hill hill-4"></div>
    <div class="hill hill-5"></div>
  </div>
  <div class="descriptionWrapper">
    <div class="temperatureWrapper">
      12°
    </div>
    <div class="infoWrapper">
      风速: E 7 km/h <br/> 湿度: 87%
    </div>
    <div class="dateWrapper">
      <div class="line">
        温度： 21° / 9°
      </div>
      <div class="line">
        日期： 10 / 10
      </div>
    </div>
  </div>
</div>
		</div>
    </div>
  </div>
  
</div>
<div class="footer"></div>
</body>
</html>