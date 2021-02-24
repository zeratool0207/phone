<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function(){
		$('#insertBtn').click(function(){
			location.href="insertf";
		});
		
		$('#deleteBtn').click(function(){
			$('#listFrm').attr('action','delete').attr('method','post').submit();
		});
		
		$('#searchBtn').click(function(){
			$('#searchFrm').attr('action','list').attr('method','post').submit();
		});
		
	});

</script>
</head>
<body>
	<h2>list</h2>
	<form name="searchFrm" id="searchFrm">
		선택 : <select name="searchType" id="searchType">
				<option>선택</option>
				<option value="name">이름</option>
			  </select>
		  <input type="text" name="searchTxt" id="searchTxt">&nbsp;
		  <input type="button" name="searchBtn" id="searchBtn" value="검색">
	</form>
	
	<input type="button" name="insertBtn" id="insertBtn" value="등록">
	<input type="button" name="deleteBtn" id="deleteBtn" value="삭제">
	<table border="1">
		<tr>
			<th>글삭제</th>
			<th>글번호</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>관계</th>
		</tr>
		
		<form name="listFrm" id="listFrm">
			<c:forEach items="${list}" var="list">
				<tr>
					<td><input type="checkbox" name="chk" value="${list.SEQ }"></td>				
					<td>${list.SEQ }</td>
					<td><a href="updatef?seq=${list.SEQ}">${list.NAME }</a></td>
					<td>${list.PHONE }</td>
					<td>${list.RELATIONSHIP }</td>		
				</tr>	
			</c:forEach>
		</form>
	</table>
	
	<div>
			<c:if test="${searchMap.startPage != 1 }">
				<a href="list?pageNo=1&listSize=5"><<</a>
				<a href="list?pageNo=${searchMap.startPage-1}&listSize=5"><</a>
			</c:if>
			<c:forEach begin="${searchMap.startPage }" end="${searchMap.endPage }" var = "i">
				<a href="list?pageNo=${i}&listSize=5">${i}</a>
			</c:forEach>
			<c:if test="${searchMap.endPage != searchMap.total }">
				<a href = "list?pageNo=${searchMap.endPage+1 }&listSize=5"> > </a>
				<a href="list?pageNo=${searchMap.total }&listSize=5">>></a>
			</c:if>
		</div>
</body>
</html>