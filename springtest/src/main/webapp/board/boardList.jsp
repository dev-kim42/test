<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%//@ page import = "com.ezen.myapp.domain.*" %>
<%//@ page import = "java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% // ArrayList<BoardVo> alist = (ArrayList<BoardVo>)request.getAttribute("alist"); %>
 <%// PageMaker pm  = (PageMaker)request.getAttribute("pm"); %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<script type="text/javascript">
alert("세션아이디:${memberId}");
var msg = '${msg}';
if (msg){
	alert(msg);	
}
</script>
</head>
<form name = "frm" action="${pageContext.request.contextPath}/board/boardList.do" method="post">
<body>
<h2> 게시판 리스트</h2>

<table border= 1>
<tr>
	<td>게시물번호</td>
	<td>제목</td>
	<td>작성날짜</td>
</tr>
<c:forEach var="bv" items="${alist}" varStatus="status">
<tr>
	<td>${bv.bidx}</td>
	<td>
		<c:forEach var="i" begin="1" end="${bv.nlevel}" step="1">
		&nbsp;&nbsp;
				<c:if test="${i == bv.nlevel}">
					ㄴ
				</c:if>
		</c:forEach>			
		<a href="${pageContext.request.contextPath}/board/boardContents.do?bidx=${bv.bidx}">${bv.subject}</a>
	</td>
	<td>${bv.writer}</td>
</tr>
</c:forEach>
 <table class="table2">
 <tr>
 	<td><button><a href='${pageContext.request.contextPath}/board/boardWrite.do' ">글쓰기</a></button></td>
 	<td style="text-align:right">
 		<select name="searchType">
 		<option value="subject">제목</option>	
 		<option value="contents">내용</option>
 		<option value="writer">작성자</option>
 		</select>
 	</td>
 	<td><input type="text" name="keyword" size="10"></td>
 	<td><input type="submit" name = "submit" value="검색">
 </tr>
</table>
<table border=1 style="width:450px; text-align:center">
<tr> <!-- 페이징 처리 -->
	<td>
		<c:if test="${pm.prev == true}">				
		<a href ="${pageContext.request.contextPath}/board/boardList.do?page=${pm.startPage-1}&keyword=${pm.scri.keyword}">이전</a>
		</c:if>
	</td>	
	<td>	
		<c:forEach var="i" begin="${pm.startPage}" end="${pm.endPage }" step="1">		 
		<a href="${pageContext.request.contextPath}/board/boardList.do?page=${i}&keyword=${pm.scri.keyword}">${i}</a>
		</c:forEach>
	</td>
	<td>
		<c:if test="${pm.next && pm.endPage >0}">		
		<a href="${pageContext.request.contextPath}/board/boardList.do?page=${pm.endPage+1}&keyword=${pm.scri.keyword}">다음</a>
		</c:if>
	</td>
</tr>
</table>
</table>
</body>
</form>
</html>