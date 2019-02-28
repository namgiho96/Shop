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
<div class="grid-item" id="side_menu">
	사이드 메뉴입니다.
</div>

<div class="grid-item" id="content_list">
    <h1><font style="font-size: 30px">고객 목록</font></h1>
	<div class="grid-item" id="content">
	    <table id="cust_tab">
	      <tr>
	        <th>No.</th>
	        <th>아이디</th>
	        <th>이 름</th>
	        <th>생년월일</th>
	        <th>성 별</th>
	        <th>전화번호</th>
	        <th>우편번호</th>
	        <th>지번주소</th>
	        <th>상세주소</th>
	      </tr>
	     <c:forEach items="${list}" var="cust">
	      <tr>
	        <td>${cust.rownum}</td>
	        <td>${cust.customerID}</td>
	        <td> <a href="${ctx}/customer.do?cmd=cust_retrieve&page=detail&customerID=${cust.customerID}">${cust.customerName}</a></td>
	        <td>${cust.ssn}</td>
	        <td>남</td>
	        <td>${cust.phone}</td>
			<td>${cust.postalCode}</td>
			<td>${cust.city}</td>
	        <td>${cust.address}</td>
	      </tr>
	    </c:forEach>
	    </table>
	    <div class="center">
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
	    </div>
	</div>
</div>
<jsp:include page="../home/bottom.jsp"/>

<script>
$('.page').each((index)=>{
		location.assign('${ctx}/customer.do?cmd=cust_list&page=list&page_num='+$(this).text());
});

$('#nav_5').click(()=>{
		location.assign('${ctx}/product.do?cmd=move&page=pro_list');
});

$('#category').attr('style','cursor:pointer').attr('src','').click(()=>{
	location.assign('${ctx}/category.do?cmd=cate_list&page=cate_list');
});
</script>