<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ezen.team.domain.BoardVo" %>    
<% BoardVo bv = (BoardVo)request.getAttribute("bv"); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=session.getAttribute("Midx") %></title>
</head>
<body>
<table border="1" style="text-align:left;width:800px;height:300px">
<tr>
<td style="width:100px;height:50px">제목</td>
<td><%=bv.getBsubject() %></td>
<td style="width:50px">작성자</td>
<td><%=bv.getBwriter() %></td>
<td style="width:50px">조회수</td>
<td><%=bv.getBview() %></td>
</tr>
<tr>
<td style="height:10px">파일다운로드</td>
<td colspan=5>
<% if (bv.getFilename() != null) { %>
 <a href = "<%=request.getContextPath()%>/board/fileDownload.do?fileName=<%=bv.getFilename()%>"><%=bv.getFilename()%></a>
<br>썸네일:
<img src="<%=request.getContextPath()%>/filefolder/s-<%=bv.getFilename()%>">
<br>원본:
<img src="<%=request.getContextPath()%>/filefolder/<%=bv.getFilename()%>">
<%} %>
</td>
</tr>
<tr>
<td style="height:300px">내용</td>
<td colspan=5>
<%=bv.getBcontents() %>
</td>
</tr>
<tr>
<td colspan="6" style="text-align:left;">
<a href="<%=request.getContextPath()%>/board/boardModify.do?bidx=<%=bv.getBidx()%>">수정</a>
<a href="<%=request.getContextPath()%>/board/boardDelete.do?bidx=<%=bv.getBidx()%>">삭제</a>
<a href="<%=request.getContextPath()%>/board/boardReply.do?bidx=<%=bv.getBidx()%>&orginbidx=<%=bv.getOrginbidx() %>&updown=<%=bv.getUpdown()%>&leftright=<%=bv.getLeftright()%>">답변</a>
<a href="<%=request.getContextPath()%>/board/boardList.do">목록</a>

<a href="<%=request.getContextPath()%>/board/boardRecommend.do?bidx=<%=bv.getBidx()%>">추천하기</a>

</td>
</tr>
</table>
</body>
</html>