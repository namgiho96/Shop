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
	<ul class="list-group" id="#cate_list" >
		<li class="list-group-item" id="cate_list">카테고리 목록</li>
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
<script src="${js}/employee.js">

</script>