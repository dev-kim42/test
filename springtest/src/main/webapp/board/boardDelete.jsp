<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ezen.myapp.domain.*" %>    
<%BoardVo bv = (BoardVo)request.getAttribute("bv");%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 삭제 페이지</title>
<script type="text/javascript">
function check(){
	var fm = document.frm;	
	if (fm.pwd.value == ""){
		alert("비밀번호를 입력하세요");
		fm.pwd.focus();
		return false;
	}
	fm.action="<%=request.getContextPath()%>/board/boardDeleteAction.do";
	fm.method="post"; 
	fm.submit();
	
	return;
}
</script>
</head>
<body>
<form name="frm">
<input type="hidden" name="bidx" value="<%=bv.getBidx()%>">
<table border=1 style="width:500px">
<tr>
	<td>제목</td>
	<td><%=bv.getSubject()%></td>
</tr>
<tr>
	<td>비밀번호</td>
	<td><input type="password" name="pwd"></td>
</tr>
<tr>
<td colspan=2 style="text-align:center">
<button name="btn1" onClick="check();return false;">확인</button>
<button name="btn2" onClick="reset();">리셋</button>
<!-- <button type="button" class="navyBtn" onClick="location.href='<%=request.getContextPath()%>/board/boardContents.do?bidx=<%=bv.getBidx()%>' ">이전으로</button>  -->
</td>
</tr>
</table>
</form>
</body>
</html>