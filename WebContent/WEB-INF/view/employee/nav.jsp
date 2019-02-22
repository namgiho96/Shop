<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<link rel="stylesheet" href="${css}/employee/nav.css" />    

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

<script>
$('#category').attr('style','cursor:pointer').attr('src','').click(()=>{
	location.assign('${ctx}/category.do?page=cate_list');
});
</script>