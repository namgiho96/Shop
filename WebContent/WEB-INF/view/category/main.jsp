<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="../home/top.jsp"/>


 <link rel="stylesheet" href="${css}/customer/list.css" />
<link rel="stylesheet" href="${css}/employee/nav.css" />
<link rel="stylesheet" href="${css}/home/main.css" />


 <div class="grid-item" id="nav">
	<div class="grid-navi_bar">
    <div id="nav_1"><a href="home.do">홈</a></div>
    <div id="nav_2"><a href="#">카테고리</a></div>
    <div id="nav_3"><a href="#">사원</a></div>
    <div id="nav_4"><a href="#">주문</a></div>
    <div id="nav_5"><a href="#">상품</a></div>
    <div id="nav_6"><a href="#">선박</a></div>
    <div id="nav_7"><a href="#">공급업체</a></div>
    <div id="nav_8"><a href="#">${customer.customerName}의 페이지</a></div>
	</div>
</div> 
  
<link rel="stylesheet" href="${css}/home/main.css"/>
        <div class="thumbnail">
          <img data-src="holder.js/100%x200" alt="100%x200" src="https://t1.daumcdn.net/thumb/R1280x0/?fname=http://t1.daumcdn.net/brunch/service/user/l9p/image/sLvqWQ5MqztfI3Iyw-TQY3-TAwI" data-holder-rendered="true" style="height: 300px; width: 100%; display: block;">
          <div class="caption">
            <h3 id="thumbnail-label">Computer<a class="anchorjs-link" href="#thumbnail-label"><span class="anchorjs-icon"></span></a></h3>
            <p></p>
            <p><a href="#" class="glyphicon glyphicon-heart-empty" role="button">좋아요</a> <a href="#" class="btn btn-default" role="button">구매</a></p>
          </div>
        </div>
        
        <div class="thumbnail">
          <img data-src="holder.js/100%x200" alt="100%x200" src="https://imagessl.hyundaihmall.com/static/1/1/57/73/2073571144_0_480.jpg" data-holder-rendered="true" style="height: 300px; width: 100%; display: block;">
          <div class="caption">
            <h3 id="thumbnail-label">Laptop<a class="anchorjs-link" href="#thumbnail-label"><span class="anchorjs-icon"></span></a></h3>
            <p></p>
            <p><a href="#" class="glyphicon glyphicon-heart-empty" role="button">좋아요</a> <a href="#" class="btn btn-default" role="button">구매</a></p>
          </div>
      </div>
      
        <div class="thumbnail">
          <img data-src="holder.js/100%x200" alt="100%x200" src="http://image.zdnet.co.kr/2019/02/01/lejj_mYP4HXmd3V4ihuQ.jpg" data-holder-rendered="true" style="height: 300px; width: 100%; display: block;">
          <div class="caption">
            <h3 id="thumbnail-label">phone<a class="anchorjs-link" href="#thumbnail-label"><span class="anchorjs-icon"></span></a></h3>
            <p></p>
            <p><a href="#" class="glyphicon glyphicon-heart-empty" role="button">좋아요</a> <a href="#" class="btn btn-default" role="button">구매</a></p>
          </div>
        </div>


<jsp:include page="../home/bottom.jsp"/>  


<script>
$('#emp_register').click(()=>{
	location.assign('employee.do?cmd=move&page=register');
});
$('#emp_access').click(()=>{
	location.assign('employee.do?cmd=move&page=access');
});

$('#nav_8 > a').click(()=>{
	alert('마이페이지 클릭')
	location.assign("${ctx}/customer.do?cmd=cust_retrieve&page=detail&customerID=${customer.customerID}");
});
</script>








