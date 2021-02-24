<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insertf</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function(){
		$('#insertBtn').click(function(){
			$('#phoneFrm').attr('action','insert').attr('method','post').submit();
		});
		
		$('#updateBtn').click(function(){
			$('#phoneFrm').attr('action','update').attr('method','post').submit();
		});
		
		$('#cancelBtn').click(function(){
			location.href="list";
		});
	});

</script>
</head>
<body>
	<c:if test="${empty detail }">
		<h2>insertf</h2>
	</c:if>

	<c:if test="${not empty detail }">
		<h2>updatef</h2>
	</c:if>
	
	<form name="phoneFrm" id="phoneFrm">
		이름 : <input type="text" name="NAME" id="NAME" placeholder = "이름" value="${detail.NAME }"><br>
		전화번호 : <input type="text" name="PHONE" id="PHONE" placeholder = "전화번호" value="${detail.PHONE }"><br>
		관계 : <input type="text" name="RELATIONSHIP" id="RELATIONSHIP" placeholder = "관계" value="${detail.RELATIONSHIP }"><br>

		<c:if test="${empty detail }">
			<input type="button" name="insertBtn" id="insertBtn" value="등록"> &nbsp;
		</c:if>
	
		<c:if test="${not empty detail }">
			<input type="button" name="updateBtn" id="updateBtn" value="수정"> &nbsp;
			<input type="hidden" name="SEQ" id="SEQ" value="${detail.SEQ }">
		</c:if>
		<input type="button" name="cancelBtn" id="cancelBtn" value="취소"> &nbsp;
	</form>
	
</body>
</html>