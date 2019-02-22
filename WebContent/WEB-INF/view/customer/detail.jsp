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
<form id="file_form">
<div class="grid-item" id="side_menu" >
<div class="myphotoin">
<img src="${img}${image.imgName}.${image.imgExtention}" style="height: 200px; width: 200px;"/>
	<input type="file" name="file_upload" />
	<input type="submit" id="file_upload_btn" />
</div>
</div>
</form>

<div class="grid-item" id="content" >
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
   <div class="botton_1">
 	<button type="button" id="updata_btn" class="btn">정보수정</button>
 </div>

 <div class="botton_2">
 	<button type="button" id="delete_btn" class="btn">회원탈퇴</button>
 </div>
<script>
$('#file_upload_btn').click(()=>{
	alert('파일업로드 버튼클릭!!')
	$('#file_form')
 	.attr('method','post')
	.attr('action','${ctx}/customer.do?cmd=cust_file_upload&page=detail&customerID=${cust.customerID}')
	.attr('enctype','multipart/form-data')
	.submit(); 
});

$('#updata_btn').click(()=>{
	location.assign("${ctx}/customer.do?cmd=cust_retrieve&page=update&customerID=${cust.customerID}");
});

$('#delete_btn').click(function(){
	location.assign("${ctx}/customer.do?cmd=cust_remove&dir=home&page=main&customerID=${cust.customerID}");
});
</script>

