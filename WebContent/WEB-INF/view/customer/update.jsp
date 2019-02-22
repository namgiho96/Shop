<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="../home/top.jsp"/>
<link rel="stylesheet" href="${css}/customer/list.css" />

<div class="grid-item" id="nav">
    <jsp:include page="../employee/nav.jsp"/>
</div>

<form id="form">
<div class="grid-item" id="side_menu" ><div class="myphotoin"><img src="${img}/default_image.png" style="height: 200px; width: 100%;"/></div></div>
<div class="grid-item" id="content">
	
	아이디 <br />
	이 름  ${cust.customerName} <br />	
	생년월일 ${cust.ssn}	<br />
	성별 : 남  <br />
	전화번호: <input type="text" name="phone" placeholder="${cust.phone}"/> 	<br />	
	우편번호: <input type="text" name="postalCode" placeholder="${cust.postalCode}" />  <br />		
	주소 :    <input type="text" name="city" placeholder="${cust.city}" />  <br />
	상세주소: <input type="text" name="address" placeholder="${cust.address}"/>  <br />
	임시비밀번호 : <input type="text" name="password" placeholder="임시비밀번호"/>  <br />
	<input type="hidden" name="customer_id" value="${cust.customerID}"/>  <br />
	<input type="hidden" name="cmd" value="cust_update"/>  <br />
	<input type="hidden" name="page" value="detail"/>  <br />
 </div>
 </form>
 <div class="grid-item">
 	<button type="button" id="confirm_btn" class="btn btn-primary" >확인</button>
 	<button type="button" id="cancel_btn" class="btn btn-success">취소</button>
 </div>
<script>
$('#confirm_btn').click(()=>{
	var form = $('#form');
	form.attr('action','${ctx}/customer.do');
	form.attr('method','post');
	form.submit();
});
$('#cancel_btn').click(()=>{
	alert('취소버튼 클릭');
});
</script>

