<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <div class="grid-item" id="nav">
    <jsp:include page="../employee/nav.jsp"/>
</div>
<jsp:include page="../home/top.jsp"/>


<link rel="stylesheet" href="${css}/home/main.css"/>

<div class="bs-example" data-example-id="thumbnails-with-custom-content">
    <div class="row">
      <div class="col-sm-6 col-md-4">
        <div class="thumbnail">
          <img data-src="holder.js/100%x200" alt="100%x200" src="https://t1.daumcdn.net/thumb/R1280x0/?fname=http://t1.daumcdn.net/brunch/service/user/l9p/image/sLvqWQ5MqztfI3Iyw-TQY3-TAwI" data-holder-rendered="true" style="height: 300px; width: 100%; display: block;">
          <div class="caption">
            <h3 id="thumbnail-label">Computer<a class="anchorjs-link" href="#thumbnail-label"><span class="anchorjs-icon"></span></a></h3>
            <p></p>
            <p><a href="#" class="glyphicon glyphicon-heart-empty" role="button">좋아요</a> <a href="#" class="btn btn-default" role="button">구매</a></p>
          </div>
        </div>
      </div>
      <div class="col-sm-6 col-md-4">
        <div class="thumbnail">
          <img data-src="holder.js/100%x200" alt="100%x200" src="https://imagessl.hyundaihmall.com/static/1/1/57/73/2073571144_0_480.jpg" data-holder-rendered="true" style="height: 300px; width: 100%; display: block;">
          <div class="caption">
            <h3 id="thumbnail-label">Laptop<a class="anchorjs-link" href="#thumbnail-label"><span class="anchorjs-icon"></span></a></h3>
            <p></p>
            <p><a href="#" class="glyphicon glyphicon-heart-empty" role="button">좋아요</a> <a href="#" class="btn btn-default" role="button">구매</a></p>
          </div>
        </div>
      </div>
      <div class="col-sm-6 col-md-4">
        <div class="thumbnail">
          <img data-src="holder.js/100%x200" alt="100%x200" src="http://image.zdnet.co.kr/2019/02/01/lejj_mYP4HXmd3V4ihuQ.jpg" data-holder-rendered="true" style="height: 300px; width: 100%; display: block;">
          <div class="caption">
            <h3 id="thumbnail-label">phone<a class="anchorjs-link" href="#thumbnail-label"><span class="anchorjs-icon"></span></a></h3>
            <p></p>
            <p><a href="#" class="glyphicon glyphicon-heart-empty" role="button">좋아요</a> <a href="#" class="btn btn-default" role="button">구매</a></p>
          </div>
        </div>
      </div>
    </div>
  </div>

<jsp:include page="../home/bottom.jsp"/>  


<script>
$('#emp_register').click(function(){
	location.assign('employee.do?cmd=move&page=register');
});
$('#emp_access').click(function(){
	location.assign('employee.do?cmd=move&page=access');
});
</script>








