    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../home/top.jsp"/>
<link rel="stylesheet" href="${css}/employee/register.css" />
<div class="grid-item" id="side_menu">
 	<h1><font style="font-size: 30px">상품 등록</font></h1>
</div>
<div class="grid-item" id="content">
<form id="form" name="form" >
	<div class="grid-container">
	    <div class="grid-item" id="item_1">제조사</div>
	    <div class="grid-item" id="item_2"><input type="text" id="" name="" ></div>
	    <div class="grid-item" id="item_3">상품이름</div>
	    <div class="grid-item" id="item_4"><input type="text" id="" name="" ></div>
	    <div class="grid-item" id="item_5">사업자 이름</div>
	    <div class="grid-item" id="item_6"><input type="text" id="" name="" ></div>
	    <div class="grid-item" id="item_7">이메일</div>
	    <div class="grid-item" id="item_8"><input type="text" id="" name="" ></div>
	    <div class="grid-item" id="item_9"></div>
	    <div class="grid-item" id="item_10"><input type="text" id="Notes" name="Notes" ></div>
	    <div class="grid-item" id="item_11"><input type="submit" id="confirm_btn" value='등록하기'></div>
	    <div class="grid-item" id="item_12"><input type="reset" id="cancel_btn" value='취소'> </div>
	    <input type="hidden" name="cmd" value="register" />
	    <input type="hidden" name="page" value="access" />
	</div>
</form>
</div>
<jsp:include page="../home/bottom.jsp"/>