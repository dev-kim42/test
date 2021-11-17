<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.ezen.myapp.domain.*" %>
<%@ page import = "java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% ArrayList<BoardVo> alist = (ArrayList<BoardVo>)request.getAttribute("alist"); %>
 <%PageMaker pm  = (PageMaker)request.getAttribute("pm"); %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<form name = "frm" action="<%=request.getContextPath() %>/board/boardList.do" method="post">
<body>
<h2> 게시판 리스트</h2>

<table border= 1>
<tr>
	<td>게시물번호</td>
	<td>제목</td>
	<td>작성날짜</td>
</tr>
<% for(BoardVo bv : alist) { %>
<tr>
	<td><%= bv.getBidx() %></td>
	<td>
		<% for(int i=1; i<=bv.getNlevel(); i++) {
			out.print("&nbsp&nbsp");
			if(i == bv.getNlevel()) {
				out.print("ㄴ");
			}
		}
		%>
		<a href="<%=request.getContextPath()%>/board/boardContents.do?bidx=<%=bv.getBidx()%>"><%=bv.getSubject() %></a>
	</td>
	<td><%= bv.getWriteday() %></td>
</tr>
 <% } %>
 <table class="table2">
 <tr>
 	<td><button><a href='<%=request.getContextPath()%>/board/boardWrite.do' ">글쓰기</a></button></td>
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
		<% if(pm.isPrev() == true) {%>
		<a href ="<%=request.getContextPath()%>/board/boardList.do?page=<%=pm.getStartPage()-1 %>&keyword=<%=pm.getScri().getKeyword()%>">이전</a>
		<% } %>
	</td>	
	<td>		
		<% for(int i=pm.getStartPage(); i<=pm.getEndPage(); i++) { %> 
		<a href="<%=request.getContextPath()%>/board/boardList.do?page=<%=i%>&keyword=<%=pm.getScri().getKeyword()%>"><%=i %></a>
		<% } %>
	</td>
	<td>
		<%if (pm.isNext() && pm.getEndPage() >0) {%>
		<a href="<%=request.getContextPath()%>/board/boardList.do?page=<%=pm.getEndPage()+1 %>&keyword=<%=pm.getScri().getKeyword()%>">다음</a>
		<% } %>
	</td>
</tr>
</table>
</table>
</body>
</form>
</html>