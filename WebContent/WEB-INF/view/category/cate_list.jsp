<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../home/top.jsp"/>
<link rel="stylesheet" href="${css}/customer/list.css" />
<link rel="stylesheet" href="${css}/home/main.css" />
<link rel="stylesheet" href="${css}/employee/nav.css" /> 
<div class="grid-item" id="grid-container_1">
	<ul id="navi_bar">
	    <li><a href="home.do">홈</a></li>
	    <li><a id="category">카테고리</a></li>
	    <li><a href="#">사원</a></li>
	    <li><a href="#">주문</a></li>
	    <li><a href="#">상품</a></li>
	    <li><a href="#">선박</a></li>
	    <li><a href="#">공급업체</a></li>
	    <li><a href="">마이페이지</a></li>
	</ul>
</div>
<div class="grid-item" id="side_menu" >
	<ul class="list-group" id="side_menu" >
		<li class="list-group-item" id="cate_list" style="background-color: #8ae294 ">카테고리 목록</li>
		<li class="list-group-item" id="cate_register" >카테고리 등록</li>
		<li class="list-group-item" id="cate_search">카테고리 조회</li>
		<li class="list-group-item" id="cate_update" >카테고리 수정</li>
		<li class="list-group-item" id="cate_delete">카테고리 삭제</li>
	</ul>
</div>
<div class="grid-item" id="content_list">
	<div class="grid" id="grid-container_2">
		<div class="grid-item" id="content">
    		<table id="cate_tab" >
			      <tr>
			        <th>No. </th>
			        <th>카테고리 제목</th>
			        <th>카테고리 설명</th>
			      </tr>
			<c:forEach items="${list}" var="cate">
			      <tr>
			        <td>${cate.categoryID}</td>
			        <td>${cate.categoryName}</td>
			        <td> <a href="#">${cate.description}</a></td>
			      </tr>
			</c:forEach>
			</table>
		</div>
	</div>
</div>
    <%-- <div class="center">
      <div class="pagination">
      
      <c:if test="${pagination.existPrev}">
      	<a href='${ctx}/customer.do?cmd=cust_list&page=list&page_num=${pagination.prevBlock}'>&laquo;</a>
      </c:if>
      
      <c:forEach begin="${pagination.startpage}" end="${pagination.endpage}" varStatus="status">
      
      <c:choose>
      		<c:when test="${pagination.pageNum eq status.index}">
      			     <a href="#"class="page active">${status.index}</a>
      		</c:when>
      		<c:otherwise>
      				<a href="#"class="page">${status.index}</a>
      		</c:otherwise>
      </c:choose>
      
      </c:forEach>
      
      <c:if test="${pagination.existNext}">
      	<a href='${ctx}/customer.do?cmd=cust_list&page=list&page_num=${pagination.nextBlock}'>&raquo;</a>
      </c:if>
      
      </div>
    </div> --%>
<jsp:include page="../home/bottom.jsp"/>
<script>
$('#cate_register').click(()=>{
	$('#cate_side_menu > li').attr('style','background-color: white');
	$('#cate_register').attr('style','background-color: #8ae294');
	$('#content').html('<form id="form">'
			+'  <div class="form-group">'
			+'    <label for="text">카테고리 이름 :</label>'
			+'    <input type="text" class="form-control" name="cate_name">'
			+'  </div>'
			+'  <div class="form-group">'
			+'    <label for="text">상세 설명 :</label>'
			+'    <textarea  rows="4" cols="50" type="text" class="form-control" name="description"></textarea>'
			+'  </div>'
			+'  <div class="checkbox">'
			+'  </div>'
			+'  <button type="submit" class="btn btn-default">등록</button>'
			+'</form>');
});

$('#cate_search').click(()=>{
	$('#cate_side_menu > li').attr('style','background-color: white');
	$('#cate_search').attr('style','background-color: #8ae294');
	$('#content').html('<form id="form">'
			+'  <div class="form-group">'
			+'    <label for="text">카테고리 검색:</label>'
			+'    <select>'
			+'    	<option name="cate_id" value="1000">스마트폰</option>'
			+'    	<option name="cate_id" value="saab">데스크톱</option>'
			+'     	<option name="cate_id" value="mercedes">노트북</option>'
			+'    </select>'
			+'  <button type="submit" class="btn btn-default">조회</button>'
			+'</form>');
});

$('#cate_update').click(()=>{
	$('#cate_side_menu > li').attr('style','background-color: white');
	$('#cate_update').attr('style','background-color: #8ae294');
	$('#content').html( 
			 ' <div class="container"> '
			+'    <h1>카테고리 수정 </h1>  '
			+'             <form id="from">  '
			+'             <input type="radio" name="vehicle1" value="Bike">스마트폰<br>  '
			+'             <input type="radio" name="vehicle2" value="Car">데스크탑<br>  '
			+'             <input type="radio" name="vehicle3" value="Boat" checked>노트북<br><br>  '
			+'           </form> '
			+'<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target=" #cate_update">수정</button>  '
			+' <div class="modal fade" id="cate_update" role="dialog">  '
			+'   <div class="modal-dialog">  '
			+'     <div class="modal-content">  '
			+'       <div class="modal-header">  '
			+'         <button type="button" class="close" data-dismiss="modal">&times;</button>  '
			+'         <h4 class="modal-title">Modal Header</h4>  '
			+'       </div>  '
			+'       <div class="modal-body">  '
			+'        <form id="form"> '
			+'              <div class="form-group"> '
			+'                <label for="text">카테고리 이름 :</label> '
			+'                <input type="text" class="form-control" name="cate_name"> '
			+'              </div> '
			+'              <div class="form-group"> '
			+'                <label for="text">상세 설명 :</label> '
			+'                <textarea  rows="4" cols="50" type="text" class="form-control" name="description"></textarea> '
			+'                <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#cate_update">수정</button>  '
			+'                 </div> '
			+'                 </div> '
			+'             </form>');
});




$('#cate_delete').click(()=>{
	$('#cate_side_menu > li').attr('style','background-color: white');
	$('#cate_delete').attr('style','background-color: #8ae294');
	$('#content').html('<h1>삭제할 카테고리 선택</h1> '
			+'	<form id="from"> '
			+'  <input type="checkbox" name="vehicle1" value="Bike">스마트폰<br> '
			+'  <input type="checkbox" name="vehicle2" value="Car">데스크탑<br> '
			+'  <input type="checkbox" name="vehicle3" value="Boat" checked>조회<br><br> '
			+'  <input type="submit" value="삭제"> '
			+'</form>');
});
</script>