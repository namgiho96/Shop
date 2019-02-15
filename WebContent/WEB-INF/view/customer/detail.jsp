<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="../home/top.jsp"/>
<link rel="stylesheet"
    href="${css}/customer/list.css" />
<div class="grid-item" id="nav">
    <jsp:include page="../employee/nav.jsp"/>
</div>
<div class="grid-item" id="side_menu" ><img src="https://pbs.twimg.com/profile_images/914868959010185217/imzHUdhl_400x400.jpg" class="center-block" alt="Responsive image" 
style=""></div>
<div class="grid-item" id="content">

검색한 사람의 정보			
아이디 ${cust.customerID}<br />
이 름  ${cust.customerName} <br />	
생년월일 ${cust.ssn}	<br />
성별 : 남  <br />
전화번호 : ${cust.phone}	<br />	
우편번호 : ${cust.postalCode} <br />		
주소 : ${cust.city} <br />
상세주소 : ${cust.address} <br />

 </div>
<jsp:include page="../home/bottom.jsp"/>
</html>