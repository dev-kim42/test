<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList" %> 
<%@ page import = "com.ezen.team.domain.*" %>
<% ArrayList<BoardVo> alist =  (ArrayList<BoardVo>)request.getAttribute("alist"); 
PageMaker pm = (PageMaker)request.getAttribute("pm");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=session.getAttribute("Midx") %></title>
<style>

a {
  text-decoration: none;
} 
</style>
</head>
<body>
<form name='frm' action='<%=request.getContextPath()%>/board/boardList.do' method='post'>
<table border ="0" width="800px">
<tr>	
<td width="750px" align="right">
<input type='text' name='keyword' size=10>
</td>
<td>
<input type='submit' name='submit' value='검색' />
</td>
</tr>	
</table>
</form>
<table border= "1" width="800px">
<tr align="center">
<td width="500px">제목</td>
<td width="100px">작성자</td>
<td>조회수</td>
<td>추천수</td>
</tr>

<% for (BoardVo bv : alist){ %>
<tr>
<td>
<% 
for (int i=1;i<=bv.getLeftright();i++){
	out.print("&nbsp;&nbsp;");
	if (i == bv.getLeftright()){
		out.print("└");
	}
} 
%>
<a href="<%=request.getContextPath()%>/board/boardContent.do?bidx=<%=bv.getBidx()%>"><%=bv.getBsubject() %></a></td>
<td><%=bv.getBwriter() %></td>
<td><%=bv.getBview() %></td>
<td><%=bv.getBrecommend() %></td>
</tr>
<% } %>
</table>

<br>
	
	<table border= "0" width="800px">
	<tr>
		 	<td width="300px" align="right">
		 	<%if (pm.isPrev() == true) { %>
	 			<a href="<%=request.getContextPath() %>/board/boardList.do?page=<%=pm.getStartPage()-1%>&keyword=<%=pm.encoding(pm.getScri().getKeyword())%>"> 			
		 			◀
	 			</a> 		
 			<% } %> 			
			</td>
 	 	<td width="200px" align="center">
 	 	  <% for(int i= pm.getStartPage(); i<=pm.getEndPage(); i++) { %>
        
           		<a href="<%=request.getContextPath() %>/board/boardList.do?page=<%=i %>&keyword=<%=pm.encoding(pm.getScri().getKeyword())%>"><%=i %></a>
  
          <% } %>
  		</td>
		 	<td width="300px" align="left">
		 	<% if (pm.isNext() && pm.getEndPage() >0) { %>
 			<a href="<%=request.getContextPath() %>/board/boardList.do?page=<%=pm.getEndPage()+1%>&keyword=<%=pm.encoding(pm.getScri().getKeyword())%>">
	 			▶
 			</a>
 			<% } %>
			</td>
		 </tr>
	 </table>
	
	<table border= 0  width="800px">
	<tr>
	<td colspan=3 style="text-align:right"><a href="<%=request.getContextPath() %>/board/boardWrite.do"> 글쓰기</a></td>
	</tr>
	</table>

</body>
</html>