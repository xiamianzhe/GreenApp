<!doctype html>
<html>
<head>
<meta charset="utf-8">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="description" content="人力资源管理平台" />

<title>绿色车间后台管理</title>
<link type="text/css"  rel="stylesheet" href="css/css.css" />
<link type="text/css"  rel="stylesheet" href="css/common.css"/>
<link type="text/css"  rel="stylesheet" href="css/jdc-side-panel.css"/>
<link type="text/css"  rel="stylesheet" href="${pageContext.request.contextPath }/css/calendar.css">


<!--<script src="js/jquery.js"></script>
<script src="js/calendar.js"></script>-->	
</head>
<body>
<div class="header">
	
  <div class="top"> 
    <ul class="nav">
    <li class="seleli"><a href="inme.html" target="iframe_a">首页</a></li>
      <li class="a1"><a href="house_list.html" target="iframe_a">人员管理</a></li>
		
		
      <li class="a2"><a href="house_list1.html" target="iframe_a">车间管理</a></li>
		<li class="a2"><a href="house_list4.html" target="iframe_a">设备管理</a></li>
      <li><a href="house_list3.html" target="iframe_a">环境限定</a></li>
     
		<li class="a3"><a href="introduce.html" target="iframe_a" >系统介绍</a></li>
      <!-- <li class="seleli"><a href="inme.html" target="iframe_a">首页</a></li>
      <li><a href="house_list.html" target="iframe_a">人员管理</a></li>
      <li><a href="house_list1.html" target="iframe_a">设备管理</a></li>
      <li><a href="house_list2.html" target="iframe_a">系统管理</a></li>
     
		<li ><a href="introduce.html" target="iframe_a" >系统介绍</a></li> -->
    </ul>
	  
	  <iframe src="inme.html"  frameborder="no"  name="iframe_a" width="79.5%" height="900" id="b"  >
    	<!--<iframe src="introduce.html"  frameborder="no"  name="iframe_a" width="79.5%" height="900" id="c" >
		</iframe>-->
  </div>
	
</div>
<div class="container">
  <div class="leftbar">
    <div class="lm01"> <img class="peptx" src="images/a1.jpg" />
      <div class="pepdet">
        <p class="pepname">${username}</p>
        <p>${Zhiwu}</p>
        <p>${cj}</p>
      </div>
           <div class="clear"></div>
    </div>
    <div class="lm02">
      <div class="title"><img class="icon" src="images/dataicon.jpg" />
        <h2>日历</h2>
      </div>
      <div class="detail"><!-- <img class="" src="images/kj_01.jpg" />-->
		
		  <div id="Demo">
<div id="calendar" class="calendar"></div>
		
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

	
	<div class="jdc-side" style="display: block;">
  <div class="mod_hang_qrcode jdc_feedback_qrcode">
    <div class="mod_hang_qrcode_btn"><i class="jdcfont"></i><span>扫码反馈</span></div>
    <div class="mod_hang_qrcode_show">
      <div class="mod-qr-tips"></div>
      <div class="mod_hang_qrcode_show_bg">
        <div id="canvas" style="height: 123px; width: 123px;"><img src="images/xcx.jpg" width="120px" height="110px"></div>
      </div>
      <p>了解车间详情</p>
    </div>
  </div>
  <div class="mod_hang_appeal">
    <div class="mod_hang_appeal_btn"><i class="jdcfont"></i> <span>咨询反馈</span></div>
    <div class="mod_hang_appeal_show">
      <ul>
        <li><a href="#" target="_blank">
          <div class="icon_box"><i class="jdcfont"></i></div>
          <div class="text_box">
            <h5>人工客服</h5>
            <p>7*12 专业客服，服务咨询</p>
          </div>
          </a></li>
        <li id="entry"><a href="#" target="_blank" class="f-cb">
          <div class="icon_box"><i class="jdcfont"></i></div>
          <div class="text_box">
            <h5>工单服务</h5>
            <p>7*24全时处理，技术支持</p>
          </div>
          </a></li>
        <li><a href="#" target="_blank" class="f-cb">
          <div class="icon_box"><i class="jdcfont"></i></div>
          <div class="text_box">
            <h5>投诉建议</h5>
            <p>倾耳聆听，一个工作日内及时处理</p>
          </div>
          </a></li>
      </ul>
    </div>
    </div>
  <div class="mod_hang_qrcode jdc_hang_qrcode"><a class="mod_hang_qrcode_btn"><i class="jdcfont"></i><span>扫码关注</span></a>
    <div class="mod_hang_qrcode_show">
      <div class="mod_hang_qrcode_show_bg"></div>
      <p>车间公众号关注</p>
    </div>
  </div>
  <div class="mod_hang_qrcode mod_hang_top"><a href="#" class="mod_hang_qrcode_btn"><i class="jdcfont"></i><span>返回顶部</span></a></div>
  <div class="el-dialog__wrapper" style="display: none;">
    <div class="el-dialog el-dialog--small" style="top: 15%;">
      <div class="el-dialog__header"><span class="el-dialog__title"></span>
        <div type="button" class="el-dialog__headerbtn"><i class="el-dialog__close el-icon el-icon-close"></i></div>
      </div>
    </div>
  </div>
</div>
			</div>
		   </div>
  </div>
</div>
</div> 
<script src="js/jquery.min.js"></script>
<script src="js/calendar.js"></script>
<script>
	document.getElementsByClassName('seleli')[0].style.background="#539D48";
	var moune = document.querySelector('.nav');
	var moune_item = moune.querySelectorAll('li');
	for(var i =0 ; i< moune_item.length ; i++)
		{
			moune_item[i].onclick=function(){
				//console.log(this.parentNode.getElementsByTagName('li'));
				var lis=this.parentNode.getElementsByTagName('li');
				/*this.parentNode.getElementsByTagName('li').style.background="#ccc";
				this.style.backgroundColor="#fff";*/
				for(var j =0;j<lis.length;j++){
					lis[j].style.background="rgb(80, 148, 98)";
					this.style.background="#539D48";
					
				}
			}
		}
</script>
</body>
</html>