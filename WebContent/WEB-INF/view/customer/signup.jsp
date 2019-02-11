<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="../home/top.jsp"/>

<link rel="stylesheet" href="${css}/employee/register.css" />

<div class="grid-item" id="side_menu">
 	<h1><font style="font-size: 30px">회원 등록</font></h1>
</div>

<div class="grid-item" id="content">
<form id="form" name="form" >
	CUSTOMER_ID아이디,CUSTOMER_NAME이름,PASSWORD비밀번호,SSN생년월일,PHONE핸드폰 번호,POSTALCODE우편번호,CITY지정주소,ADDRESS상세주소,
	
	<div class="input-group">
  		<span class="input-group-addon" id="basic-addon1">아이디</span>
  		<input type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1"id="customerName" name="customerName">
	</div>
	    
	    
	<div class="input-group">
  		<span class="input-group-addon" id="basic-addon1">이름</span>
  		<input type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1"id="custmerID" name="custmerID">
	</div>
	    
	    
	 <div class="input-group">
  		<span class="input-group-addon" id="basic-addon1">비밀번호</span>
  		<input type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1"id="password" name="password">
	</div>
	
	 <div class="input-group">
  		<span class="input-group-addon" id="basic-addon1">주민등록번호</span>
  		<input type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1"id="ssn" name="ssn">
	</div>
	
	
	 <div class="input-group">
  		<span class="input-group-addon" id="basic-addon1">휴대폰번호</span>
  		<input type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1"id="phone" name="phone">
	</div>
	
	
	<div class="input-group">
  		<span class="input-group-addon" id="basic-addon1">우편번호</span>
  		<input type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1"id="postalCode" name="postalCode" >
	</div>
	    
	        
	<div class="input-group">
  		<span class="input-group-addon" id="basic-addon1">상세주소</span>
  		<input type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1"id="city" name="city" >
	</div>
	    
	    
	<div class="input-group">
  		<span class="input-group-addon" id="basic-addon1">지번주소</span>
  		<input type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1"id="address" name="address" >
	</div>
	    
	    


	
	
	    <div class="btn-group" role="group" aria-label="...">
	    <button type="button" class="btn btn-default btn-lg">
  		<span class="glyphicon glyphicon-ok" aria-hidden="true" id="confirm_btn"></span> 확인 </button>
	    
	    	    
	    <button type="button" class="btn btn-default btn-lg">
  		<span class="glyphicon glyphicon-remove" aria-hidden="true" id="cancel_btn"></span>취소</button>
	    </div>
	    
	    
	    <input type="hidden" name="cmd" value="signup"/>
	    <input type="hidden" name="page" value="signin"/>
</form>
</div>


<jsp:include page="../home/bottom.jsp"/>
<script>
$('#confirm_btn').click(function(){
	var name = $('#name').val();
	var custmerID = $('#custmerID').val();
	var password = $('#password').val();
	var address = $('#address').val();
	var city = $('#city').val();
	var postalCode = $('#postalCode').val();
	var ssn = $('#ssn').val();
	$('#form')
	.attr('action','${ctx}/customer.do')
	.submit();
});
</script>
