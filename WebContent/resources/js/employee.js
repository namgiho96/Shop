var ctx = "${ctx}";// context 설정값 1.설정값을 정의해준다


$('.page').each((index)=>{
		location.assign(ctx+'/customer.do?cmd=cust_list&page=list&page_num='+$(this).text());
});


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